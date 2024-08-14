package br.senac.talentforge.hirehub.modelo.entidade.professor;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;

public class Professor extends Aluno {

	private List<Turma> turmas;
	private String materia;
	
	public Professor(List<Turma> turmas, String materia) {
		
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public String getMaterias() {
		return materia;
	}
	
	public void setMaterias() {
		this.materia = materia;
	}
	
	public void adicionarDossie(Aluno aluno, String dossie, String matricula) {
        aluno.setDossie(dossie);
        aluno.setMatricula(matricula);
    }
	
}
