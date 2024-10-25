package br.senac.talentforge.hirehub.controle.servlet;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.turno.Turno;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/inserir-turma", "/atualizar-turma", "/recuperar-lista-turma"})
public class TurmaServlet extends HttpServlet {

    private static final long serialVersionUID = -1567154649778415575L;

    private TurmaDAO turmaDAO;
    private UsuarioDAO usuarioDAO;
    private PapelDAO papelDAO;
    private ProfessorDAO professorDAO;
    private EnderecoDAO enderecoDAO;
    private InstituicaoDAO instituicaoDAO;
    private CursoDAO cursoDAO;

    public void init() {
        turmaDAO = new TurmaDAOImpl();
        enderecoDAO = new EnderecoDAOImpl();
        papelDAO = new PapelDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
        professorDAO = new ProfessorDAOImpl();
        instituicaoDAO = new InstituicaoDAOImpl();
        cursoDAO = new CursoDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-turma" -> inserirTurma(request, response);
                case "/recuperar-lista-turma" -> recuperarListaTurma(request, response);
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

    private void inserirTurma(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        //Endereco Professor e instituição retirar depois

        HttpSession session = request.getSession();
        Instituicao instituicao = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + ("/usuario-login"));
        }

        instituicao = (Instituicao) session.getAttribute("usuario-logado");

        if (instituicao.equals(session.getAttribute("usuario-logado"))) {

            Professor professor = professorDAO.recuperarProfessor(request.getParameter("professor-cpf"));

            String nome = request.getParameter("nome");
            String codigo = request.getParameter("codigo");
            byte tamanho = Byte.valueOf(request.getParameter("tamanho"));
            Turno turno = Turno.valueOf(request.getParameter("turno").toUpperCase());
            turmaDAO.inserirTurma(new Turma(nome, codigo, tamanho, professor, instituicao, turno, null));
            //Jonathan THE MAN disse que curso está nulo para testes. REMOVA ASSIM QUE PUDER!!!!!!!

        }
    }

    private void recuperarListaTurma(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Professor professor = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect("Paginas/tela-login.jsp");
        }

        professor = (Professor) session.getAttribute("usuario-logado");

        if (professor.equals(session.getAttribute("usuario-logado"))) {

            List<Turma> turmas = turmaDAO.recuperarTurmasPeloIdProfessor(professor.getId());

            request.setAttribute("turmas", turmas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-turmas.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
