package Controller.Aluno;

import Daos.AlunoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/ServletExcluirAluno")
public class ServletExcluirAluno extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.removerAluno(Integer.parseInt(id));
        response.sendRedirect("listarAlunos");



        }

}
