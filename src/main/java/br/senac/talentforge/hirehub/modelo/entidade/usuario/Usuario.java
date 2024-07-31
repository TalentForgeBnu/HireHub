package hirehub.talentforge.modelo.entity.usuario;

import java.time.LocalDate;

public abstract class Usuario extends Endereco {

	private String nomeUsuario;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String cpf;
	private Endereco endereco;
	private long id;
	
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
