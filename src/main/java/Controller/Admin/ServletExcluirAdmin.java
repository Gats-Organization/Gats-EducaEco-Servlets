package Controller.Admin;

import Daos.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/ServletExcluirAdmin")
public class ServletExcluirAdmin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AdminDAO adminDAO = new AdminDAO();
        try{
            adminDAO.removerAdmin(Integer.parseInt(id));
            response.sendRedirect("listarAdmin");
        }catch(Exception e){
            e.printStackTrace();}
    }

}
