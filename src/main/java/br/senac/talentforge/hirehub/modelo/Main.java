package br.senac.talentforge.hirehub.modelo;

import java.time.LocalDate;

import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAO;
import br.senac.talentforge.hirehub.modelo.dao.curso.CursoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.talentforge.hirehub.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
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
    	endereco.setLogradouro("Manoel Bernardo Da Silva");
    	endereco.setNumero(1016);
    	
    	enderecoDAO.inserirEndereco(endereco);

        InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
        
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        
        Instituicao instituicao = new Instituicao();
        
        usuarioDAO.inserirUsuario(instituicao);
       
        
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
        
        professor.setNome("Raico");
        professor.setSobrenome("Ronda");
        professor.setGenero(Genero.MASCULINO);
        professor.setCpf("15946823536");
        professor.setEndereco(endereco);
        professor.setInstituicao(instituicao);
        professor.setMateria("Matemática");
        professor.setRendaFamiliar(4500);
        professor.setTurmas(null);
        
        usuarioDAO.inserirUsuario(professor);
        
        System.out.println("Teste DAO");
    }
}
