package br.senac.talentforge.hirehub.modelo.entidade.proposta;

import java.io.Serializable;
import java.util.Objects;

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

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.oferta.Oferta;

@Entity
@Table(name = "proposta")
public class Proposta implements Serializable {

    private static final long serialVersionUID = -3383714348610491036L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proposta")
    private long id;

    @Column(name = "proposta", length = 50, unique = false)
    private String proposta;

    @Column(name = "resposta", length = 50, unique = false)
    private String resposta;

    @Enumerated(EnumType.STRING)
    private Oferta andamentoOferta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vaga")
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

    public Proposta() {
    }

    public Proposta(String proposta, String resposta, Oferta andamentoOferta, Vaga vaga, Curso curso, Empresa empresa, Instituicao instituicao) {
        setProposta(proposta);
        setResposta(resposta);
        setAndamentoOferta(andamentoOferta);
        setVaga(vaga);
        setCurso(curso);
        setEmpresa(empresa);
        setInstituicao(instituicao);
    }
    
    public Proposta(String proposta, String resposta, Oferta andamentoOferta, Vaga vaga, Empresa empresa, Instituicao instituicao) {
        setProposta(proposta);
        setResposta(resposta);
        setAndamentoOferta(andamentoOferta);
        setVaga(vaga);
        setEmpresa(empresa);
        setInstituicao(instituicao);
    }

    public Proposta(long id, String proposta, String resposta, Oferta andamentoOferta, Vaga vaga, Curso curso, Empresa empresa, Instituicao instituicao) {
        setId(id);
        setProposta(proposta);
        setResposta(resposta);
        setAndamentoOferta(andamentoOferta);
        setVaga(vaga);
        setCurso(curso);
        setEmpresa(empresa);
        setInstituicao(instituicao);
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

    public Oferta getAndamentoOferta() {
        return andamentoOferta;
    }

    public void setAndamentoOferta(Oferta andamentoOferta) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta1 = (Proposta) o;
        return id == proposta1.id &&
                Objects.equals(proposta, proposta1.proposta) &&
                Objects.equals(resposta, proposta1.resposta) &&
                andamentoOferta == proposta1.andamentoOferta &&
                Objects.equals(vaga, proposta1.vaga) &&
                Objects.equals(curso, proposta1.curso) &&
                Objects.equals(empresa, proposta1.empresa) &&
                Objects.equals(instituicao, proposta1.instituicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proposta, resposta, andamentoOferta, vaga, curso, empresa, instituicao);
    }
}