package br.senac.talentforge.hirehub.modelo.entidade.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica.PessoaFisica;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.estudante.Estudante;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@Entity
@Table(name = "aluno")
public class Aluno extends PessoaFisica implements Serializable {

    private static final long serialVersionUID = -1588651712344525933L;

    @Column(name = "matricula", length = 30, nullable = false, unique = false)
    private String matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Enumerated(EnumType.STRING)
    private Estudante estudante;

    public Aluno() {
    }

    public Aluno(String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf, String nome, String sobrenome, String nomeSocial, LocalDate dataNascimento, float rendaFamiliar, Etnia etnia, Sexo sexo, String matricula, Instituicao instituicao, Turma turma, Estudante alunoMatriculado) {
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
        setRendaFamiliar(rendaFamiliar);
        setEtnia(etnia);
        setSexo(sexo);
        setMatricula(matricula);
        setInstituicao(instituicao);
        setTurma(turma);
        setEstudante(alunoMatriculado);
    }

    public Aluno(long id, String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf, String nome, String sobrenome, String nomeSocial, LocalDate dataNacimento, float rendaFamiliar, Etnia etnia, Sexo sexo, String matricula, Instituicao instituicao, Turma turma, Estudante alunoMatriculado) {
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
        setRendaFamiliar(rendaFamiliar);
        setEtnia(etnia);
        setSexo(sexo);
        setMatricula(matricula);
        setInstituicao(instituicao);
        setTurma(turma);
        setEstudante(alunoMatriculado);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante= estudante;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Aluno aluno = (Aluno) object;
        return Objects.equals(matricula, aluno.matricula) &&
                Objects.equals(instituicao, aluno.instituicao) &&
                Objects.equals(turma, aluno.turma) &&
                estudante == aluno.estudante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricula, instituicao, turma, estudante);
    }
}