package Controller.Escola;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.EscolaDAO;
import Model.Escola;
import Model.EscolaDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletEditarEscola
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/editarEscola")
public class ServletEditarEscola extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET e encaminhar para o JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Escola com o valor do campo do formulário e atribuindo valor ao atributo que será usado como parâmetro na página de edição
        EscolaDAO escolaDAO = new EscolaDAO();
        EscolaDTO escola = escolaDAO.buscarEscolaPorId(Integer.parseInt(id));
        request.setAttribute("escola", escola);

        // Redirecionando para a página de edição de escolas
        request.getRequestDispatcher("/Pages/editarEscola.jsp").forward(request, response);
    }
}
