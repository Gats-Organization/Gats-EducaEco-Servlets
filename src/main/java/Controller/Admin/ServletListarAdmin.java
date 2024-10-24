package Controller.Admin;

import Daos.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Admin;
import java.util.List;

import java.io.IOException;

@WebServlet(name="listarAdmin", value="/listarAdmin")
public class ServletListarAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> listaAdmins = adminDAO.listarAdmins();
        req.setAttribute("listaAdmins", listaAdmins);
        req.getRequestDispatcher("/Pages/listarAdmin.jsp").forward(req, resp);
    }
}
