package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAO;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;

@WebServlet(urlPatterns = { "/inserir-vaga", "/recuperar-lista-vagas", "/recuperar-vaga", "/cadastro-vaga" })
public class VagaServlet extends HttpServlet {

	private static final long serialVersionUID = 3963892615335298562L;
	private VagaDAO vagaDAO;

	public void init() {
		vagaDAO = new VagaDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-vaga" -> inserirVaga(request, response);
			case "/recuperar-lista-vagas" -> recuperarListaVagas(request, response);
			case "/recuperar-vaga" -> recuperarVaga(request, response);
			case "/cadastro-vaga" -> cadastroVaga(request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void inserirVaga(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		Usuario usuario = null;
		Empresa empresa = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("empresa")) {

			empresa = (Empresa) usuario;

			String codigo = request.getParameter("codigo-vaga");
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao-vaga");
			Contratacao contratacao = Contratacao.valueOf(request.getParameter("modalidade-contratacao").toUpperCase());
			Situacao situacao = Situacao.ABERTA;

			Vaga vaga = new Vaga(codigo, nome, descricao, contratacao, situacao, empresa);

			vagaDAO.inserirVaga(vaga);

			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

	private void recuperarListaVagas(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Usuario usuario = null;
		Empresa empresa = null;
		List<Vaga> vagas = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("empresa")) {

			empresa = (Empresa) usuario;

			vagas = vagaDAO.recuperarVagasPeloIdDaEmpresa(empresa.getId());

			request.setAttribute("vagas", vagas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-vagas-empresa.jsp");
			dispatcher.forward(request, response);
		}else if(usuario.getPapel().getFuncao().equals("aluno") || usuario.getPapel().getFuncao().equals("instituicao")){
			
			vagas = vagaDAO.recuperarVagaPelaSituacaoVaga(Situacao.ABERTA); 
	
			request.setAttribute("vagas", vagas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-vagas-empresa.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath());
		}
	}

	private void recuperarVaga(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Vaga vaga = null;
		Usuario usuario = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
		}

		usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("empresa")) {

			long idVaga = Long.parseLong(request.getParameter("id-vaga"));

			vaga = vagaDAO.recuperarVagaPeloId(idVaga);

			request.setAttribute("vaga", vaga);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-vaga");
			dispatcher.forward(request, response);
		}
	}
	
	private void cadastroVaga(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Empresa empresa = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
		}

		Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

		if (usuario.getPapel().getFuncao().equals("empresa")) {
			
			empresa = (Empresa) usuario;
       	 
       	    request.setAttribute("empresa", empresa);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/cadastro-vaga");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}
}