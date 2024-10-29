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

@WebServlet("/atualizarResponsavel")
public class ServletAtualizarResponsavel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String aluno = request.getParameter("aluno");

        // Atualizar os dados do responsável pelo id
        ResponsavelDTO responsavel = new ResponsavelDTO(nome, sobrenome, email, aluno);
        ResponsavelDAO responsavelDao = new ResponsavelDAO();
        responsavelDao.atualizarResponsavel(responsavel);
        response.sendRedirect("listarResponsavel");

    }
}
