package br.senac.talentforge.hirehub.modelo.dao.endereco;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno_;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class EnderecoDAOImpl implements EnderecoDAO {

    private ConexaoFactory fabrica;

    public EnderecoDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirEndereco(Endereco endereco) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(endereco);
            sessao.getTransaction().commit();
        } catch (Exception sqlException) {
            erroSessao(sessao, sqlException);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarEndereco(Endereco endereco) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(endereco);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarEndereco(Endereco endereco) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(endereco);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    private Endereco recuperarEnderecoDoAluno(Aluno aluno) {
        ConexaoFactory fabrica = new ConexaoFactory();
        Session sessao = null;
        Endereco enderecoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
            Root<Aluno> raizAluno = criteria.from(Aluno.class);
            Join<Aluno, Endereco> joinEndereco = raizAluno.join(Aluno_.endereco);
            criteria.select(joinEndereco).where(construtor.equal(raizAluno.get(Aluno_.CPF), aluno.getCpf()));
            enderecoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return enderecoRecuperado;
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