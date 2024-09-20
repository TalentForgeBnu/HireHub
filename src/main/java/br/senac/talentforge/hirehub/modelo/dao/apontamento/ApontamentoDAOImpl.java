package br.senac.talentforge.hirehub.modelo.dao.apontamento;

import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class ApontamentoDAOImpl implements ApontamentoDAO {

    private final ConexaoFactory fabrica;

    public ApontamentoDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirApontamento(Apontamento apontamento) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            transacao = sessao.beginTransaction();

            sessao.save(apontamento);
            transacao.commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }


    public void deletarApontamento(Apontamento apontamento) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            transacao = sessao.beginTransaction();

            sessao.delete(apontamento);
            transacao.commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }


    public void atualizarApontamento(Apontamento apontamento) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            transacao = sessao.beginTransaction();

            sessao.update(apontamento);
            transacao.commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public Apontamento recuperarApontamentoPeloIdDossie(long idDossie) {
        Session sessao = null;
        Apontamento apontamentoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Apontamento> criteria = construtor.createQuery(Apontamento.class);
            Root<Dossie> raizDossie = criteria.from(Dossie.class);
            Join<Dossie, Apontamento> joinApontamento = raizDossie.join(Dossie_.ID);
            criteria.select(joinApontamento).where(construtor.equal(raizDossie.get(Dossie_.ID), idDossie));
            apontamentoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return apontamentoRecuperado;
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