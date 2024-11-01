package Controller.Responsavel;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.ResponsavelDAO;
import Model.Responsavel;
import Model.ResponsavelDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletAtualizarResponsavel
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/atualizarResponsavel")
public class ServletAtualizarResponsavel extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os valores dos campos do formulário
        //int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));

        // Criando um objeto Responsavel com os valores dos campos do formulário e chamando o método de atualização de responsaveis
        Responsavel responsavel = new Responsavel(nome, sobrenome, email, id_aluno);
        ResponsavelDAO responsavelDao = new ResponsavelDAO();
        responsavelDao.atualizarResponsavel(responsavel);

        // Redirecionando para a página de listagem de responsaveis
        response.sendRedirect("listarResponsavel");

    }
}
