package br.senac.talentforge.hirehub.modelo.dao.curso;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CursoDAOImpl implements CursoDAO{

    private ConexaoFactory fabrica;

    public CursoDAOImpl() {
        fabrica = new ConexaoFactory();
    }
    
    public void inserirCurso(Curso curso) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(curso);
            sessao.getTransaction().commit();
        } catch (Exception sqlException) {
            erroSessao(sessao, sqlException);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarCurso(Curso curso) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(curso);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarCurso(Curso curso) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(curso);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public List<Curso> recuperarCursoPeloIdDaInstituicao(long idInstituicao){
        Session sessao = null;
        List<Curso> cursosRecuperados = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
            Root<Curso> raizCurso = criteria.from(Curso.class);
            criteria.where(construtor.equal(raizCurso.get(Curso_.instituicao), idInstituicao));
            cursosRecuperados = sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return cursosRecuperados;
    }

    public List<Curso> recuperarCursosPorAtuacao(String areaDeAtuacao){
        Session sessao = null;
        List<Curso> cursosRecuperados = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
            Root<Curso> raizCurso = criteria.from(Curso.class);
            criteria.where(construtor.equal(raizCurso.get(Curso_.AREA_DE_ATUACAO), areaDeAtuacao));
            cursosRecuperados= sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return cursosRecuperados;
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