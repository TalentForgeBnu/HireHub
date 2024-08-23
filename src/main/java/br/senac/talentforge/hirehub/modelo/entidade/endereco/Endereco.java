package br.senac.talentforge.hirehub.modelo.entidade.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "endereco", uniqueConstraints = { @UniqueConstraint(columnNames = { "logradouro", "numero" }) })
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private long id;

	@Column(name = "logradouro", length = 50, nullable = false, unique = false)
	private String logradouro;

	@Column(name = "bairro", length = 50, nullable = false, unique = false)
	private String bairro;

	@Column(name = "cidade", length = 50, nullable = false, unique = false)
	private String cidade;

	@Column(name = "estado", length = 50, nullable = false, unique = false)
	private String estado;

	@Column(name = "cep", length = 9, nullable = false, unique = false)
	private String cep;

	@Column(name = "numero", nullable = false, unique = true)
	private int numero;

	public Endereco() {
		
	}
	
	public Endereco(String logradouro, String bairro, String cidade, String estado, String cep, int numero) {

		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numero = numero;
	}
	public Endereco(String logradouro, String bairro, String cidade, String estado, String cep, String celular, String telefone, String email) {
		
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getlogradouro() {
		return logradouro;
	}

	public void setlogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
