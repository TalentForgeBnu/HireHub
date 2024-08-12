package br.senac.talentforge.hirehub.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.entidade.genero.Genero;
import exemplo.modelo.entidade.endereco.Column;
import exemplo.modelo.entidade.endereco.JoinColumn;
import exemplo.modelo.entidade.endereco.MapsId;
import exemplo.modelo.entidade.endereco.OneToOne;

@Entity
@Table(name = "usuario")
public abstract class Usuario extends Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long id;
	
	@Column(name = "nome_usuario", length = 20, nullable = false, unique = false)
	private String nomeUsuario;
	
	@Column(name = "sobrenome", length = 20, nullable = false, unique = false)
	private String sobrenome;
	
	@Column(name = "data_nascimento", nullable = false, unique = true)
	private LocalDate dataNascimento;
	
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = genero)
	private Genero genero;
	
	@Column(name = "nome_social", length = 20, nullable = true, unique = false)
	private String nomeSocial;
	
	@Column(name = "renda_familiar", nullable = false, unique = false)
	private float rendaFamiliar;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	public Usuario() {
		
	}
	
	public Usuario(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf, Genero genero, float rendaFamiliar){
	    super();
		setNome(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setGenero(genero);
		setRendaFamiliar(rendaFamiliar);
	}
	
	public Usuario(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf, Genero genero, String nomeSocial, float rendaFamiliar){
	    super();
		setNome(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setGenero(genero);
		setNomeSocial(nomeSocial);
		setRendaFamiliar(rendaFamiliar);
	}
	
	public Usuario(long id, String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf, Genero genero, String nomeSocial, float rendaFamiliar){
	    super();
	    setId(id);
		setNome(nomeUsuario);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setGenero(genero);
		setNomeSocial(nomeSocial);
		setRendaFamiliar(rendaFamiliar);
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
	
	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public String getNomeSocial() {
		return nomeSocial;
	}
	
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	
	public float getRendaFamiliar() {
		return rendaFamiliar;
	}
	
	public void setRendaFamiliar(float rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}
	
}
