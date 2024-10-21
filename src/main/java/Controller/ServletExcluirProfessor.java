package Controller;

import Daos.ProfessorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletExcluirProfessor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ProfessorDAO dao = new ProfessorDAO();
        dao.removerProfessor(Integer.parseInt(id));
        resp.sendRedirect("listarProfessor");

    }
}
