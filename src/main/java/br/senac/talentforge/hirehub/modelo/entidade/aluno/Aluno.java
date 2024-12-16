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
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica.PessoaFisica;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.estudante.Estudante;
import br.senac.talentforge.hirehub.modelo.enumeracao.etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.rendafamiliar.RendaFamiliar;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@Entity
@Table(name = "aluno")
public class Aluno extends PessoaFisica implements Serializable {

    private static final long serialVersionUID = -1588651712344525933L;

    @Column(name = "matricula", length = 30, nullable = true, unique = true)
    private String matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Enumerated(EnumType.STRING)
    private Estudante estudante;

    @Enumerated(EnumType.STRING)
    private RendaFamiliar rendaFamiliar;

    public Aluno() {
    }

    public Aluno(String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf, String nome, String sobrenome, String nomeSocial, LocalDate dataNascimento, RendaFamiliar rendaFamiliar, Etnia etnia, Sexo sexo, String matricula, Turma turma, Estudante estudante) {
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
        setMatricula(matricula);
        setTurma(turma);
        setEstudante(estudante);
        setRendaFamiliar(rendaFamiliar);
    }

    public Aluno(long id, String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf, String nome, String sobrenome, String nomeSocial, LocalDate dataNacimento, RendaFamiliar rendaFamiliar, Etnia etnia, Sexo sexo, String matricula, Turma turma, Estudante estudante) {
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
        setTurma(turma);
        setEstudante(estudante);
    }

    //esse contrutor no momento foi criado para pode suprir a necessidade do AlunoServlet.
    public Aluno(String senha, Endereco endereco, Papel papel, String telefone, String email, String cpf, String nome, String sobrenome, String nomeSocial, LocalDate dataNascimento, RendaFamiliar rendaFamiliar, Etnia etnia, Sexo sexo) {
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
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        this.estudante = estudante;
    }

    public RendaFamiliar getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(RendaFamiliar rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Aluno aluno = (Aluno) object;
        return Objects.equals(matricula, aluno.matricula) &&
                Objects.equals(turma, aluno.turma) &&
                estudante == aluno.estudante &&
                rendaFamiliar == aluno.rendaFamiliar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricula, turma, estudante);
    }

}
