package br.senac.talentforge.hirehub.modelo.dao.Turma;

import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;

import java.util.List;

public interface TurmaDAO {
    void inserirTurma(Turma turma);

    void deletarTurma(Turma turma);

    void atualizarTurma(Turma turma);

    List<Turma> recuperarTurmas();
}