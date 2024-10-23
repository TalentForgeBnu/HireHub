package br.senac.talentforge.hirehub.modelo.dao.vaga;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga_;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;

public class VagaDAOImpl implements VagaDAO {

	private ConexaoFactory fabrica;

	public VagaDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirVaga(Vaga vaga) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.save(vaga);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarVaga(Vaga vaga) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.delete(vaga);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarVaga(Vaga vaga) {
		Session sessao = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			sessao.update(vaga);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Vaga recuperarVagaPeloIdEmpresa(long codigo) {
		Session sessao = null;
		Vaga vagaRecuperada = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Vaga> criteria = construtor.createQuery(Vaga.class);
			Root<Vaga> raizVaga = criteria.from(Vaga.class);
			criteria.select(raizVaga).where(construtor.equal(raizVaga.get(Vaga_.EMPRESA), codigo));
			vagaRecuperada = sessao.createQuery(criteria).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return vagaRecuperada;
	}

	public Vaga recuperarVagaPelaModalidade(Contratacao modalidadeContratacao) {
		Session sessao = null;
		Vaga vagaRecuperada = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Vaga> criteria = construtor.createQuery(Vaga.class);
			Root<Vaga> raizVaga = criteria.from(Vaga.class);
			criteria.select(raizVaga).where(construtor.equal(raizVaga.get(Vaga_.contratacao), modalidadeContratacao));
			vagaRecuperada = sessao.createQuery(criteria).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return vagaRecuperada;
	}

	public Vaga recuperarVagaPelaSituacaoVaga(Situacao situacaoVaga) {
		Session sessao = null;
		Vaga vagaRecuperada = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Vaga> criteria = construtor.createQuery(Vaga.class);
			Root<Vaga> raizVaga = criteria.from(Vaga.class);
			criteria.select(raizVaga).where(construtor.equal(raizVaga.get(Vaga_.SITUACAO), situacaoVaga));
			vagaRecuperada = sessao.createQuery(criteria).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return vagaRecuperada;
	}

	public List<Vaga> recuperarVagasPeloIdDaEmpresa(long idEmpresa) {
		Session sessao = null;
		List<Vaga> vagasRecuperadas = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Vaga> criteria = construtor.createQuery(Vaga.class);
			Root<Vaga> raizVaga = criteria.from(Vaga.class);
			criteria.where(construtor.equal(raizVaga.get(Vaga_.EMPRESA), idEmpresa));
			vagasRecuperadas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return vagasRecuperadas;
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
