package br.senac.talentforge.hirehub.modelo.dao.aluno;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno_;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

    private final ConexaoFactory fabrica;

    public AlunoDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirAluno(Aluno aluno) {
        Session sessao = null;
        Endereco endereco = aluno.getEndereco();
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            if (endereco != null) {
                sessao.save(endereco);
            }

            sessao.save(aluno);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarAluno(Aluno aluno) {
        Session sessao = null;
        Endereco endereco = aluno.getEndereco();
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            if (endereco != null) {
                sessao.delete(endereco);
            }

            sessao.delete(aluno);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarAluno(Aluno aluno) {
        Session sessao = null;
        Endereco endereco = aluno.getEndereco();
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            if (endereco != null) {
                sessao.update(endereco);
            }

            sessao.update(aluno);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public List<Aluno> recuperarAluno() {
        Session sessao = null;
        List<Aluno> alunos = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
            Root<Aluno> raizAluno = criteria.from(Aluno.class);

            raizAluno.fetch(Aluno_.endereco, JoinType.LEFT);

            alunos = sessao.createQuery(criteria).getResultList();

            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return alunos;
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