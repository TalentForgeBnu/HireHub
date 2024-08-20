package br.senac.talentforge.hirehub.modelo.entidade.professor;

import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private long id;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;
    private Turma turma;

    @Column(name = "materia", length = 30, nullable = false, unique = false)
    private String materia;

    //Adicionar Lista de Dosie;

    public Professor() {
    }

    public Professor(long id, List<Turma> turmas, String materia) {
        setId(id);
        setTurmas(turmas);
        setMateria(materia);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
