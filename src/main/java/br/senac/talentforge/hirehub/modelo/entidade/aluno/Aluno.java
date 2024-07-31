package hirehub.talentforge.modelo.entity.aluno;

import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

public class Aluno extends Usuario {
	
	private String matricula;
	private String codigoTurma;
	private String dossie;
	private StatusAluno status;
	private long id;
	
	public Aluno() {
		
	}
	
	public Aluno(String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf,String matricula, int codigoTurma, String dossie, StatusAluno status, long id) {
		
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
