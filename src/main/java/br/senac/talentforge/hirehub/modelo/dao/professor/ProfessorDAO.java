package br.senac.talentforge.hirehub.modelo.dao.professor;

import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;

public interface ProfessorDAO {
    void inserirProfessor(Professor professor);

    void deletarProfessor(Professor professor);

    void atualizarProfessor(Professor professor);
}