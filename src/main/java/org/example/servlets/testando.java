package org.example.servlets;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//duda e clara lindas
@WebServlet(name = "Teste", value = "/login")
    public class testando extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if(verificandoEmail(email) == true && verificandoSenha(senha) == true) {
            //if regex == true
            //abre a tela do crud
            request.getRequestDispatcher("crud.jsp").forward(request, response);

        } else if (email.isEmpty() || senha.isEmpty()) {
            //verifica se o usuário preencheu todos os campos (se estiver vazio, retorna erro)
            request.getRequestDispatcher("ErrorIsEmpty").forward(request, response);

        } else{
            //else (regex == false)
            //mostra um erro pro usuário
            request.getRequestDispatcher("ErrorSintaxe.jsp").forward(request, response);
        }
    }

    public boolean verificandoEmail(String email){
        Pattern expressaoRegex = Pattern.compile("^admin\\.crud@gats\\.com\\.br$");
        Matcher emailValidado = expressaoRegex.matcher(email);
        return emailValidado.find();
    }

    public boolean verificandoSenha (String senha){
        String senhaOfc = "GatsAdm123";
        if(senha.equals(senhaOfc)){
            return false;
        }
        return true;
    }
}
