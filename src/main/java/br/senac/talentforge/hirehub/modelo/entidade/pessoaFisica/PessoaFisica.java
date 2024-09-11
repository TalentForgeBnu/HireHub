package br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoafisica")
public abstract class PessoaFisica extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome_social", length = 20, nullable = true, unique = false)
    private String nomeSocial;

    @Column(name = "nome_usuario", length = 20, nullable = false, unique = false)
    private String nome;

    @Column(name = "sobrenome", length = 20, nullable = false, unique = false)
    private String sobrenome;

    @Column(name = "data_nascimento", nullable = false, unique = false)
    private LocalDate dataNascimento;

    @Column(name = "renda_familiar", nullable = false, unique = false)
    private float rendaFamiliar;

    @Enumerated(EnumType.STRING)
    private Etnia etnia;

    @Enumerated(EnumType.STRING)
    private Genero genero;


    public PessoaFisica() {

    }

    public PessoaFisica(String cpf, String nomeSocial, String nome, String sobrenome, LocalDate dataNascimento, float rendaFamiliar, Etnia etnia, Genero genero) {
        setCpf(cpf);
        setNomeSocial(nomeSocial);
        setNome(nome);
        setSobrenome(sobrenome);
        setDataNascimento(dataNascimento);
        setRendaFamiliar(rendaFamiliar);
        setEtnia(etnia);
        setGenero(genero);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
