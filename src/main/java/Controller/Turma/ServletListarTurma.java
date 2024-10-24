package Controller.Turma;

import Daos.TurmaDAO;
import Model.Turma;
import Model.TurmaDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarTurma")
public class ServletListarTurma extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TurmaDAO turmaDAO = new TurmaDAO();
        List<TurmaDTO> listaTurma = turmaDAO.listarTurmasPorEscola();
        req.setAttribute("listaTurma", listaTurma);
        req.getRequestDispatcher("/Pages/listarTurma.jsp").forward(req, resp);
    }
}
