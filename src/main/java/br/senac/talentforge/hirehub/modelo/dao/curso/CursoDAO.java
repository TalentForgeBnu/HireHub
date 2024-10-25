package br.senac.talentforge.hirehub.modelo.dao.curso;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;

public interface CursoDAO {
    void inserirCurso(Curso curso);

    void deletarCurso(Curso curso);

    void atualizarCurso(Curso curso);
    
    Curso recuperarCursoPeloIdDaInstituicao(long idInstituicao);
 
    Curso recuperarCursoPorAtuacao(String areaDeAtuacao);
    
    List<Curso> recuperarCursosPeloIdDaInstituicao(long idInstituicao);

    List<Curso> recuperarCursosPorAtuacao(String areaDeAtuacao);
}