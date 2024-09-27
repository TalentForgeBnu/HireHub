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
    private Estudante alunoMatriculado;

    public Aluno() {
    }

    public Aluno(String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf, String nome, String sobrenome, LocalDate dataNascimento, float rendaFamiliar, Etnia etnia, Sexo genero, String matricula, Instituicao instituicao, Turma turma, Estudante alunoMatriculado) {
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
        setTelefone(telefone);
        setEmail(email);
        setCpf(cpf);
        setNome(nome);
        setSobreNome(sobrenome);
        setDataNascimento(dataNascimento);
        setRendaFamiliar(rendaFamiliar);
        setEtnia(etnia);
        setGenero(genero);
        setMatricula(matricula);
        setInstituicao(instituicao);
        setTurma(turma);
        setAlunoMatriculado(alunoMatriculado);
    }

    public Aluno(long id, String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf, String nome, String sobrenome, LocalDate dataNacimento, float rendaFamiliar, Etnia etnia, Sexo genero, String matricula, Instituicao instituicao, Turma turma, Estudante alunoMatriculado) {
        setId(id);
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
        setTelefone(telefone);
        setEmail(email);
        setCpf(cpf);
        setNome(nome);
        setSobreNome(sobrenome);
        setDataNascimento(dataNacimento);
        setRendaFamiliar(rendaFamiliar);
        setEtnia(etnia);
        setGenero(genero);
        setMatricula(matricula);
        setInstituicao(instituicao);
        setTurma(turma);
        setAlunoMatriculado(alunoMatriculado);
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

    public Estudante getAlunoMatriculado() {
        return alunoMatriculado;
    }

    public void setAlunoMatriculado(Estudante alunoMatriculado) {
        this.alunoMatriculado = alunoMatriculado;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Aluno aluno = (Aluno) object;
        return Objects.equals(matricula, aluno.matricula) &&
                Objects.equals(instituicao, aluno.instituicao) &&
                Objects.equals(turma, aluno.turma) &&
                alunoMatriculado == aluno.alunoMatriculado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricula, instituicao, turma, alunoMatriculado);
    }
}