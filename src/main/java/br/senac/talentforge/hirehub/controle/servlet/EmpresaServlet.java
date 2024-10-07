package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAO;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/inserir-empresa", "/atualizar-empresa"})
public class EmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = -7157263069775551523L;
	
	private EmpresaDAO empresaDAO;
	private UsuarioDAO usuarioDAO;
	private EnderecoDAO enderecoDAO;
	
	public void init() {	  
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
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
    	
    	//Pt1 Dados Empresa
    	Papel papel = new Papel();
    	
    	String nome = request.getParameter("nome-empresa");
        String descricao = request.getParameter("descricao-empresa");
        String email = request.getParameter("email");
        String cnpj = request.getParameter("cnpj");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        LocalDate dataFundacao = LocalDate.ofEpochDay(request.getDateHeader("data-fundacao"));
    	
        //Pt2 Dados Empresa
        
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        int numero = Integer.valueOf("numero");
        String complemento = request.getParameter("complemento");
        String via = request.getParameter("via");
        
        Endereco endereco = new Endereco(logradouro,bairro,cidade,estado,cep,numero,complemento,via);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Empresa(senha,endereco,papel,telefone,email,cnpj,nome,dataFundacao,descricao));
    	
    }
    
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
