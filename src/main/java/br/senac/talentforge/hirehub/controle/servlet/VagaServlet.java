package br.senac.talentforge.hirehub.controle.servlet;
 
import java.io.IOException;
 
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
 
@WebServlet(urlPatterns = { "/inserir-vaga", "/recuperar-vaga" })
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
			throws IOException, ServletException {
 
		HttpSession session = request.getSession();
		Empresa empresa = null;
		Vaga vaga = null;
 
		if (session == null && session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}
 
		empresa = (Empresa) session.getAttribute("usuario-logado");
 
		if (empresa.equals(session.getAttribute("usuario-logado"))) {
 
			if (empresa != null) {
				
				vagaDAO.inserirVaga(vaga);
				
				request.setAttribute("vaga", vaga);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-vagas-empresa");
				dispatcher.forward(request, response);
			}
		}
	}
 
	private void recuperarVaga(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
 
		HttpSession session = request.getSession();
		Empresa empresa = null;
		Vaga vaga = null;
 
		if (session == null && session.getAttribute("usuario-logado") == null) {
			response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
		}
 
		empresa = (Empresa) session.getAttribute("usuario-logado");
 
		if (empresa.equals(session.getAttribute("usuario-logado"))) {
 
			if (empresa != null) {
				
				vaga = vagaDAO.recuperarVagaPeloIdEmpresa(empresa.getId());
				
				request.setAttribute("vaga", vaga);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-vagas-empresa.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
 