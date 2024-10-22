package Controller.Responsavel;

import Daos.ResponsavelDAO;
import Model.Responsavel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/atualizarResponsavel")
public class ServletAtualizarResponsavel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));

        // Atualizar os dados do responsável pelo id
        Responsavel responsavel = new Responsavel(id, nome, sobrenome, email, id_aluno);
        ResponsavelDAO responsavelDao = new ResponsavelDAO();
        responsavelDao.atualizarResponsavel(responsavel);
        response.sendRedirect("listarResponsavel");

    }
}
