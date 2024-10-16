package Controller;

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
        List<Admin> adminList = adminDAO.listarAdmins();
        req.setAttribute("adminList", adminList);
        req.getRequestDispatcher("listarAdmin.jsp").forward(req, resp);
    }
}

