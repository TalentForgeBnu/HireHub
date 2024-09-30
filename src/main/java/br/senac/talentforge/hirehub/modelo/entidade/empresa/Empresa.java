package br.senac.talentforge.hirehub.modelo.entidade.empresa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica.PessoaJuridica;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;

@Entity
@Table(name = "empresa")
public class Empresa extends PessoaJuridica implements Serializable {

    private static final long serialVersionUID = -6802369364395050191L;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaga> vagas = new ArrayList<Vaga>();

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proposta> propostas = new ArrayList<Proposta>();

    public Empresa() {
    }

    public Empresa(String senha, Endereco endereco, Papel papel, String telefone, String email, String cnpj, String nome, LocalDate dataFundacao, String descricao) {
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
        setTelefone(telefone);
        setEmail(email);
        setCnpj(cnpj);
        setNome(nome);
        setDataFundacao(dataFundacao);
        setDescricao(descricao);
    }

    public Empresa(long id, String senha, Endereco endereco, Papel papel, String telefone, String email, String cnpj, String nome, LocalDate dataFundacao, String descricao) {
        setId(id);
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
        setTelefone(telefone);
        setEmail(email);
        setCnpj(cnpj);
        setNome(nome);
        setDataFundacao(dataFundacao);
        setDescricao(descricao);
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public void adicionarVaga(Vaga vaga) {
        this.vagas.add(vaga);
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }

    public void adicionarProposta(Proposta propostas) {
        this.propostas.add(propostas);
    }

}
