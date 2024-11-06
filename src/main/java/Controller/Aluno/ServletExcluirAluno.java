package Controller.Aluno;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AlunoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletExcluirAluno
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/excluirAluno")
public class ServletExcluirAluno extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Aluno e chamando o método removerAluno, usando o valor do campo do formulário como parâmetro
        // Ao finalizar, redireciona para a página de listagem de alunos
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.removerAluno(Integer.parseInt(id));
        response.sendRedirect("listarAlunos");
    }
}
