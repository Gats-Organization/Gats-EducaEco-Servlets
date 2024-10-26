package Controller.Admin;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Admin;
import java.util.List;
import java.io.IOException;

// Criando a classe ServletListarAdmin
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet(name="listarAdmin", value="/listarAdmin")
public class ServletListarAdmin extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Criando um objeto do tipo Admin e criando uma lista que irá armazenar cada registro da tabela
        // A inserção de valores na lista será feita a partir do método listarAdmins() da classe AdminDAO
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> listaAdmins = adminDAO.listarAdmins();

        // Direcionando a lista pronta para a página JSP de listagem de administradores
        request.setAttribute("listaAdmins", listaAdmins);
        request.getRequestDispatcher("/Pages/listarAdmin.jsp").forward(request, response);
    }
}

