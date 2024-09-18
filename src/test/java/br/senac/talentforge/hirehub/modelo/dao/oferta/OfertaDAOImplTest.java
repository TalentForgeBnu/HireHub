package br.senac.talentforge.hirehub.modelo.dao.oferta;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAO;
import br.senac.talentforge.hirehub.modelo.dao.apontamento.ApontamentoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAO;
import br.senac.talentforge.hirehub.modelo.dao.dossie.DossieDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAO;
import br.senac.talentforge.hirehub.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAO;
import br.senac.talentforge.hirehub.modelo.dao.vaga.VagaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.andamentocurso.AndamentoCurso;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;
import br.senac.talentforge.hirehub.modelo.enumeracao.modalidadecontratacao.ModalidadeContratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacaovaga.SituacaoVaga;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.time.LocalTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OfertaDAOImplTest {

    private final ApontamentoDAO apontamentoDAO = new ApontamentoDAOImpl();
    private final DossieDAO dossieDAO = new DossieDAOImpl();
    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final EmpresaDAO empresaDAO = new EmpresaDAOImpl();
    private final CursoDAO cursoDAO = new CursoDAOImpl();
    private final VagaDAO vagaDAO = new VagaDAOImpl();
    private final OfertaDAO ofertaDAO = new OfertaDAOImpl();
    private final TurmaDAO turmaDAO = new TurmaDAOImpl();
    private final InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
    private final AlunoDAO alunoDAO = new AlunoDAOImpl();
    private final ProfessorDAO professorDAO = new ProfessorDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private final Apontamento apontamentoTeste = new Apontamento();
    private final Dossie dossieTeste = new Dossie();
    private final Endereco enderecoTeste1 = new Endereco();
    private final Endereco enderecoTeste2 = new Endereco();
    private final Endereco enderecoTeste3 = new Endereco();
    private final Endereco enderecoTeste4 = new Endereco();
    private final Empresa empresaTeste = new Empresa();
    private final Curso cursoTeste = new Curso();
    private final Vaga vagaTeste = new Vaga();
    private final Oferta ofertaTeste = new Oferta();
    private final Turma turmaTeste = new Turma();
    private final Instituicao instituicaoTeste = new Instituicao();
    private final Aluno alunoTeste = new Aluno();
    private final Professor professorTeste = new Professor();

    @Test
    @Order(1)
    void inserirOferta() {
        enderecoDAO.inserirEndereco(enderecoTeste3);
        usuarioDAO.inserirUsuario(instituicaoTeste);

        enderecoDAO.inserirEndereco(enderecoTeste4);
        usuarioDAO.inserirUsuario(empresaTeste);

        cursoDAO.inserirCurso(cursoTeste);

        vagaDAO.inserirVaga(vagaTeste);
        ofertaDAO.inserirOferta(ofertaTeste);

        enderecoDAO.inserirEndereco(enderecoTeste2);
        usuarioDAO.inserirUsuario(professorTeste);

        enderecoDAO.inserirEndereco(enderecoTeste1);
        usuarioDAO.inserirUsuario(alunoTeste);

        turmaDAO.inserirTurma(turmaTeste);

        atualizarEmpresa();
        usuarioDAO.atualizarUsuario(empresaTeste);

        atualizarProfessor();
        usuarioDAO.atualizarUsuario(professorTeste);

        atualizarIntituicao();
        usuarioDAO.atualizarUsuario(instituicaoTeste);

        dossieDAO.inserirDossie(dossieTeste);
        apontamentoDAO.inserirApontamento(apontamentoTeste);

        atualizarDossie();
        dossieDAO.atualizarDossie(dossieTeste);

    }

    @Test
    void atualizarOferta() {
    }

    @Test
    void recuperarOfertaPeloIdCurso() {
    }

    @Test
    void recuperarOfertaSPelosIdEmpresa() {
    }

    @Test
    void recuperarOfertaSPelosIdInstituicao() {
    }

    @Test
    void deletarOferta() {
    }

    private void setarDados() {
        dadosEndereco();
        dadosIntituicao();

        dadosEmpresa();
        dadosVaga();
        dadosOferta();
        dadosCurso();
        dadosProfessor();
        dadosTurmas();

        dadosAluno();
        dadosDossie();
        dadosApontamento();
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

        enderecoTeste4.setCep("23456-789");
        enderecoTeste4.setEstado("Santa Catarina");
        enderecoTeste4.setCidade("Blumenau");
        enderecoTeste4.setBairro("Garcia");
        enderecoTeste4.setNumero(7412);
        enderecoTeste4.setLogradouro("Rua São Paulo");
    }

    private void dadosIntituicao() {
        instituicaoTeste.setNome("Senac");
        instituicaoTeste.setSenha("1234");
        instituicaoTeste.setDescricao("Empresa focada na area de educação");
        instituicaoTeste.setDataFundacao(LocalDate.of(2000,3,9));
        instituicaoTeste.setCnpj("12.345.678/0001-95");
        instituicaoTeste.setEndereco(enderecoTeste3);
    }

    private void dadosEmpresa(){
        empresaTeste.setNome("Tiago Techs");
        empresaTeste.setDescricao("Empresa dedicada na area de programação");
        empresaTeste.setSenha("cs-GO123");
        empresaTeste.setEndereco(enderecoTeste4);
        empresaTeste.setDataFundacao(LocalDate.of(2018, 3, 20));
    }

    private void dadosCurso() {
        cursoTeste.setNomeCurso("Desenvolvimento de Sistemas");
        cursoTeste.setStatus(AndamentoCurso.INICIADO);
        cursoTeste.setAreaDeAtuacao("Area da Tecnologia");
        cursoTeste.setDataInicio(LocalDate.of(2024, 3, 12));
        cursoTeste.setDataFim(LocalDate.of(2025, 12, 21));
        cursoTeste.setInsituicao(instituicaoTeste);
    }

    private void dadosVaga(){
        vagaTeste.setNome("Vaga de Analista de Sistemas");
        vagaTeste.setSituacaoVaga(SituacaoVaga.ABERTA);
        vagaTeste.setModalidadeContratacao(ModalidadeContratacao.MEIO_PERIODO);
        vagaTeste.setEmpresa(empresaTeste);
    }

    private void dadosOferta(){
        ofertaTeste.setCurso(cursoTeste);
        ofertaTeste.setVaga(vagaTeste);
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
    }

    private void dadosTurmas() {
        turmaTeste.setNomeTurma("Turma Da Bagunça");
        turmaTeste.addAluno(alunoTeste);
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
        alunoTeste.setMatricula("matricula :)");
        alunoTeste.setCodigoTurma("123");
        alunoTeste.setCpf("123-456-789-10");
        alunoTeste.setEndereco(enderecoTeste1);
    }

    private void dadosDossie() {
        dossieTeste.setDescricao("O Aluno é bom com logica de programação mas tem problemas de comportamento");
        dossieTeste.setAluno(alunoTeste);
    }

    private void dadosApontamento() {
        apontamentoTeste.setData(LocalDate.now());
        apontamentoTeste.setDescricao("Hoje o aluno dormiu em sala e não faz nenhuma das atividades");
        apontamentoTeste.setDossie(dossieTeste);
    }

    private void atualizarIntituicao(){
        instituicaoTeste.addCurso(cursoTeste);
        instituicaoTeste.addTurma(turmaTeste);
        instituicaoTeste.addProfessores(professorTeste);
    }

    private void atualizarProfessor(){
        professorTeste.addTurma(turmaTeste);
    }

    private void atualizarDossie(){
        dossieTeste.addApontamento(apontamentoTeste);
    }

    private void atualizarEmpresa(){
        empresaTeste.addVaga(vagaTeste);
    }

}