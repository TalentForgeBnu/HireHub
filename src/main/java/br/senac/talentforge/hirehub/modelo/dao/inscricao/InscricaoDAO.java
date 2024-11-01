package br.senac.talentforge.hirehub.modelo.dao.inscricao;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.inscricao.Inscricao;

public interface InscricaoDAO {
    void inserirInscricao(Inscricao inscricao);

    void deletarInscricao(Inscricao inscricao);

    void atualizarInscricao(Inscricao inscricao);

    Inscricao recuperarInscricaoPeloId(long idInscricao);

    List<Inscricao> recuperarInscricaoPeloIdCurso(long idCurso);
}