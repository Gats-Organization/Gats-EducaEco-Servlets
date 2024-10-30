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

// Criando a classe ServletAtualizarEscola
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/atualizarEscola")
public class ServletAtualizarEscola extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os valores dos campos do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int id_endereco = Integer.parseInt(request.getParameter("id_endereco"));

        // Criando um objeto Escola com os valores dos campos do formulário e chamando o método de atualização de escolas
        EscolaDAO dao = new EscolaDAO();
        Escola escola = new Escola(id, nome, email, telefone, id_endereco);
        dao.atualizarEscola(escola);

        // Redirecionando para a página de listagem de escolas
        response.sendRedirect("listarEscola");
    }
}
