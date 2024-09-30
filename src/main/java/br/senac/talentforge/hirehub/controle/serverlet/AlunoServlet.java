package br.senac.talentforge.hirehub.controle.serverlet;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@WebServlet("/")
public class AlunoServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 1817596775729858905L;
    private AlunoDAO alunoDAO;
    private UsuarioDAO usuarioDAO;

    public void init() {
        alunoDAO = new AlunoDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir" -> inserirAluno(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    private void inserirAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        Papel papel = new Papel();

        //Pt1 Dados Aluno
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        LocalDate dataNascimento = LocalDate.ofEpochDay(request.getDateHeader("dataNascimento"));
        Etnia etnia = Etnia.valueOf(request.getParameter("etinia"));
        Sexo sexo = Sexo.valueOf(request.getParameter("sexo"));

        //Pt1 Dados Endereco
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String logadouro = request.getParameter("logadouro");
        String bairro = request.getParameter("bairo");
        String cep = request.getParameter("cep");
        int numero = Integer.parseInt(request.getParameter("numero"));

        //Pt2 Dados Aluno
        String nomeSocial = request.getParameter("nomeSocial");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        Float rendaFamiliar = Float.valueOf(request.getParameter("rendaFamiliar"));

        // Dados não existentes
        String cpf = request.getParameter("cpf");

        Endereco endereco = new Endereco(logadouro, bairro, cidade, estado, cep, numero);
        usuarioDAO.inserirUsuario(new Aluno(senha, endereco, papel, telefone, email, cpf, nome, sobrenome, nomeSocial, dataNascimento, rendaFamiliar, etnia, sexo));

    }

}