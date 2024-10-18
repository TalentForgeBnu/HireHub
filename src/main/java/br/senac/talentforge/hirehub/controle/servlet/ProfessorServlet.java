package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@WebServlet(urlPatterns = {"/inserir-professor", "/atualizar-perfil-professor", "/recuperar-perfil-professor"})
public class ProfessorServlet extends HttpServlet {

    private static final long serialVersionUID = 512561250174084370L;

    PapelDAO papelDAO;
    private EnderecoDAO enderecoDAO;
    private ProfessorDAO professorDAO;
    private UsuarioDAO usuarioDAO;

    public void init() {
        papelDAO = new PapelDAOImpl();
        enderecoDAO = new EnderecoDAOImpl();
        professorDAO = new ProfessorDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-professor" -> inserirProfessor(request, response);
                case "/atualizar-perfil-professor" -> atualizarPerfilProfessor(request, response);
                case "/recuperar-perfil-professor" -> recuperarPerfilProfessor(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void inserirProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        //Lembrar de remover intituicao pois é para testes
        Papel papelInstituicao = new Papel("papelInst");
        Endereco enderecoInstituicao = new Endereco("rua 1", "bairro1", "Cidade1", "estado1", "cep1", 1, "complemento1", "via1");

        Instituicao instituicao = new Instituicao("senha1", enderecoInstituicao, papelInstituicao, "telefone1", "instituicao@email.com", "cnpj1", "nomeInstituicao", LocalDate.now(), "uma descricão");

        Papel papel = new Papel("papelProfessor");

        //Pt1 Dados Professor
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String nomeSocial = request.getParameter("nome-social");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");

        //Pt1 Dados Endereço
        String estado = request.getParameter("estado");
        String logradouro = request.getParameter("logradouro");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String cep = request.getParameter("cep");
        String complemento = request.getParameter("complemento");
        String via = request.getParameter("via");

        //Pt2 Dados Professor
        LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
        Etnia etnia = Etnia.valueOf(request.getParameter("etnia").toUpperCase());
        Sexo sexo = Sexo.valueOf(request.getParameter("sexo").toUpperCase());

        Endereco endereco = new Endereco(logradouro, bairro, cidade, estado, cep, numero, complemento, via);

        papelDAO.inserirPapel(papelInstituicao);
        enderecoDAO.inserirEndereco(enderecoInstituicao);
        usuarioDAO.inserirUsuario(instituicao);

        papelDAO.inserirPapel(papel);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Professor(senha, endereco, papel, telefone, email, cpf, nome, sobrenome, nomeSocial, dataNascimento, etnia, sexo, instituicao));
    }
   
    private void atualizarPerfilProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //dados professorS
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String nomeSocial = request.getParameter("nome-social");
        String cpf = request.getParameter("cpf");
        LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
        Etnia etnia = Etnia.valueOf(request.getParameter("etnia").toUpperCase());
        Sexo sexo = Sexo.valueOf(request.getParameter("sexo").toUpperCase());
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");

        Professor professorRecuperado = professorDAO.recuperarProfessor(cpf);

        //atualizando dados.
        professorRecuperado.setNome(nome);
        professorRecuperado.setSobrenome(sobrenome);
        professorRecuperado.setNomeSocial(nomeSocial);
        professorRecuperado.setDataNascimento(dataNascimento);
        professorRecuperado.setEtnia(etnia);
        professorRecuperado.setSexo(sexo);
        professorRecuperado.setEmail(email);
        professorRecuperado.setSenha(senha);
        professorRecuperado.setTelefone(telefone);

        usuarioDAO.atualizarUsuario(professorRecuperado);

        request.setAttribute("professor", professorRecuperado);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-professor.jsp");
        dispatcher.forward(request, response);
    }
    
    private void recuperarPerfilProfessor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	HttpSession session = request.getSession();
    	Professor professor = (Professor)session.getAttribute("usuario-logado");
    	
        request.setAttribute("professor", professor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-professor.jsp");
        dispatcher.forward(request, response);
    }
}
