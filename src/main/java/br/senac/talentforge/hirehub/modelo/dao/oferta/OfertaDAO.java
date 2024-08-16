package br.senac.talentforge.hirehub.modelo.dao.oferta;

import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;

public interface OfertaDAO {
    void inserirOferta(Oferta oferta);

    void deletarOferta(Oferta oferta);

    void atualizarOferta(Oferta oferta);
}