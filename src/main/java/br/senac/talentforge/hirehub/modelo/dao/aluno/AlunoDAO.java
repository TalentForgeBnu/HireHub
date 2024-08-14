package br.senac.talentforge.hirehub.modelo.dao.aluno;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;

import java.util.List;

public interface AlunoDAO {
    void inserirAluno(Aluno aluno);

    void deletarAluno(Aluno aluno);

    void atualizarAluno(Aluno aluno);

    List<Aluno> recuperarAluno();
}