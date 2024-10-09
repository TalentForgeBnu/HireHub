package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAO;
import br.senac.talentforge.hirehub.modelo.dao.papel.PapelDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;
import br.senac.talentforge.hirehub.modelo.enumeracao.turno.Turno;


@WebServlet(urlPatterns = {"/inserir-turma", "/atualizar-turma"})
public class TurmaServlet extends HttpServlet {

    private static final long serialVersionUID = -1567154649778415575L;

    private TurmaDAO turmaDAO;
    private UsuarioDAO usuarioDAO;
    private PapelDAO papelDAO;
    private ProfessorDAO professorDAO;
    private EnderecoDAO enderecoDAO;
    private InstituicaoDAO instituicaoDAO;
    private CursoDAO cursoDAO;

    public void init() {
        turmaDAO = new TurmaDAOImpl();
        enderecoDAO = new EnderecoDAOImpl();
        papelDAO = new PapelDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
        professorDAO = new ProfessorDAOImpl();
        instituicaoDAO = new InstituicaoDAOImpl();       
		cursoDAO = new CursoDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-turma" -> inserirTurma(request, response);
                default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void inserirTurma(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        
        //Endereco Professor e inst retirar depois

        String estado = "SC";
        String cidade = "Blumenau";
        String logradouro = "Aquele";
        String bairro = "la";
        String bairro2 = "la2";
        String cep = "123123";
        int numero = 123;
        int numero2 = 1223;
        String complemento = "Casa";
        String via = "rua";
        String data = "2024-10-01";
        LocalDate dataNascimento = LocalDate.parse(data);
        LocalDate dataFundacao = LocalDate.parse(data);
        Etnia etnia = Etnia.ASIATICO;
        Sexo sexo = Sexo.FEMININO;
        Disponibilidade disponibilidade = Disponibilidade.ABERTO;
        
        Endereco end = new Endereco(logradouro, bairro, cidade, estado, cep, numero, complemento, via);
        Endereco end2 = new Endereco(logradouro, bairro2, cidade, estado, cep, numero2, complemento, via);
        
        //Prof, curso, inst retirar depois
        Papel papel = new Papel();
        papel.setPapel("Sim");
        papelDAO.inserirPapel(papel);
        
        enderecoDAO.inserirEndereco(end);
        enderecoDAO.inserirEndereco(end2);
        
        Instituicao inst = new Instituicao("123",end,papel,"123123","thiago@gmail.com","12312312","Senac",dataFundacao,"sim");       
        usuarioDAO.inserirUsuario(inst);
        
        Professor prof = new Professor("123",end2,papel,"1231123","thiago123@gmail.com","123122","Sim","Oi","Oiii",dataNascimento,etnia, sexo,inst);
        usuarioDAO.inserirUsuario(prof);
        
        Curso curso = new Curso("Java","Java",disponibilidade,dataFundacao,dataNascimento,"é ai");
        cursoDAO.inserirCurso(curso);

        String nome = request.getParameter("nome");
        String codigo = request.getParameter("codigo");
        byte tamanho = Byte.valueOf(request.getParameter("tamanho"));
        Turno turno = Turno.valueOf(request.getParameter("turno").toUpperCase());

        turmaDAO.inserirTurma(new Turma(nome, codigo, tamanho, prof, inst, turno, curso));

    }


    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
