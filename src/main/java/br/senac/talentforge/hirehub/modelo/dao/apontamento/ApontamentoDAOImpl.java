package br.senac.talentforge.hirehub.modelo.dao.apontamento;
 
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
 
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
            if (transacao != null) {
                transacao.rollback();
            }
            exception.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
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
            if (transacao != null) {
                transacao.rollback();
            }
            exception.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
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
            if (transacao != null) {
                transacao.rollback();
            }
            exception.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
 
    
    public List<Apontamento> recuperarApontamentos() {
        Session sessao = null;
        List<Apontamento> apontamentos = null;
        try {
            sessao = fabrica.getConexao().openSession();
 
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Apontamento> criteria = construtor.createQuery(Apontamento.class);
            Root<Apontamento> raizApontamento = criteria.from(Apontamento.class);
            criteria.select(raizApontamento);
 
            apontamentos = sessao.createQuery(criteria).getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return apontamentos;
    }
}