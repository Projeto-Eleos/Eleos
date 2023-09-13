package com.example.javawebapp;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "authpasswordchange", value = "/auth-password-change")
public class AuthPasswordChangeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        // TODO validar se o e-mail existe no banco
        // TODO enviar para este e-mail um código aleatório para ter acesso a
        // redefinição de senha

        long cod_gerado = 0; // TODO deverá ser o código aleatório gerado
        long cod_digitado = Long.parseLong(request.getParameter("cod"));

        if (cod_gerado == cod_digitado) {
            request.setAttribute("codUser", "<id do usuário>");

            // Obtém o RequestDispatcher
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Servlet2");

            // Encaminha a solicitação para Servlet2
            dispatcher.forward(request, response);
            response.sendRedirect("/change-password.html");
        } else {
            response.sendRedirect("/código-inválido.html");
        }

        System.out.println(email);
        System.out.println(cod_digitado);
    }

}
