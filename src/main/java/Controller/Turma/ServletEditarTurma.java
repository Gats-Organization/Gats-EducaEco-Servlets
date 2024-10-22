package Controller.Turma;

import Daos.TurmaDAO;
import Model.Turma;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarTurma")
public class ServletEditarTurma extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String id = req.getParameter("id");
        TurmaDAO turmaDAO = new TurmaDAO();
        Turma turma = turmaDAO.buscarTurmaPorId(Integer.parseInt(id));
        req.setAttribute("turma", turma);
        req.getRequestDispatcher("/Pages/editarTurma.jsp").forward(req, resp);
    }
    }

