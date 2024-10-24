package Controller.Aluno;
import Daos.AlunoDAO;
import Model.AlunoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="listarAlunos" ,value="/listarAlunos")
public class ServletListarAlunos extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AlunoDAO alunoDao = new AlunoDAO();
        List<AlunoDTO> listaAlunos = alunoDao.listarAlunosTurma();
        req.setAttribute("listaAlunos", listaAlunos);
        req.getRequestDispatcher("/Pages/listarAluno.jsp").forward(req, resp);


    }
}
