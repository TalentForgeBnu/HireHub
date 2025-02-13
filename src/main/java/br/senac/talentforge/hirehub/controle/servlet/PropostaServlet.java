package br.senac.talentforge.hirehub.controle.servlet;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAO;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAO;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.oferta.Oferta;
 
@WebServlet(urlPatterns = { "/inserir-proposta","/atualizar-proposta","/recuperar-proposta", "/recuperar-lista-proposta"})
public class PropostaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4400143644977694774L;
	
	private VagaDAO vagaDAO;
	private CursoDAO cursoDAO;
	private PropostaDAO propostaDAO;
 
	public void init() {
		vagaDAO = new VagaDAOImpl();
		cursoDAO = new CursoDAOImpl();
		propostaDAO = new PropostaDAOImpl();
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-proposta" -> inserirProposta(request, response);
			case "/atualizar-proposta" -> atualizarProposta(request, response);
			case "/recuperar-proposta" -> recuperarProposta(request, response);
			case "/recuperar-lista-proposta" -> recuperarListaProposta(request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void inserirProposta(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		
		HttpSession session = request.getSession();
		Instituicao instituicao = null;
		
		if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("instituicao")) {
        	
        	instituicao = (Instituicao) usuario;
        	
        	long idproposta = Long.parseLong(request.getParameter("proposta"));  
        	long idCurso = Long.parseLong(request.getParameter("curso-id"));
        	long idvaga = Long.parseLong(request.getParameter("vaga-id"));
        	Oferta oferta = Oferta.EM_ESPERA;
        	Vaga vaga = vagaDAO.recuperarVagaPeloId(idvaga);
        	Curso curso = cursoDAO.recuperarCursoPeloId(idCurso);
        	
        	Proposta proposta = new Proposta(idproposta,null,oferta,null,curso,vaga.getEmpresa(),instituicao);
        	propostaDAO.inserirProposta(proposta);
        	
        }else {
            response.sendRedirect(request.getContextPath());
        }		
	}
	
	private void atualizarProposta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Empresa empresa = null;
		
		if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("empresa")) {
        	
        	empresa = (Empresa) usuario;
        	
        	String resposta = request.getParameter("resposta");        	
        	Oferta oferta = Oferta.valueOf(request.getParameter("andamento-oferta").toUpperCase());
        	long idProposta = Long.parseLong(request.getParameter("id-proposta")); 
        	Proposta proposta = propostaDAO.recuperarPropostaPeloId(idProposta);
        	
        	proposta.setResposta(resposta);
        	proposta.setAndamentoOferta(oferta);
        	
        	propostaDAO.atualizarProposta(proposta);
        	
        }else {
            response.sendRedirect(request.getContextPath());
        }
		
		
		
	}
	
	private void recuperarProposta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Instituicao instituicao = null;
		
		if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("instituicao") || usuario.getPapel().getFuncao().equals("empresa")){
        	       
        	Long idproposta = Long.parseLong(request.getParameter("id-prospota"));
        	Proposta proposta = propostaDAO.recuperarPropostaPeloId(idproposta);
        	
        	request.setAttribute("proposta", proposta);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/recuperar-proposta.jsp");
    		dispatcher.forward(request, response);       	
        }else {
            response.sendRedirect(request.getContextPath());
        } 	
	}
	
	private void recuperarListaProposta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Instituicao instituicao = null;
		Empresa empresa = null;
		List<Proposta> propostas = new ArrayList<Proposta>();
		
		if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("instituicao")){
        	
        	instituicao = (Instituicao) session.getAttribute("usuario-logado");
        	
        	propostas = propostaDAO.recuperarPropostasPeloIdInstituicao(instituicao.getId());    
        	request.setAttribute("propostas", propostas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-propostas-instituicao.jsp");
            dispatcher.forward(request, response);
        }
        if(usuario.getPapel().getFuncao().equals("empresa")) {
        
        	empresa = (Empresa) session.getAttribute("usuario-logado");
        	propostas = propostaDAO.recuperarPropostasPeloIdEmpresa(empresa.getId());
        	request.setAttribute("propostas", propostas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-propostas-empresa.jsp");
            dispatcher.forward(request, response);
        	
        }else {
            response.sendRedirect(request.getContextPath());
        }	
	}
}