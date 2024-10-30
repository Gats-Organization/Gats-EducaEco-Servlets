package Controller.Turma;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.TurmaDAO;
import Model.Turma;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recebendo os valores dos campos do formulário
        int id = Integer.parseInt(req.getParameter("id"));
        int serie  = Integer.parseInt(req.getParameter("serie"));
        String nomenclatura = req.getParameter("nomenclatura");
        int ano = Integer.parseInt(req.getParameter("ano"));
        int id_professor = Integer.parseInt(req.getParameter("id_professor"));
        int id_escola = Integer.parseInt(req.getParameter("id_escola"));

        // Criando um objeto Turma com os valores dos campos do formulário e chamando o método de atualização de turmas
        Turma turma = new Turma(id, serie, nomenclatura, ano, id_professor, id_escola);
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.atualizarTurma(turma);

        // Redirecionando para a página de listagem de turmas
        resp.sendRedirect("listarTurma");
    }
}
