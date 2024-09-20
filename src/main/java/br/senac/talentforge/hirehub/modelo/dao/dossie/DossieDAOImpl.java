package br.senac.talentforge.hirehub.modelo.dao.dossie;

import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DossieDAOImpl implements DossieDAO {

    private final ConexaoFactory fabrica;

    public DossieDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirDossie(Dossie dossie) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(dossie);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarDossie(Dossie dossie) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(dossie);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarDossie(Dossie dossie) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(dossie);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public Dossie recuperarDossiePeloIdDoUsuarioAluno(long idUsuario) {
        Session sessao = null;
        Dossie dossieRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Dossie> criteria = construtor.createQuery(Dossie.class);
            Root<Dossie> raizDossie = criteria.from(Dossie.class);
            criteria.select(raizDossie).where(construtor.equal(raizDossie.get(Dossie_.ALUNO), idUsuario));
            dossieRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return dossieRecuperado;
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
