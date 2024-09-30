package br.senac.talentforge.hirehub.modelo;

import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gerar Banco");

        EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
        Endereco endereco = new Endereco();

        endereco.setCep("12345-679");
        endereco.setEstado("Santa Catarina");
        endereco.setCidade("Blumenau");
        endereco.setBairro("Alameda");
        endereco.setNumero(456);
        endereco.setLogradouro("Rua das Roxas");

        enderecoDAO.inserirEndereco(endereco);

        Aluno alunoTeste = new Aluno();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        AlunoDAO alunoDAO = new AlunoDAOImpl();

        alunoTeste.setNome("João");
        alunoTeste.setSobrenome("Costa");
        alunoTeste.setNomeSocial("Joazinho");
        alunoTeste.setSenha("123");
        alunoTeste.setSexo(Sexo.MASCULINO);
        alunoTeste.setDataNascimento(LocalDate.of(2005, 11, 20));
        alunoTeste.setMatricula("3rt6");
        alunoTeste.setCpf("123-456-789-10");
        alunoTeste.setEndereco(endereco);
        alunoTeste.setEmail("Joaozinho@email.com");
        alunoTeste.setTelefone("12-93456-7890");

        usuarioDAO.inserirUsuario(alunoTeste);

        Aluno aluno1 = alunoDAO.recuperarAlunoPeloCpf(alunoTeste.getCpf());
        Aluno aluno2 = alunoDAO.recuperarAlunoPeloCpf(alunoTeste.getCpf());

        System.out.println("Banco Gerado.");
        System.out.println("Alunos iguais: " + aluno1.equals(aluno2));
    }
}
