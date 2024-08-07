package br.senac.talentforge.hirehub.modelo.entidade.contato;

import java.io.Serializable;

public class Contato implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private long id;
	
	@Column(name = "celular", length = 13, nullable = false, unique = false)
	private String celular;
	
	@Column(name = "telefone", length = 13, nullable = false, unique = false)
	private String telefone;
	
	@Column(name = "telefone", length = 30, nullable = false, unique = false)
	private String email;
	
	public Contato(){
		
	}
	
	public Contato(String celular, String telefone, String email, long id) {
		super();
		setCelular(celular);
		setTelefone(telefone);
		setEmail(email);
		setId(id);
	}
	
	public String getCelular(){
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
