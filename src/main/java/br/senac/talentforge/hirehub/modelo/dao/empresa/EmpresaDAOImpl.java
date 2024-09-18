package br.senac.talentforge.hirehub.modelo.dao.empresa;

import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;
import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EmpresaDAOImpl implements EmpresaDAO {

    private ConexaoFactory fabrica;

    public EmpresaDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public Empresa recuperarEmpresa(String cnpj) {
        Session sessao = null;
        Empresa empresaRecuperada = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Empresa> criteria = construtor.createQuery(Empresa.class);
            Root<Empresa> raizEmpresa = criteria.from(Empresa.class);
            criteria.select(raizEmpresa).where(construtor.equal(raizEmpresa.get(Empresa_.CNPJ), cnpj));
            empresaRecuperada = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return empresaRecuperada;
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