package br.senac.talentforge.hirehub.modelo.dao.aluno;

import br.senac.talentforge.hirehub.modelo.dao.contato.ContatoDAO;
import br.senac.talentforge.hirehub.modelo.dao.contato.ContatoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.contato.Contato;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoDAOImplTest {

    private final ContatoDAO contatoDAO = new ContatoDAOImpl();
    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final AlunoDAO alunoDAO = new AlunoDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private final Contato contatoTeste = new Contato();
    private final Endereco enderecoTeste = new Endereco();
    private final Aluno alunoTeste = new Aluno();

    @Test
    void recuperarAlunos() {
        setarDadosTeste();
        inserirDados();

        List<Aluno> alunos = alunoDAO.recuperarAlunos();

        assertNotNull(alunos);
        assertFalse(alunos.isEmpty());

        deletarDados();
    }

    @Test
    void recuperarAluno() {
        setarDadosTeste();
        inserirDados();

        Aluno alunoRecuperado = alunoDAO.recuperarAluno(alunoTeste.getCpf());

        assertNotNull(alunoRecuperado);
        assertEquals(alunoTeste.getNome(), alunoRecuperado.getNome());

        deletarDados();
    }

    private void setarDadosTeste(){
        dadosContato();
        dadosEndereco();
        dadosAluno();
    }

    private void dadosContato() {
        contatoTeste.setEmail("Lucas@email.com");
        contatoTeste.setnumero("12-93456-7890");
    }

    private void dadosEndereco(){
        enderecoTeste.setContato(contatoTeste);
        enderecoTeste.setCep("12345-678");
        enderecoTeste.setEstado("Santa Catarina");
        enderecoTeste.setCidade("Blumenau");
        enderecoTeste.setBairro("Alameda");
        enderecoTeste.setNumero(123);
        enderecoTeste.setLogradouro("Rua das Rosas");
    }

    private void dadosAluno(){
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

    private void inserirDados(){
        inserirContato();
        inserirEndereco();
        inserirUsuario();
    }

    private void inserirContato(){
        contatoDAO.inserirContato(contatoTeste);
    }

    private void inserirEndereco(){
        enderecoDAO.inserirEndereco(enderecoTeste);
    }

    private void inserirUsuario(){
        usuarioDAO.inserirUsuario(alunoTeste);
    }

    private void deletarDados(){
        deletarUsuario();
        deletarEndereco();
        deletarContato();
    }

    private void deletarContato(){
        contatoDAO.deletarContato(contatoTeste);
    }

    private void deletarEndereco(){
        enderecoDAO.deletarEndereco(enderecoTeste);
    }

    private void deletarUsuario(){
        usuarioDAO.deletarUsuario(alunoTeste);
    }
}