package Controller.Responsavel;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.ResponsavelDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletExcluirResponsavel
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/excluirResponsavel")
public class ServletExcluirResponsavel extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Responsavel e chamando o método removerResponsavel, usando o valor do campo do formulário como parâmetro
        // Ao finalizar, redireciona para a página de listagem de responsáveis
        ResponsavelDAO responsavelDao = new ResponsavelDAO();
        responsavelDao.removerResponsavel(Integer.parseInt(id));
        response.sendRedirect("listarResponsavel");
    }
}
