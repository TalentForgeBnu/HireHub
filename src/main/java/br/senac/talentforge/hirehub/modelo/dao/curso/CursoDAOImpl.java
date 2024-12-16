package br.senac.talentforge.hirehub.modelo.dao.curso;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso_;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma_;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario_;
import br.senac.talentforge.hirehub.modelo.enumeracao.disponibilidade.Disponibilidade;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;

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

    public Curso recuperarCursoPeloId(long idCurso){
        Session sessao = null;
        Curso cursoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
            Root<Curso> raizCurso = criteria.from(Curso.class);
            criteria.where(construtor.equal(raizCurso.get(Curso_.ID), idCurso));
            cursoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return cursoRecuperado;
    }
    
    public Curso recuperarCursoPeloIdTurma(long idTurma){
        Session sessao = null;
        Curso cursoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
            Root<Turma> raizTurma = criteria.from(Turma.class);
            Join<Turma, Curso> joinCursoTurma = raizTurma.join(Turma_.CURSO);
            criteria.select(joinCursoTurma).where(construtor.equal(raizTurma.get(Turma_.CURSO), idTurma));
            cursoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return cursoRecuperado;
    }
    

    public List<Curso> recuperarCursosPeloIdDaInstituicao(long idInstituicao){
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
            criteria.where(construtor.equal(raizCurso.get(Curso_.AREA_ATUACAO), areaDeAtuacao));
            cursosRecuperados= sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return cursosRecuperados;
    }

    public List<Curso> recuperarCursoPelaDisponibilidade(Disponibilidade disponibilidade) {
        Session sessao = null;
        List<Curso> cursosRecuperados = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
            Root<Curso> raizCurso = criteria.from(Curso.class);
            criteria.where(construtor.equal(raizCurso.get(Curso_.DISPONIBILIDADE), disponibilidade));
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