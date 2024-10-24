package Controller.Responsavel;

import Daos.ResponsavelDAO;
import Model.Responsavel;
import Model.ResponsavelDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarResponsavel")
public class ServletListarResponsavel extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        List<ResponsavelDTO> listaResponsavel = responsavelDAO.listarResponsavelPorAluno();
        request.setAttribute("listaResponsavel", listaResponsavel);
        request.getRequestDispatcher("/Pages/listarResponsavel.jsp").forward(request, response);
    }
}
