package Controller.Escola;

import Daos.EscolaDAO;
import Model.Escola;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/atualizarEscola")
public class ServletAtualizarEscola extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int id_endereco = Integer.parseInt(request.getParameter("id_endereco"));

        EscolaDAO dao = new EscolaDAO();
        Escola escola = new Escola(id, nome, email, telefone, id_endereco);
        dao.atualizarEscola(escola);
        response.sendRedirect("listarEscola");
    }
}
