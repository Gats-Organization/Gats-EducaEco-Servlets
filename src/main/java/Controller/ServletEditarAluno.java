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

@WebServlet(name = "ServletEditarAluno", value = "/ServletEditarAluno")
public class ServletEditarAluno extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        AlunoDAO dao = new AlunoDAO();

        try {
            Aluno aluno = dao.buscarAlunoPorId(Integer.parseInt(id));
            req.setAttribute("aluno", aluno);

            // Verifique se o caminho está correto
            System.out.println("Encaminhando para: /Pages/editarAluno.jsp");
            req.getRequestDispatcher("/Pages/editarAluno.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

