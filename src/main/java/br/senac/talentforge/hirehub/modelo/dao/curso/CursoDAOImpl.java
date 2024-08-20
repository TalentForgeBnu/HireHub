package br.senac.talentforge.hirehub.modelo.dao.curso;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

public class CursoDAOImpl implements CursoDAO{

    private ConexaoFactory fabrica;

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