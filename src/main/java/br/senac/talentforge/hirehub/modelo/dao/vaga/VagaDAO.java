package br.senac.talentforge.hirehub.modelo.dao.vaga;

import java.util.List;

import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.contratacao.Contratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacao.Situacao;

public interface VagaDAO {
	void inserirVaga(Vaga vaga);

	void deletarVaga(Vaga vaga);

	void atualizarVaga(Vaga vaga);

	Vaga recuperarVagaPeloId(long idVaga);
	
	Vaga recuperarVagaPelaModalidade(Contratacao modalidadeContratacao);

	Vaga recuperarVagaPelaSituacaoVaga(Situacao situacaoVaga);

	List<Vaga> recuperarVagasPeloIdDaEmpresa(long idEmpresa);
}