package br.senac.talentforge.hirehub.modelo.entidade.curso;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
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
    private String nome;

    @Column(name = "area_atuacao", length = 50, nullable = false, unique = false)
    private String areaAtuacao;

    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    @Column(name = "data_inicio", nullable = false, unique = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false, unique = false)
    private LocalDate dataFim;

    @Column(name = "descricao", length = 300, nullable = true, unique = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas = new ArrayList<Turma>();
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proposta")
    private Proposta proposta;
    
    public Curso() {}

    public Curso(String nome, String areaAtuacao, Disponibilidade disponibilidade, LocalDate dataInicio, LocalDate dataFim, String descricao, Proposta proposta) {
        setNome(nome);
        setAreaAtuacao(areaAtuacao);
        setDisponibilidade(disponibilidade);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setDescricao(descricao);
        setProposta(proposta);
    }

    public Curso(long id, String nome, String areaAtuacao, Disponibilidade disponibilidade, LocalDate dataInicio, LocalDate dataFim, String descricao, Proposta proposta) {
        setId(id);
        setNome(nome);
        setAreaAtuacao(areaAtuacao);
        setDisponibilidade(disponibilidade);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setDescricao(descricao);
        setProposta(proposta);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
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
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public Proposta getProposta() {
    	return proposta;
    }
    
    public void setProposta(Proposta proposta) {
    	this.proposta = proposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) &&
                Objects.equals(nome, curso.nome) &&
                Objects.equals(areaAtuacao, curso.areaAtuacao) &&
                disponibilidade == curso.disponibilidade &&
                Objects.equals(dataInicio, curso.dataInicio) &&
                Objects.equals(dataFim, curso.dataFim) &&
                Objects.equals(descricao, curso.descricao) &&
                Objects.equals(instituicao, curso.instituicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, areaAtuacao, disponibilidade, dataInicio, dataFim, descricao, instituicao);
    }
}