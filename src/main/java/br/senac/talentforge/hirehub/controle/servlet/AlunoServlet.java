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
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.rendafamiliar.RendaFamiliar;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@WebServlet(urlPatterns = {"/inserir-aluno", "/atualizar-perfil-aluno", "/recuperar-lista-alunos"})
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

    private void inserirAluno(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        //arrumar gambiarra
        Papel papel = new Papel("aluno");
        papelDAO.inserirPapel(papel);
        papel = papelDAO.recuperarPapelPelaFuncao("aluno");

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

        Endereco endereco = new Endereco(logadouro, bairro, cidade, estado, cep, numero, complemento, via);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Aluno(senha, endereco, papel, telefone, email, cpf, nome, sobrenome, nomeSocial, dataNascimento, rendaFamiliar, etnia, sexo));

        response.sendRedirect(request.getContextPath());
    }

    private void atualizarPerfilAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Aluno aluno = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + ("Paginas/tela-login.jsp"));
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("aluno")) {

            aluno = (Aluno) usuario;

            // Dados endereço
            String estado = request.getParameter("estado");
            String cidade = request.getParameter("cidade");
            String logadouro = request.getParameter("logradouro");
            String bairro = request.getParameter("bairro");
            String cep = request.getParameter("cep");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String complemento = request.getParameter("complemento");
            String via = request.getParameter("via");
            Endereco endereco = new Endereco(logadouro, bairro, cidade, estado, cep, numero, complemento, via);

            // dados aluno
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String nomeSocial = request.getParameter("nome-social");
            LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
            Etnia etnia = Etnia.valueOf(request.getParameter("etnia").toUpperCase());
            Sexo sexo = Sexo.valueOf(request.getParameter("sexo").toUpperCase());
            String senha = request.getParameter("senha");
            String renda = request.getParameter("renda-familiar").replace("-", "_");
            RendaFamiliar rendaFamiliar = RendaFamiliar.valueOf(renda.toUpperCase());

            // atualizando dados.
            aluno.setNome(nome);
            aluno.setSobrenome(sobrenome);
            aluno.setNomeSocial(nomeSocial);
            aluno.setDataNascimento(dataNascimento);
            aluno.setEtnia(etnia);
            aluno.setSexo(sexo);
            aluno.setSenha(senha);
            aluno.setRendaFamiliar(rendaFamiliar);
            aluno.setEndereco(endereco);

            usuarioDAO.atualizarUsuario(aluno);

            request.setAttribute("aluno", aluno);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/perfil-aluno.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

    private void recuperarPerfilAluno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.getAttribute("usuario-logado");

        Aluno aluno = null;
        Endereco alunoEndereco = null;

        if (session == null || session.getAttribute("usuario-logado") == null) {
            response.sendRedirect(request.getContextPath() + "/Paginas/tela-login.jsp");
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario-logado");

        if (usuario.getPapel().getFuncao().equals("aluno")) {

            aluno = (Aluno) usuario;
            alunoEndereco = enderecoDAO.recuperarEnderecoPeloIdUsuario(aluno.getId());

            request.setAttribute("aluno", aluno);
            request.setAttribute("endereco", alunoEndereco);

            String rendafamiliar = aluno.getRendaFamiliar().toString().replace("_", "-").toLowerCase();
            request.setAttribute("rendafamiliar", rendafamiliar);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Paginas/perfil-aluno.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

}