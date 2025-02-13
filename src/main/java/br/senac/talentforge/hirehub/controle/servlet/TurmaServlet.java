package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.turno.Turno;

@WebServlet(urlPatterns = { "/inserir-turma", "/recuperar-lista-turma", "/cadastro-turma", "/inscricao-turma", "/listagem-alunos-turma" })
public class TurmaServlet extends HttpServlet {

	private static final long serialVersionUID = -1567154649778415575L;

	private TurmaDAO turmaDAO;
	private CursoDAO cursoDAO;
	private ProfessorDAO professorDAO;
	private AlunoDAO alunoDAO;
	private UsuarioDAO usuarioDAO;

	public void init() {
		turmaDAO = new TurmaDAOImpl();
		cursoDAO = new CursoDAOImpl();
		professorDAO = new ProfessorDAOImpl();
		alunoDAO = new AlunoDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-turma" -> inserirTurma(request, response);
			case "/cadastro-turma" -> cadastroTurma(request, response);
			case "/recuperar-lista-turma" -> recuperarListaTurma(request, response);
			case "/inscricao-turma" -> inscricaoTurma(request, response);
			case "/listagem-alunos-turma" -> alunosTurma(request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void inserirTurma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		HttpSession session = request.getSession();
		Instituicao instituicao = null;
		Professor professor = null;
		Usuario usuario = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("instituicao")) {

			instituicao = (Instituicao) usuario;

			long cursoId = Long.parseLong(request.getParameter("id-curso"));
			String cpf = request.getParameter("cpf-professor");

			Curso curso = cursoDAO.recuperarCursoPeloId(cursoId);
			professor = professorDAO.recuperarProfessorPeloCpf(cpf);

			String nome = request.getParameter("nome");
			String codigo = request.getParameter("codigo");
			byte tamanho = Byte.valueOf(request.getParameter("tamanho"));
			Turno turno = Turno.valueOf(request.getParameter("turno").toUpperCase());

			turmaDAO.inserirTurma(new Turma(nome, codigo, tamanho, professor, instituicao, turno, curso));
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	private void recuperarListaTurma(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		Professor professor = null;
		Usuario usuario = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("professor")) {

			professor = (Professor) usuario;

			List<Turma> turmas = turmaDAO.recuperarTurmasPeloIdProfessor(professor.getId());

			request.setAttribute("turmas", turmas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-turmas.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

	private void cadastroTurma(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		Usuario usuario = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("instituicao")) {

			Instituicao instituicao = (Instituicao) usuario;

			long idCurso = Long.parseLong(request.getParameter("id"));
			Curso curso = cursoDAO.recuperarCursoPeloId(idCurso);

			List<Professor> professores = professorDAO.recuperarProfessoresPeloIdInstituicao(instituicao.getId());

			request.setAttribute("curso", curso);
			request.setAttribute("professores", professores);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/cadastro-turma.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	private void inscricaoTurma(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Usuario usuario = null;
		List<Turma> turmas = null;
		Aluno aluno = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("aluno")) {

			aluno = (Aluno) usuario;
			long idCurso = Long.parseLong(request.getParameter("id-curso"));
			turmas = turmaDAO.recuperarTurmasPeloIdCurso(idCurso);
			Turno turno = Turno.valueOf(request.getParameter("turno").toUpperCase());
			boolean inscricaoFeita = false;

			for (Turma turma : turmas) {
				if (turma.getTurno().equals(turno)) {
					List<Aluno> alunosTurma = alunoDAO.recuperarAlunosPeloIdTurma(turma.getId());
					if (alunosTurma.size() <= turma.getCapacidade()) {
						aluno.setTurma(turma);
						usuarioDAO.atualizarUsuario(aluno);
						inscricaoFeita = true;
						break;
					}
				}
			}

			if (inscricaoFeita) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/inscricao-concluida.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/inscricao-rejeitada.jsp");
				dispatcher.forward(request, response);
			}

		}

	}

	private void alunosTurma(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Usuario usuario = null;
		List<Aluno> alunos = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("professor")) {

			long idTurma = Long.parseLong(request.getParameter("id-turma"));
			alunos = alunoDAO.recuperarAlunosPeloIdTurma(idTurma);
			request.setAttribute("alunos", alunos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-alunos-professor.jsp");
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

}
