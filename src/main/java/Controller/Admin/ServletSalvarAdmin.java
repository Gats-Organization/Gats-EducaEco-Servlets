package Controller.Admin;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AdminDAO;
import Model.Admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Criando a classe ServletSalvarAdmin
// A anotação @WebServlet é usada para mapear o Servlet para uma URL
@WebServlet("/salvarAdmin")
public class ServletSalvarAdmin extends HttpServlet {

    // Criando o método para processar as solicitações do tipo POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os parâmetros do formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Verificando se o e-mail e a senha estão corretos usando os métodos criados abaixo
        // Caso o login esteja correto, o admin será salvo no banco de dados
        if (verificandoEmail(email) && verificandoSenha(senha)) {
            Admin admin = new Admin(nome, email, senha);
            AdminDAO adminDao = new AdminDAO();
            adminDao.inserirAdmin(admin);
            response.sendRedirect("listarAdmin?txt=Adicionado com sucesso!");
        } else{
            response.sendRedirect("listarAdmin?txt=Erro ao adicionar!");
        }
    }

    // A regex do método é usada para verificar se o e-mail está no formato correto
    public boolean verificandoEmail(String email) {

        // Definindo a regex (formato) que o e-mail informado deve seguir
        String regexEmail = "[a-z]+\\.crud@gats\\.com$";

        // Atributo Matcher usado na comparação
        Matcher comparadorEmail;

        // Comparando o e-mail com o formato da regex
        comparadorEmail = Pattern.compile(regexEmail).matcher(email);

        // Verificando se o e-mail do admin esta correto
        if (!comparadorEmail.matches()) {
            return false;
        }
        return true;
    }

    // A regex do método é usada para verificar se a senha está no formato correto
    public boolean verificandoSenha(String senha) {
        // Definindo a regex (formato) que a senha informada deve seguir
        String regexSenha = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";

        // Atributo Matcher usado na comparação
        Matcher comparadorSenha;

        // Comparando a senha com o formato da regex
        comparadorSenha = Pattern.compile(regexSenha).matcher(senha);

        // Verificando se a senha do admin esta correta
        if (!comparadorSenha.matches()) {
            return false;
        }
        return true;
    }
}
