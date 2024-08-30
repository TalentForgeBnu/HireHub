package br.senac.talentforge.hirehub.modelo.dao.pessoajuridica;

import org.hibernate.Session;

import br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica.PessoaJuridica;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;

public class PessoaJuridicaDAOImpl implements PessoaJuridicaDAO {

	private ConexaoFactory fabrica;

	public PessoaJuridicaDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirPessoaJuridica(PessoaJuridica pessoajuridica) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.save(pessoajuridica);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarPessoaJuridica(PessoaJuridica pessoajuridica) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.delete(pessoajuridica);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarPessoaJuridica(PessoaJuridica pessoajuridica) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.update(pessoajuridica);
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
