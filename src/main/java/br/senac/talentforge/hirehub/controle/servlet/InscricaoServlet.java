package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.inscricao.InscricaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.inscricao.InscricaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.inscricao.Inscricao;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

@WebServlet(urlPatterns = {"/inserir-inscricao"})
public class InscricaoServlet extends HttpServlet {

	private static final long serialVersionUID = 6745024583303936471L;
	
	private InscricaoDAO inscricaoDAO;
	private CursoDAO cursoDAO;
	
	public void init() {
		
		inscricaoDAO = new InscricaoDAOImpl();
		cursoDAO = new CursoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-inscricao" -> inserirInscricao(request, response);
                 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private void inserirInscricao(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

		HttpSession session = request.getSession();
        Aluno aluno = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("aluno")) {
		
         aluno = (Aluno) session.getAttribute("usuario-logado");
        
        long idCurso = Long.parseLong(request.getParameter("id-curso"));
        Curso curso = cursoDAO.recuperarCursoPeloId(idCurso);
        boolean estado = Boolean.getBoolean(request.getParameter("estado"));
    
        inscricaoDAO.inserirInscricao(new Inscricao(aluno,estado,curso));

        response.sendRedirect(request.getContextPath());
        
        }
    }
}
