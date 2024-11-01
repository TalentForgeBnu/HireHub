package br.senac.talentforge.hirehub.modelo.dao.instituicao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;

public class InstituicaoDAOImpl implements InstituicaoDAO {

    private ConexaoFactory fabrica;

    public InstituicaoDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public Instituicao recuperarInstituicaoPeloCnpj(String cnpj) {
        Session sessao = null;
        Instituicao instituicaoRecuperada = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Instituicao> criteria = construtor.createQuery(Instituicao.class);
            Root<Instituicao> raizIntituicao = criteria.from(Instituicao.class);
            criteria.select(raizIntituicao).where(construtor.equal(raizIntituicao.get(Instituicao_.CNPJ), cnpj));
            instituicaoRecuperada = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return instituicaoRecuperada;
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
