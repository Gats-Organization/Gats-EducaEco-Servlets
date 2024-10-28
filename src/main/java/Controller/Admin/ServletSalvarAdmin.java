package Controller.Admin;

// Importando as classes necessárias para o funcionamento do Servlet
import Daos.AdminDAO;
import Model.Admin;
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

    // Criando listas para armazenar os e-mails e senhas
    private static LinkedList<String> emails = new LinkedList<>();
    private static LinkedList<String> senhas = new LinkedList<>();

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
        } else{
            //página de erro
        }
        response.sendRedirect("listarAdmin");
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
        emails.add(email);
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
        senhas.add(senha);
        return true;
    }

    // Métodos para receber os emails e senhas de administradores
    public static LinkedList<String> getEmails() {
        return emails;
    }
    public static LinkedList<String> getSenhas() {
        return senhas;
    }
}
