package br.senac.talentforge.hirehub.modelo.dao.empresa;

import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpresaDAOImplTest {

    private final EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private final EmpresaDAO empresaDAO = new EmpresaDAOImpl();

    private final Endereco enderecoTeste = new Endereco();
    private final Empresa empresaTeste = new Empresa();

    @Test
    void recuperarEmpresaPeloCnpj() {
        setarDados();
        inserirDados();

        Empresa empresaRecuperada = empresaDAO.recuperarEmpresaPeloCnpj(empresaTeste.getCnpj());

        assertEquals(empresaRecuperada.getCnpj(), empresaTeste.getCnpj());

        deletarDados();
    }

    private void setarDados() {
        setarDadosEndereco();
        setarDadosEmpresa();
    }

    private void setarDadosEndereco() {
        enderecoTeste.setCep("23456-789");
        enderecoTeste.setEstado("Santa Catarina");
        enderecoTeste.setCidade("Blumenau");
        enderecoTeste.setBairro("Garcia");
        enderecoTeste.setNumero(7412);
        enderecoTeste.setLogradouro("Rua São Paulo");
    }

    private void setarDadosEmpresa() {
        empresaTeste.setNomeEmpresa("Tiago Techs");
        empresaTeste.setCnpj("12.345.678/0001-96");
        empresaTeste.setDescricao("Empresa dedicada na area de programação");
        empresaTeste.setSenha("cs-GO123");
        empresaTeste.setEndereco(enderecoTeste);
        empresaTeste.setDataFundacao(LocalDate.of(2018, 3, 20));
        empresaTeste.setEmail("TiagoTechs@Email.com");
        empresaTeste.setTelefone("47 3333-3331");
    }

    private void inserirDados() {
        enderecoDAO.inserirEndereco(enderecoTeste);
        usuarioDAO.inserirUsuario(empresaTeste);
    }

    private void deletarDados() {
        usuarioDAO.deletarUsuario(empresaTeste);
        enderecoDAO.deletarEndereco(enderecoTeste);
    }

}