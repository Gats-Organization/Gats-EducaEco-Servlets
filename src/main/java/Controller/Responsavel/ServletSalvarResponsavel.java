package Controller.Responsavel;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.ResponsavelDAO;
import Model.ResponsavelDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletSalvarResponsavel
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/salvarResponsavel")
public class ServletSalvarResponsavel extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String aluno = request.getParameter("aluno");

        // Criando um objeto do tipo ResponsavelDAO
        // O objeto chama o método inserirResponsavel e usa os valores recebidos do formulário como parâmetro
        // Por fim, redireciona para a página de listagem de responsaveis
        ResponsavelDTO responsavel = new ResponsavelDTO(nome, sobrenome, email, aluno);
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        responsavelDAO.inserirResponsavel(responsavel);
        response.sendRedirect("listarResponsavel");

    }
}
