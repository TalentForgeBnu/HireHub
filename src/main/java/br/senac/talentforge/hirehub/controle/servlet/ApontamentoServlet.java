package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAO;
import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/apontamento")
public class ApontamentoServlet extends HttpServlet {

	private static final long serialVersionUID = -4592280850903991380L;
	
	private ApontamentoDAO apontamentoDAO;
	
	public void init() {
		apontamentoDAO = new ApontamentoDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action){
               case "/inserir" -> inserirApontamento(request,response);
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
		
		//Retirar dossie depois
		
		Dossie dossie = new Dossie();
		
		String apontamento = request.getParameter("apontamento");
		LocalDate dataCriacao = LocalDate.parse(request.getParameter("datacriacao"));
		
		apontamentoDAO.inserirApontamento(new Apontamento(apontamento,dataCriacao,dossie));
		
	}
	
	private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }

}
