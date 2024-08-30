package br.senac.talentforge.hirehub.modelo.dao.pessoafisica;

import org.hibernate.Session;

import br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica.PessoaFisica;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;

public class PessoaFisicaDAOImpl implements PessoaFisicaDAO {
	
	private ConexaoFactory fabrica;
	
	public PessoaFisicaDAOImpl() {
        fabrica = new ConexaoFactory();
    }
	
	public void inserirPessoaFisica(PessoaFisica pessoafisica) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(pessoafisica);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }
	
	public void deletarPessoaFisica(PessoaFisica pessoafisica) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(pessoafisica);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }
	
	public void atualizarPessoaFisica(PessoaFisica pessoafisica) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(pessoafisica);
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
