package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;

@WebServlet(urlPatterns = { "/inserir-instituicao", "/atualizar-perfil-instituicao", "/recuperar-perfil-instituicao" })
public class InstituicaoServlet extends HttpServlet {

	private static final long serialVersionUID = 772514583419437616L;

	PapelDAO papelDAO;
	private InstituicaoDAO instituicaoDAO;
	private UsuarioDAO usuarioDAO;
	private EnderecoDAO enderecoDAO;

	public void init() {
		papelDAO = new PapelDAOImpl();
		instituicaoDAO = new InstituicaoDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-instituicao" -> inserirInstituicao(request, response);
			case "/atualizar-perfil-instituicao" -> atualizarPerfilInstituicao(request, response);
			case "/recuperar-perfil-instituicao" -> recuperarPerfilInstituicao(request, response);
			default -> referenciaNaoEncontrada(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void inserirInstituicao(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome-instituicao");
		String descricao = request.getParameter("descricao-instituicao");
		String email = request.getParameter("email");
		String cnpj = request.getParameter("cnpj");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		LocalDate dataFundacao = LocalDate.parse(request.getParameter("data-fundacao"));
		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String via = request.getParameter("via");

		// papel mais detalhado quando for construido.
		Papel papel = new Papel();
		papel.setPapel("Nulo");

		Endereco endereco = new Endereco(logradouro, bairro, cidade, estado, cep, numero, complemento, via);

		papelDAO.inserirPapel(papel);
		enderecoDAO.inserirEndereco(endereco);
		usuarioDAO.inserirUsuario(
				new Instituicao(senha, endereco, papel, telefone, email, cnpj, nome, dataFundacao, descricao));
	}

	private void atualizarPerfilInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Instituicao instituicaoRecuperada = null;

		if (session == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		instituicaoRecuperada = (Instituicao) session.getAttribute("usuario-logado");

		if (instituicaoRecuperada.equals(session.getAttribute("usuario-logado"))) {

			if (instituicaoRecuperada != null) {

				String nome = request.getParameter("nome-instituicao");
				String descricao = request.getParameter("descricao-instituicao");
				String email = request.getParameter("email");
				String cnpj = request.getParameter("cnpj");
				String telefone = request.getParameter("telefone");
				String senha = request.getParameter("senha");
				LocalDate dataFundacao = LocalDate.parse(request.getParameter("data-fundacao"));

				instituicaoRecuperada = instituicaoDAO.recuperarIntituicaoPeloCnpj(cnpj);

				instituicaoRecuperada.setNome(nome);
				instituicaoRecuperada.setDescricao(descricao);
				instituicaoRecuperada.setEmail(email);
				instituicaoRecuperada.setCnpj(cnpj);
				instituicaoRecuperada.setTelefone(telefone);
				instituicaoRecuperada.setSenha(senha);
				instituicaoRecuperada.setDataFundacao(dataFundacao);

				usuarioDAO.atualizarUsuario(instituicaoRecuperada);

				request.setAttribute("instituicao", instituicaoRecuperada);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-instituicao.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	private void recuperarPerfilInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Instituicao instituicaoRecuperada = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		instituicaoRecuperada = (Instituicao) session.getAttribute("usuario-logado");

		if (instituicaoRecuperada.equals(session.getAttribute("usuario-logado"))) {

			if (instituicaoRecuperada != null) {

		request.setAttribute("instituicao", instituicaoRecuperada);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-instituicao.jsp");
		dispatcher.forward(request, response);
			}
		}
	}

	private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
		// pagina para referência não encontrada.
	}
}
