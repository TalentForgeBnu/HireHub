package br.senac.talentforge.hirehub.modelo.entidade.vaga;

import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.enumeracao.modalidadecontratacao.ModalidadeContratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacaovaga.SituacaoVaga;

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
import javax.persistence.Table;
import java.io.Serializable;

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
    private ModalidadeContratacao modalidadeContratacao;

    @Enumerated(EnumType.STRING)
    private SituacaoVaga situacaoVaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Vaga() {}

    public Vaga(String codigo, String nome, String descricao, long id, ModalidadeContratacao modalidadeContratacao, SituacaoVaga situacaoVaga, Empresa empresa) {
        setId(id);
        setCodigo(codigo);
        setNome(nome);
        setDescricao(descricao);
        setModalidadeContratacao(modalidadeContratacao);
        setSituacaoVaga(situacaoVaga);
        setEmpresa(empresa);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public SituacaoVaga getSituacaoVaga() {
        return situacaoVaga;
    }

    public void setSituacaoVaga(SituacaoVaga situacaoVaga) {
        this.situacaoVaga = situacaoVaga;
    }

    public ModalidadeContratacao getModalidadeContratacao() {
        return modalidadeContratacao;
    }

    public void setModalidadeContratacao(ModalidadeContratacao modalidadeContratacao) {
        this.modalidadeContratacao = modalidadeContratacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}