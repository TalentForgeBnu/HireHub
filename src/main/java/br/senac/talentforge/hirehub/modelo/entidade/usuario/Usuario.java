package br.senac.talentforge.hirehub.modelo.entidade.usuario;


import java.io.Serializable;
import javax.persistence.*;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
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

    
    @Column(name = "senha", length = 20, nullable = false, unique = false)
    private String senha;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    protected Endereco endereco;


    public Usuario() {}

    public Usuario(long id, String senha, Endereco endereco) {
        setId(id);       
        setSenha(senha);
        setEndereco(endereco);


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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}