package Controller.Escola;

import Daos.EscolaDAO;
import Model.Escola;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salvarEscola")
public class ServletSalvarEscola extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        int telefone = Integer.parseInt(req.getParameter("telefone"));
        int id_endereco = Integer.parseInt(req.getParameter("id_endereco"));

        EscolaDAO dao = new EscolaDAO();
        dao.inserirEscola(id, nome, email, telefone, id_endereco);
        resp.sendRedirect("listarEscola");



        }
}
