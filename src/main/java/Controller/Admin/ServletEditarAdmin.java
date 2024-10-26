package Controller.Admin;

// Importando as classes necessárias para o funciomanento do Servlet
import Daos.AdminDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletEditarAdmin
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/editarAdmins")
public class ServletEditarAdmin extends HttpServlet {
    // Criando o método para processar as solicitações do tipo GET e encaminhar para o JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Admin com o valor do campo do formulário e atribuindo valor ao atributo que será usado como parâmetro para a edição
        AdminDAO admindao = new AdminDAO();
        Admin admin = admindao.buscarAdminPorId(Integer.parseInt(id));
        request.setAttribute("admin", admin);

        // Redirecionando para a página de edição de administradores
        request.getRequestDispatcher("/Pages/editarAdmin.jsp").forward(request, response);
    }
}
