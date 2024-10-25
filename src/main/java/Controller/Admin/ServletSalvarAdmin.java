package Controller.Admin;

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

@WebServlet("/salvarAdmin")
public class ServletSalvarAdmin extends HttpServlet {
    //Criando uma lista que armazena os e-mails
    private static LinkedList<String> emails = new LinkedList<>();

    //Criando uma lista que armazena as senhas
    private static LinkedList<String> senhas = new LinkedList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (verificandoEmail(email) && verificandoSenha(senha)) {
            Admin admin = new Admin(id, nome, email, senha);
            AdminDAO adminDao = new AdminDAO();
            adminDao.inserirAdmin(admin);
        } else{
            //página de erro
        }
        response.sendRedirect("listarAdmin");
    }

    public boolean verificandoEmail(String email) {
        //Definindo a regex (formato) que o e-mail informado deve seguir
        String regexEmail = "[a-z]+\\.crud@gats\\.com$";

        //Atributo Matcher usado na comparação
        Matcher comparadorEmail;

        //Comparando o e-mail com o formato da regex
        comparadorEmail = Pattern.compile(regexEmail).matcher(email);

        //Verificando se o e-mail do admin estão corretas
        if (!comparadorEmail.matches()) {
            return false;
        }
        emails.add(email);
        return true;
    }

    public boolean verificandoSenha(String senha) {
        //Definindo a regex (formato) que a senha informada deve seguir
        String regexSenha = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";

        //Atributo Matcher usado na comparação
        Matcher comparadorSenha;

        //Comparando a senha com o formato da regex
        comparadorSenha = Pattern.compile(regexSenha).matcher(senha);

        if (!comparadorSenha.matches()) {
            return false;
        }
        senhas.add(senha);
        return true;
    }

    public static LinkedList<String> getEmails() {
        return emails;
    }

    public static LinkedList<String> getSenhas() {
        return senhas;
    }
}
