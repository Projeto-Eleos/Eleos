package com.example.javawebapp;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "changepassword", value = "/change-password")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codUser = (String) request.getAttribute("codUser");
        String senhaNova = request.getParameter("senha_nova");
        String confirmSenhaNova = request.getParameter("confirm_senha_nova");

        if(senhaNova.equals(confirmSenhaNova)){
            // TODO fazer o UPDATE da senha do usuário
        }

        System.out.println(codUser);
        System.out.println(senhaNova);
        System.out.println(confirmSenhaNova);
    }
}

