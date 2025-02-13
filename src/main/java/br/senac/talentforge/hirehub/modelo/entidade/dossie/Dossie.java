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

@Entity
@Table(name = "dossie")
public class Dossie implements Serializable {

    private static final long serialVersionUID = -4638951545394835839L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dossie")
    private long id;

    @Column(name = "conteudo_dossie", length = 200, nullable = false, unique = false)
    private String conteudo;

    @OneToMany(mappedBy = "dossie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apontamento> apontamentos = new ArrayList<Apontamento>();

    @OneToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    public Dossie() {
    }

    public Dossie(String conteudo, Aluno aluno) {
        setConteudo(conteudo);
        setAluno(aluno);
    }

    public Dossie(long id, String conteudo, Aluno aluno) {
        setId(id);
        setConteudo(conteudo);
        setAluno(aluno);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<Apontamento> getApontamentos() {
        return apontamentos;
    }

    public void setApontamentos(List<Apontamento> apontamentos) {
        this.apontamentos = apontamentos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}