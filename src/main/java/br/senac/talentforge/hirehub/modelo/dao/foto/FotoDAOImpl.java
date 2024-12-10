package br.senac.talentforge.hirehub.modelo.dao.foto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.talentforge.hirehub.modelo.entidade.foto.Foto;
import br.senac.talentforge.hirehub.modelo.entidade.foto.Foto_;
import br.senac.talentforge.hirehub.modelo.factory.conexao.ConexaoFactory;

public class FotoDAOImpl implements FotoDAO {

    private ConexaoFactory fabrica;

    public FotoDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirFoto(Foto foto) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(foto);
            sessao.getTransaction().commit();
        } catch (Exception sqlException) {
            erroSessao(sessao, sqlException);
        } finally {
            fecharSessao(sessao);
        }
    }

	public void deletarFoto(Foto foto) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(foto);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }

    public void atualizarFoto(Foto foto) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(foto);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }
    
    public Foto recuperarFotoPeloIdDeUsuario(long idUsuario) {
        Session sessao = null;
        Foto fotoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
            Root<Foto> raizFoto = criteria.from(Foto.class);
            criteria.select(raizFoto).where(construtor.equal(raizFoto.get(Foto_.USUARIO), idUsuario));
            fotoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return fotoRecuperado;
    }
    
    public Foto recuperarFotoPeloIdDeCurso(long idCurso) {
        Session sessao = null;
        Foto fotoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
            Root<Foto> raizFoto = criteria.from(Foto.class);
            criteria.select(raizFoto).where(construtor.equal(raizFoto.get(Foto_.CURSO), idCurso));
            fotoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return fotoRecuperado;
    }
    
    public  Foto recuperarFotoPeloIdDeVaga(long idVaga) {
        Session sessao = null;
        Foto fotoRecuperado = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
            Root<Foto> raizFoto = criteria.from(Foto.class);
            criteria.select(raizFoto).where(construtor.equal(raizFoto.get(Foto_.VAGA), idVaga));
            fotoRecuperado = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
        return fotoRecuperado;
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