package br.senac.talentforge.hirehub.modelo.dao.vaga;

import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga_;
import br.senac.talentforge.hirehub.modelo.enumeracao.modalidadecontratacao.ModalidadeContratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacaovaga.SituacaoVaga;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VagaDAOImpl implements VagaDAO {

    private ConexaoFactory fabrica;

    public VagaDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirVaga(Vaga vaga) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(vaga);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarVaga(Vaga vaga) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(vaga);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarVaga(Vaga vaga) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(vaga);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public Vaga recuperarVagaPeloIdEmpresa(long codigo) {
        Session sessao = null;
        Vaga vagaRecuperada = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Vaga> criteria = construtor.createQuery(Vaga.class);
            Root<Vaga> raizVaga = criteria.from(Vaga.class);
            criteria.select(raizVaga).where(construtor.equal(raizVaga.get(Vaga_.EMPRESA), codigo));
            vagaRecuperada = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return vagaRecuperada;
    }

    public Vaga recuperarVagaPelaModalidade(ModalidadeContratacao modalidadeContratacao) {
        Session sessao = null;
        Vaga vagaRecuperada = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Vaga> criteria = construtor.createQuery(Vaga.class);
            Root<Vaga> raizVaga = criteria.from(Vaga.class);
            criteria.select(raizVaga).where(construtor.equal(raizVaga.get(Vaga_.MODALIDADE_CONTRATACAO), modalidadeContratacao));
            vagaRecuperada = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return vagaRecuperada;
    }

    public Vaga recuperarVagaPelaSituacaoVaga(SituacaoVaga situacaoVaga) {
        Session sessao = null;
        Vaga vagaRecuperada = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Vaga> criteria = construtor.createQuery(Vaga.class);
            Root<Vaga> raizVaga = criteria.from(Vaga.class);
            criteria.select(raizVaga).where(construtor.equal(raizVaga.get(Vaga_.SITUACAO_VAGA), situacaoVaga));
            vagaRecuperada = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return vagaRecuperada;
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
