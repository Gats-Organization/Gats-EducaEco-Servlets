package Controller.Turma;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.TurmaDAO;
import Model.Turma;
import Model.TurmaDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletAtualizarTurma
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/atualizarTurma")
public class ServletAtualizarTurma extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os valores dos campos do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        int serie  = Integer.parseInt(request.getParameter("serie"));
        String nomenclatura = request.getParameter("nomenclatura");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String professor = request.getParameter("id_professor");
        String escola = request.getParameter("id_escola");

        // Criando um objeto Turma com os valores dos campos do formulário e chamando o método de atualização de turmas
        TurmaDTO turma = new TurmaDTO(id, serie, nomenclatura, ano, professor, escola);
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.atualizarTurma(turma);

        // Redirecionando para a página de listagem de turmas
        response.sendRedirect("listarTurma");
    }
}
