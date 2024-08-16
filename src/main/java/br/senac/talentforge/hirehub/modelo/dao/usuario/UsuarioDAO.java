package br.senac.talentforge.hirehub.modelo.dao.usuario;

import br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void inserirUsuario(Usuario usuario);

    void deletarUsuario(Usuario usuario);

    void atualizarUsuario(Usuario usuario);

    List<Usuario> recuperarUsuario();
}