package Controller.Turma;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.TurmaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletExcluirTurma
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/excluirTurma")
public class ServletExcluirTurma extends HttpServlet {
    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Pegando os valores dos campos do formulário
        String id = req.getParameter("id");

        // Criando um objeto do tipo Turma e chamando o método removerTurma, usando o valor do campo do formulário como parâmetro
        // Ao finalizar, redireciona para a página de listagem de turmas
        TurmaDAO dao = new TurmaDAO();
        dao.removerTurma(Integer.parseInt(id));
        resp.sendRedirect("listarTurma");
    }
}
