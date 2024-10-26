package Controller.Escola;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.EscolaDAO;
import Model.Escola;
import Model.EscolaDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Criando a classe ServletListarEscola
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/listarEscola")
public class ServletListarEscola extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Criando um objeto do tipo Escola e criando uma lista que irá armazenar cada registro da tabela
        // A inserção de valores na lista será feita a partir do método listarEscolasPorEndereco() da classe EscolaDAO
        EscolaDAO dao = new EscolaDAO();
        List<EscolaDTO> listaEscola = dao.listarEscolasPorEndereco();

        // Direcionando a lista pronta para a página JSP de listagem de escolas
        request.setAttribute("listaEscola", listaEscola);
        request.getRequestDispatcher("/Pages/listarEscola.jsp").forward(request, response);
    }
}
