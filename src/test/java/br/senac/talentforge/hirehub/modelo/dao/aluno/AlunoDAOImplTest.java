package br.senac.talentforge.hirehub.modelo.dao.aluno;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.andamentocurso.AndamentoCurso;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AlunoDAOImplTest {

    private final InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
    private final CursoDAO cursoDAO = new CursoDAOImpl();
    private final TurmaDAO turmaDAO = new TurmaDAOImpl();
    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final AlunoDAO alunoDAO = new AlunoDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private final Instituicao instituicaoTeste = new Instituicao();
    private final Professor professorTeste = new Professor();
    private final Curso cursoTeste = new Curso();
    private final Turma turmaTeste = new Turma();
    private final Endereco enderecoTeste1 = new Endereco();
    private final Endereco enderecoTeste2 = new Endereco();
    private final Endereco enderecoTeste3 = new Endereco();
    private final Endereco enderecoTeste4 = new Endereco();
    private final Aluno alunoTeste1 = new Aluno();
    private final Aluno alunoTeste2 = new Aluno();

    @Test
    @Order(1)
    void recuperarAluno() {
        setarDadosTeste();
        inserirDados();

        Aluno alunoRecuperado = alunoDAO.recuperarAlunoPeloCpf(alunoTeste1.getCpf());

        assertNotNull(alunoRecuperado);
        assertEquals(alunoTeste1.getNome(), alunoRecuperado.getNome());
    }

    @Test
    @Order(2)
    void recuperarAlunosPeloIdTurma() {
        setarDadosTeste();

        Instituicao instituicaoRecuperada = instituicaoDAO.recuperarIntituicao(instituicaoTeste.getCnpj());
        Turma turmaRecuperada = turmaDAO.recuperarTurmaPeloIdIntituicao(instituicaoRecuperada.getId());

        Aluno alunoRecuperado1 = alunoDAO.recuperarAlunoPeloCpf(alunoTeste1.getCpf());
        Aluno alunoRecuperado2 = alunoDAO.recuperarAlunoPeloCpf(alunoTeste2.getCpf());

        alunoRecuperado1.setTurma(turmaRecuperada);
        alunoRecuperado2.setTurma(turmaRecuperada);

        usuarioDAO.atualizarUsuario(alunoRecuperado1);
        usuarioDAO.atualizarUsuario(alunoRecuperado2);
        turmaDAO.atualizarTurma(turmaRecuperada);

        List<Aluno> alunos = alunoDAO.recuperarAlunosPeloIdTurma(turmaRecuperada.getId());

        assertNotNull(alunos);

        assertEquals(2, alunos.size());

        deletarDados();
    }

    private void setarDadosTeste() {
        dadosIntituicao();
        dadosCurso();
        dadosProfessor();
        dadosTurma();
        dadosEndereco();
        dadosAluno();
    }

    private void dadosIntituicao() {
        instituicaoTeste.setNomeEmpresa("Senac");
        instituicaoTeste.setSenha("1234");
        instituicaoTeste.setDescricao("Empresa focada na area de educação");
        instituicaoTeste.setDataFundacao(LocalDate.of(2000, 3, 9));
        instituicaoTeste.setCnpj("12.345.678/0001-95");
        instituicaoTeste.setEndereco(enderecoTeste3);
        instituicaoTeste.setEmail("Senac@email.com");
        instituicaoTeste.setTelefone("47-3332-1234");
    }

    private void dadosCurso() {
        cursoTeste.setNomeCurso("Desenvolvimento de Sistemas");
        cursoTeste.setStatus(AndamentoCurso.INICIADO);
        cursoTeste.setAreaDeAtuacao("Area da Tecnologia");
        cursoTeste.setDataInicio(LocalDate.of(2024, 3, 12));
        cursoTeste.setDataFim(LocalDate.of(2025, 12, 21));
        cursoTeste.setInsituicao(instituicaoTeste);
    }

    private void dadosProfessor() {
        professorTeste.setNome("Lucas");
        professorTeste.setSobrenome("Silva");
        professorTeste.setSenha("aquela");
        professorTeste.setNomeSocial("Luca");
        professorTeste.setCpf("123.456.789-00");
        professorTeste.setMateria("Programação");
        professorTeste.setEndereco(enderecoTeste2);
        professorTeste.setGenero(Genero.MASCULINO);
        professorTeste.setDataNascimento(LocalDate.of(1994, 1, 3));
        professorTeste.setInstituicao(instituicaoTeste);
        professorTeste.setEmail("Lucas@email.com");
        professorTeste.setTelefone("47-91234-5678");

    }

    private void dadosTurma() {
        turmaTeste.setNomeTurma("Turma Da Bagunça");
        turmaTeste.adicionarAluno(alunoTeste1);
        turmaTeste.setCodigo("codigoSecreto");
        turmaTeste.setHorario(LocalTime.of(15, 30));
        turmaTeste.setCurso(cursoTeste);
        turmaTeste.setInstituicao(instituicaoTeste);
        turmaTeste.setProfessor(professorTeste);
    }

    private void dadosEndereco() {
        enderecoTeste1.setCep("12345-678");
        enderecoTeste1.setEstado("Santa Catarina");
        enderecoTeste1.setCidade("Blumenau");
        enderecoTeste1.setBairro("Alameda");
        enderecoTeste1.setNumero(123);
        enderecoTeste1.setLogradouro("Rua das Rosas");

        enderecoTeste2.setCep("12345-679");
        enderecoTeste2.setEstado("Santa Catarina");
        enderecoTeste2.setCidade("Blumenau");
        enderecoTeste2.setBairro("Alameda");
        enderecoTeste2.setNumero(456);
        enderecoTeste2.setLogradouro("Rua das Roxas");

        enderecoTeste3.setCep("23456-789");
        enderecoTeste3.setEstado("Santa Catarina");
        enderecoTeste3.setCidade("Blumenau");
        enderecoTeste3.setBairro("Garcia");
        enderecoTeste3.setNumero(7812);
        enderecoTeste3.setLogradouro("Rua São Paulo");

        enderecoTeste4.setCep("23416-723");
        enderecoTeste4.setEstado("São Paulo");
        enderecoTeste4.setCidade("Piracicaba");
        enderecoTeste4.setBairro("Hugo");
        enderecoTeste4.setNumero(3);
        enderecoTeste4.setLogradouro("Rua Brasil");
    }

    private void dadosAluno() {
        alunoTeste1.setNome("João");
        alunoTeste1.setSobrenome("Costa");
        alunoTeste1.setSenha("123");
        alunoTeste1.setNomeSocial("Joaozinho");
        alunoTeste1.setGenero(Genero.MASCULINO);
        alunoTeste1.setDataNascimento(LocalDate.of(2005, 11, 20));
        alunoTeste1.setMatricula("3rt6");
        alunoTeste1.setCodigoTurma("123");
        alunoTeste1.setCpf("123-456-789-10");
        alunoTeste1.setEndereco(enderecoTeste1);
        alunoTeste1.setEmail("Joaozinho@email.com");
        alunoTeste1.setTelefone("12-93456-7890");

        alunoTeste2.setNome("Carlos");
        alunoTeste2.setSobrenome("Silva");
        alunoTeste2.setSenha("123");
        alunoTeste2.setNomeSocial("Carlinhos");
        alunoTeste2.setGenero(Genero.MASCULINO);
        alunoTeste2.setDataNascimento(LocalDate.of(2004, 11, 20));
        alunoTeste2.setMatricula("ik28");
        alunoTeste2.setCodigoTurma("123");
        alunoTeste2.setCpf("123-456-789-20");
        alunoTeste2.setEmail("pauloguedes@emial.com");
        alunoTeste2.setTelefone("11-99244-1354");
    }

    private void inserirDados() {
        enderecoDAO.inserirEndereco(enderecoTeste3);
        usuarioDAO.inserirUsuario(instituicaoTeste);

        cursoDAO.inserirCurso(cursoTeste);
        enderecoDAO.inserirEndereco(enderecoTeste2);
        usuarioDAO.inserirUsuario(professorTeste);

        enderecoDAO.inserirEndereco(enderecoTeste1);
        usuarioDAO.inserirUsuario(alunoTeste1);

        enderecoDAO.inserirEndereco(enderecoTeste4);
        usuarioDAO.inserirUsuario(alunoTeste2);

        turmaDAO.inserirTurma(turmaTeste);

        atualizarProfessor();
        usuarioDAO.atualizarUsuario(professorTeste);

        atualizarIntituicao();
        usuarioDAO.atualizarUsuario(instituicaoTeste);
    }

    private void deletarDados() {
        turmaDAO.deletarTurma(turmaTeste);

        usuarioDAO.deletarUsuario(alunoTeste2);
        enderecoDAO.deletarEndereco(enderecoTeste4);

        usuarioDAO.deletarUsuario(alunoTeste1);
        enderecoDAO.deletarEndereco(enderecoTeste1);

        cursoDAO.deletarCurso(cursoTeste);

        usuarioDAO.deletarUsuario(professorTeste);
        enderecoDAO.deletarEndereco(enderecoTeste2);

        usuarioDAO.deletarUsuario(instituicaoTeste);
        enderecoDAO.deletarEndereco(enderecoTeste3);
    }

    private void atualizarIntituicao() {
        instituicaoTeste.addCurso(cursoTeste);
        instituicaoTeste.addTurma(turmaTeste);
        instituicaoTeste.addProfessores(professorTeste);
    }

    private void atualizarProfessor() {
        professorTeste.addTurma(turmaTeste);
    }

}