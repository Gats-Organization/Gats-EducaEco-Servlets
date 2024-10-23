package Controller.Turma;

import Daos.TurmaDAO;
import Model.Turma;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salvarTurma")
public class ServletSalvarTurma extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    int serie = Integer.parseInt(req.getParameter("serie"));
    String nomenclatura = req.getParameter("nomenclatura");
    int ano = Integer.parseInt(req.getParameter("ano"));
    int id_professor = Integer.parseInt(req.getParameter("id_professor"));
    int id_escola = Integer.parseInt(req.getParameter("id_escola"));

    TurmaDAO dao = new TurmaDAO();
    dao.inserirTurma(id, serie, nomenclatura, ano, id_professor, id_escola);
        resp.sendRedirect("listarTurma");
    }
}
