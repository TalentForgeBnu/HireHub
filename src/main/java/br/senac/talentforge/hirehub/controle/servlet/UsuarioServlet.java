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
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

@WebServlet(urlPatterns = {"/login", "/usuario-login", "/usuario-logout"})
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
                case "/usuario-login" -> loginUsuario(request, response);
                case "/usuario-logout" -> logoutUsuario(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void paginaLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/tela-login.jsp");
        dispatcher.forward(request, response);

    }

    private void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            response.sendRedirect(request.getContextPath());
        }else {
            response.sendRedirect(request.getContextPath() + "/login");
        }


    }

    private void logoutUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath());
    }

}