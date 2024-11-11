package br.senac.talentforge.hirehub.modelo.dao.proposta;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta;

public interface PropostaDAO {
    void inserirProposta(Proposta proposta);

    void deletarProposta(Proposta proposta);

    void atualizarProposta(Proposta proposta);

    Proposta recuperarPropostaPeloId(long idProposta);
    
    Proposta recuperarPropostaPeloIdCurso(long idCurso);

    List<Proposta> recuperarPropostasPeloIdEmpresa(long idEmpresa);

    List<Proposta> recuperarPropostasPeloIdInstituicao(long idInstituicao);
}