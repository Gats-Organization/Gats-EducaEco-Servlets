package Controller.Turma;

import Daos.TurmaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/excluirTurma")
public class ServletExcluirTurma extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TurmaDAO dao = new TurmaDAO();
        dao.removerTurma(Integer.parseInt(id));
        resp.sendRedirect("listarTurma");
    }
}
