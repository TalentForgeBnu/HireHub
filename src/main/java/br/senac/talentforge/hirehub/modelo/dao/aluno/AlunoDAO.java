package br.senac.talentforge.hirehub.modelo.dao.aluno;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;

public interface AlunoDAO {
    Aluno recuperarAlunoPeloCpf(String cpf);

    List<Aluno> recuperarAlunosPeloIdTurma(long idTurma);
}