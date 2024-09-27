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
	private Contratacao contratacao;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proposta> ofertas = new ArrayList<Proposta>();

    public Vaga() {
    }

    public Vaga(String codigo, String nome, String descricao, Contratacao contratacao, Situacao situacao, Empresa empresa) {
        setCodigo(codigo);
        setNome(nome);
        setDescricao(descricao);
        setContratacao(contratacao);
        setSituacao(situacao);
        setEmpresa(empresa);
    }

    public Vaga(long id, String codigo, String nome, String descricao, Contratacao contratacao, Situacao situacao, Empresa empresa) {
        setId(id);
        setCodigo(codigo);
        setNome(nome);
        setDescricao(descricao);
        setContratacao(contratacao);
        setSituacao(situacao);
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

    public Contratacao getContratacao() {
        return contratacao;
    }

    public void setContratacao(Contratacao contratacao) {
        this.contratacao = contratacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao= situacao;
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
                contratacao == vaga.contratacao &&
                situacao == vaga.situacao &&
                Objects.equals(empresa, vaga.empresa) &&
                Objects.equals(ofertas, vaga.ofertas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nome, descricao, contratacao, situacao, empresa, ofertas);
    }
}