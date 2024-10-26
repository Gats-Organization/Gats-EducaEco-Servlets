package Controller.Escola;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.EscolaDAO;
import Model.Escola;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletSalvarEscola
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/salvarEscola")
public class ServletSalvarEscola extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        String endereco = request.getParameter("endereco");

        // Criando um objeto do tipo EscolaDAO
        // O objeto chama o método inserirEscola e usa os valores recebidos do formulário como parâmetro
        // Por fim, redireciona para a página de listagem de escolas
        EscolaDAO escolaDAO = new EscolaDAO();
        escolaDAO.inserirEscola(id, nome, email, telefone, endereco);
        response.sendRedirect("listarEscola");
    }
}
