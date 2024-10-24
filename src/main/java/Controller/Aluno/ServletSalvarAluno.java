package Controller.Aluno;

import Daos.AlunoDAO;
import Model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/salvarAluno")
public class ServletSalvarAluno extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        int xp = Integer.parseInt(req.getParameter("xp"));
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String turma = req.getParameter("turma");



        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.inserirAluno(id, nome, sobrenome, xp, email, senha, turma);
        resp.sendRedirect("listarAlunos");

    }
}
