package br.senac.talentforge.hirehub.modelo.dao.proposta;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;
import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta_;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;

public class PropostaDAOImpl implements PropostaDAO {

    private ConexaoFactory fabrica;

    public PropostaDAOImpl() {
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

    public Proposta recuperarPropostaPeloIdCurso(long idCurso) {
        Session sessao = null;
        Proposta oferta = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Proposta> criteria = construtor.createQuery(Proposta.class);
            Root<Proposta> raizOferta = criteria.from(Proposta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Proposta_.CURSO), idCurso));
            oferta = sessao.createQuery(criteria).getSingleResult();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return oferta;
    }

    public List<Proposta> recuperarPropostasPeloIdEmpresa(long idEmpresa) {
        Session sessao = null;
        List<Proposta> ofertas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Proposta> criteria = construtor.createQuery(Proposta.class);
            Root<Proposta> raizOferta = criteria.from(Proposta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Proposta_.EMPRESA), idEmpresa));
            ofertas = sessao.createQuery(criteria).getResultList();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return ofertas;
    }

    public List<Proposta> recuperarPropostasPelosIdInstituicao(long idInstituicao) {
        Session sessao = null;
        List<Proposta> ofertas = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Proposta> criteria = construtor.createQuery(Proposta.class);
            Root<Proposta> raizOferta = criteria.from(Proposta.class);
            criteria.select(raizOferta).where(construtor.equal(raizOferta.get(Proposta_.INSTITUICAO), idInstituicao));
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
