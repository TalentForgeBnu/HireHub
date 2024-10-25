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
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Papel papel = new Papel();

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
        papel.setPapel("sim:)");

        Endereco endereco = new Endereco(logradouro,bairro,cidade,estado,cep,numero,complemento,via);
        papelDAO.inserirPapel(papel);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Empresa(senha,endereco,papel,telefone,email,cnpj,nome,dataFundacao,descricao));
    }
    private void atualizarPerfilEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Papel papel = new Papel();

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
        //int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String via = request.getParameter("via");

        papel.setPapel("sim:)");

        Endereco endereco = new Endereco(logradouro,bairro,cidade,estado,cep,1 /*numero*/,complemento,via);

        Empresa empresaRecuperada = empresaDAO.recuperarEmpresaPeloCnpj(cnpj);

        //atualizando dados.
        empresaRecuperada.setNome(nome);
        empresaRecuperada.setDescricao(descricao);
        empresaRecuperada.setEmail(email);
        empresaRecuperada.setDataFundacao(dataFundacao);
        empresaRecuperada.setCnpj(cnpj);
        empresaRecuperada.setTelefone(telefone);
        empresaRecuperada.setSenha(senha);
        empresaRecuperada.setEndereco(endereco);

        usuarioDAO.atualizarUsuario(empresaRecuperada);

        request.setAttribute("empresa", empresaRecuperada);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-empresa.jsp");
        dispatcher.forward(request, response);
    }
    private void recuperarPerfilEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Papel papel = new Papel();
        papel.setPapel("sim");
        Endereco endereco = new Endereco("rua tal", "um bairro ae", "cidade", "um Estado", "cep", 123, "complemento ai", "via");
        Empresa empresa = new Empresa("213", endereco, papel, "123", "123@gmail.com", "123", "NOme", LocalDate.now(), "AAAAAAAAAAAAAA");

        request.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-empresa.jsp");
        dispatcher.forward(request, response);
    }
    
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
