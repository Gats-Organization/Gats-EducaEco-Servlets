package Controller;

import Daos.EscolaDAO;
import Model.Escola;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarEscola")
public class ServletListarEscola extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EscolaDAO dao = new EscolaDAO();
        List<Escola> listaEscola = dao.listarEscolas();
        request.setAttribute("listaEscola", listaEscola);
        request.getRequestDispatcher("/Pages/listarEscola.jsp").forward(request, response);
    }
}
