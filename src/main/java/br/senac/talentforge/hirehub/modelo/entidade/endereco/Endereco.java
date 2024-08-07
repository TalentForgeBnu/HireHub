package br.senac.talentforge.hirehub.modelo.entidade.endereco;

public class Endereco {

	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco(String rua, String bairro, String cidade, String estado, String cep) {

		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void adicionarEndereco() {
	}

	public void removerEndereco() {
	}

	public void editarEndereco() {
	}

}
