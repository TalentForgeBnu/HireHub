package br.senac.talentforge.hirehub.modelo.dao.professor;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;

public interface ProfessorDAO {
    Professor recuperarProfessorPeloId(long idProfessor);

    Professor recuperarProfessorPeloCpf(String cpf);

    List<Professor> recuperarProfessoresPeloIdInstituicao(long idInstituicao);
}