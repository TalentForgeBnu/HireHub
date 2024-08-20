package br.senac.talentforge.hirehub.modelo.entidade.turma;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private long id;

    @Column(name = "nomeTurma", length = 30, nullable = false, unique = false)
    private String nomeTurma;

    @Column(name = "horario")
    private LocalDate horario;

    @Column(name = "codigo", length = 50, nullable = false, unique = false)
    private String codigo;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos;

    @Column(name = "tamanho")
    private byte tamanho;

    //Adicionar turno quando for criado.

    public Turma(){
    }

    public Turma(long id, String nomeTurma, LocalDate horario, String codigo, List<Aluno> alunos){
        setId(id);
        setNomeTurma(nomeTurma);
        setHorario(horario);
        setCodigo(codigo);
        setAlunos(alunos);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public byte getTamanho() {
        return tamanho;
    }

    public void setTamanho(byte tamanho) {
        this.tamanho = tamanho;
    }
}