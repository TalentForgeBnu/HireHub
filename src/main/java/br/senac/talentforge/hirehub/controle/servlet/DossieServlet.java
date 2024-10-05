package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAO;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dossie")
public class DossieServlet extends HttpServlet {

	private static final long serialVersionUID = -5219702605927605608L;

	private DossieDAO dossieDAO;
	
	public void init() {
		dossieDAO = new DossieDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/inserir" -> inserirDossie(request, response);
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void inserirDossie(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
    	
    	//Retirar Aluno depois
    	
    	Aluno aluno = new Aluno();
    	
    	String conteudo = request.getParameter("conteudo");
    	
    	dossieDAO.inserirDossie(new Dossie(conteudo,aluno));
    	
    }
    
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
	
}
