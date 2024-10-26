package Controller.Admin;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AdminDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletAtualizarAdmin
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/atualizarAdmin")
public class ServletAtualizarAdmin extends HttpServlet {
    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando os valores dos campos do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Criando um objeto Admin com os valores dos campos do formulário e chamando o método de atualização de administradores
        Admin admin = new Admin(id, nome, email, senha);
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.atualizarAdmin(admin);

        // Redirecionando para a página de listagem de administradores
        response.sendRedirect("listarAdmin");
    }
}
