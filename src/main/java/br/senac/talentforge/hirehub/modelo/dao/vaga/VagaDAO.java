package br.senac.talentforge.hirehub.modelo.dao.vaga;

import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.modalidadecontratacao.ModalidadeContratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacaovaga.SituacaoVaga;

public interface VagaDAO {
    void inserirVaga(Vaga vaga);

    void deletarVaga(Vaga vaga);

    void atualizarVaga(Vaga vaga);

    Vaga recuperarVagaPeloIdEmpresa(long codigo);

    Vaga recuperarVagaPelaModalidade(ModalidadeContratacao modalidadeContratacao);

    Vaga recuperarVagaPelaSituacaoVaga(SituacaoVaga situacaoVaga);
}