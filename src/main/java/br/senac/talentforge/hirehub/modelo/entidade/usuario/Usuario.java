package br.senac.talentforge.hirehub.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")

public abstract class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    protected long id;

    @Column(name = "nome_social", length = 20, nullable = true, unique = false)
    protected String nomeSocial;

    @Column(name = "nome_usuario", length = 20, nullable = false, unique = false)
    protected String nome;

    @Column(name = "sobrenome", length = 20, nullable = false, unique = false)
    protected String sobrenome;

    @Column(name = "data_nascimento", nullable = false, unique = true)
    protected LocalDate dataNascimento;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    protected String cpf;

    @Column(name = "renda_familiar", nullable = false, unique = false)
    protected float rendaFamiliar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    protected Endereco endereco;

    @Enumerated(EnumType.STRING)
    protected Genero genero;

    public Usuario() {}

    public Usuario(long id, String nomeSocial, String nome, String sobrenome, LocalDate dataNascimento, String cpf, float rendaFamiliar, Endereco endereco, Genero genero) {
        setId(id);
        setNomeSocial(nomeSocial);
		setnome(nome);
        setsobrenome(sobrenome);
        setDataNascimento(dataNascimento);
        setCpf(cpf);
        setRendaFamiliar(rendaFamiliar);
        setEndereco(endereco);
        setGenero(genero);
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public float getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(float rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getsobrenome() {
        return sobrenome;
    }

    public void setsobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}