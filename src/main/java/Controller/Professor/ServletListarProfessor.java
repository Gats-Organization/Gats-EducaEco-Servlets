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
import java.util.List;

// Criando a classe ServletListarProfessor
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/listarProfessor")
public class ServletListarProfessor extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Criando um objeto do tipo Professor e criando uma lista que irá armazenar cada registro da tabela
        // A inserção de valores na lista será feita a partir do método listarProfessores() da classe ProfessorDAO
        ProfessorDAO professorDao = new ProfessorDAO();
        List<Professor> listaProfessores = professorDao.listarProfessores();

        // Direcionando a lista pronta para a página JSP de listagem de professores
        request.setAttribute("listaProfessores", listaProfessores);
        request.getRequestDispatcher("/Pages/listarProfessor.jsp").forward(request, response);
    }
}
