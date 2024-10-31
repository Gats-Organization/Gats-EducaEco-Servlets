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

// Criando a classe ServletEditarProfessor
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/ServletEditarProfessor")
public class ServletEditarProfessor extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET e encaminhar para o JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Professor com o valor do campo do formulário e atribuindo valor ao atributo que será usado como parâmetro na página de edição
        ProfessorDAO professorDAO= new ProfessorDAO();
        Professor professor= professorDAO.buscarProfessorPorId(Integer.parseInt(id));
        request.setAttribute("professor", professor);

        // Redirecionando para a página de edição de escolas
        request.getRequestDispatcher("/Pages/editarProfessor.jsp").forward(request, response);

    }
}
