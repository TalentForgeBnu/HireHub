package br.senac.talentforge.hirehub.modelo.dao.dossie;

import br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento;
import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;

import java.util.List;

public interface DossieDAO {

    void inserirDossie(Dossie dossie);

    void deletarDossie(Dossie dossie);

    void atualizarDossie(Dossie dossie);

}