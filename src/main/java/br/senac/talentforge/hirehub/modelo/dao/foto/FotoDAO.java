package br.senac.talentforge.hirehub.modelo.dao.foto;

import br.senac.talentforge.hirehub.modelo.entidade.foto.Foto;

public interface FotoDAO {
    void inserirUsuario(Foto foto);

    void deletarUsuario(Foto foto);

    void atualizarUsuario(Foto foto);

    Foto recuperarFotoPeloIdDeUsuario(long idUsuario);

    Foto recuperarFotoPeloIdDeCurso(long idCurso);

    Foto recuperarFotoPeloIdDeVaga(long idVaga);
}