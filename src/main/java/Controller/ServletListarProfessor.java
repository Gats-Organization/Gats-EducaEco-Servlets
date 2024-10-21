package Controller;

import Daos.ProfessorDAO;
import Model.Professor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarProfessor")
public class ServletListarProfessor extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfessorDAO professorDao = new ProfessorDAO();
        List<Professor> listaProfessores = professorDao.listarProfessores();
        req.setAttribute("listaProfessores", listaProfessores);
        req.getRequestDispatcher("/Pages/listarProfessor.jsp").forward(req, resp);

    }
}
