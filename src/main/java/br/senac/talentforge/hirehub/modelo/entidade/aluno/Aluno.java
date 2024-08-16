package br.senac.talentforge.hirehub.modelo.entidade.aluno;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.enumeracao.alunomatriculado.AlunoMatriculado;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

public class Aluno extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private long id;

    @Column(name = "matricula", length = 30, nullable = false, unique = false)
    private String matricula;

    @Column(name = "codigo_turma", length = 30, nullable = false, unique = false)
    private String codigoTurma;

    @Column(name = "dossie", length = 200, nullable = false, unique = false)
    private String dossie;

    @Enumerated(EnumType.STRING)
    private AlunoMatriculado status;

    public Aluno() {

    }

    public Aluno(String matricula, String codigoTurma, String dossie, AlunoMatriculado status, long idUsuario, String nomeUsuario, String sobrenome, LocalDate dataNascimento, String cpf, Genero genero, String nomeSocial, float rendaFamiliar) {

        super(idUsuario,nomeUsuario, sobrenome, dataNascimento, cpf, genero, nomeSocial, rendaFamiliar);
        setMatricula(matricula);
        setCodigoTurma(codigoTurma);
        setDossie(dossie);
        setStatusAluno(status);

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getDossie() {
        return dossie;
    }

    public void setDossie(String dossie) {
        this.dossie = dossie;
    }

    public AlunoMatriculado getStatus() {
        return status;
    }

    public void setStatusAluno(AlunoMatriculado status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
