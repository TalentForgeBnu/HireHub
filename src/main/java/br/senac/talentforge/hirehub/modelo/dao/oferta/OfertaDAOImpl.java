package br.senac.talentforge.hirehub.modelo.dao.oferta;

import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Oferta_;
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

    public void inserirOferta(Proposta oferta) {
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

    public void deletarOferta(Proposta oferta) {
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

    public void atualizarOferta(Proposta oferta) {
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

    public Proposta recuperarOfertaPeloIdCurso(long idCurso) {
        Session sessao = null;
        Proposta oferta = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Proposta> criteria = construtor.createQuery(Proposta.class);
            Root<Proposta> raizOferta = criteria.from(Proposta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Oferta_.CURSO), idCurso));
            oferta = sessao.createQuery(criteria).getSingleResult();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return oferta;
    }

    public List<Proposta> recuperarOfertasPelosIdEmpresa(long idEmpresa) {
        Session sessao = null;
        List<Proposta> ofertas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Proposta> criteria = construtor.createQuery(Proposta.class);
            Root<Proposta> raizOferta = criteria.from(Proposta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Oferta_.EMPRESA), idEmpresa));
            ofertas = sessao.createQuery(criteria).getResultList();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return ofertas;
    }

    public List<Proposta> recuperarOfertaSPelosIdInstituicao(long idInstituicao) {
        Session sessao = null;
        List<Proposta> ofertas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Proposta> criteria = construtor.createQuery(Proposta.class);
            Root<Proposta> raizOferta = criteria.from(Proposta.class);
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
