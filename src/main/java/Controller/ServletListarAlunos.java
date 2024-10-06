package Controller;
import Daos.AlunoDAO;
import Model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name="listarAlunos" ,value="/listarAlunos")
public class ServletListarAlunos extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDAO alunoDao = new AlunoDAO();
        ResultSet listaAlunos = alunoDao.listarAlunos();
        request.setAttribute("resultSetAlunos", listaAlunos);
        request.getRequestDispatcher("/Pages/listarAlunos.jsp").forward(request, response);

    }
}
