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

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAO;
import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAO;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;

@WebServlet(urlPatterns = {"/inserir-apontamento", "/recuperar-lista-apontamentos"})
public class ApontamentoServlet extends HttpServlet {

	private static final long serialVersionUID = -4592280850903991380L;

	private ApontamentoDAO apontamentoDAO;
	private DossieDAO dossieDAO;
	private AlunoDAO alunoDAO;

	public void init() {
		apontamentoDAO = new ApontamentoDAOImpl();
		dossieDAO = new DossieDAOImpl();
		alunoDAO = new AlunoDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-apontamento" -> inserirApontamento(request, response);
			case "/recuperar-lista-apontamentos" -> recuperarListaApontamentos(request, response);
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
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();
		Professor professor = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		professor = (Professor) session.getAttribute("usuario-logado");

		if (professor.equals(session.getAttribute("usuario-logado"))) {

			long idAluno = Long.parseLong(request.getParameter("id-aluno"));
			String cpfAluno = request.getParameter("aluno-cpf");
			Aluno aluno = alunoDAO.recuperarAlunoPeloCpf(cpfAluno);
			Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(idAluno);
			String apontamento = request.getParameter("apontamento");
			LocalDate dataCriacao = LocalDate.parse(request.getParameter("data-criacao"));
			apontamentoDAO.inserirApontamento(new Apontamento(apontamento, dataCriacao, dossie));
			
			
			request.setAttribute("aluno", aluno);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/recuperar-lista-apontamentos");
            dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath());
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

			long idAluno = Long.parseLong(request.getParameter("id-aluno"));
			String cpfAluno = request.getParameter("aluno-cpf");
			Aluno aluno = alunoDAO.recuperarAlunoPeloCpf(cpfAluno);
			Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(idAluno);
			apontamentos = apontamentoDAO.recuperarApontamentosPeloIdDossie(dossie.getId());
			request.setAttribute("apontamentos", apontamentos);
			
			
			request.setAttribute("aluno", aluno);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/recuperar-dossie");
            dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath());
		}
	}
}