package br.senac.talentforge.hirehub.modelo.entidade.curso;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.enumeracao.andamentocurso.AndamentoCurso;

@Entity
@Table(name = "curso" )
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_professor")
	private Long id;
	
	@Column(name = "nome_curso", length = 50, nullable = false, unique = true)
	private String nomeCurso;
	
	@Column(name = "area_atuacao", length = 50, nullable = false, unique = false)
    private String areaDeAtuacao;
	
	@Enumerated(EnumType.STRING)
    private AndamentoCurso status;
	
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricaoCurso;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	
	public Curso() {
		
	}
	
    public Curso(String nomeCurso, String areaDeAtuacao, AndamentoCurso status) {
    	this.nomeCurso = nomeCurso;
    	this.areaDeAtuacao = areaDeAtuacao;
    	this.status = status;
    }
    
    public LocalDate getDataInicio() {
    	return dataInicio;
    }
    
    public void setDataInicio(LocalDate dataInicio) {
    	this.dataInicio = dataInicio;
    }
    
    public LocalDate getDataFim() {
    	return dataFim;
    }
    
    public void setDataFim(LocalDate dataFim) {
    	this.dataFim = dataFim;
    }
    
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    
    public String getDescricaoCurso() {
    	return descricaoCurso;
    }
    
    public void setDescricaoCurso(String descricaoCurso) {
    	this.descricaoCurso = descricaoCurso;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public AndamentoCurso getStatus() {
        return status;
    }

    public void setStatus(AndamentoCurso status) {
        this.status = status;
    }
    
    public Professor getProfessor() {
    	return professor;
    }
    
    public void setProfessor(Professor professor) {
    	this.professor = professor;
    }
    
    
	
}
