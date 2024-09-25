package br.senac.talentforge.hirehub.modelo.dao.dossie;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DossieDAOImplTest {

    private final DossieDAO dossieDAO = new DossieDAOImpl();
    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final CursoDAO cursoDAO = new CursoDAOImpl();
    private final TurmaDAO turmaDAO = new TurmaDAOImpl();
    private final InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
    private final AlunoDAO alunoDAO = new AlunoDAOImpl();
    private final ProfessorDAO professorDAO = new ProfessorDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private final Dossie dossieTeste = new Dossie();
    private final Endereco enderecoTeste1 = new Endereco();
    private final Endereco enderecoTeste2 = new Endereco();
    private final Endereco enderecoTeste3 = new Endereco();
    private final Curso cursoTeste = new Curso();
    private final Turma turmaTeste = new Turma();
    private final Instituicao instituicaoTeste = new Instituicao();
    private final Aluno alunoTeste = new Aluno();
    private final Professor professorTeste = new Professor();

    @Test
    @Order(1)
    void inserirDossie() {
        setarDados();

        enderecoDAO.inserirEndereco(enderecoTeste3);
        usuarioDAO.inserirUsuario(instituicaoTeste);

        cursoDAO.inserirCurso(cursoTeste);
        enderecoDAO.inserirEndereco(enderecoTeste2);
        usuarioDAO.inserirUsuario(professorTeste);

        enderecoDAO.inserirEndereco(enderecoTeste1);
        usuarioDAO.inserirUsuario(alunoTeste);

        turmaDAO.inserirTurma(turmaTeste);

        atualizarProfessor();
        usuarioDAO.atualizarUsuario(professorTeste);

        atualizarIntituicao();
        usuarioDAO.atualizarUsuario(instituicaoTeste);

        Aluno alunoRecuperdado = alunoDAO.recuperarAlunoPeloCpf(alunoTeste.getCpf());
        Dossie dossieRecuperado = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(alunoRecuperdado.getId());

        assertNull(dossieRecuperado);

        dossieDAO.inserirDossie(dossieTeste);

        dossieRecuperado = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(alunoRecuperdado.getId());

        assertEquals(dossieRecuperado.getDescricao(), dossieTeste.getDescricao());
    }

    @Test
    @Order(2)
    void recuperarDossiePeloIdDoUsuarioAluno() {
        setarDados();

        Aluno alunoRecuperdado = alunoDAO.recuperarAlunoPeloCpf(alunoTeste.getCpf());
        Dossie dossieRecuperado = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(alunoRecuperdado.getId());

        assertEquals(dossieRecuperado.getDescricao(), dossieTeste.getDescricao());
    }

    @Test
    @Order(3)
    void atualizarDossie() {
        setarDados();

        Aluno alunoRecuperdado = alunoDAO.recuperarAlunoPeloCpf(alunoTeste.getCpf());
        Dossie dossieRecuperado = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(alunoRecuperdado.getId());

        Dossie dossieAtualizado = new Dossie();
        dossieAtualizado.setId(dossieRecuperado.getId());
        dossieAtualizado.setDescricao("O Aluno é bom com logica de programação mas tem problemas de comportamento extremo.");
        dossieAtualizado.setApontamentos(dossieRecuperado.getApontamentos());
        dossieAtualizado.setAluno(dossieRecuperado.getAluno());

        assertNotEquals(dossieAtualizado.getDescricao(), dossieRecuperado.getDescricao());

        dossieDAO.atualizarDossie(dossieAtualizado);
        dossieRecuperado = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(alunoRecuperdado.getId());

        assertEquals(dossieAtualizado.getDescricao(), dossieRecuperado.getDescricao());
    }

    @Test
    @Order(4)
    void deletarDossie() {
        setarDados();
        Instituicao instituicaoRecuperada = instituicaoDAO.recuperarIntituicaoPeloCnpj(instituicaoTeste.getCnpj());
        Aluno alunoRecuperado = alunoDAO.recuperarAlunoPeloCpf(alunoTeste.getCpf());
        Professor professorRecuperado = professorDAO.recuperarProfessor(professorTeste.getCpf());
        Endereco enderecoRecuperado1 = enderecoDAO.recuperarEnderecoPeloIdUsuario(alunoRecuperado.getId());
        Endereco enderecoRecuperado2 = enderecoDAO.recuperarEnderecoPeloIdUsuario(professorRecuperado.getId());
        Endereco enderecoRecuperado3 = enderecoDAO.recuperarEnderecoPeloIdUsuario(instituicaoRecuperada.getId());
        List<Curso> cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());
        Turma turmaRecuperada = turmaDAO.recuperarTurmaPeloIdIntituicao(instituicaoRecuperada.getId());
        Dossie dossieRecuperado = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(alunoRecuperado.getId());

        assertNotNull(dossieRecuperado);

        dossieDAO.deletarDossie(dossieRecuperado);
        turmaDAO.deletarTurma(turmaRecuperada);
        usuarioDAO.deletarUsuario(alunoRecuperado);
        enderecoDAO.deletarEndereco(enderecoRecuperado1);
        usuarioDAO.deletarUsuario(professorRecuperado);
        enderecoDAO.deletarEndereco(enderecoRecuperado2);
        for (Curso curso : cursosRecuperados) {
            cursoDAO.deletarCurso(curso);
        }
        usuarioDAO.deletarUsuario(instituicaoRecuperada);
        enderecoDAO.deletarEndereco(enderecoRecuperado3);

        dossieRecuperado = dossieDAO.recuperarDossiePeloIdDoUsuarioAluno(alunoRecuperado.getId());

        assertNull(dossieRecuperado);
    }

    private void setarDados() {
        dadosEndereco();
        dadosIntituicao();

        dadosCurso();
        dadosProfessor();
        dadosTurmas();

        dadosAluno();
        dadosDossie();
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

    private void dadosTurmas() {
        turmaTeste.setNomeTurma("Turma Da Bagunça");
        turmaTeste.adicionarAluno(alunoTeste);
        turmaTeste.setCodigo("codigoSecreto");
        turmaTeste.setHorario(LocalTime.of(15, 30));
        turmaTeste.setCurso(cursoTeste);
        turmaTeste.setInstituicao(instituicaoTeste);
        turmaTeste.setProfessor(professorTeste);
    }

    private void dadosAluno() {
        alunoTeste.setNome("João");
        alunoTeste.setSobrenome("Costa");
        alunoTeste.setSenha("123");
        alunoTeste.setNomeSocial("Joaozinho");
        alunoTeste.setGenero(Genero.MASCULINO);
        alunoTeste.setDataNascimento(LocalDate.of(2005, 11, 20));
        alunoTeste.setMatricula("3rt6");
        alunoTeste.setCodigoTurma("123");
        alunoTeste.setCpf("123-456-789-10");
        alunoTeste.setEndereco(enderecoTeste1);
        alunoTeste.setEmail("Joaozinho@email.com");
        alunoTeste.setTelefone("12-93456-7890");
    }

    private void dadosDossie() {
        dossieTeste.setDescricao("O Aluno é bom com logica de programação mas tem problemas de comportamento");
        dossieTeste.setAluno(alunoTeste);
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