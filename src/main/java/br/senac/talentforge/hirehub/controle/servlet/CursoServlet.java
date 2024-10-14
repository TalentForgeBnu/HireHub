package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;


@WebServlet(urlPatterns = {"/inserir-curso", "/atualizar-curso", "/recuperar-curso", "/recuperar-lista-cursos"})
public class CursoServlet extends HttpServlet {

    private static final long serialVersionUID = 6830527891806311155L;

    private PropostaDAO propostaDAO;
    private CursoDAO cursoDAO;

    public void init() {
        propostaDAO = new PropostaDAOImpl();
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
                case "/recuperar-lista-cursos" -> recuperarListaCursos(request, response);
                case "/recuperar-curso" -> recuperarCurso(request, response);     
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirCurso(HttpServletRequest request, HttpServletResponse response) {
        String nomeCurso = request.getParameter("nome-curso");
        String areaAtuacao = request.getParameter("area-atuacao");
        String descricao = request.getParameter("descricao-curso");
        LocalDate dataInicio = LocalDate.parse(request.getParameter("data-inicio"));
        LocalDate dataFim = LocalDate.parse(request.getParameter("data-termino"));
        Disponibilidade disponibilidade = Disponibilidade.ABERTO;

        Curso curso = new Curso(nomeCurso, areaAtuacao, disponibilidade, dataInicio, dataFim, descricao, null);

        cursoDAO.inserirCurso(curso);
    }
  
    private void recuperarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    	Curso curso = new Curso("Sistemas da Informação","Informatica", Disponibilidade.ABERTO, LocalDate.now(), LocalDate.now(),"Curso de TI massa", null);

    	  request.setAttribute("curso", curso);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-cursos-instituicao.jsp");
        dispatcher.forward(request, response);
    }  

    private void recuperarListaCursos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	LocalDate dataInicio = LocalDate.parse("2024-10-01");
        LocalDate dataFim = LocalDate.parse("2024-11-01");
        
        Curso curso1 = new Curso("Java", "Java", Disponibilidade.ABERTO, dataInicio,dataFim,"Curso de java");
        Curso curso2 = new Curso("C#", "C#", Disponibilidade.FINALIZADO, dataInicio,dataFim,"Curso de C#");
        Curso curso3 = new Curso("PHP", "PHP", Disponibilidade.INICIADO, dataInicio,dataFim,"Curso de PHP");
        Curso curso4 = new Curso("C++", "C++", Disponibilidade.FINALIZADO, dataInicio,dataFim,"Curso de C++");    	
        List<Curso> cursos = List.of(curso1, curso2, curso3, curso4);
        request.setAttribute("cursos", cursos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-cursos-instituicao.jsp");
        dispatcher.forward(request, response);
    }
}
