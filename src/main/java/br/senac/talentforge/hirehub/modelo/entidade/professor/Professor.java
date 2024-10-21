package br.senac.talentforge.hirehub.modelo.entidade.professor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica.PessoaFisica;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@Entity
@Table(name = "professor")
public class Professor extends PessoaFisica implements Serializable {

	private static final long serialVersionUID = 8321801558181373534L;

	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Turma> turmas = new ArrayList<Turma>();

	@ManyToOne
	@JoinColumn(name = "id_instituicao", nullable = true)
	private Instituicao instituicao;

	public Professor() {
	}

	public Professor(String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf,
			String nome, String sobrenome, String nomeSocial, LocalDate dataNascimento, Etnia etnia, Sexo sexo,
			Instituicao instituicao) {
		setSenha(senha);
		setEndereco(endereco);
		setPapel(papel);
		setTelefone(telefone);
		setEmail(email);
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setNomeSocial(nomeSocial);
		setDataNascimento(dataNascimento);
		setEtnia(etnia);
		setSexo(sexo);
		setInstituicao(instituicao);
	}

	public Professor(long id, String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf,
			String nome, String sobrenome, String nomeSocial, LocalDate dataNacimento, Etnia etnia, Sexo sexo,
			Instituicao instituicao) {
		setId(id);
		setSenha(senha);
		setEndereco(endereco);
		setPapel(papel);
		setTelefone(telefone);
		setEmail(email);
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setNomeSocial(nomeSocial);
		setDataNascimento(dataNacimento);
		setEtnia(etnia);
		setSexo(sexo);
		setInstituicao(instituicao);
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public void adicionarTurma(Turma turma) {
		this.turmas.add(turma);
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public boolean equals(Object obj) {

		if (obj == null)
			return false;

		if (this == obj)
			return true;

		if (this.getClass() != obj.getClass())
			return false;

		Professor professor = (Professor) obj;

		return this.getSenha().equals(professor.getSenha()) && this.getEndereco().equals(professor.getEndereco())
				&& this.getPapel().equals(professor.getPapel()) && this.getTelefone().equals(professor.getTelefone())
				&& this.getEmail().equals(professor.getEmail()) && this.getCpf().equals(professor.getCpf())
				&& this.getNome().equals(professor.getNome()) && this.getSobrenome().equals(professor.getSobrenome())
				&& this.getNomeSocial().equals(professor.getNomeSocial())
				&& this.getDataNascimento().equals(professor.getDataNascimento())
				&& this.getEtnia().equals(professor.getEtnia()) && this.getSexo().equals(professor.getSexo())
				&& this.getInstituicao().equals(professor.getInstituicao());

	}

}