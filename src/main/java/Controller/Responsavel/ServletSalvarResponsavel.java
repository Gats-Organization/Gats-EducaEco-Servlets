package Controller.Responsavel;

import Daos.ResponsavelDAO;
import Model.Responsavel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salvarResponsavel")
public class ServletSalvarResponsavel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
        // Salvar no banco de dados
        ResponsavelDAO dao = new ResponsavelDAO();
        dao.inserirResponsavel(id, nome, sobrenome, email, id_aluno);
        response.sendRedirect("listarResponsavel");

    }
}
