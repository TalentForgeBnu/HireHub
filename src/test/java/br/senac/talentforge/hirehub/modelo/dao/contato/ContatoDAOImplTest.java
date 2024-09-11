package br.senac.talentforge.hirehub.modelo.dao.contato;

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.contato.Contato;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContatoDAOImplTest {

    private final ContatoDAO contatoDAO = new ContatoDAOImpl();
    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final AlunoDAO alunoDAO = new AlunoDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private final Contato contatoTeste = new Contato();
    private final Endereco enderecoTeste = new Endereco();
    private final Aluno alunoTeste = new Aluno();

    @Test
    @Order(1)
    void inserirContato() {
        dadosParaTeste();

        contatoDAO.inserirContato(contatoTeste);
        enderecoDAO.inserirEndereco(enderecoTeste);
        usuarioDAO.inserirUsuario(alunoTeste);

        Contato contatoRecuperado = contatoDAO.recuperarContatoPeloEndereco(enderecoTeste);

        assertEquals(contatoRecuperado.getEmail(), contatoTeste.getEmail());
    }

    @Test
    @Order(2)
    void recuperarContatoPeloEndereco() {
        dadosAluno();
        dadosContato();

        Aluno alunoRecuperado = alunoDAO.recuperarAluno(alunoTeste.getCpf());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoDoAluno(alunoRecuperado);
        Contato contatoRecuperado = contatoDAO.recuperarContatoPeloEndereco(enderecoRecuperado);

        assertEquals(contatoTeste.getEmail(), contatoRecuperado.getEmail());
    }

    @Test
    @Order(3)
    void atualizarContato() {
        dadosAluno();
        String novoEmail = "Lucas@email.com.br";

        Aluno alunoRecuperado = alunoDAO.recuperarAluno(alunoTeste.getCpf());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoDoAluno(alunoRecuperado);
        Contato contatoRecuperado = contatoDAO.recuperarContatoPeloEndereco(enderecoRecuperado);

        contatoRecuperado.setEmail(novoEmail);

        contatoDAO.atualizarContato(contatoRecuperado);

        Contato contatoAtualizado = contatoDAO.recuperarContatoPeloEndereco(enderecoRecuperado);

        assertNotSame(contatoRecuperado, contatoAtualizado);
        assertEquals(contatoAtualizado.getEmail(), novoEmail);
    }

    @Test
    @Order(4)
    void deletarContato() {
        dadosAluno();

        Aluno alunoRecuperado = alunoDAO.recuperarAluno(alunoTeste.getCpf());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoDoAluno(alunoRecuperado);
        Contato contatoRecuperado = contatoDAO.recuperarContatoPeloEndereco(enderecoRecuperado);

        assertNotNull(alunoRecuperado);
        assertNotNull(enderecoRecuperado);
        assertNotNull(contatoRecuperado);

        usuarioDAO.deletarUsuario(alunoRecuperado);
        enderecoDAO.deletarEndereco(enderecoRecuperado);
        contatoDAO.deletarContato(contatoRecuperado);

        Aluno alunoDeletado = alunoDAO.recuperarAluno(alunoTeste.getCpf());
        Endereco enderecoDeletado = enderecoDAO.recuperarEnderecoDoAluno(alunoRecuperado);
        Contato contatoDeletado = contatoDAO.recuperarContatoPeloEndereco(enderecoRecuperado);

        assertNull(alunoDeletado);
        assertNull(enderecoDeletado);
        assertNull(contatoDeletado);
    }

    private void dadosParaTeste() {
        dadosContato();
        dadosEndereco();
        dadosAluno();
    }

    private void dadosContato() {
        contatoTeste.setEmail("Lucas@email.com");
        contatoTeste.setnumero("12-93456-7890");
    }

    private void dadosEndereco() {
        enderecoTeste.setContato(contatoTeste);
        enderecoTeste.setCep("12345-678");
        enderecoTeste.setEstado("Santa Catarina");
        enderecoTeste.setCidade("Blumenau");
        enderecoTeste.setBairro("Alameda");
        enderecoTeste.setNumero(123);
        enderecoTeste.setLogradouro("Rua das Rosas");
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
        alunoTeste.setEndereco(enderecoTeste);
    }

}