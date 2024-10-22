package Controller.Professor;

import Daos.ProfessorDAO;
import Model.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ServletEditarProfessor")
public class ServletEditarProfessor extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ProfessorDAO dao= new ProfessorDAO();
        Professor professor= dao.buscarProfessorPorId(Integer.parseInt(id));
        req.setAttribute("professor", professor);
        req.getRequestDispatcher("/Pages/editarProfessor.jsp").forward(req, resp);

    }
}
