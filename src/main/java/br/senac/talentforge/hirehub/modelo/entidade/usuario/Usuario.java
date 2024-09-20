package br.senac.talentforge.hirehub.modelo.entidade.usuario;


import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;

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

    @Column(name = "senha", length = 20, nullable = false, unique = false)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    protected Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nome_papel")
    private Papel papel;

    @Column(name = "telefone", length = 13, nullable = false, unique = true)
    private String telefone;

    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    public Usuario() {
    }

    public Usuario(long id, String senha, Endereco endereco, Papel papel, String telefone, String email) {
        setId(id);
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
        setTelefone(telefone);
        setEmail(email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}