package br.senac.talentforge.hirehub.modelo.dao.foto;

import br.senac.talentforge.hirehub.modelo.entidade.foto.Foto;

public interface FotoDAO {
    void inserirFoto(Foto foto);

    void deletarFoto(Foto foto);

    void atualizarFoto(Foto foto);

    Foto recuperarFotoPeloIdDeUsuario(long idUsuario);

    Foto recuperarFotoPeloIdDeCurso(long idCurso);

    Foto recuperarFotoPeloIdDeVaga(long idVaga);
}