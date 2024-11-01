package Controller.Responsavel;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.ResponsavelDAO;
import Model.Responsavel;
import Model.ResponsavelDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletEditarProfessor
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/editarResponsavel")
public class ServletEditarResponsavel extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET e encaminhar para o JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Responsavel com o valor do campo do formulário e atribuindo valor ao atributo que será usado como parâmetro na página de edição
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        ResponsavelDTO responsavel = responsavelDAO.buscarResponsavelPorId(Integer.parseInt(id));
        request.setAttribute("responsavel", responsavel);

        // Redirecionando para a página de edição de escolas
        request.getRequestDispatcher("/Pages/editarResponsavel.jsp").forward(request, response);

    }
}
