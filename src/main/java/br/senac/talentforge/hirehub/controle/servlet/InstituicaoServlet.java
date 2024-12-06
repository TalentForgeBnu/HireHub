package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

@WebServlet(urlPatterns = {"/inserir-instituicao", "/atualizar-perfil-instituicao","/tela-logado-instituicao"})
public class InstituicaoServlet extends HttpServlet {

    private static final long serialVersionUID = 772514583419437616L;

    private PapelDAO papelDAO;
    private UsuarioDAO usuarioDAO;
    private EnderecoDAO enderecoDAO;

    public void init() {
        papelDAO = new PapelDAOImpl();
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
                case "/inserir-instituicao" -> inserirInstituicao(request, response);
                case "/atualizar-perfil-instituicao" -> atualizarPerfilInstituicao(request, response);
                case "/tela-logado-instituicao" -> instituicaoLogado(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirInstituicao(HttpServletRequest request, HttpServletResponse response) throws IOException{

        //arrumar gambiarra
        Papel papel = new Papel("instituicao");
        papelDAO.inserirPapel(papel);
        papel = papelDAO.recuperarPapelPelaFuncao("instituicao");

        String nome = request.getParameter("nome-instituicao");
        String descricao = request.getParameter("descricao-instituicao");
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

        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Instituicao(senha, endereco, papel, telefone, email, cnpj, nome, dataFundacao, descricao));
        response.sendRedirect(request.getContextPath());
    }

    private void atualizarPerfilInstituicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Instituicao instituicao = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("instituicao")) {

            instituicao = (Instituicao) usuario;

            String nome = request.getParameter("nome-instituicao");
            String descricao = request.getParameter("descricao-instituicao");
            String email = request.getParameter("email");
            String cnpj = request.getParameter("cnpj");
            String telefone = request.getParameter("telefone");
            String senha = request.getParameter("senha");
            LocalDate dataFundacao = LocalDate.parse(request.getParameter("data-fundacao"));

            instituicao.setNome(nome);
            instituicao.setDescricao(descricao);
            instituicao.setEmail(email);
            instituicao.setCnpj(cnpj);
            instituicao.setTelefone(telefone);
            instituicao.setSenha(senha);
            instituicao.setDataFundacao(dataFundacao);

            usuarioDAO.atualizarUsuario(instituicao);

            request.setAttribute("instituicao", instituicao);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-instituicao.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath());
        }

    }
    
private void instituicaoLogado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
         session.getAttribute("usuario-logado");

         Instituicao instituicao = null;

         if (session == null || session.getAttribute("usuario-logado") == null) {
             response.sendRedirect(request.getContextPath() + "/Paginas/tela-login.jsp");
         }

         Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

         if (usuario.getPapel().getFuncao().equals("instituicao")) {
    	    	   
        	 instituicao = (Instituicao) usuario;
        	 
        	 request.setAttribute("instituicao", instituicao);
        	 RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/instituicao-logado.jsp");
             dispatcher.forward(request, response);
        
         }
    }

}
