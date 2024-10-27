package Controller.Turma;
//Importando as classes necessárias para o funcionamento do Servlet
import Daos.TurmaDAO;
import Model.TurmaDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//Criando a classe ServletAtualizarAdmin
//A anotação @WebServlet é usada para mapear o Servlet
@WebServlet("/salvarTurma")
public class ServletSalvarTurma extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int serie = Integer.parseInt(request.getParameter("serie"));
    String nomenclatura = request.getParameter("nomenclatura");
    int ano = Integer.parseInt(request.getParameter("ano"));
    String escola = request.getParameter("escola");
    String professor = request.getParameter("professor");
    TurmaDTO turmaDTO = new TurmaDTO(serie, nomenclatura, ano,escola, professor);
    TurmaDAO turmaDAO = new TurmaDAO();
    turmaDAO.inserirTurma(turmaDTO);
        response.sendRedirect("listarTurma");
    }
}
