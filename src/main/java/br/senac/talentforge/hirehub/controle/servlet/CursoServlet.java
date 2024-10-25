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

import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAO;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;

@WebServlet(urlPatterns = { "/inserir-curso", "/atualizar-curso", "/recuperar-curso", "/recuperar-lista-cursos" })
public class CursoServlet extends HttpServlet {

	private static final long serialVersionUID = 6830527891806311155L;

	private PropostaDAO propostaDAO;
	private CursoDAO cursoDAO;

	public void init() {
		propostaDAO = new PropostaDAOImpl();
		cursoDAO = new CursoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-curso" -> inserirCurso(request, response);
			case "/recuperar-lista-cursos" -> recuperarListaCursos(request, response);
			case "/recuperar-curso" -> recuperarCurso(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void inserirCurso(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		HttpSession session = request.getSession();
		Instituicao instituicao = null;

		if (session == null) {
			response.sendRedirect(request.getContextPath() + ("/usuario-login"));
		}

		instituicao = (Instituicao) session.getAttribute("usuario-logado");

		if (instituicao.equals(session.getAttribute("usuario-logado"))) {

			if (instituicao != null) {
				String nomeCurso = request.getParameter("nome-curso");
				String areaAtuacao = request.getParameter("area-atuacao");
				String descricao = request.getParameter("descricao-curso");
				LocalDate dataInicio = LocalDate.parse(request.getParameter("data-inicio"));
				LocalDate dataFim = LocalDate.parse(request.getParameter("data-termino"));
				Disponibilidade disponibilidade = Disponibilidade.ABERTO;

				Curso curso = new Curso(nomeCurso, areaAtuacao, disponibilidade, dataInicio, dataFim, descricao, null);

				cursoDAO.inserirCurso(curso);
			}
		}
	}

	private void recuperarCurso(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Instituicao instituicao = null;
		Aluno aluno = null;

		if (session == null) {
			response.sendRedirect(request.getContextPath() + ("/usuario-login"));
		}

		aluno = (Aluno) session.getAttribute("usuario-logado");

		if (aluno.equals(session.getAttribute("usuario-logado"))) {

			if (aluno != null) {

				Curso curso = cursoDAO.recuperarCurso("");

				request.setAttribute("curso", curso);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-cursos-instituicao.jsp");
				dispatcher.forward(request, response);
			}
		}
		instituicao = (Instituicao) session.getAttribute("usuario-logado");

		if (instituicao.equals(session.getAttribute("usuario-logado"))) {

			if (instituicao != null) {
				Curso curso = cursoDAO.recuperarCurso(instituicao.getId());
			}
		}

	}

	private void recuperarListaCursos(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Instituicao instituicao = new Instituicao();
		Aluno aluno = new Aluno();
		List<Curso> cursos = new ArrayList<Curso>();

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		aluno = (Aluno) session.getAttribute("usuario-logado");

		if (aluno.equals(session.getAttribute("usuario-logado"))) {

				cursos = cursoDAO.recuperarCursosPorAtuacao("");

				request.setAttribute("curso", cursos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-cursos-instituicao.jsp");
				dispatcher.forward(request, response);
		}

		instituicao = (Instituicao) session.getAttribute("usuario-logado");

		if (instituicao.equals(session.getAttribute("usuario-logado"))) {

			if (instituicao != null) {
				cursos = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicao.getId());
			}
		}
		request.setAttribute("cursos", cursos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-cursos-instituicao.jsp");
		dispatcher.forward(request, response);
	}
}
