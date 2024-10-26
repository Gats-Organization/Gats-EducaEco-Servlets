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
import java.util.List;

// Criando a classe ServletListarTurmas
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/listarTurma")
public class ServletListarTurma extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Criando um objeto do tipo Turma e criando uma lista que irá armazenar cada registro da tabela
        // A inserção de valores na lista será feita a partir do método listarTurmasPorEscola() da classe TurmaDAO
        TurmaDAO turmaDAO = new TurmaDAO();
        List<TurmaDTO> listaTurma = turmaDAO.listarTurmasPorEscola();

        // Direcionando a lista pronta para a página JSP de listagem de turmas
        request.setAttribute("listaTurma", listaTurma);
        request.getRequestDispatcher("/Pages/listarTurma.jsp").forward(request, response);
    }
}
