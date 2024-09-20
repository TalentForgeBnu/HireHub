package br.senac.talentforge.hirehub.modelo.entidade.professor;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica.PessoaFisica;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor extends PessoaFisica implements Serializable {

    private static final long serialVersionUID = 8321801558181373534L;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas;

    @ManyToOne
    @JoinColumn(name = "id_instituicao", nullable = true)
    private Instituicao instituicao;

    @Column(name = "materia", length = 30, nullable = false, unique = false)
    private String materia;

    public Professor() {
        turmas = new ArrayList<>();
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

}