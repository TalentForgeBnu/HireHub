package br.senac.talentforge.hirehub.modelo.entidade.oferta;

import java.io.ObjectInputFilter.Status;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;

public class Oferta {

	@Column(name = "proposta", length  = 50, unique = false)
	private String proposta;
	@Column(name = "resposta", length  = 50, unique = false)
	private String resposta;
	@Enumerated(EnumType.STRING)
	private Status andamentoOferta;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_vaga")
	private Vaga vaga;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso")
	private Curso curso;

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getProposta() {
		return proposta;
	}

	public void setProposta(String proposta) {
		this.proposta = proposta;

	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	//public Status getAndamentoOferta() {
	//	return andamentoOferta;
	//}

	//public void setAndamentoOferta(Status andamentoOferta) {
	//	this.andamentoOferta = andamentoOferta;
	//}

}
