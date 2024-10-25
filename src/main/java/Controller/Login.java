package Controller;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controller.Admin.ServletAdicionarAdmin;
import Controller.Admin.ServletSalvarAdmin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Login", value = "/login")
    public class    Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if(emailExiste(email) && senhaExiste(senha)) {
            //if regex == true
            //abre a tela do crud
            request.getRequestDispatcher("painelPrincipal.html").forward(request, response);

        } else if (email.isEmpty() || senha.isEmpty()) {
            //verifica se o usuário preencheu todos os campos (se estiver vazio, retorna erro)
            request.getRequestDispatcher("/Pages/ErrorIsEmpty.jsp").forward(request, response);

        } else{
            //else (regex == false)
            //mostra um erro pro usuário
            request.getRequestDispatcher("/Pages/ErrorSintaxe.jsp").forward(request, response);
        }

    }

    public static boolean emailExiste (String email) {
        for (String emailArmazenado : ServletSalvarAdmin.getEmails()) {
            if (!email.equals(emailArmazenado)) {
                return false;
            }
        }
        return true;
    }

    public static boolean senhaExiste(String senha) {
        for (String senhaArmazenada : ServletSalvarAdmin.getSenhas()) {
            if (!senha.equals(senhaArmazenada)) {
                return false;
            }
        }
        return true;
    }
}
