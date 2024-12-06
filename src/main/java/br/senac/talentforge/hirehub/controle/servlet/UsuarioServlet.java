package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

@WebServlet(urlPatterns = {"/login", "/perfil", "/usuario-login", "/usuario-logout", "/cadastro"})
public class UsuarioServlet extends HttpServlet {

    UsuarioDAO usuarioDAO;

    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAOImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/login" -> paginaLogin(request, response);
                case "/perfil" -> perfilUsuario(request, response);
                case "/usuario-login" -> loginUsuario(request, response);
                case "/usuario-logout" -> logoutUsuario(request, response);
                case "/cadastro" -> cadastro(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void paginaLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Paginas/tela-login.jsp");
        dispatcher.forward(request, response);
    }

    private void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Usuario usuarioRecuperado = null;
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            usuarioRecuperado = usuarioDAO.recuperarUsuarioPeloEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (usuarioRecuperado != null && usuarioRecuperado.getEmail().equals(email) && usuarioRecuperado.getSenha().equals(senha)) {
            session.setAttribute("usuario-logado", usuarioRecuperado);
            session.setMaxInactiveInterval(6000);
            response.sendRedirect(request.getContextPath());
        } else {
            request.setAttribute("erro", "Usuario não existe ou as credenciais são invalidadas");
            paginaLogin(request, response);
        }

    }

    private void logoutUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath());
    }

    private void perfilUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Usuario usuario = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }

        usuario = (Usuario) session.getAttribute("usuario-logado");

        String funcao = usuario.getPapel().getFuncao();

        switch (funcao) {
            case "aluno" -> perfilAluno(request, response, usuario);
            case "empresa" -> perfilEmpresa(request, response, usuario);
            case "instituicao" -> perfilInstituicao(request, response, usuario);
            case "professor" -> perfilProfessor(request, response, usuario);
            default -> response.sendRedirect(request.getContextPath());
        }

    }

    private void perfilAluno(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
        Aluno aluno = (Aluno) usuario;

        request.setAttribute("aluno", aluno);
        String rendafamiliar = aluno.getRendaFamiliar().toString().replace("_", "-").toLowerCase();
        request.setAttribute("rendafamiliar", rendafamiliar);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-aluno.jsp");
        dispatcher.forward(request, response);
    }

    private void perfilEmpresa(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
        Empresa empresa = (Empresa) usuario;

        request.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-empresa.jsp");
        dispatcher.forward(request, response);
    }

    private void perfilInstituicao(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
        Instituicao instituicao = (Instituicao) usuario;

        request.setAttribute("instituicao", instituicao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-instituicao.jsp");
        dispatcher.forward(request, response);
    }

    private void perfilProfessor(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
        Professor professor = (Professor) usuario;

        request.setAttribute("professor", professor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-professor.jsp");
        dispatcher.forward(request, response);
    }

    private void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/cadastro-acesso.jsp");
        dispatcher.forward(request, response);
    }

}