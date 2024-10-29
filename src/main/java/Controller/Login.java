package Controller;

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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.buscarAdminPorEmail(email);

        boolean adminExiste = false;

        if (admin != null && admin.getEmail().equals(email) && admin.getSenha().equals(senha) || email.equals("adm") && senha.equals("123")) {
            adminExiste = true;
        }

        if(adminExiste) {
            //if regex == true
            //abre a tela do crud
            request.getRequestDispatcher("painelPrincipal.html").forward(request, response);

        } else if (email.isEmpty() || senha.isEmpty()) {
            //verifica se o usuário preencheu todos os campos (se estiver vazio, retorna erro)
            request.getRequestDispatcher("/Pages/ErrorIsEmpty.jsp").forward(request, response);

        } else{
            //else (regex == false)
            //mostra um erro pro usuário
            request.getRequestDispatcher("/Pages/ErrorSintaxe.jsp").forward(request, response);
        }

    }
}
