package br.senac.talentforge.hirehub.modelo.dao.curso;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;

public interface CursoDAO {
    void inserirCurso(Curso curso);

    void deletarCurso(Curso curso);

    void atualizarCurso(Curso curso);

    Curso recuperarCursoPeloId(long idCurso);

    List<Curso> recuperarCursosPeloIdDaInstituicao(long idInstituicao);

    List<Curso> recuperarCursosPorAtuacao(String areaDeAtuacao);

    List<Curso> recuperarCursoPelaDisponibilidade(Disponibilidade disponibilidade);
}