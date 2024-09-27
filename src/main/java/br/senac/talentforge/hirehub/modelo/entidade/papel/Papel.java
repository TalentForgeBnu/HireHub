package br.senac.talentforge.hirehub.modelo.entidade.papel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "papel")
public class Papel implements Serializable {

    private static final long serialVersionUID = -2742798415290393914L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_papel")
    private long id;

    @Column(name = "papel", length = 25, nullable = false, unique = true)
    private String papel;

    @OneToMany(mappedBy = "papel", fetch = FetchType.LAZY)
    private List<Usuario> usuarios = new ArrayList<>();

    public Papel() {
    }

    public Papel(String papel) {
        setPapel(papel);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

}