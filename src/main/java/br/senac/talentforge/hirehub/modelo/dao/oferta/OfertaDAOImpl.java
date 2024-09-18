package br.senac.talentforge.hirehub.modelo.dao.oferta;

import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;
import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta_;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OfertaDAOImpl implements OfertaDAO {

    private ConexaoFactory fabrica;

    public OfertaDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirOferta(Oferta oferta) {
        Session sessao = null;
        Vaga vaga = oferta.getVaga();
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            if (vaga != null) {
                sessao.save(vaga);
            }
            sessao.save(oferta);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarOferta(Oferta oferta) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(oferta);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarOferta(Oferta oferta) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(oferta);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public Oferta recuperarOfertaPeloIdCurso(long idCurso) {
        Session sessao = null;
        Oferta oferta = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Oferta> criteria = construtor.createQuery(Oferta.class);
            Root<Oferta> raizOferta = criteria.from(Oferta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Oferta_.CURSO), idCurso));
            oferta = sessao.createQuery(criteria).getSingleResult();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return oferta;
    }

    public List<Oferta> recuperarOfertaSPelosIdEmpresa(long idEmpresa) {
        Session sessao = null;
        List<Oferta> ofertas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Oferta> criteria = construtor.createQuery(Oferta.class);
            Root<Oferta> raizOferta = criteria.from(Oferta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Oferta_.EMPRESA), idEmpresa));
            ofertas = sessao.createQuery(criteria).getResultList();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return ofertas;
    }

    public List<Oferta> recuperarOfertaSPelosIdInstituicao(long idInstituicao) {
        Session sessao = null;
        List<Oferta> ofertas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Oferta> criteria = construtor.createQuery(Oferta.class);
            Root<Oferta> raizOferta = criteria.from(Oferta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Oferta_.INSTITUICAO), idInstituicao));
            ofertas = sessao.createQuery(criteria).getResultList();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return ofertas;
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
