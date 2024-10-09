package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAO;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;


@WebServlet(urlPatterns = {"/inserir-curso", "/atualizar-curso"})
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
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-curso" -> inserirCurso(request, response);
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirCurso(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
    	
    	
    	String nomeCurso = request.getParameter("nomeCurso");
    	String areaAtuacao = request.getParameter("areaAtuacao");
    	String descricao = request.getParameter("descricaocurso");    	
    	LocalDate dataInicio =  LocalDate.parse(request.getParameter("dataInicio"));
    	LocalDate dataFim =  LocalDate.parse(request.getParameter("dataTermino"));
    	Disponibilidade disponibilidade = Disponibilidade.ABERTO;
    	   	
    	cursoDAO.inserirCurso(new Curso(nomeCurso,areaAtuacao,disponibilidade,dataInicio,dataFim,descricao));
    	
    }
    
    
    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
