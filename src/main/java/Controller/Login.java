package Controller;

// Importando as classes necessárias para o funcionamento do Servlet
import java.io.*;
import java.util.List;
import Controller.Admin.ServletSalvarAdmin;
import Daos.AdminDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Variaveis que receberão os valores passados pelo formulário
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Instanciando objetos dos tipos Admin e AdminDAO
        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.buscarAdminPorEmail(email);

        // Condição para verificar se o usuário existe e se a senha está correta
        boolean adminExiste = false;

        // Condição para verificar se os campos foram preenchidos, e se foram preenchidos corretamente
        if (admin != null && admin.getEmail().equals(email) && admin.getSenha().equals(senha)) {
            adminExiste = true;
        }

        // Condições para verificar se o login correu bem
            // Caso o login seja bem sucedido, redireciona para a página de painel principal
        if(adminExiste) {
            request.getRequestDispatcher("painelPrincipal.html").forward(request, response);

            // Condição que verifica se o email e senha foram preenchidos
            // Caso haja algum erro, direciona para a página de erro
        } else if (email.isEmpty() || senha.isEmpty()) {
            request.getRequestDispatcher("/Pages/ErrorIsEmpty.jsp").forward(request, response);

            // Condição que verifica se o regex foi respeitado
            // Caso haja algum erro, direciona para a página de erro
        } else{
            request.getRequestDispatcher("/Pages/ErrorSintaxe.jsp").forward(request, response);
        }
    }
}
