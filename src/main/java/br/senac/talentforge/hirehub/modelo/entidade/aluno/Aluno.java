package br.senac.talentforge.hirehub.modelo.entidade.aluno;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica.PessoaFisica;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.alunomatriculado.AlunoMatriculado;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aluno")
public class Aluno extends PessoaFisica implements Serializable {

	private static final long serialVersionUID = 1L;

    @Column(name = "matricula", length = 30, nullable = false, unique = false)
    private String matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Column(name = "codigo_turma", length = 30, nullable = false, unique = false)
    private String codigoTurma;

    @Enumerated(EnumType.STRING)
    private AlunoMatriculado alunoMatriculado;

    public Aluno() {
    }

    public Aluno(long id, String matricula, Instituicao instituicao, Turma turma, String codigoTurma, AlunoMatriculado alunoMatriculado){
        setId(id);
        setMatricula(matricula);
        setInstituicao(instituicao);
        setTurma(turma);
        setCodigoTurma(codigoTurma);
        setAlunoMatriculado(alunoMatriculado);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public AlunoMatriculado getAlunoMatriculado() {
        return alunoMatriculado;
    }

    public void setAlunoMatriculado(AlunoMatriculado alunoMatriculado) {
        this.alunoMatriculado = alunoMatriculado;
    }

}