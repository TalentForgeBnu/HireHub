package br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "pessoajuridica")
public abstract class PessoaJuridica extends Usuario implements Serializable {

    private static final long serialVersionUID = -2650136282802411329L;

    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    protected String cnpj;

    @Column(name = "nome_empresa", length = 20, nullable = false, unique = false)
    protected String nomeEmpresa;

    @Column(name = "data_fundacao", nullable = false, unique = false)
    protected LocalDate dataFundacao;

    @Column(name = "descricao", length = 300, nullable = false, unique = false)
    protected String descricao;

    public PessoaJuridica() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}