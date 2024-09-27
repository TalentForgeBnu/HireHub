package br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoafisica")
public abstract class PessoaFisica extends Usuario implements Serializable {

    private static final long serialVersionUID = -6846672268949621291L;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    protected String cpf;

    @Column(name = "nome_usuario", length = 20, nullable = false, unique = false)
    protected String nome;

    @Column(name = "sobreNome", length = 20, nullable = false, unique = false)
    protected String sobreNome;

    @Column(name = "data_nascimento", nullable = false, unique = false)
    protected LocalDate dataNascimento;

    @Column(name = "renda_familiar", nullable = false, unique = false)
    protected float rendaFamiliar;

    @Enumerated(EnumType.STRING)
    protected Etnia etnia;

    @Enumerated(EnumType.STRING)
    protected Sexo genero;

    public PessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(float rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public Etnia getEtnia() {
        return etnia;
    }

    public void setEtnia(Etnia etnia) {
        this.etnia = etnia;
    }

    public Sexo getGenero() {
        return genero;
    }

    public void setGenero(Sexo genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PessoaFisica that = (PessoaFisica) object;
        return Float.compare(rendaFamiliar, that.rendaFamiliar) == 0 &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(sobreNome, that.sobreNome) &&
                Objects.equals(dataNascimento, that.dataNascimento) &&
                etnia == that.etnia && genero == that.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, nome, sobreNome, dataNascimento, rendaFamiliar, etnia, genero);
    }

}