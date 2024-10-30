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

// Criando a classe ServletAtualizarProfessor
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/atualizarProfessor")
public class ServletAtualizarProfessor extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os valores dos campos do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Criando um objeto Professor com os valores dos campos do formulário e chamando o método de atualização de professores
        Professor professor = new Professor(id, nome, sobrenome, email, senha);
        ProfessorDAO professorDAO = new ProfessorDAO();
        System.out.println(professorDAO.atualizarProfessor(professor));

        // Redirecionando para a página de listagem de professores
        response.sendRedirect("listarProfessor");
    }
}
