package br.senac.talentforge.hirehub.modelo.dao.usuario;

import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {
    void inserirUsuario(Usuario usuario);

    void deletarUsuario(Usuario usuario);

    void atualizarUsuario(Usuario usuario);

    Usuario recuperarUsuarioPeloEmail(String email);
}
