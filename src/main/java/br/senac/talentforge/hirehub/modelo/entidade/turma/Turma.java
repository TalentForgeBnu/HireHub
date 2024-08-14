package br.senac.talentforge.hirehub.modelo.entidade.turma;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long id;

    @Column(name = "nome_turma", length = 50, nullable = false)
    private String nomeTurma;

    @Column(name = "codigo_turma", length = 50, nullable = false)
    private String codigoTurma;

    @Column(name = "tamanho_turma")
    private byte tamanhoTurma;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private List<Aluno> alunos;

    @Column(name = "dossie_turma", length = 300, nullable = true)
    private String dossieTurma;

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public byte getTamanhoTurma() {
        return tamanhoTurma;
    }

    public void setTamanhoTurma(byte tamanhoTurma) {
        this.tamanhoTurma = tamanhoTurma;
    }

    public String getDossieTurma() {
        return dossieTurma;
    }

    public void setDossieTurma(String dossieTurma) {
        this.dossieTurma = dossieTurma;
    }
}