package br.senac.talentforge.hirehub.modelo.entidade.curso;

import java.io.Serializable;
import java.time.LocalDate;
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

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 5425389670106431381L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;

    @Column(name = "nome_curso", length = 50, nullable = false, unique = true)
    private String nomeCurso;

    @Column(name = "area_atuacao", length = 50, nullable = false, unique = false)
    private String areaDeAtuacao;

    @Enumerated(EnumType.STRING)
    private Disponibilidade andamentoCurso;

    @Column(name = "data_inicio", nullable = false, unique = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false, unique = false)
    private LocalDate dataFim;

    @Column(name = "descricao", length = 300, nullable = true, unique = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    public Curso() {
    }

    public Curso(String nomeCurso, String areaDeAtuacao, Disponibilidade andamentoCurso, LocalDate dataInicio, LocalDate dataFim, String descricao) {
        setNomeCurso(nomeCurso);
        setAreaDeAtuacao(areaDeAtuacao);
        setAndamentoCurso(andamentoCurso);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setDescricao(descricao);
    }

    public Curso(long id, String nomeCurso, String areaDeAtuacao, Disponibilidade andamentoCurso, LocalDate dataInicio, LocalDate dataFim, String descricao) {
        setId(id);
        setNomeCurso(nomeCurso);
        setAreaDeAtuacao(areaDeAtuacao);
        setAndamentoCurso(andamentoCurso);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setDescricao(descricao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Disponibilidade getAndamentoCurso() {
        return andamentoCurso;
    }

    public void setAndamentoCurso(Disponibilidade andamentoCurso) {
        this.andamentoCurso = andamentoCurso;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) &&
                Objects.equals(nomeCurso, curso.nomeCurso) &&
                Objects.equals(areaDeAtuacao, curso.areaDeAtuacao) &&
                andamentoCurso == curso.andamentoCurso &&
                Objects.equals(dataInicio, curso.dataInicio) &&
                Objects.equals(dataFim, curso.dataFim) &&
                Objects.equals(descricao, curso.descricao) &&
                Objects.equals(instituicao, curso.instituicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCurso, areaDeAtuacao, andamentoCurso, dataInicio, dataFim, descricao, instituicao);
    }
}