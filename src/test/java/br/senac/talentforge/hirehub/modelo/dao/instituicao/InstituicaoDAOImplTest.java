package br.senac.talentforge.hirehub.modelo.dao.instituicao;

import br.senac.talentforge.hirehub.modelo.dao.contato.ContatoDAO;
import br.senac.talentforge.hirehub.modelo.dao.contato.ContatoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.contato.Contato;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InstituicaoDAOImplTest {

    private final ContatoDAO contatoDAO = new ContatoDAOImpl();
    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private final Contato contatoTeste1 = new Contato();
    private final Endereco enderecoTeste1 = new Endereco();
    private final Instituicao instituicaoTeste = new Instituicao();


    @Test
    void recuperarIntituicao() {
        setarDados();
        inserirDados();
    }

    private void setarDados(){
        dadosContato();
        dadosEndereco();
        dadosIntituicao();
    }

    private void dadosContato() {
        contatoTeste1.setEmail("Joaozinho@email.com");
        contatoTeste1.setnumero("12-93456-7890");
    }

    private void dadosEndereco() {
        enderecoTeste1.setContato(contatoTeste1);
        enderecoTeste1.setCep("12345-678");
        enderecoTeste1.setEstado("Santa Catarina");
        enderecoTeste1.setCidade("Blumenau");
        enderecoTeste1.setBairro("Alameda");
        enderecoTeste1.setNumero(123);
        enderecoTeste1.setLogradouro("Rua das Rosas");
    }

    private void dadosIntituicao(){
        instituicaoTeste.setNomeEmpresa("Senac");
        instituicaoTeste.setSenha("1234");
        instituicaoTeste.setDescricao("Empresa focada na area de educação");
        instituicaoTeste.setDataFundacao(LocalDate.of(2000,3,9));
        instituicaoTeste.setCnpj("12.345.678/0001-95");
        instituicaoTeste.setEndereco(enderecoTeste1);
    }

    private void inserirDados(){
        contatoDAO.inserirContato(contatoTeste1);
        enderecoDAO.inserirEndereco(enderecoTeste1);
        usuarioDAO.inserirUsuario(instituicaoTeste);
    }

}