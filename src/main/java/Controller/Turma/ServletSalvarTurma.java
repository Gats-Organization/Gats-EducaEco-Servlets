package Controller.Turma;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.TurmaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//Criando a classe ServletSalvarTurma
//A anotação @WebServlet é usada para mapear o Servlet
@WebServlet("/salvarTurma")
public class ServletSalvarTurma extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        int serie = Integer.parseInt(request.getParameter("serie"));
        String nomenclatura = request.getParameter("nomenclatura");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String escola = request.getParameter("escola");
        String professor = request.getParameter("professor");

        // Criando um objeto do tipo TurmaDAO
        // O objeto chama o método inserirTurma e usa os valores recebidos do formulário como parâmetro
        // Por fim, redireciona para a página de listagem de turmas
        TurmaDAO dao = new TurmaDAO();
        dao.inserirTurma(id, serie, nomenclatura, ano,escola, professor);
        response.sendRedirect("listarTurma");
    }
}
