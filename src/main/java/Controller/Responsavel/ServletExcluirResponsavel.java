package Controller.Responsavel;

import Daos.ResponsavelDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/excluirResponsavel")
public class ServletExcluirResponsavel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ResponsavelDAO responsavelDao = new ResponsavelDAO();
        responsavelDao.removerResponsavel(Integer.parseInt(id));
        resp.sendRedirect("listarResponsavel");

    }
}
