package br.senac.talentforge.hirehub.modelo.dao.pessoafisica;

import br.senac.talentforge.hirehub.modelo.entidade.pessoaFisica.PessoaFisica;

public interface PessoaFisicaDAO {
	
	void inserirPessoaFisica(PessoaFisica pessoafisica);
	
	void deletarPessoaFisica(PessoaFisica pessoafisica);
		
	void atualizarPessoaFisica(PessoaFisica pessoafisica);
	
}
