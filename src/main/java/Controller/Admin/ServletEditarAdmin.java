package Controller.Admin;

import Daos.AdminDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarAdmins")
public class ServletEditarAdmin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    int idAdmin = Integer.parseInt(id);
    AdminDAO admindao = new AdminDAO();
    Admin admin = admindao.buscarAdminPorId(idAdmin);
    request.setAttribute("admin", admin);
    request.getRequestDispatcher("/Pages/editarAdmin.jsp").forward(request, response);
    }
}
