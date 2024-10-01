package org.example.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//duda e clara lindas
@WebServlet(name = "Teste", value = "/login")
    public class testando extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        //recebi os parâmetros e vou fazer o regex
        //método regex - retorna true se deu certo e false se não condiz{}

        boolean teste = true;
        if(teste == true) {
            //if regex == true
            //abre a tela do crud
            request.getRequestDispatcher("crud.jsp").forward(request, response);

        } else {
            //else (regex == false)
            //mostra um erro pro usuário
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }
}
