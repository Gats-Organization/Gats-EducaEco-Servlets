package Controller.Aluno;

import Daos.AlunoDAO;
import Model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/atualizarAluno")
public class ServletAtualizarAluno extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nomeAluno = request.getParameter("nome");
        String sobrenomeAluno = request.getParameter("sobrenome");
        int xpAluno = Integer.parseInt(request.getParameter("xp"));
        String emailAluno = request.getParameter("email");
        String senhaAluno = request.getParameter("senha");
        int id_aluno = Integer.parseInt(request.getParameter("id_turma"));

        Aluno aluno = new Aluno(id,nomeAluno, sobrenomeAluno, xpAluno, emailAluno, senhaAluno, id_aluno);
        AlunoDAO alunoDao = new AlunoDAO();
        int ret = alunoDao.atualizarAluno(aluno);
        response.sendRedirect("listarAlunos");

    }
}
