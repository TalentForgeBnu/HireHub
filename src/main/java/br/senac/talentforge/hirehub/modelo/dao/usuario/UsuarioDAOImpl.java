package br.senac.talentforge.hirehub.modelo.dao.usuario;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;
import org.hibernate.Session;

public class UsuarioDAOImpl implements UsuarioDAO{

    private ConexaoFactory fabrica;

    public UsuarioDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirUsuario(Usuario usuario) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(usuario);
            sessao.getTransaction().commit();
        } catch (Exception sqlException) {
            erroSessao(sessao, sqlException);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void deletarUsuario(Usuario usuario) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(usuario);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(usuario);
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