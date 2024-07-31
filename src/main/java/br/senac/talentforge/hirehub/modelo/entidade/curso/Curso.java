package br.senac.talentforge.hirehub.modelo.entidade.curso;


public class Curso {
	
	private String nomeCurso;
    private String areaDeAtuacao;
    private StatusCurso status;
    
    public Curso(String nomeCurso, String areaDeAtuacao, StatusCurso status) {
    	this.nomeCurso = nomeCurso;
    	this.areaDeAtuacao = areaDeAtuacao;
    	this.status = status;
    }
    
    
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
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
