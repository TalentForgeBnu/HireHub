package br.senac.talentforge.hirehub.modelo.dao.oferta;

import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;

import java.util.List;

public interface OfertaDAO {

    void inserirOferta(Oferta oferta);

    void deletarOferta(Oferta oferta);

    void atualizarOferta(Oferta oferta);

    Oferta recuperarOfertaPeloIdCurso(long idCurso);

    List<Oferta> recuperarOfertaSPelosIdEmpresa(long idEmpresa);

    List<Oferta> recuperarOfertaSPelosIdInstituicao(long idInstituicao);

}