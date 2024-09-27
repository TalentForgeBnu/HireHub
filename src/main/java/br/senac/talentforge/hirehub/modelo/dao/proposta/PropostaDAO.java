package br.senac.talentforge.hirehub.modelo.dao.proposta;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;

public interface PropostaDAO {
    void inserirOferta(Proposta oferta);

    void deletarOferta(Proposta oferta);

    void atualizarOferta(Proposta oferta);

    Proposta recuperarPropostaPeloIdCurso(long idCurso);

    List<Proposta> recuperarPropostasPelosIdEmpresa(long idEmpresa);

    List<Proposta> recuperarPropostasPelosIdInstituicao(long idInstituicao);
}