package br.senac.talentforge.hirehub.modelo.entidade.usuario;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")

public class Usuario implements Serializable {

    private static final long serialVersionUID = -7754498462408877687L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    protected long id;

    @Column(name = "senha", length = 20, nullable = false, unique = false)
    protected String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    protected Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_papel")
    protected Papel papel;

    @Column(name = "telefone", length = 13, nullable = false, unique = true)
    protected String telefone;

    @Column(name = "email", length = 40, nullable = false, unique = true)
    protected String email;

    public Usuario() {
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return id == usuario.id &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(endereco, usuario.endereco) &&
                Objects.equals(papel, usuario.papel) &&
                Objects.equals(telefone, usuario.telefone) &&
                Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, senha, endereco, papel, telefone, email);
    }
}