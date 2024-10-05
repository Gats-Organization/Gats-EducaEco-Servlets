package Controller;
import Daos.AlunoDAO;
import Model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name="ListarAlunos" ,value="/listarAlunos")
public class ServletListarAlunos {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDAO alunoDao = new AlunoDAO();
        ResultSet listaAlunos = alunoDao.listarAlunos();
        request.setAttribute("listaAlunos", listaAlunos);
        request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);

    }
}
