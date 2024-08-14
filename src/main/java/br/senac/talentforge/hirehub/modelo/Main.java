package br.senac.talentforge.hirehub.modelo;

import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAO;
import br.senac.talentforge.hirehub.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.enumeracao.alunomatriculado.AlunoMatriculado;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAOImpl();

        Aluno aluno = new Aluno();

        LocalDate date = LocalDate.now();

        aluno.setNome("Thomas");
        aluno.setSobrenome("Sim");
        aluno.setEmail("Thomas@Test.com");
        aluno.setCelular("47 99999-0000");
        aluno.setDataNascimento(date);
        aluno.setEstado("Santa Catarina");
        aluno.setCidade("Blumenau");
        aluno.setBairro("Aquele");
        aluno.setGenero(Genero.PREFIRO_NAO_INFORMAR);
        aluno.setStatusAluno(AlunoMatriculado.CURSANDO);

        alunoDAO.inserirAluno(aluno);

        System.out.println("Teste DAO");
    }
}
