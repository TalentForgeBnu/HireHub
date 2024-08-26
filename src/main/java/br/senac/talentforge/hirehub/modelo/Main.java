package br.senac.talentforge.hirehub.modelo;

import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;

public class Main {
    public static void main(String[] args) {

        InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();

        Instituicao instituicao = new Instituicao();
        
        LocalDate date = LocalDate.now();
        
        instituicaoDAO.inserirInstituicao(instituicao);
        
        
        System.out.println("Teste DAO");
    }
}
