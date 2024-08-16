package br.senac.talentforge.hirehub.modelo.dao.instituicao;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;

public interface InstituicaoDAO {
    void inserirInstituicao(Instituicao instituicao);

    void deletarInstituicao(Instituicao instituicao);

    void atualizarInstituicao(Instituicao instituicao);
}