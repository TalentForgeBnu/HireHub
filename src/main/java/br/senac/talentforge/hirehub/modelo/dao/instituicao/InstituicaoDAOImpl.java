package br.senac.talentforge.hirehub.modelo.dao.instituicao;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

public class InstituicaoDAOImpl implements InstituicaoDAO{

    private ConexaoFactory fabrica;

    public void inserirInstituicao(Instituicao instituicao) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(instituicao);
            sessao.getTransaction().commit();
        } catch (Exception sqlException) {
            erroSessao(sessao, sqlException);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarInstituicao(Instituicao instituicao) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(instituicao);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarInstituicao(Instituicao instituicao) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(instituicao);
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
