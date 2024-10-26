package Controller.Professor;


import Daos.ProfessorDAO;
import Model.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/atualizarProfessor")
public class ServletAtualizarProfessor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Professor professor = new Professor(id, nome, sobrenome, email, senha);
        ProfessorDAO professorDAO = new ProfessorDAO();
        System.out.println(professorDAO.atualizarProfessor(professor));//;int ret = ;
        response.sendRedirect("listarProfessor");
    }
}
