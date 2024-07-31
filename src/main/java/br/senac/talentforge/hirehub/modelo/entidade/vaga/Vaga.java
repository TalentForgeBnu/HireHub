package modelo;

public class Vaga  {

	private String nomeVaga;
	private int codigoVaga;
	private String descricaoVaga;

	public Vaga(String nomeVaga, int codigoVaga, String descricaoVaga) {
		
		this.nomeVaga = nomeVaga;
		this.codigoVaga = codigoVaga;
		this.descricaoVaga = descricaoVaga;
	}

	public String getNomeVaga() {
		return nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}

	public int getCodigoVaga() {
		return codigoVaga;
	}

	public void setCodigoVaga(int codigoVaga) {
		this.codigoVaga = codigoVaga;
	}

	public String getDescricaoVaga() {
		return descricaoVaga;
	}

	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}
	
	public void adicionarVaga() {
	}

	public void removerVaga() {	
	}

	public void editarVaga() {
	}

}
