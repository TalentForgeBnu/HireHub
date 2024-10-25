package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
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
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.estudante.Estudante;
import br.senac.talentforge.hirehub.modelo.enumeracao.rendafamiliar.RendaFamiliar;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;
import org.hibernate.Session;

@WebServlet(urlPatterns = {"/inserir-aluno", "/atualizar-perfil-aluno", "/recuperar-perfil-aluno", "/recuperar-lista-alunos"})
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
                case "/recuperar-lista-alunos" -> recuperarListaAlunos(request, response);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirAluno(HttpServletRequest request, HttpServletResponse response) {

        // Papel ainda tem que ser melhor revisado com o professor.
        Papel papel = new Papel();

        // Dados endereço
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String logadouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String via = request.getParameter("via");

        // Dados aluno
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

    private void atualizarPerfilAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Aluno alunoRecuperado = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
        }

        alunoRecuperado = (Aluno) session.getAttribute("usuario-logado");

        if (alunoRecuperado.equals(session.getAttribute("usuario-logado"))) {
            // dados aluno
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

            // atualizando dados.
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
    }

    private void recuperarPerfilAluno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.getAttribute("usuario-lgado");

        Aluno aluno = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        aluno = (Aluno) session.getAttribute("usuario-logado");

        if (aluno.equals(session.getAttribute("usuario-logado"))) {
            String rendafamiliar = aluno.getRendaFamiliar().toString().replace("_", "-").toLowerCase();
            request.setAttribute("aluno", aluno);
            request.setAttribute("rendafamiliar", rendafamiliar);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-aluno.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void recuperarListaAlunos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Professor professor = null;
        List<Aluno> alunos = new ArrayList<Aluno>();

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "Paginas/tela-login.jsp");
        }

        professor = (Professor) session.getAttribute("usuario-logado");

        if (professor.equals(session.getAttribute("usuario-logado"))) {
            long tumarId = Long.parseLong(request.getParameter("turma-id"));

            alunos = alunoDAO.recuperarAlunosPeloIdTurma(tumarId);

            request.setAttribute("alunos", alunos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/listagem-alunos-professor.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

}