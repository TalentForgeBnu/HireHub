package br.senac.talentforge.hirehub.modelo.entidade.oferta;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.andamentooferta.AndamentoOferta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "oferta")
public class Oferta implements Serializable {

    private static final long serialVersionUID = -3383714348610491036L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private long id;

    @Column(name = "proposta", length = 50, unique = false)
    private String proposta;

    @Column(name = "resposta", length = 50, unique = false)
    private String resposta;

    @Enumerated(EnumType.STRING)
    private AndamentoOferta andamentoOferta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_vaga")
    private Vaga vaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    public Oferta() {}

    public Oferta(long id, String proposta, String resposta, AndamentoOferta andamentoOferta, Vaga vaga, Curso curso) {
        setId(id);
        setProposta(proposta);
        setResposta(resposta);
        setAndamentoOferta(andamentoOferta);
        setVaga(vaga);
        setCurso(curso);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public AndamentoOferta getAndamentoOferta() {
        return andamentoOferta;
    }

    public void setAndamentoOferta(AndamentoOferta andamentoOferta) {
        this.andamentoOferta = andamentoOferta;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

}