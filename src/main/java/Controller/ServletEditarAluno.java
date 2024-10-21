package Controller;

import Daos.AlunoDAO;
import Model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/buscarAluno")
public class ServletEditarAluno extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int alunoId = Integer.parseInt(id);
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = dao.buscarAlunoPorId(alunoId);
        req.setAttribute("aluno", aluno);

        // Verifique se o caminho está correto
        req.getRequestDispatcher("/Pages/editarAluno.jsp").forward(req, resp);




    }
}

