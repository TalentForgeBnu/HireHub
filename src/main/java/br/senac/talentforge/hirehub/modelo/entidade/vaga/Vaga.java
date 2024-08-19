package br.senac.talentforge.hirehub.modelo.entidade.vaga;

import java.io.Serializable;

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

import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.enumeracao.modalidadecontratacao.ModalidadeContratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacaovaga.SituacaoVaga;

@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_vaga")
    private int codigoVaga;

    @Column(name = "nome_vaga", length = 50, nullable = false, unique = true)
    private String nomeVaga;

    @Column(name = "descricao_vaga", length = 50, nullable = false, unique = false)
    private String descricaoVaga;

    @Enumerated(EnumType.STRING)
    private ModalidadeContratacao modalidadeContratacao;
    
    @Enumerated(EnumType.STRING)
    private SituacaoVaga situacaoVaga;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Vaga(){

    }
    
    public Vaga(String nomeVaga, int codigoVaga, String descricaoVaga, ModalidadeContratacao modalidadeContratacao, SituacaoVaga situacaoVaga) {

        setNomeVaga(nomeVaga);
        setCodigoVaga(codigoVaga);
        setDescricaoVaga(descricaoVaga);
        setModalidadeContratacao(modalidadeContratacao);
        setSituacaoVaga(situacaoVaga);
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public int getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(int codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    public String getDescricaoVaga() {
        return descricaoVaga;
    }

    public void setDescricaoVaga(String descricaoVaga) {
        this.descricaoVaga = descricaoVaga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ModalidadeContratacao getModalidadeContratacao() {
        return modalidadeContratacao;
    }

    public void setModalidadeContratacao(ModalidadeContratacao modalidadeContratacao) {
        this.modalidadeContratacao = modalidadeContratacao;
    }
    
    public SituacaoVaga getSituacaoVaga() {
        return situacaoVaga;
    }

    public void setSituacaoVaga(SituacaoVaga situacaoVaga ) {
        this.situacaoVaga = situacaoVaga;
    }

}
