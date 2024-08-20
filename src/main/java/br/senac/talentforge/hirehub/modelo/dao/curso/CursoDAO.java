package br.senac.talentforge.hirehub.modelo.dao.curso;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;

public interface CursoDAO {
    void inserirCurso(Curso curso);

    void deletarCurso(Curso curso);

    void atualizarCurso(Curso curso);
}