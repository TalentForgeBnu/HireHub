package br.senac.talentforge.hirehub.modelo.dao.professor;

import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;

public interface ProfessorDAO {
    Professor recuperarProfessorPeloCpf(String cpf);
}