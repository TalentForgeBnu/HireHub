package br.senac.talentforge.hirehub.modelo.entidade.usuario;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;

@Entity
@Table(name = "usuario")
public abstract class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    @Column(name = "nome_social", length = 20, nullable = true, unique = false)
    private String nomeSocial;

    @Column(name = "nome_usuario", length = 20, nullable = false, unique = false)
    private String nomeUsuario;

    @Column(name = "sobrenome", length = 20, nullable = false, unique = false)
    private String sobreNome;

    @Column(name = "data_nascimento", nullable = false, unique = true)
    private LocalDate dataNascimento;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(name = "renda_familiar", nullable = false, unique = false)
    private float rendaFamiliar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Usuario() {}

    public Usuario(long id, String nomeSocial, String nomeUsuario, String sobreNome, LocalDate dataNascimento, String cpf, float rendaFamiliar, Endereco endereco, Genero genero) {
        setId(id);
        setNomeSocial(nomeSocial);
        setNomeUsuario(nomeUsuario);
        setSobreNome(sobreNome);
        setDataNascimento(dataNascimento);
        setCpf(cpf);
        setRendaFamiliar(rendaFamiliar);
        setEndereco(endereco);
        setGenero(genero);
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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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