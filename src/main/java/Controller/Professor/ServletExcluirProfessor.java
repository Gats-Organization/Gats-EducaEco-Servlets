package Controller.Professor;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.ProfessorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletExcluirProfessor
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/excluirProfessor")
public class ServletExcluirProfessor extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Professor e chamando o método removerProfessor, usando o valor do campo do formulário como parâmetro
        // Ao finalizar, redireciona para a página de listagem de professores
        ProfessorDAO dao = new ProfessorDAO();
        dao.removerProfessor(Integer.parseInt(id));
        response.sendRedirect("listarProfessor");
    }
}
