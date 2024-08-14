package br.senac.talentforge.hirehub.modelo.entidade.oferta;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;

public class Oferta {

	private Vaga vaga;
	private Curso curso;
	private String proposta;
	private String resposta;
	//private Status andamentoOferta;

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
