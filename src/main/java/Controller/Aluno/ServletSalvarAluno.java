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

// Criando a classe ServletSalvarAluno
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/salvarAluno")
public class ServletSalvarAluno extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os parâmetros do formulário
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        int xp = Integer.parseInt(request.getParameter("xp"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String turma = request.getParameter("turma");

        // Criando um objeto do tipo AlunoDAO
        // O objeto chama o método inserirAluno e usa os valores recebidos do formulário como parâmetro
        // Por fim, redireciona para a página de listagem de alunos

        AlunoDTO alunoDTO = new AlunoDTO(nome, sobrenome, xp, email, senha, turma);
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.inserirAluno(alunoDTO);
        response.sendRedirect("listarAlunos");
    }
}
