package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAO;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;

@WebServlet(urlPatterns = {"/inserir-dossie", "/atualizar-dossie", "/recuperar-dossie"})
public class DossieServlet extends HttpServlet {

    private static final long serialVersionUID = -5219702605927605608L;

    private AlunoDAO alunoDAO;
    private DossieDAO dossieDAO;

    public void init() {
        dossieDAO = new DossieDAOImpl();
        alunoDAO = new AlunoDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-dossie" -> inserirDossie(request, response);
                case "/recuperar-dossie" -> recuperarDossie(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirDossie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        HttpSession session = request.getSession();
        Professor professor = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
        }

        professor = (Professor) session.getAttribute("usuario-logado");

        if(professor.equals(session.getAttribute("usuario-logado"))){
            Aluno aluno = alunoDAO.recuperarAlunoPeloCpf(request.getParameter("aluno-cpf"));
            String conteudo = request.getParameter("conteudo");
            dossieDAO.inserirDossie(new Dossie(conteudo, aluno));
        }else {
            response.sendRedirect(request.getContextPath());
        }

    }

    private void recuperarDossie(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(Long.parseLong(request.getParameter("aluno-id")));
        request.setAttribute("dossie", dossie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/cadastro-dossie.jsp");
        dispatcher.forward(request, response);
    }

}
