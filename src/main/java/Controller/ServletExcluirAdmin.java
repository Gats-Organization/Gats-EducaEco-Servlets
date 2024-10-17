package Controller;

import Daos.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ServletExcluirAdmin")
public class ServletExcluirAdmin extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AdminDAO adminDAO = new AdminDAO();
        try{
            adminDAO.removerAdmin(Integer.parseInt(id));
            response.sendRedirect("listarAdmin");
        }catch(Exception e){
            e.printStackTrace();}
    }

}
