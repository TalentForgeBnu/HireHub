package br.senac.talentforge.hirehub.modelo.entidade.usuario;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")

public abstract class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    protected long id;

    @Column(name = "nome_usuario", length = 20, nullable = false, unique = false)
    protected String nome;

    @Column(name = "sobrenome", length = 20, nullable = false, unique = false)
    protected String sobreNome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    protected Endereco endereco;

    public Usuario() {
    }

    public Usuario(long id, String nome, String sobreNome, Endereco endereco) {
        setId(id);
        setNome(nome);
        setSobreNome(sobreNome);
        setEndereco(endereco);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}