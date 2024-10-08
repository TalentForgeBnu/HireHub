package br.senac.talentforge.hirehub.modelo.entidade.instituicao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import antlr.collections.List;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;


@Entity
@Table(name = "instituicao")
public class Instituicao extends Usuario implements Serializable {

  private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_instituicao")
	private long id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Professor> professores;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos;
    private List<Oferta> ofertas;
    
    public Instituicao() {
    	
    }
    
    public Instituicao(List<Curso> cursos, List<Professor> professores, List<Aluno> alunos) {
    	this.cursos = cursos;
    	this.professores = professores;
    	this.alunos = alunos;
    }
    
    public List<Oferta> getOfertas(){
    	return ofertas;
    }
    
    public void setOfertas(List<Oferta> ofertas) {
    	this.ofertas = ofertas;
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public List<Professor> getProfessores() {
    	return professores;
    }
    
    public void setProfessores(List<Professor> professores) {
    	this.professores = professores;
    }
	
    public List<Curso> getCursos() {
    	return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
    	this.cursos = cursos;
    }
    
    public List<Aluno> getAlunos() {
    	return alunos;
    }
    
    public void setAlunos(List<Aluno> Alunos) {
    	this.alunos = alunos;
    }
    
    public void atualizarProfessor(List<Professor> professores) {
    	setProfessores(professores);
    }
    
    public void removerProfessor(List<Professor> professores) {
    	this.professores.removeAll(professores);
    }
    
    public void atualizarAluno(List<Aluno> alunos) {
    	setAlunos(alunos);
    }
    
    public void removerAluno(List<Aluno> alunos) {
    	this.alunos.removeAll(alunos);
    }
    
    public long getId() {
		return id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}
    
    
    
    
}	
