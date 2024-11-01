package br.senac.talentforge.hirehub.modelo.dao.dossie;

import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;

public interface DossieDAO {
    void inserirDossie(Dossie dossie);

    void deletarDossie(Dossie dossie);

    void atualizarDossie(Dossie dossie);

    Dossie recuperarDossiePeloIdDoUsuarioAluno(long idUsuario);
}