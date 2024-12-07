package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
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
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;

@WebServlet(urlPatterns = {"/inserir-curso", "/atualizar-curso", "/recuperar-lista-cursos", "/cadastro-turma"})
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
                case "/atualizar-curso" -> atualizarCurso(request, response);
                case "/recuperar-lista-cursos" -> recuperarListaCursos(request, response);
                case "/cadastro-turma" -> cadastroTurma(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirCurso(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        Instituicao instituicao = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        instituicao = (Instituicao) session.getAttribute("usuario-logado");

        if (instituicao.equals(session.getAttribute("usuario-logado"))) {

            String nomeCurso = request.getParameter("nome-curso");
            String areaAtuacao = request.getParameter("area-atuacao");
            String descricao = request.getParameter("descricao-curso");
            LocalDate dataInicio = LocalDate.parse(request.getParameter("data-inicio"));
            LocalDate dataFim = LocalDate.parse(request.getParameter("data-termino"));
            Disponibilidade disponibilidade = Disponibilidade.ABERTO;

            Curso curso = new Curso(nomeCurso, areaAtuacao, disponibilidade, dataInicio, dataFim, descricao, instituicao);

            cursoDAO.inserirCurso(curso);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    private void atualizarCurso(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        Instituicao instituicao = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("instituicao")) {

            instituicao = (Instituicao) usuario;

            long cursoId = Long.parseLong(request.getParameter("curso-id"));

            Curso curso = cursoDAO.recuperarCursoPeloId(cursoId);

            String descricao = request.getParameter("descricao");
            LocalDate dataInicio = LocalDate.parse(request.getParameter("data-inicio"));
            LocalDate dataFim = LocalDate.parse(request.getParameter("data-fim"));
            String areaAtuacao = request.getParameter("area-atuacao");
            Disponibilidade disponibilidade = Disponibilidade.valueOf(request.getParameter("disponibilidade").toUpperCase().replace("-", "_"));

            curso.setDescricao(descricao);
            curso.setDataInicio(dataInicio);
            curso.setDataFim(dataFim);
            curso.setAreaAtuacao(areaAtuacao);
            curso.setDisponibilidade(disponibilidade);

            cursoDAO.atualizarCurso(curso);
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

    private void recuperarListaCursos(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        List<Curso> cursos = new ArrayList<Curso>();
        Instituicao instituicao = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("aluno")) {

            String atuacao = request.getParameter("atuacao");

            if (atuacao == null || atuacao.isEmpty()) {
                cursos = cursoDAO.recuperarCursoPelaDisponibilidade(Disponibilidade.ABERTO);
            } else {
                cursos = cursoDAO.recuperarCursosPorAtuacao(atuacao);
            }

            request.setAttribute("cursos", cursos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-cursos-instituicao.jsp");
            dispatcher.forward(request, response);

        }

        if (usuario.getPapel().getFuncao().equals("instituicao")) {

            instituicao = (Instituicao) usuario;

            cursos = cursoDAO.recuperarCursosPeloIdDaInstituicao(instituicao.getId());

            request.setAttribute("cursos", cursos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-cursos-instituicao.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath());
        }

    }
    
    private void cadastroTurma(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Usuario usuario = null;
 
        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }
 
        usuario = (Usuario) session.getAttribute("usuario-logado");
 
        if (usuario.getPapel().getFuncao().equals("instituicao")) {
 
        	long idCurso = Long.parseLong(request.getParameter("id"));
            Curso curso = cursoDAO.recuperarCursoPeloId(idCurso);
 
            request.setAttribute("curso", curso);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/cadastro-turma.jsp");
            dispatcher.forward(request, response);
        }
 
    }


}
