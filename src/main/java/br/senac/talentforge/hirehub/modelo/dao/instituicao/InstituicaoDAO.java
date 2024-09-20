package br.senac.talentforge.hirehub.modelo.dao.instituicao;

import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;

public interface InstituicaoDAO {
    Instituicao recuperarIntituicao(String cnpj);
}