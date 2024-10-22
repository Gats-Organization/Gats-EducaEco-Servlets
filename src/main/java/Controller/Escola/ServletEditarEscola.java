package Controller.Escola;

import Daos.EscolaDAO;
import Model.Escola;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarEscola")
public class ServletEditarEscola extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        EscolaDAO dao = new EscolaDAO();
        Escola escola = dao.buscarEscolaPorId(Integer.parseInt(id));
        req.setAttribute("escola", escola);
        req.getRequestDispatcher("/Pages/editarEscola.jsp").forward(req, resp);
    }
}
