package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.time.LocalDate;

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


@WebServlet("/aluno/*")
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/inserir" -> inserirAluno(request, response);
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void inserirAluno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Papel ainda tem que ser melhor revisado com o professor.
        Papel papel = new Papel();

        //Pt1 Dados Aluno
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String nomeSocial = request.getParameter("nomesocial");
        String cpf = request.getParameter("cpf");
        LocalDate dataNascimento = LocalDate.parse(request.getParameter("datanascimento"));
        Etnia etnia = Etnia.valueOf(request.getParameter("etnia").toUpperCase());
        Sexo sexo = Sexo.valueOf(request.getParameter("sexo").toUpperCase());
        RendaFamiliar rendaFamiliar = RendaFamiliar.valueOf(request.getParameter("rendafamiliar").toUpperCase());

        //Pt1 Dados Endereco
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String logadouro = request.getParameter("logadouro");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String via = request.getParameter("via");

        //Pt2 Dados Aluno
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");


        papel.setPapel("Sim");
        Endereco endereco = new Endereco(logadouro, bairro, cidade, estado, cep, numero,complemento,via);
        papelDAO.inserirPapel(papel);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Aluno(senha, endereco, papel, telefone, email, cpf, nome, sobrenome, nomeSocial, dataNascimento, rendaFamiliar, etnia, sexo));

        response.sendRedirect(request.getContextPath() + "/Pages/CadastroAlunoP1.jsp");
    }

    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }

}