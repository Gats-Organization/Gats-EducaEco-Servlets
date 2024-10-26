package Controller.Aluno;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AlunoDAO;
import Model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletEditarAluno
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet( "/buscarAluno")
public class ServletEditarAluno extends HttpServlet {
    // Criando o método para processar as solicitações do tipo GET e encaminhar para o JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando os valores dos campos do formulário
        String id = request.getParameter("id");

        // Criando um objeto do tipo Aluno com o valor do campo do formulário e atribuindo valor ao atributo que será usado como parâmetro na página de edição
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = dao.buscarAlunoPorId(Integer.parseInt(id));
        request.setAttribute("aluno", aluno);

        // Redirecionando para a página de edição de alunos
        request.getRequestDispatcher("/Pages/editarAluno.jsp").forward(request, response);




    }
}

