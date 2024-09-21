package br.senac.talentforge.hirehub.modelo.entidade.dossie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;

@Entity
@Table(name="dossie")
public class Dossie implements Serializable {

    private static final long serialVersionUID = -4638951545394835839L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dossie")
    private long id;

    @Column(name="descricao", length = 200,nullable = false,unique = false)
    private String descricao;

    @OneToMany(mappedBy = "dossie", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Apontamento> apontamentos;

    @OneToOne
    @JoinColumn(name="id_turma",nullable = false)
    private Turma turma;

    @OneToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Aluno aluno;

    public Dossie() {
        apontamentos = new ArrayList<>();
    }

    public Dossie(long id, String descricao, Apontamento apontamento) {
        apontamentos = new ArrayList<Apontamento>();
        setDescricao(descricao);
        addApontamento(apontamento);
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Apontamento> getApontamento(){
        return apontamentos;
    }

    public void setApontamento(List<Apontamento> apontamentos) {
        this.apontamentos = apontamentos;
    }

    public void addApontamento(Apontamento apontamento){
        this.apontamentos.add(apontamento);
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}