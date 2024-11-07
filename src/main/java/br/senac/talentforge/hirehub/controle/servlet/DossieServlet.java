package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;

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
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

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
                case "/atualizar-dossie" -> atualizarDossie(request, response);
                case "/recuperar-dossie" -> recuperarDossie(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirDossie(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        Usuario usuario = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }

        usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("professor")) {

            String cpf = request.getParameter("aluno-cpf");
            Aluno aluno = alunoDAO.recuperarAlunoPeloCpf(cpf);

            String conteudo = request.getParameter("conteudo");
            dossieDAO.inserirDossie(new Dossie(conteudo, aluno));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/recuperar-dossie");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

    private void atualizarDossie(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        Usuario usuario = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }

        usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("professor")) {

            String cpfAluno = request.getParameter("aluno-cpf");
            String conteudo = request.getParameter("conteudo");

            Aluno aluno = alunoDAO.recuperarAlunoPeloCpf(cpfAluno);
            Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(aluno.getId());

            dossie.setConteudo(conteudo);

            dossieDAO.atualizarDossie(dossie);

            request.setAttribute("aluno", aluno);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/recuperar-dossie");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

    private void recuperarDossie(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    	Aluno aluno = null;            
        String cpfAluno = request.getParameter("cpf-aluno");
        
        if(cpfAluno != null) {
        	
        	long idAluno = Long.parseLong(request.getParameter("id-aluno"));
        	aluno = alunoDAO.recuperarAlunoPeloCpf(cpfAluno);
            Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(idAluno);

            request.setAttribute("aluno", aluno);
            request.setAttribute("dossie", dossie);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/cadastro-dossie.jsp");
            dispatcher.forward(request, response);
        	
        }else {
        	
        	aluno = (Aluno) request.getAttribute("aluno");
       	
        	Dossie dossie = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(aluno.getId());

            request.setAttribute("aluno", aluno);
            request.setAttribute("dossie", dossie);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/cadastro-dossie.jsp");
            dispatcher.forward(request, response);
        }




    }

}
