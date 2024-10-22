package Controller;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Login", value = "/login")
    public class    Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if(verificandoRegex(email)) {
            //if regex == true
            //abre a tela do crud
            request.getRequestDispatcher("/Pages/painelPrincipal.jsp").forward(request, response);

        } else if (email.isEmpty() || senha.isEmpty()) {
            //verifica se o usuário preencheu todos os campos (se estiver vazio, retorna erro)
            request.getRequestDispatcher("/Pages/ErrorIsEmpty.jsp").forward(request, response);

        } else{
            //else (regex == false)
            //mostra um erro pro usuário
            request.getRequestDispatcher("/Pages/ErrorSintaxe.jsp").forward(request, response);
        }

    }

    public boolean verificandoRegex(String email){
        Pattern expressaoRegex = Pattern.compile("^admin\\.crud@gats\\.com\\.br$");
        Matcher emailValidado = expressaoRegex.matcher(email);
        return emailValidado.find();
    }


}
