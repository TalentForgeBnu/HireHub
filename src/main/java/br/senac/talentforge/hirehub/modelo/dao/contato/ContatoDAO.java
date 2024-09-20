package br.senac.talentforge.hirehub.modelo.dao.contato;

import br.senac.talentforge.hirehub.modelo.entidade.contato.Contato;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;

public interface ContatoDAO {
    void inserirContato(Contato contato);

    void deletarContato(Contato contato);

    void atualizarContato(Contato contato);

    Contato recuperarContatoPeloEndereco(Endereco endereco);
}