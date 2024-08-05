package br.senac.talentforge.hirehub.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import exemplo.modelo.entidade.cliente.Column;
import exemplo.modelo.entidade.contato.JoinColumn;
import exemplo.modelo.entidade.contato.MapsId;
import exemplo.modelo.entidade.contato.OneToOne;

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
	
	public Usuario() {
		
	}
	
	public Usuario(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf){
	    super();
		setNomeUsuario(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
	}
	
	public Usuario(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf, long id){
		setNomeUsuario(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setId(id);
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
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
