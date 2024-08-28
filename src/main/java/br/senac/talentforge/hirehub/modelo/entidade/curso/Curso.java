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

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.enumeracao.andamentocurso.AndamentoCurso;

@Entity
@Table(name = "curso" )
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long id;
	
	@Column(name = "nome_curso", length = 50, nullable = false, unique = true)
	private String nomeCurso;	

	@Column(name = "area_atuacao", length = 50, nullable = false, unique = false)
    private String areaDeAtuacao;
	
	@Enumerated(EnumType.STRING)
    private AndamentoCurso andamentoCurso;
	
	@Column(name = "data_inicio", nullable = false, unique = false)
    private LocalDate dataInicio;
	
	@Column(name = "data_fim", nullable = false, unique = false)
    private LocalDate dataFim;
	
	@Column(name = "descricao", length = 300, nullable = true, unique = false)
    private String descricao;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;
	
	
	public Curso() {
		
	}
	
  public Curso(String nomeCurso, String areaDeAtuacao, LocalDate dataInicio, LocalDate dataFim, String descricao, AndamentoCurso andamentoCurso) {
    	this.nomeCurso = nomeCurso; 
    	this.areaDeAtuacao = areaDeAtuacao;
    	this.dataInicio = dataInicio;
    	this.dataFim = dataFim;
    	this.descricao = descricao;
    	this.andamentoCurso = andamentoCurso;
    }
    
    public Curso(String nomeCurso, String areaDeAtuacao, LocalDate dataInicio, LocalDate dataFim, String descricao, Instituicao instituica, AndamentoCurso andamentoCurso) {
    	this.nomeCurso = nomeCurso; 
    	this.areaDeAtuacao = areaDeAtuacao;
    	this.dataInicio = dataInicio;
    	this.dataFim = dataFim;
    	this.descricao = descricao;
    	this.instituicao = instituica;
    	this.andamentoCurso = andamentoCurso;
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
    
    public String getDescricao() {
    	return descricao;
    }
    
    public void setDescricao(String descricaoCurso) {
    	this.descricao = descricaoCurso;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public AndamentoCurso getStatus() {
        return andamentoCurso;
    }

    public void setStatus(AndamentoCurso andamentoCurso) {
        this.andamentoCurso = andamentoCurso;
    }
    
    public Instituicao getInsituicao() {
    	return instituicao;
    }
    
    public void setInsituicao(Instituicao instituicao) {
    	this.instituicao = instituicao;
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
	
}
