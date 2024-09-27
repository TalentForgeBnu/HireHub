package br.senac.talentforge.hirehub.modelo.entidade.turma;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.enumeracao.turno.Turno;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

    private static final long serialVersionUID = 387637421011881759L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private long id;

    @Column(name = "nome_turma", length = 30, nullable = false, unique = false)
    private String nome;

    @Column(name = "horario")
    private LocalTime horario;

    @Column(name = "codigo", length = 50, nullable = false, unique = false)
    private String codigo;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos = new ArrayList<Aluno>();

    @Column(name = "tamanho_turma")
    private byte tamanho;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_instituicao", nullable = false)
    private Instituicao instituicao;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public Turma() {
    }

    public Turma(String nome, LocalTime horario, String codigo, byte tamanho, Professor professor, Instituicao instituicao, Turno turno, Curso curso) {
        setNome(nome);
        setHorario(horario);
        setCodigo(codigo);
        setTamanho(tamanho);
        setProfessor(professor);
        setInstituicao(instituicao);
        setTurno(turno);
        setCurso(curso);
    }

    public Turma(long id, String nome, LocalTime horario, String codigo, byte tamanho, Professor professor, Instituicao instituicao, Turno turno, Curso curso) {
        setId(id);
        setNome(nome);
        setHorario(horario);
        setCodigo(codigo);
        setTamanho(tamanho);
        setProfessor(professor);
        setInstituicao(instituicao);
        setTurno(turno);
        setCurso(curso);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public byte getTamanho() {
        return tamanho;
    }

    public void setTamanho(byte tamanho) {
        this.tamanho = tamanho;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return id == turma.id &&
                tamanho == turma.tamanho &&
                Objects.equals(nome, turma.nome) &&
                Objects.equals(horario, turma.horario) &&
                Objects.equals(codigo, turma.codigo) &&
                Objects.equals(alunos, turma.alunos) &&
                Objects.equals(professor, turma.professor) &&
                Objects.equals(instituicao, turma.instituicao) &&
                turno == turma.turno && Objects.equals(curso, turma.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, horario, codigo, alunos, tamanho, professor, instituicao, turno, curso);
    }
}