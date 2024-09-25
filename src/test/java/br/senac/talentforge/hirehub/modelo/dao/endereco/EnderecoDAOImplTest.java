package br.senac.talentforge.hirehub.modelo.dao.endereco;

import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.persistence.NoResultException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnderecoDAOImplTest {

    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private final ProfessorDAO professorDAO = new ProfessorDAOImpl();

    private final Endereco enderecoTeste = new Endereco();
    private final Professor professorTeste = new Professor();

    @Test
    @Order(1)
    void inserirEndereco() {
        setarDados();

        enderecoDAO.inserirEndereco(enderecoTeste);
        usuarioDAO.inserirUsuario(professorTeste);

        Professor professorRecuperado = professorDAO.recuperarProfessor(professorTeste.getCpf());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoPeloIdUsuario(professorRecuperado.getId());

        assertEquals(enderecoRecuperado.getCep(), enderecoTeste.getCep());
    }

    @Test
    @Order(2)
    void recuperarEnderecoPeloIdUsuario() {
        setarDados();

        Professor professorRecuperado = professorDAO.recuperarProfessor(professorTeste.getCpf());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoPeloIdUsuario(professorRecuperado.getId());

        assertEquals(enderecoRecuperado.getCep(), enderecoTeste.getCep());
    }

    @Test
    @Order(3)
    void atualizarEndereco() {
        setarDados();

        Professor professorRecuperado = professorDAO.recuperarProfessor(professorTeste.getCpf());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoPeloIdUsuario(professorRecuperado.getId());

        Endereco enderecoAtualizado = new Endereco();
        enderecoAtualizado.setId(enderecoRecuperado.getId());
        enderecoAtualizado.setCep("22345-679");
        enderecoAtualizado.setEstado(enderecoRecuperado.getEstado());
        enderecoAtualizado.setCidade(enderecoRecuperado.getCidade());
        enderecoAtualizado.setBairro(enderecoRecuperado.getBairro());
        enderecoAtualizado.setNumero(enderecoRecuperado.getNumero());
        enderecoAtualizado.setLogradouro(enderecoRecuperado.getLogradouro());

        assertNotEquals(enderecoRecuperado.getCep(), enderecoAtualizado.getCep());

        enderecoDAO.atualizarEndereco(enderecoAtualizado);

        enderecoRecuperado = enderecoDAO.recuperarEnderecoPeloIdUsuario(professorRecuperado.getId());

        assertEquals(enderecoRecuperado.getCep(), enderecoAtualizado.getCep());
    }

    @Test
    @Order(4)
    void deletarEndereco() {
        setarDados();

        Professor professorRecuperado = professorDAO.recuperarProfessor(professorTeste.getCpf());
        Endereco enderecoRecuperado = enderecoDAO.recuperarEnderecoPeloIdUsuario(professorRecuperado.getId());

        assertNotNull(enderecoRecuperado);

        usuarioDAO.deletarUsuario(professorRecuperado);
        enderecoDAO.deletarEndereco(enderecoRecuperado);

        enderecoRecuperado = enderecoDAO.recuperarEnderecoPeloIdUsuario(professorRecuperado.getId());

        assertNull(enderecoRecuperado);
    }

    private void setarDados() {
        dadosEndereco();
        dadosProfessor();
    }

    private void dadosEndereco() {
        enderecoTeste.setCep("12345-679");
        enderecoTeste.setEstado("Santa Catarina");
        enderecoTeste.setCidade("Blumenau");
        enderecoTeste.setBairro("Alameda");
        enderecoTeste.setNumero(456);
        enderecoTeste.setLogradouro("Rua das Roxas");
    }

    private void dadosProfessor() {
        professorTeste.setNome("Lucas");
        professorTeste.setSobrenome("Silva");
        professorTeste.setSenha("aquela");
        professorTeste.setNomeSocial("Luca");
        professorTeste.setCpf("123.456.789-00");
        professorTeste.setMateria("Programação");
        professorTeste.setEndereco(enderecoTeste);
        professorTeste.setGenero(Genero.MASCULINO);
        professorTeste.setDataNascimento(LocalDate.of(1994, 1, 3));
        professorTeste.setEmail("Lucas@email.com");
        professorTeste.setTelefone("47-91234-5678");
    }

}