package Controller.Professor;

import Daos.ProfessorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salvarProfessor")
public class ServletSalvarProfessor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.inserirProfessor(id, nome, sobrenome, email, senha);
        resp.sendRedirect("listarProfessor");

    }
}
