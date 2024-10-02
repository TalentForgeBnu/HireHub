package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAO;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;

@WebServlet("/empresa/*")
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
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/inserir" -> inserirEmpresa(request, response);
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
    	
    	//Pt1 Dados Empresa
    	Papel papel = new Papel();
    	
    	String nome = request.getParameter("nomeempresa");
        String descricao = request.getParameter("descricaoempresa");
        String email = request.getParameter("email");
        String cnpj = request.getParameter("cnpj");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        LocalDate dataFundacao = LocalDate.ofEpochDay(request.getDateHeader("datafundacao"));
    	
        //Pt2 Dados Empresa
        
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        int numero = Integer.valueOf("numero");
        
        Endereco endereco = new Endereco(logradouro,bairro,cidade,estado,cep,numero);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Empresa(senha,endereco,papel,telefone,email,cnpj,nome,dataFundacao,descricao));
    	
    }
    
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
