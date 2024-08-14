package br.senac.talentforge.hirehub.modelo.dao.vaga;

import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;

public interface VagaDAO {
    void inserirVaga(Vaga vaga);

    void deletarVaga(Vaga vaga);

    void atualizarVaga(Vaga vaga);
}