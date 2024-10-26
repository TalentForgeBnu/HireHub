package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAO;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

@WebServlet(urlPatterns = {"/inserir-empresa", "/atualizar-perfil-empresa", "/recuperar-perfil-empresa"})
public class EmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = -7157263069775551523L;

    private PapelDAO papelDAO;
    private EmpresaDAO empresaDAO;
    private UsuarioDAO usuarioDAO;
    private EnderecoDAO enderecoDAO;

    public void init() {
        papelDAO = new PapelDAOImpl();
        empresaDAO = new EmpresaDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
        enderecoDAO = new EnderecoDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-empresa" -> inserirEmpresa(request, response);
                case "/atualizar-perfil-empresa" -> atualizarPerfilEmpresa(request, response);
                case "/recuperar-perfil-empresa" -> recuperarPerfilEmpresa(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Papel papel = new Papel("empresa");

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String email = request.getParameter("email");
        String cnpj = request.getParameter("cnpj");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        LocalDate dataFundacao = LocalDate.parse(request.getParameter("data-fundacao"));
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String via = request.getParameter("via");

        Endereco endereco = new Endereco(logradouro, bairro, cidade, estado, cep, numero, complemento, via);
        papelDAO.inserirPapel(papel);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Empresa(senha, endereco, papel, telefone, email, cnpj, nome, dataFundacao, descricao));

        response.sendRedirect(request.getContextPath());
    }

    private void atualizarPerfilEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        Empresa empresa = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("empresa")) {

            empresa = (Empresa) usuario;

            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String email = request.getParameter("email");
            String cnpj = request.getParameter("cnpj");
            String telefone = request.getParameter("telefone");
            String senha = request.getParameter("senha");
            LocalDate dataFundacao = LocalDate.parse(request.getParameter("data-fundacao"));
            String logradouro = request.getParameter("logradouro");
            String bairro = request.getParameter("bairro");
            String cep = request.getParameter("cep");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String complemento = request.getParameter("complemento");
            String via = request.getParameter("via");

            Endereco endereco = new Endereco(logradouro, bairro, cidade, estado, cep, numero, complemento, via);

            empresa.setNome(nome);
            empresa.setDescricao(descricao);
            empresa.setEmail(email);
            empresa.setDataFundacao(dataFundacao);
            empresa.setCnpj(cnpj);
            empresa.setTelefone(telefone);
            empresa.setSenha(senha);
            empresa.setEndereco(endereco);

            usuarioDAO.atualizarUsuario(empresa);

            request.setAttribute("empresa", empresa);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-empresa.jsp");
            dispatcher.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath());
        }

    }

    private void recuperarPerfilEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        Empresa empresa = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("empresa")) {

            empresa = (Empresa) usuario;
            request.setAttribute("empresa", empresa);

            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-empresa.jsp");
            dispatcher.forward(request, response);

        }else {
            response.sendRedirect(request.getContextPath());
        }

    }

}
