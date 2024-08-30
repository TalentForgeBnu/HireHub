package br.senac.talentforge.hirehub.modelo;

import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.dao.contato.ContatoDAO;
import br.senac.talentforge.hirehub.modelo.dao.contato.ContatoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.contato.Contato;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.enumeracao.andamentocurso.AndamentoCurso;
import br.senac.talentforge.hirehub.modelo.enumeracao.genero.Genero;

public class Main {
    public static void main(String[] args) {
    	
    	EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
    	
    	Endereco endereco = new Endereco();
    	
    	endereco.setEstado("Santa Catarina");
    	endereco.setCidade("Gaspar");
    	endereco.setBairro("Figueira");
    	endereco.setCep("89110430");
    	endereco.setlogradouro("Manoel Bernardo Da Silva");
    	endereco.setNumero(1016);
    	
    	enderecoDAO.inserirEndereco(endereco);

        InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
        
        Instituicao instituicao = new Instituicao();
        
        instituicaoDAO.inserirInstituicao(instituicao);
        
        ContatoDAO contatoDAO = new ContatoDAOImpl();
        
        Contato contato = new Contato();
        
        contato.setEmail("JASDHJASHDJASDLKAD");
        contato.setnumero("34538535");
        
        contatoDAO.inserirContato(contato);
       
        
        CursoDAO cursoDAO = new CursoDAOImpl();
        
        Curso curso = new Curso();
        
        curso.setNomeCurso("Jovem Programador");
        curso.setDescricao("Cursinho daora");
        curso.setAreaDeAtuacao("Informática");
        curso.setDataInicio(LocalDate.of(2007, 03, 01));
        curso.setDataFim(LocalDate.of(2026, 06, 10));
        curso.setInsituicao(instituicao);
        curso.setStatus(AndamentoCurso.ABERTO);
        
        cursoDAO.inserirCurso(curso);
        
        
        ProfessorDAO professorDAO = new ProfessorDAOImpl();
        
        Professor professor = new Professor();
        
        professor.setnome("Raico");
        professor.setsobrenome("Ronda");
        professor.setGenero(Genero.MASCULINO);
        professor.setCpf("15946823536");
        professor.setEndereco(endereco);
        professor.setInstituicao(instituicao);
        professor.setMateria("Matemática");
        professor.setRendaFamiliar(4500);
        professor.setTurmas(null);
        
        professorDAO.inserirProfessor(professor);
        
        System.out.println("Teste DAO");
    }
}
