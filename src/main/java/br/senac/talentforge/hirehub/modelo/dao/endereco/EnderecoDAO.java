package br.senac.talentforge.hirehub.modelo.dao.endereco;

import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
    void inserirEndereco(Endereco endereco);

    void deletarEndereco(Endereco endereco);

    void atualizarEndereco(Endereco endereco);

    Endereco recuperarEnderecoPeloIdUsuario(long idUsuario);
}