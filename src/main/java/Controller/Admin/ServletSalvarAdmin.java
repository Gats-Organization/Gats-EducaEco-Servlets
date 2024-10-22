package Controller.Admin;

import Daos.AdminDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salvarAdmin")
public class ServletSalvarAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Admin admin = new Admin(id, nome, email, senha);
        AdminDAO adminDao = new AdminDAO();
        adminDao.inserirAdmin(admin);

        response.sendRedirect("listarAdmin");


    }

}
