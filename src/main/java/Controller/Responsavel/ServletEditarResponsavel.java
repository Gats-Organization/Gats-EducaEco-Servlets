package Controller.Responsavel;

import Daos.ResponsavelDAO;
import Model.Responsavel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarResponsavel")
public class ServletEditarResponsavel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ResponsavelDAO responsavelDao= new ResponsavelDAO();
        Responsavel responsavel = responsavelDao.buscarResponsavelPorId(Integer.parseInt(id));
        req.setAttribute("responsavel", responsavel);
        req.getRequestDispatcher("/Pages/editarResponsavel.jsp").forward(req, resp);

    }
}
