package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.rendafamiliar.RendaFamiliar;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@WebServlet(urlPatterns = {"/inserir-aluno", "/atualizar-perfil-aluno", "/recuperar-perfil-aluno"})
public class AlunoServlet extends HttpServlet {

    private static final long serialVersionUID = 1817596775729858905L;

    private EnderecoDAO enderecoDAO;
    private PapelDAO papelDAO;
    private AlunoDAO alunoDAO;
    private UsuarioDAO usuarioDAO;

    public void init() {
        enderecoDAO = new EnderecoDAOImpl();
        papelDAO = new PapelDAOImpl();
        alunoDAO = new AlunoDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-aluno" -> inserirAluno(request, response);
                case "/atualizar-perfil-aluno" -> atualizarPerfilAluno(request, response);
                case "/recuperar-perfil-aluno" -> recuperarPerfilAluno(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void inserirAluno(HttpServletRequest request, HttpServletResponse response) {
        //Papel ainda tem que ser melhor revisado com o professor.
        Papel papel = new Papel();

        //Dados endereço
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String logadouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String via = request.getParameter("via");

        //Dados aluno
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
        String renda = request.getParameter("renda-familiar").replace("-", "_");
        RendaFamiliar rendaFamiliar = RendaFamiliar.valueOf(renda.toUpperCase());

        papel.setPapel("Sim");
        Endereco endereco = new Endereco(logadouro, bairro, cidade, estado, cep, numero, complemento, via);
        papelDAO.inserirPapel(papel);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Aluno(senha, endereco, papel, telefone, email, cpf, nome, sobrenome, nomeSocial, dataNascimento, rendaFamiliar, etnia, sexo));
    }

    private void atualizarPerfilAluno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //dados aluno
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
        String renda = request.getParameter("renda-familiar").replace("-", "_");
        RendaFamiliar rendaFamiliar = RendaFamiliar.valueOf(renda.toUpperCase());

        Aluno alunoRecuperado = alunoDAO.recuperarAlunoPeloCpf(cpf);

        //atualizando dados.
        alunoRecuperado.setNome(nome);
        alunoRecuperado.setSobrenome(sobrenome);
        alunoRecuperado.setNomeSocial(nomeSocial);
        alunoRecuperado.setDataNascimento(dataNascimento);
        alunoRecuperado.setEtnia(etnia);
        alunoRecuperado.setSexo(sexo);
        alunoRecuperado.setEmail(email);
        alunoRecuperado.setSenha(senha);
        alunoRecuperado.setTelefone(telefone);
        alunoRecuperado.setRendaFamiliar(rendaFamiliar);

        usuarioDAO.atualizarUsuario(alunoRecuperado);

        request.setAttribute("aluno", alunoRecuperado);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-aluno.jsp");
        dispatcher.forward(request, response);
    }

    private void recuperarPerfilAluno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Apos a tela de login, montar isso de forma correta.
        Papel papel = new Papel();
        papel.setPapel("sim");
        Endereco endereco = new Endereco("rua tal", "um bairro ae", "cidade", "um Estado", "cep", 123, "complemento ai", "via");
        Aluno aluno = new Aluno("minhasenha", endereco, papel, "12345678", "aluno@email.com", "1234567890", "nomealuno", "sobrenome aluno", "sim", LocalDate.now(), RendaFamiliar.ATE_1_SALARIO_MINIMO, Etnia.BRANCO, Sexo.MASCULINO);
        request.setAttribute("aluno", aluno);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-aluno.jsp");
        dispatcher.forward(request, response);
    }

}