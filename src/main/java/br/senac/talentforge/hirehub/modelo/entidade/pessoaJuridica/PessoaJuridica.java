package br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;


@Entity
@Table(name = "pessoajuridica")
public class PessoaJuridica extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;

	@Column(name = "data_fundacao", nullable = false, unique = true)
	private LocalDate dataFundacao;
	
	@Column(name = "descricao", length = 300, nullable = false, unique = false)
    private String descricao;
	
	public PessoaJuridica() {
		
		}

	public PessoaJuridica(String cnpj, LocalDate dataFundacao, String descricao) {
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.descricao = descricao;
	}
	
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
}
