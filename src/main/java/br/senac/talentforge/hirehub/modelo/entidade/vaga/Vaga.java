package br.senac.talentforge.hirehub.modelo.entidade.vaga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;


@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {

    private static final long serialVersionUID = 3028127181895527836L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private long id;

    @Column(name = "codigo_vaga", length = 32, nullable = false, unique = true)
    private String codigo;

    @Column(name = "nome_vaga", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao_vaga", length = 50, nullable = false, unique = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Contratacao modalidadeContratacao;

    @Enumerated(EnumType.STRING)
    private Situacao situacaoVaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proposta> ofertas = new ArrayList<Proposta>();

    public Vaga() {
    }

    public Vaga(String codigo, String nome, String descricao, Contratacao modalidadeContratacao, Situacao situacaoVaga, Empresa empresa) {
        setCodigo(codigo);
        setNome(nome);
        setDescricao(descricao);
        setModalidadeContratacao(modalidadeContratacao);
        setSituacaoVaga(situacaoVaga);
        setEmpresa(empresa);
    }

    public Vaga(long id, String codigo, String nome, String descricao, Contratacao modalidadeContratacao, Situacao situacaoVaga, Empresa empresa) {
        setId(id);
        setCodigo(codigo);
        setNome(nome);
        setDescricao(descricao);
        setModalidadeContratacao(modalidadeContratacao);
        setSituacaoVaga(situacaoVaga);
        setEmpresa(empresa);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Contratacao getModalidadeContratacao() {
        return modalidadeContratacao;
    }

    public void setModalidadeContratacao(Contratacao modalidadeContratacao) {
        this.modalidadeContratacao = modalidadeContratacao;
    }

    public Situacao getSituacaoVaga() {
        return situacaoVaga;
    }

    public void setSituacaoVaga(Situacao situacaoVaga) {
        this.situacaoVaga = situacaoVaga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Proposta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Proposta> ofertas) {
        this.ofertas = ofertas;
    }

    public void adicionarOferta(Proposta oferta) {
        this.ofertas.add(oferta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return id == vaga.id &&
                Objects.equals(codigo, vaga.codigo) &&
                Objects.equals(nome, vaga.nome) &&
                Objects.equals(descricao, vaga.descricao) &&
                modalidadeContratacao == vaga.modalidadeContratacao &&
                situacaoVaga == vaga.situacaoVaga &&
                Objects.equals(empresa, vaga.empresa) &&
                Objects.equals(ofertas, vaga.ofertas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nome, descricao, modalidadeContratacao, situacaoVaga, empresa, ofertas);
    }
}