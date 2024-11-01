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

// Criando a classe ServletAtualizarAluno
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/atualizarAluno")
public class ServletAtualizarAluno extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os valores dos campos do formulário

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        int xp = Integer.parseInt(request.getParameter("xp"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        int id_turma = Integer.parseInt(request.getParameter("id_turma"));

        // Criando um objeto Aluno com os valores dos campos do formulário e chamando o método de atualização de alunos
        Aluno aluno = new Aluno(nome, sobrenome, xp, email, senha, id_turma);
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.atualizarAluno(aluno);

        // Redirecionando para a página de listagem de alunos
        response.sendRedirect("listarAlunos");

    }
}
