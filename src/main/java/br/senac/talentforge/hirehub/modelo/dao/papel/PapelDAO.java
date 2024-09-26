package br.senac.talentforge.hirehub.modelo.dao.papel;

import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;

public interface PapelDAO {
	void inserirPapel(Papel papel);
	
	void deletarPapel(Papel papel);
		
	void atualizarPapel(Papel papel);
}
