package Controller.Admin;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletExcluirAdmin
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/ServletExcluirAdmin")
public class ServletExcluirAdmin extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Admin e chamando o método removerAdmin, usando o valor do campo do formulário como parâmetro
        // Ao finalizar, o método redireciona para a página de listagem de administradores. Caso haja algum erro, ele mostra a mensagem adequada.
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.removerAdmin(Integer.parseInt(id));
        response.sendRedirect("listarAdmin");
    }
}
