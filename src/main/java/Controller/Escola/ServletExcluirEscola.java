package Controller.Escola;

import Daos.EscolaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/excluirEscola")
public class ServletExcluirEscola extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        EscolaDAO dao = new EscolaDAO();
        dao.removerEscola(Integer.parseInt(id));
        resp.sendRedirect("listarEscola");
    }


}
