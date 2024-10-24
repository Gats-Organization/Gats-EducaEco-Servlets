package Controller.Admin;
//Importando as classes necessárias para o funcionamento do Servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//Criando a classe ServletAdicionarAdmin
//A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/adicionarAdmin")
public class ServletAdicionarAdmin extends HttpServlet {
    //Criando o método para processar as solicitações do tipo GET e encaminhar para o jsp
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Pages/adicionarAdmin.jsp").forward(request, response);

    }
}
