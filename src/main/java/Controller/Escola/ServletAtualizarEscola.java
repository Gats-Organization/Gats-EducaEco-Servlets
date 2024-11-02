package Controller.Escola;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.EscolaDAO;
import Model.EscolaDTO;
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
        String telefone = request.getParameter("telefone");
        String enderecoCompleto = request.getParameter("enderecoCompleto");


        // Criando um objeto Escola com os valores dos campos do formulário e chamando o método de atualização de escolas
        EscolaDTO escola = new EscolaDTO(id, nome, email, telefone, enderecoCompleto);
        EscolaDAO escolaDAO = new EscolaDAO ();
        escolaDAO.atualizarEscola(escola);

        // Redirecionando para a página de listagem de escolas
        response.sendRedirect("listarEscola");
    }
}
