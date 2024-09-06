package br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;
import java.io.Serializable;
import java.time.LocalDate;



@Entity
@Table(name = "pessoajuridica")
public abstract class PessoaJuridica extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;

	@Column(name = "nome_empresa", length = 20, nullable = false, unique = false)
    private String nomeEmpresa;
	
	@Column(name = "data_fundacao", nullable = false, unique = false)
	private LocalDate dataFundacao;
	
	@Column(name = "descricao", length = 300, nullable = false, unique = false)
    private String descricao;

	
	public PessoaJuridica() {
		
		}

	public PessoaJuridica(String cnpj, String nomeEmpresa, LocalDate dataFundacao, String descricao) {
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
		this.dataFundacao = dataFundacao;
		this.descricao = descricao;
	}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

	public String getDescricao(){
		return descricao;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}

}
