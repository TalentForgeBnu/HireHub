package br.senac.talentforge.hirehub.modelo.entidade.PessoaFisica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;


@Entity
@Table(name = "pessoafisica")
public class PessoaFisica extends Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pessoa_fisica")
    private long codigoPessoaFisica;
	
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
	
	@Column(name = "nome_social", length = 50, nullable = false, unique = true)
    private String nomeSocial;
	
	@Column(name = "renda_familiar", nullable = false, unique = false)
    private float rendaFamiliar;
	
	@Enumerated(EnumType.STRING)
    private Etnia etnia;
	
	@Enumerated(EnumType.STRING)
    private Genero genero;
	
	
	public PessoaFisica() {
		
	}


	public PessoaFisica(long codigoPessoaFisica, String cpf, String nomeSocial, float rendaFamiliar, Etnia etnia,
			Genero genero) {
		this.codigoPessoaFisica = codigoPessoaFisica;
		this.cpf = cpf;
		this.nomeSocial = nomeSocial;
		this.rendaFamiliar = rendaFamiliar;
		this.etnia = etnia;
		this.genero = genero;
	}
	
	
	public long getCodigoPessoaFisica() {
        return codigoPessoaFisica;
    }

    public void setCodigoPessoaFisica(long codigoPessoaFisica) {
        this.codigoPessoaFisica= codigoPessoaFisica;
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
