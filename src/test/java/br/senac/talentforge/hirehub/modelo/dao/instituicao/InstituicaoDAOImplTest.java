package br.senac.talentforge.hirehub.modelo.dao.instituicao;

import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstituicaoDAOImplTest {

    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private final Endereco enderecoTeste = new Endereco();
    private final Instituicao instituicaoTeste = new Instituicao();


    @Test
    void recuperarIntituicao() {
        setarDados();
        inserirDados();

        Instituicao instituicaoRecuperada = instituicaoDAO.recuperarIntituicao(instituicaoTeste.getCnpj());

        assertEquals(instituicaoTeste.getNomeEmpresa(), instituicaoRecuperada.getNomeEmpresa());

        deletarDados();
    }

    private void setarDados() {
        dadosEndereco();
        dadosIntituicao();
    }

    private void dadosEndereco() {
        enderecoTeste.setCep("12345-678");
        enderecoTeste.setEstado("Santa Catarina");
        enderecoTeste.setCidade("Blumenau");
        enderecoTeste.setBairro("Alameda");
        enderecoTeste.setNumero(123);
        enderecoTeste.setLogradouro("Rua das Rosas");
    }

    private void dadosIntituicao() {
        instituicaoTeste.setNomeEmpresa("Senac");
        instituicaoTeste.setSenha("1234");
        instituicaoTeste.setDescricao("Empresa focada na area de educação");
        instituicaoTeste.setDataFundacao(LocalDate.of(2000, 3, 9));
        instituicaoTeste.setCnpj("12.345.678/0001-95");
        instituicaoTeste.setEndereco(enderecoTeste);
    }

    private void inserirDados() {
        enderecoDAO.inserirEndereco(enderecoTeste);
        usuarioDAO.inserirUsuario(instituicaoTeste);
    }

    private void deletarDados() {
        usuarioDAO.deletarUsuario(instituicaoTeste);
        enderecoDAO.deletarEndereco(enderecoTeste);
    }

}