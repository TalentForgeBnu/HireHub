package br.senac.talentforge.hirehub.modelo.dao.Turma;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;

public interface TurmaDAO {
    void inserirTurma(Turma turma);

    void deletarTurma(Turma turma);

    void atualizarTurma(Turma turma);

    Turma recuperarTurmaPeloIdInstituicao(long idInstituicao);

    List<Turma> recuperarTurmasPeloIdCurso(long idCurso);
    
    List<Turma> recuperarTurmasPeloIdProfessor(long idProfessor);
}