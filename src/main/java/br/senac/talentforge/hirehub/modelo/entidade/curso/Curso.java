package br.senac.talentforge.hirehub.modelo.entidade.curso;

import java.time.LocalDate;

public class Curso {
	
	private String nomeCurso;
    private String areaDeAtuacao;
    private StatusCurso status;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricaoCurso;
    
    public Curso(String nomeCurso, String areaDeAtuacao, StatusCurso status) {
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

    public StatusCurso getStatus() {
        return status;
    }

    public void setStatus(StatusCurso status) {
        this.status = status;
    }
    
	
}
