package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAO;
import br.senac.talentforge.hirehub.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAO;
import br.senac.talentforge.hirehub.modelo.dao.professor.ProfessorDAOImpl;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAO;
import br.senac.talentforge.hirehub.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.papel.Papel;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.enumeracao.Etnia.Etnia;
import br.senac.talentforge.hirehub.modelo.enumeracao.sexo.Sexo;

@WebServlet("/professor/*")
public class ProfessorServlet extends HttpServlet {

	private static final long serialVersionUID = 512561250174084370L;

	private ProfessorDAO professorDAO;
	private UsuarioDAO usuarioDAO;
	private EnderecoDAO enderecoDAO;
	
	public void init() {
		professorDAO = new ProfessorDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action){
               case "/inserir" -> inserirAluno(request,response);
               default -> referenciaNaoEncontrada(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
      }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	
	private void inserirAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        
		//Lembrar de remover intituicao pois é para testes
		
		Instituicao instTest = new Instituicao();
		Papel papel = new Papel();
		
		//Pt1 Dados Professor
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String nomeSocial = request.getParameter("nomeSocial");
		String telefone = request.getParameter("telefone");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        
        //Pt2 Dados Professor
        
        String estado = request.getParameter("estado");
        String logradouro = request.getParameter("logradouro");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        LocalDate dataNascimento = LocalDate.ofEpochDay(request.getDateHeader("dataNascimento"));
        Etnia etnia = Etnia.valueOf(request.getParameter("etinia"));
        Sexo sexo = Sexo.valueOf(request.getParameter("sexo"));
       
        int numeroCasa = Integer.valueOf(numero);
        
        Endereco endereco = new Endereco(logradouro,bairro,cidade,estado,cep,numeroCasa);
        enderecoDAO.inserirEndereco(endereco);
        usuarioDAO.inserirUsuario(new Professor(senha,endereco,papel,telefone,email,cpf,nome,sobrenome,nomeSocial,dataNascimento,etnia,sexo,instTest));
      
    }

    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
	
}
