package Controller.Professor;

import Daos.ProfessorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/ServletExcluirProfessor")
public class ServletExcluirProfessor extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ProfessorDAO dao = new ProfessorDAO();
        dao.removerProfessor(Integer.parseInt(id));
        resp.sendRedirect("listarProfessor");

    }
}
