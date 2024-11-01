package br.senac.talentforge.hirehub.modelo.dao.professor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

public class ProfessorDAOImpl implements ProfessorDAO {

    private ConexaoFactory fabrica;

    public ProfessorDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public Professor recuperarProfessorPeloId(long idProfessor) {

        Session sessao = null;
        Professor professorRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Professor> criteria = construtor.createQuery(Professor.class);
            Root<Professor> raizProfessor = criteria.from(Professor.class);
            criteria.select(raizProfessor).where(construtor.equal(raizProfessor.get(Professor_.ID), idProfessor));
            professorRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return professorRecuperado;
    }

    public Professor recuperarProfessorPeloCpf(String cpf) {

        Session sessao = null;
        Professor professorRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Professor> criteria = construtor.createQuery(Professor.class);
            Root<Professor> raizProfessor = criteria.from(Professor.class);
            criteria.select(raizProfessor).where(construtor.equal(raizProfessor.get(Professor_.CPF), cpf));
            professorRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return professorRecuperado;
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