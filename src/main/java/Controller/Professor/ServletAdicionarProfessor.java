package Controller.Professor;

// Importando as classes necessárias para o funcionamento do Servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Criando a classe ServletAdicionarProfessor
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/adicionarProfessor")
public class ServletAdicionarProfessor extends HttpServlet {

    // Criando o método para processar as solicitações do tipo GET e encaminhar para o JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Encaminhando a solicitação para o JSP
        request.getRequestDispatcher("/Pages/adicionarProfessor.jsp").forward(request, response);
    }
}
