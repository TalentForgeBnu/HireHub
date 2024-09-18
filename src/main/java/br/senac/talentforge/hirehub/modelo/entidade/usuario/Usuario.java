package br.senac.talentforge.hirehub.modelo.entidade.usuario;


import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")

public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 387637421011881759L;


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

    public Usuario() {}

    public Usuario(long id, String senha, Endereco endereco, Papel papel) {
        setId(id);
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
    }
    
    public Papel getPapel() {
    	return papel;
    }
    
    public void setPapel(Papel papel) {
    	this.papel = papel;
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

}