package br.senac.talentforge.hirehub.modelo.dao.Turma;

import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TurmaDAOImpl implements TurmaDAO {

    private ConexaoFactory fabrica;

    public TurmaDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirTurma(Turma turma) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(turma);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarTurma(Turma turma) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(turma);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarTurma(Turma turma) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(turma);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public Turma recuperarTurmaPeloIdIntituicao(long idInstituicao) {
        Session sessao = null;
        Turma turmaRecuperada = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
            Root<Turma> raizTurma = criteria.from(Turma.class);
            criteria.select(raizTurma).where(construtor.equal(raizTurma.get(Turma_.INSTITUICAO), idInstituicao));
            turmaRecuperada = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return turmaRecuperada;
    }

    public List<Turma> recuperarTurmasPeloIdCurso(long idCurso) {
        Session sessao = null;
        List<Turma> turmaRecuperadas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
            Root<Turma> raizTurma = criteria.from(Turma.class);
            criteria.select(raizTurma).where(construtor.equal(raizTurma.get(Turma_.CURSO), idCurso));
            turmaRecuperadas = sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return turmaRecuperadas;
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