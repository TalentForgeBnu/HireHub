package br.senac.talentforge.hirehub.modelo.entidade.instituicao;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica.PessoaJuridica;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instituicao")
public class Instituicao extends PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Professor> professores;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oferta> ofertas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas;

    public Instituicao() {
        cursos = new ArrayList<>();
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
        ofertas = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Turma> getTurma() {
        return turmas;
    }

    public void setTurma(List<Turma> turma) {
        turmas = turma;
    }

    public void addTurma(Turma turma){
        turmas.add(turma);
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public void addOferta(Oferta oferta){
        this.ofertas.add(oferta);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public void addProfessores(Professor professor){
        this.professores.add(professor);
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setListaCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void addCurso(Curso curso){
        this.cursos.add(curso);
    }

}