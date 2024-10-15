package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAO;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAO;
import br.senac.talentforge.hirehub.modelo.dao.proposta.PropostaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAO;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;
import br.senac.talentforge.hirehub.modelo.enumeracao.oferta.Oferta;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;

@WebServlet(urlPatterns = { "/recuperar-proposta" })
public class PropostaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4400143644977694774L;
	
	private EnderecoDAO enderecoDAO;
	private InstituicaoDAO instituicaoDAO;
	private EmpresaDAO empresaDAO;
	private PapelDAO papelDAO;
	private VagaDAO vagaDAO;
	private CursoDAO cursoDAO;
	private PropostaDAO propostaDAO;

	public void init() {
		enderecoDAO = new EnderecoDAOImpl();
		instituicaoDAO = new InstituicaoDAOImpl();
		empresaDAO = new EmpresaDAOImpl();
		papelDAO = new PapelDAOImpl();
		vagaDAO = new VagaDAOImpl();
		cursoDAO = new CursoDAOImpl();
		propostaDAO = new PropostaDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/recuperar-proposta" -> recuperarProposta(request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void recuperarProposta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Endereco enderecoEmp = new Endereco("rua", "bairro", "uma cidade", "Estado", "12982-213", (int) 123,
				"complemento", "via expressa");
		Endereco enderecoInst = new Endereco("rua2", "bairro2", "uma cidade2", "Estado2", "12982-523", (int) 321,
				"complemento2", "via expressa2");
		Papel papelEmp = new Papel("empresa");
		Papel papelInst = new Papel("Instituicao");
		Empresa empresa = new Empresa("1", enderecoEmp, papelEmp, "8002-8922", "sim@gmail", "12-2314-341", "millium",
				LocalDate.now(), "boa");
		Instituicao instituicao = new Instituicao("123", enderecoInst, papelInst, "840", "id@gmail.com", "cnpj",
				"cebrac", LocalDate.now(), "curso bom");
		Vaga vaga = new Vaga("efede", "vaga", "sim", Contratacao.ESTAGIO, Situacao.ABERTA, empresa);
		Curso curso = new Curso();
		Proposta proposta = new Proposta("dorreal", "trereal", Oferta.EM_ESPERA, vaga, curso, empresa, instituicao);
		request.setAttribute("proposta", proposta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/recuperar-proposta.jsp");
		dispatcher.forward(request, response);
	}
}