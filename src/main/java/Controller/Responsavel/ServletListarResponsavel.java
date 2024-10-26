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
import java.util.List;

// Criando a classe ServletListarResponsavel
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/listarResponsavel")
public class ServletListarResponsavel extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Criando um objeto do tipo Responsavel e criando uma lista que irá armazenar cada registro da tabela
        // A inserção de valores na lista será feita a partir do método listarResponsavelPorAluno() da classe ResponsavelDAO
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        List<ResponsavelDTO> listaResponsavel = responsavelDAO.listarResponsavelPorAluno();

        // Direcionando a lista pronta para a página JSP de listagem de responsaveis
        request.setAttribute("listaResponsavel", listaResponsavel);
        request.getRequestDispatcher("/Pages/listarResponsavel.jsp").forward(request, response);
    }
}
