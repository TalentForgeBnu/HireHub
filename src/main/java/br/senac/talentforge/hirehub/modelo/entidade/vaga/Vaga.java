package br.senac.talentforge.hirehub.modelo.entidade.vaga;

import java.io.Serializable;

import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;

@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTIFY)
	@Column(name = "codigo_vaga")
	private int codigoVaga;
	
	@Column(name = "nome_vaga", length = 50, nullable = false, unique = true)
	private String nomeVaga;
	
	@Column(name = "descricao_vaga", length = 50, nullable = false, unique = false)
	private String descricaoVaga;

	@ManyToOne(fetch = fetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
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

	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
