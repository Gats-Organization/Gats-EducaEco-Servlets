package Controller.Aluno;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AlunoDAO;
import Model.AlunoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Criando a classe ServletListarAlunos
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet(name="listarAlunos" ,value="/listarAlunos")
public class ServletListarAlunos extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Criando um objeto do tipo Aluno e criando uma lista que irá armazenar cada registro da tabela
        // A inserção de valores na lista será feita a partir do método listarAlunosTurma() da classe AlunoDAO
        AlunoDAO alunoDao = new AlunoDAO();
        List<AlunoDTO> listaAlunos = alunoDao.listarAlunosTurma();

        // Direcionando a lista pronta para a página JSP de listagem de alunos
        request.setAttribute("listaAlunos", listaAlunos);
        request.getRequestDispatcher("/Pages/listarAluno.jsp").forward(request, response);
    }
}
