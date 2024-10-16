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

import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAO;
import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAO;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.rendafamiliar.RendaFamiliar;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;
 
@WebServlet(urlPatterns = {"/inserir-apontamento", "/recuperar-apontamento"})
public class ApontamentoServlet extends HttpServlet {
 
    private static final long serialVersionUID = -4592280850903991380L;
 
    private ApontamentoDAO apontamentoDAO;
 
    public void init() {
        apontamentoDAO = new ApontamentoDAOImpl();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-apontamento" -> inserirApontamento(request, response);
                case "/recuperar-apontamento" -> recuperarApontamento(request, response);
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    private void inserirApontamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Papel papel = new Papel("sim");
        Endereco endereco = new Endereco("rua tal", "um bairro ae", "cidade", "um Estado", "cep", 123, "complemento ai", "via");
        Aluno aluno = new Aluno("minhasenha", endereco, papel, "12345678", "aluno@email.com", "1234567890", "nomealuno", "sobrenome aluno", "sim", LocalDate.now(), RendaFamiliar.ATE_1_SALARIO_MINIMO, Etnia.BRANCO, Sexo.MASCULINO);
        Dossie dossie = new Dossie("um conteudo", aluno);
 
        PapelDAO papelDAO = new PapelDAOImpl();
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
        DossieDAO dossieDAO = new DossieDAOImpl();
 
        papelDAO.inserirPapel(papel);
        enderecoDAO.inserirEndereco(endereco);
        dossieDAO.inserirDossie(dossie);
        
        String apontamento = request.getParameter("apontamento");
        LocalDate dataCriacao = LocalDate.parse(request.getParameter("data-criacao"));
 
        apontamentoDAO.inserirApontamento(new Apontamento(apontamento, dataCriacao, dossie));
    }
 
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
    	
    }
    private void recuperarApontamento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	Papel papel = new Papel("sim");
    	Endereco endereco = new Endereco("rua tal", "um bairro ae", "cidade", "um Estado", "cep", 123, "complemento ai", "via");
    	Aluno aluno = new Aluno("minhasenha", endereco, papel, "12345678", "aluno@email.com", "1234567890", "nomealuno", "sobrenome aluno", "sim", LocalDate.now(), RendaFamiliar.ATE_1_SALARIO_MINIMO, Etnia.BRANCO, Sexo.MASCULINO);
        Dossie dossie = new Dossie("da boa", aluno);
        Apontamento apontamento = new Apontamento("da boa",  LocalDate.now(), dossie );
        request.setAttribute("apontamento", apontamento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/Apontamento.jsp");
        dispatcher.forward(request, response);
    }
}