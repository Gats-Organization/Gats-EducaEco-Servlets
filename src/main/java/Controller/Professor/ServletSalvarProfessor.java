package Controller.Professor;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.ProfessorDAO;
import Model.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletSalvarProfessor
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/salvarProfessor")
public class ServletSalvarProfessor extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os parâmetros do formulário
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Criando um objeto do tipo ProfessorDAO
        // O objeto chama o método inserirProfessor e usa os valores recebidos do formulário como parâmetro
        // Por fim, redireciona para a página de listagem de professores
        Professor professor  = new Professor(nome, sobrenome, email, senha);
        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.inserirProfessor(professor);
        response.sendRedirect("listarProfessor");

    }
}
