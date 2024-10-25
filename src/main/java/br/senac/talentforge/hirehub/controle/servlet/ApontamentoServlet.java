package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAO;
import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAO;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;

@WebServlet(urlPatterns = {"/inserir-apontamento", "/recuperar-apontamento", "/recuperar-lista-apontamentos"})
public class ApontamentoServlet extends HttpServlet {

	private static final long serialVersionUID = -4592280850903991380L;

	private ApontamentoDAO apontamentoDAO;
	private DossieDAO dossieDAO;

	public void init() {
		apontamentoDAO = new ApontamentoDAOImpl();
		dossieDAO = new DossieDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-apontamento" -> inserirApontamento(request, response);
			case "/recuperar-lista-apontamentos" -> recuperarListaApontamentos(request, response);
			default -> referenciaNaoEncontrada(request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void inserirApontamento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		HttpSession session = request.getSession();
		Professor professor = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		professor = (Professor) session.getAttribute("usuario-logado");

		if (professor.equals(session.getAttribute("usuario-logado"))) {

			long id = Long.parseLong(request.getParameter("aluno-id"));
			Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(id);
			String apontamento = request.getParameter("apontamento");
			LocalDate dataCriacao = LocalDate.parse(request.getParameter("data-criacao"));
			apontamentoDAO.inserirApontamento(new Apontamento(apontamento, dataCriacao, dossie));
		}
	}

	private void recuperarListaApontamentos(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Professor professor = null;
		List<Apontamento> apontamentos = new ArrayList<Apontamento>();

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		professor = (Professor) session.getAttribute("usuario-logado");

		if (professor.equals(session.getAttribute("usuario-logado"))) {

			long id = Long.parseLong(request.getParameter("aluno-id"));
			Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(id);
			apontamentos = apontamentoDAO.recuperarApontamentosPeloIdDossie(dossie.getId());
			request.setAttribute("apontamentos", apontamentos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/apontamentos.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
	}
}