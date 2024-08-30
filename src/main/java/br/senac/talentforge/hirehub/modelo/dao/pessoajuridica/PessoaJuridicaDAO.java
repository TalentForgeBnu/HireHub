package br.senac.talentforge.hirehub.modelo.dao.pessoajuridica;

import br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica.PessoaJuridica;

public interface PessoaJuridicaDAO {

	void inserirPessoaJuridica(PessoaJuridica pessoajuridica);

	void deletarPessoaJuridica(PessoaJuridica pessoajuridica);

	void atualizarPessoaJuridica(PessoaJuridica pessoajuridica);

}
