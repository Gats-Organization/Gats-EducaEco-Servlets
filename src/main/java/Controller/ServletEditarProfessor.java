package Controller;

import Daos.ProfessorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/buscarProfessor")
public class ServletEditarProfessor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int idProf = Integer.parseInt(id);
        ProfessorDAO professor= new ProfessorDAO();
        professor.buscarProfessorPorId(idProf);
        req.setAttribute("professor", professor);
        resp.sendRedirect("/Pages/editarProfessor.jsp");

    }
}
