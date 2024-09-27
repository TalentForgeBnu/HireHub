package br.senac.talentforge.hirehub.modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

public class AlunoDAOImpl implements AlunoDAO {

    private final ConexaoFactory fabrica;

    public AlunoDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public Aluno recuperarAlunoPeloCpf(String cpf) {
        Session sessao = null;
        Aluno alunoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
            Root<Aluno> raizAluno = criteria.from(Aluno.class);
            criteria.select(raizAluno).where(construtor.equal(raizAluno.get(Aluno_.CPF), cpf));
            alunoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return alunoRecuperado;
    }

    public List<Aluno> recuperarAlunosPeloIdTurma(long idTurma) {
        Session sessao = null;
        List<Aluno> alunosRecuperados = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
            Root<Aluno> raizAluno = criteria.from(Aluno.class);
            criteria.select(raizAluno).where(construtor.equal(raizAluno.get(Aluno_.TURMA), idTurma));
            alunosRecuperados = sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return alunosRecuperados;
    }

    private void erroSessao(Session sessao, Exception exception) {
        exception.printStackTrace();
        if (sessao.getTransaction() != null) {
            sessao.getTransaction().rollback();
        }
    }

    private void fecharSessao(Session sessao) {
        if (sessao != null) {
            sessao.close();
        }
    }

}