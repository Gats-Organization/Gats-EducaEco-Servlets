package Controller.Aluno;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AlunoDAO;
import Model.Aluno;
import Model.AlunoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletAtualizarAdmin
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/atualizarAluno")
public class ServletAtualizarAluno extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        int xp = Integer.parseInt(request.getParameter("xp"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String turma = request.getParameter("turma");

        AlunoDTO aluno = new AlunoDTO(nome, sobrenome, xp, email, senha, turma);
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.atualizarAluno(aluno);
        response.sendRedirect("listarAlunos");

    }
}
