package br.senac.talentforge.hirehub.modelo.entidade.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = -790779129042088312L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private long id;
	
	@Column(name = "numero", length = 13, nullable = false, unique = true)
	private String numero;
	
	@Column(name = "email", length = 40, nullable = false, unique = true)
	private String email;
	
	public Contato(){
		
	}

	public Contato( String numero, String email) {
		super();
		setnumero(numero);
		setEmail(email);
	}


	public Contato( String numero, String email, long id) {
		setnumero(numero);
		setEmail(email);
		setId(id);
	}
	
	
	
	public String getnumero(){
		return numero;
	}
	
	public void setnumero(String numero) {
		this.numero = numero;
	}
	
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	
}
