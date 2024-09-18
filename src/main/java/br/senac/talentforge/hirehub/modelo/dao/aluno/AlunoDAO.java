package br.senac.talentforge.hirehub.modelo.dao.aluno;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;

import java.util.List;

public interface AlunoDAO {
    Aluno recuperarAlunoPeloCpf(String cpf);

    List<Aluno> recuperarAlunosPeloIdTurma(long idTurma);
}