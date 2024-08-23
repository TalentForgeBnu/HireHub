package br.senac.talentforge.hirehub.modelo.entidade.professor;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas;

    @ManyToOne
    @JoinColumn(name = "id_instituicao", nullable = false)
    private Instituicao instituicao;

    @Column(name = "materia", length = 30, nullable = false, unique = false)
    private String materia;

    //Adicionar Lista de Dosie;


    public Professor() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
