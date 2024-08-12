package br.senac.talentforge.hirehub.modelo.entidade.aluno;

import java.io.Serializable;
import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Column;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.GeneratedValue;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Id;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

public class Aluno extends Usuario implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private long id;
	
	@Column(name = "matricula", length = 30, nullable = false, unique = false)
	private String matricula;
	
	@Column(name = "codigo_turma", length = 30, nullable = false, unique = false)
	private String codigoTurma;
	
	@Column(name = "dossie", length = 200, nullable = false, unique = false)
	private String dossie;
	
	@Enumarated(EnumType.STRING)
  private AlunoMatriculado status;
	
	public Aluno() {
		
	}
	
	public Aluno(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf,String matricula, String codigoTurma, String dossie, StatusAluno status, long id) {
		
		super(nomeUsuario,sobrenome,dataNascimento, cpf);
		setMatricula(matricula);
		setCodigoTurma(codigoTurma);
		setDossie(dossie);
		setStatusAluno(status);
		setId(id);
		
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;		
	}
	
	public String getCodigoTurma() {
		return codigoTurma;
	}
	
	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;		
	}
	
	public String getDossie() {
		return dossie;
	}
	
	public void setDossie(String dossie) {
		this.dossie = dossie;		
	}
	
	public StatusAluno getStatus() {
		return status;
	}
	
	public void setStatusAluno(StatusAluno status) {
		this.status = status;		
	}

	public long getId() {
		return id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
