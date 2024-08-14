package br.senac.talentforge.hirehub.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;

@Entity
@Table(name = "usuario")
public abstract class Usuario extends Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long id;
	
	@Column(name = "nome_usuario", length = 25, nullable = false, unique = false)
	private String nomeUsuario;
	
	@Column(name = "sobrenome", length = 25, nullable = false, unique = false)
	private String sobrenome;
	
	@Column(name = "data_nascimento", nullable = false, unique = true)
	private LocalDate dataNascimento;
	
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	
	public Usuario(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf,String logradouro, String bairro, String cidade, String estado, String cep){
	    super(logradouro, bairro, cidade, estado, cep);
		setNome(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
	}
	
    public Usuario() {
		
	}
	
    public Usuario(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf){
		
    	super();
    	setNome(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
	}
    
	public Usuario(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf, long id){
		setNome(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setId(id);
	}
	
	public String getNome() {
		return nomeUsuario;
	}
	
	public void setNome(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public long getId() {
		return id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
