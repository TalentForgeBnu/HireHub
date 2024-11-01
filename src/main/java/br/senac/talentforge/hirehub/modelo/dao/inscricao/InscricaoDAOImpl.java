package br.senac.talentforge.hirehub.modelo.dao.inscricao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.senac.talentforge.hirehub.modelo.entidade.inscricao.Inscricao;
import br.senac.talentforge.hirehub.modelo.entidade.inscricao.Inscricao_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

public class InscricaoDAOImpl implements InscricaoDAO{

    private ConexaoFactory fabrica;

    public InscricaoDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirInscricao(Inscricao inscricao) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(inscricao);
            sessao.getTransaction().commit();
        } catch (Exception sqlException) {
            erroSessao(sessao, sqlException);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarInscricao(Inscricao inscricao) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(inscricao);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarInscricao(Inscricao inscricao) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(inscricao);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public Inscricao recuperarInscricaoPeloId(long idInscricao) {
        Session sessao = null;
        Inscricao inscricaoRecuperada = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Inscricao> criteria = construtor.createQuery(Inscricao.class);
            Root<Inscricao> raizInscricao = criteria.from(Inscricao.class);
            criteria.select(raizInscricao).where(construtor.equal(raizInscricao.get(Inscricao_.ID), idInscricao));
            inscricaoRecuperada = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return inscricaoRecuperada;
    }

    public List<Inscricao> recuperarInscricaoPeloIdCurso(long idCurso) {
        Session sessao = null;
        List<Inscricao> inscricoesRecuperadas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Inscricao> criteria = construtor.createQuery(Inscricao.class);
            Root<Inscricao> raizInscricao = criteria.from(Inscricao.class);
            criteria.select(raizInscricao).where(construtor.equal(raizInscricao.get(Inscricao_.CURSO), idCurso));
            inscricoesRecuperadas = sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return inscricoesRecuperadas;
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