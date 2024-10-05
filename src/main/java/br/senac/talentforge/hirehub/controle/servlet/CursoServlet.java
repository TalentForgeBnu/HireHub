package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/curso")
public class CursoServlet extends HttpServlet {

	private static final long serialVersionUID = 6830527891806311155L;
	
	private CursoDAO cursoDAO;
	
	public void init() {
		cursoDAO = new CursoDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/inserir" -> inserirCurso(request, response);
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirCurso(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
    	
    	//Retirar proposta depois
    	
    	Proposta proposta = new Proposta();
    	
    	String nomeCurso = request.getParameter("nomeCurso");
    	String areaAtuacao = request.getParameter("areaAtuacao");
    	String descricao = request.getParameter("descricaocurso");    	
    	LocalDate dataInicio = LocalDate.ofEpochDay(request.getDateHeader("dataInicio"));
    	LocalDate dataFim = LocalDate.ofEpochDay(request.getDateHeader("dataTermino"));
    	Disponibilidade disponibilidade = Disponibilidade.valueOf(request.getParameter("disponibilidade").toUpperCase());
    	   	
    	cursoDAO.inserirCurso(new Curso(nomeCurso,areaAtuacao,disponibilidade,dataInicio,dataFim,descricao,proposta));
    	
    }
    
    
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
