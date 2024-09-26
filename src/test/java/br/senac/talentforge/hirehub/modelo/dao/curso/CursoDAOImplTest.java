package br.senac.talentforge.hirehub.modelo.dao.curso;

import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.enumeracao.andamentocurso.AndamentoCurso;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CursoDAOImplTest {

    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private final InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final CursoDAO cursoDAO = new CursoDAOImpl();

    private final Instituicao instituicaoTeste = new Instituicao();
    private final Endereco enderecoTeste = new Endereco();
    private final Curso cursoTeste = new Curso();

    @Test
    @Order(1)
    void inserirCurso() {
        setarDados();

        enderecoDAO.inserirEndereco(enderecoTeste);
        usuarioDAO.inserirUsuario(instituicaoTeste);

        Instituicao instituicaoRecuperada = instituicaoDAO.recuperarIntituicaoPeloCnpj(instituicaoTeste.getCnpj());
        List<Curso> cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());

        assertTrue(cursosRecuperados.isEmpty());

        cursoDAO.inserirCurso(cursoTeste);

        cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());

        assertTrue(cursosRecuperados.stream().map(Curso::getNomeCurso).collect(Collectors.toList()).contains(cursoTeste.getNomeCurso()));
    }

    @Test
    @Order(2)
    void recuperarCursoPeloIdDaInstitucao() {
        setarDados();
        Instituicao instituicaoRecuperada = instituicaoDAO.recuperarIntituicaoPeloCnpj(instituicaoTeste.getCnpj());
        List<Curso> cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());

        assertTrue(cursosRecuperados.stream().map(Curso::getNomeCurso).collect(Collectors.toList()).contains(cursoTeste.getNomeCurso()));
    }

    @Test
    @Order(3)
    void recuperarCursosPorAtuacao() {
        setarDados();
        List<Curso> cursosRecuperados = cursoDAO.recuperarCursosPorAtuacao(cursoTeste.getAreaDeAtuacao());

        assertFalse(cursosRecuperados.isEmpty());
    }

    @Test
    @Order(4)
    void recuperarCursos() {
        List<Curso> cursosRecuperados = cursoDAO.recuperarCursos();

        assertFalse(cursosRecuperados.isEmpty());
    }

    @Test
    @Order(5)
    void atualizarCurso() {
        setarDados();

        Instituicao instituicaoRecuperada = instituicaoDAO.recuperarIntituicaoPeloCnpj(instituicaoTeste.getCnpj());
        List<Curso> cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());

        Curso cursoRecupedado = cursosRecuperados.get(0);

        Curso cursoAtualizado = new Curso();
        cursoAtualizado.setId(cursoRecupedado.getId());
        cursoAtualizado.setNomeCurso(cursoRecupedado.getNomeCurso());
        cursoAtualizado.setInsituicao(cursoRecupedado.getInsituicao());
        cursoAtualizado.setStatus(AndamentoCurso.INICIADO);
        cursoAtualizado.setDataInicio(cursoRecupedado.getDataInicio());
        cursoAtualizado.setDataFim(cursoRecupedado.getDataFim());
        cursoAtualizado.setAreaDeAtuacao(cursoRecupedado.getAreaDeAtuacao());

        assertNotEquals(cursoRecupedado.getStatus(), cursoAtualizado.getStatus());

        cursoDAO.atualizarCurso(cursoAtualizado);

        cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());

        cursoRecupedado = cursosRecuperados.get(0);

        assertEquals(cursoRecupedado.getStatus(), cursoAtualizado.getStatus());
    }

    @Test
    @Order(6)
    void deletarCurso() {
        setarDados();

        Instituicao instituicaoRecuperada = instituicaoDAO.recuperarIntituicaoPeloCnpj(instituicaoTeste.getCnpj());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoPeloIdUsuario(instituicaoRecuperada.getId());
        List<Curso> cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());

        assertFalse(cursosRecuperados.isEmpty());

        for (Curso curso : cursosRecuperados) {
            cursoDAO.deletarCurso(curso);
        }

        cursosRecuperados = cursoDAO.recuperarCursoPeloIdDaInstituicao(instituicaoRecuperada.getId());

        assertTrue(cursosRecuperados.isEmpty());

        usuarioDAO.deletarUsuario(instituicaoRecuperada);
        enderecoDAO.deletarEndereco(enderecoRecuperado);
    }

    private void setarDados() {
        dadosEndereco();
        dadosIntituicao();
        dadosCurso();
    }

    private void dadosEndereco() {
        enderecoTeste.setCep("23456-789");
        enderecoTeste.setEstado("Santa Catarina");
        enderecoTeste.setCidade("Blumenau");
        enderecoTeste.setBairro("Garcia");
        enderecoTeste.setNumero(7812);
        enderecoTeste.setLogradouro("Rua São Paulo");
    }

    private void dadosIntituicao() {
        instituicaoTeste.setNomeEmpresa("Senac");
        instituicaoTeste.setSenha("1234");
        instituicaoTeste.setDescricao("Empresa focada na area de educação");
        instituicaoTeste.setDataFundacao(LocalDate.of(2000, 3, 9));
        instituicaoTeste.setCnpj("12.345.678/0001-95");
        instituicaoTeste.setEndereco(enderecoTeste);
        instituicaoTeste.setEmail("Senac@email.com");
        instituicaoTeste.setTelefone("47-3332-1234");
    }

    private void dadosCurso() {
        cursoTeste.setNomeCurso("Desenvolvimento de Sistemas");
        cursoTeste.setStatus(AndamentoCurso.ABERTO);
        cursoTeste.setAreaDeAtuacao("Tecnologia");
        cursoTeste.setDataInicio(LocalDate.of(2024, 3, 12));
        cursoTeste.setDataFim(LocalDate.of(2025, 12, 21));
        cursoTeste.setInsituicao(instituicaoTeste);
    }

}