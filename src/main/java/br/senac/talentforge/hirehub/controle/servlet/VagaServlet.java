package br.senac.talentforge.hirehub.controle.servlet;
 
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAO;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAO;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;

@WebServlet(urlPatterns = {"/inserir-vaga", "/atualizar-vaga"})
public class VagaServlet extends HttpServlet {
 
	private static final long serialVersionUID = 3963892615335298562L;
	private VagaDAO vagaDAO;
    private EmpresaDAO empresaDAO;
 
    public void init() {
        vagaDAO = new VagaDAOImpl();
        empresaDAO = new EmpresaDAOImpl();
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
 
    	String codigo = request.getParameter("codigo-vaga");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao-vaga");
        String empresaId = request.getParameter("id-empresa");
        Empresa empresa = empresaDAO.recuperarEmpresaPeloCnpj(empresaId);
        Contratacao contratacao = Contratacao.valueOf(request.getParameter("modalidade-contratacao").toUpperCase());
        Situacao situacao = Situacao.valueOf(request.getParameter("situacao").toUpperCase());
        Vaga vaga = new Vaga(codigo, nome, descricao, contratacao, situacao, empresa);
        vagaDAO.inserirVaga(vaga);
    }
 
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}