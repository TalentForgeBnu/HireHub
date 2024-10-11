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
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAO;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;

@WebServlet(urlPatterns = {"/inserir-vaga", "/atualizar-vaga"})
public class VagaServlet extends HttpServlet {
 
	private static final long serialVersionUID = 3963892615335298562L;
	private VagaDAO vagaDAO;
    private EmpresaDAO empresaDAO;
    private EnderecoDAO enderecoDAO;
    private UsuarioDAO usuarioDAO;
    private PapelDAO papelDAO;
    
    public void init() {
        vagaDAO = new VagaDAOImpl();
        empresaDAO = new EmpresaDAOImpl();
        enderecoDAO = new EnderecoDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
        papelDAO = new PapelDAOImpl();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-vaga":
                    inserirVaga(request, response);
                    break;
                default:
                    referenciaNaoEncontrada(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
      }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
    private void inserirVaga(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
 
    	String estado = "SC";
        String cidade = "Gaspar";
        String logradouro = "Alfredo ramos";
        String bairro = "lala";
        String cep = "123123";
        int numero = 123;
        String complemento = "Casa";
        String via = "rua";
        String data = "2024-03-01";
        LocalDate dataFundacao = LocalDate.parse(data);
        
        Endereco end = new Endereco(logradouro, bairro, cidade, estado, cep, numero, complemento, via);
        
        Papel papel = new Papel();
        papel.setPapel("Sim");
        papelDAO.inserirPapel(papel);
        
        enderecoDAO.inserirEndereco(end);
     
        Empresa empresa = new Empresa("123", end, papel, "4578916475", "empresa@empresa.com", "106572194377", "Empresa", dataFundacao, "sim");
        usuarioDAO.inserirUsuario(empresa);
        
    	String codigo = request.getParameter("codigo-vaga");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao-vaga");
        Contratacao contratacao = Contratacao.valueOf(request.getParameter("modalidade-contratacao").toUpperCase());
        Situacao situacao = Situacao.ABERTA;
        Vaga vaga = new Vaga(codigo, nome, descricao, contratacao, situacao, empresa);
        vagaDAO.inserirVaga(vaga);
    }
 
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}