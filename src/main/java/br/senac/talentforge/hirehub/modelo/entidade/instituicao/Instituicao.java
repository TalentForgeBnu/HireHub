package br.senac.talentforge.hirehub.modelo.entidade.instituicao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica.PessoaJuridica;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;

@Entity
@Table(name = "instituicao")
public class Instituicao extends PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos = new ArrayList<Curso>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Professor> professores = new ArrayList<Professor>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos = new ArrayList<Aluno>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proposta> ofertas = new ArrayList<Proposta>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas = new ArrayList<Turma>();

    public Instituicao() {
    }

    public Instituicao(String senha, Endereco endereco, Papel papel, String telefone, String email, String cnpj, String nomeEmpresa, LocalDate dataFundacao, String descricao) {
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
        setTelefone(telefone);
        setEmail(email);
        setCnpj(cnpj);
        setNomeEmpresa(nomeEmpresa);
        setDataFundacao(dataFundacao);
        setDescricao(descricao);
    }

    public Instituicao(long id, String senha, Endereco endereco, Papel papel, String telefone, String email, String cnpj, String nomeEmpresa, LocalDate dataFundacao, String descricao) {
        setId(id);
        setSenha(senha);
        setEndereco(endereco);
        setPapel(papel);
        setTelefone(telefone);
        setEmail(email);
        setCnpj(cnpj);
        setNomeEmpresa(nomeEmpresa);
        setDataFundacao(dataFundacao);
        setDescricao(descricao);
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
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

    public List<Proposta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Proposta> ofertas) {
        this.ofertas = ofertas;
    }

    public void adicionarOfertas(Proposta oferta) {
        this.ofertas.add(oferta);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void adicionarTurmas(Turma turma) {
        this.turmas.add(turma);
    }

}