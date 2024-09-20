package br.senac.talentforge.hirehub.modelo.entidade.papel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "papel")
public class Papel implements Serializable{

    private static final long serialVersionUID = -2742798415290393914L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_papel")
    private long id;

    @Column(name = "nome_papel", length = 20, nullable = false, unique = false)
    private String nomePapel;

    public Papel() {}

    public Papel(long id, String nomePapel) {
        setId(id);
        setNomePapel(nomePapel);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomePapel(String nomePapel) {
        this.nomePapel = nomePapel;
    }

    public String getNomePapel() {
        return nomePapel;
    }

}