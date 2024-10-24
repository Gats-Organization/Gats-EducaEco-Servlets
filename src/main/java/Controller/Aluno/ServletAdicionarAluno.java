package Controller.Aluno;
//Importando as classes necessárias para o funcionamento do Servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//Criando a classe ServletAdicionarAluno
//A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/adicionarAluno")
public class ServletAdicionarAluno extends HttpServlet {
    //Criando o método para processar as solicitações do tipo GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Encaminhando a solicitação para o jsp
        request.getRequestDispatcher("/Pages/adicionarAluno.jsp").forward(request, response);

    }
}
