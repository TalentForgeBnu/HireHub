package br.senac.talentforge.hirehub.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAO;
import br.senac.talentforge.hirehub.modelo.dao.Turma.TurmaDAOImpl;
import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao;
import br.senac.talentforge.hirehub.modelo.entidade.professor.Professor;
import br.senac.talentforge.hirehub.modelo.entidade.turma.Turma;
import br.senac.talentforge.hirehub.modelo.enumeracao.turno.Turno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/inserir-turma", "/atualizar-turma"})
public class TurmaServlet extends HttpServlet {

    private static final long serialVersionUID = -1567154649778415575L;

    private TurmaDAO turmaDAO;

    public void init() {
        turmaDAO = new TurmaDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/inserir-turma" -> inserirTurma(request, response);
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

    private void inserirTurma(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        //Prof, curso, inst retirar depois

        Professor prof = new Professor();
        Curso curso = new Curso();
        Instituicao inst = new Instituicao();

        String nome = request.getParameter("nome");
        String codigo = request.getParameter("codigo");
        byte tamanho = Byte.valueOf(request.getParameter("tamanho"));
        Turno turno = Turno.valueOf(request.getParameter("turno").toUpperCase());

        turmaDAO.inserirTurma(new Turma(nome, codigo, tamanho, prof, inst, turno, curso));

    }


    private void referenciaNaoEncontrada(HttpServletRequest request, HttpServletResponse response) {
        //pagina para referência não encontrada.
    }
}
