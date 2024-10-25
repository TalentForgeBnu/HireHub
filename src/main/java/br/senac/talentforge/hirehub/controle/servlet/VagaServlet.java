package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAO;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAO;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;

@WebServlet(urlPatterns = { "/inserir-vaga", "/atualizar-vaga", "/recuperar-lista-vagas" })
public class VagaServlet extends HttpServlet {

	private static final long serialVersionUID = 3963892615335298562L;
	private VagaDAO vagaDAO;
	private EmpresaDAO empresaDAO;
	private EnderecoDAO enderecoDAO;
	private UsuarioDAO usuarioDAO;
	private PapelDAO papelDAO;

	public void init() {
		vagaDAO = new VagaDAOImpl();
		empresaDAO = new EmpresaDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
		papelDAO = new PapelDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/inserir-vaga" -> inserirVaga(request, response);
			case "/recuperar-lista-vagas" -> recuperaListaVagas(request, response);
			case "/recuperar-vagas" -> recuperarVaga(request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void inserirVaga(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		HttpSession session = request.getSession();
		Empresa empresa = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		empresa = (Empresa) session.getAttribute("usuario-logado");

		if (empresa.equals(session.getAttribute("usuario-logado"))) {

			if (empresa != null) {

				String codigo = request.getParameter("codigo-vaga");
				String nome = request.getParameter("nome");
				String descricao = request.getParameter("descricao-vaga");
				Contratacao contratacao = Contratacao.valueOf(request.getParameter("modalidade-contratacao").toUpperCase());
				Situacao situacao = Situacao.ABERTA;
				Vaga vaga = new Vaga(codigo, nome, descricao, contratacao, situacao, empresa);
				vagaDAO.inserirVaga(vaga);
			}
		}
	}

	private void recuperaListaVagas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Empresa empresa = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		empresa = (Empresa) session.getAttribute("usuario-logado");

		if (empresa.equals(session.getAttribute("usuario-logado"))) {

			if (empresa != null) {

				Vaga vaga1 = new Vaga("codigo1", "nome1", "descrição1", Contratacao.MEIO_PERIODO, Situacao.ABERTA, empresa);
				Vaga vaga2 = new Vaga("codigo2", "nome2", "descrição2", Contratacao.ESTAGIO, Situacao.FECHADA, empresa);
				Vaga vaga3 = new Vaga("codigo3", "nome3", "descrição3", Contratacao.INTEGRAL, Situacao.ABERTA, empresa);
				Vaga vaga4 = new Vaga("codigo4", "nome4", "descrição4", Contratacao.MEIO_PERIODO, Situacao.FECHADA, empresa);
				Vaga vaga5 = new Vaga("codigo5", "nome5", "descrição5", Contratacao.INTEGRAL, Situacao.ABERTA, empresa);

				List<Vaga> vagas = List.of(vaga1, vaga2, vaga3, vaga4, vaga5);

				request.setAttribute("vagas", vagas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-vagas-empresa.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	private void recuperarVaga(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		Empresa empresa = null;

		if (session == null || session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}

		empresa = (Empresa) session.getAttribute("usuario-logado");

		if (empresa.equals(session.getAttribute("usuario-logado"))) {

			if (empresa != null) {

				Vaga vaga = new Vaga("codigo1", "nome1", "descricao1", Contratacao.MEIO_PERIODO, Situacao.ABERTA, empresa);

				request.setAttribute("vaga", vaga);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-vagas-aluno.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}