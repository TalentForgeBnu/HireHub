package br.senac.talentforge.hirehub.modelo.dao.oferta;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;

public interface OfertaDAO {
    void inserirOferta(Proposta oferta);

    void deletarOferta(Proposta oferta);

    void atualizarOferta(Proposta oferta);

    Proposta recuperarOfertaPeloIdCurso(long idCurso);

    List<Proposta> recuperarOfertasPelosIdEmpresa(long idEmpresa);

    List<Proposta> recuperarOfertaSPelosIdInstituicao(long idInstituicao);
}