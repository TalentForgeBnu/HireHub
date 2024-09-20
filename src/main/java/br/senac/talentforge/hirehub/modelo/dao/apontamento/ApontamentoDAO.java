package br.senac.talentforge.hirehub.modelo.dao.apontamento;

import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;

public interface ApontamentoDAO {
    void inserirApontamento(Apontamento apontamento);
 
    void deletarApontamento(Apontamento apontamento);
 
    void atualizarApontamento(Apontamento apontamento);

    Apontamento recuperarApontamentoPeloIdDossie(long idDossie);
}