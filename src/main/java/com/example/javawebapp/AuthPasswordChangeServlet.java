package com.example.javawebapp;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "authPasswordChange", value = "/auth-password-change")
public class AuthPasswordChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/password-recover.jsp").forward(req, res);
    }

    private class GenerateCode{
        public int randomic(){
            Random randomObj = new Random();
            return randomObj.nextInt(1000000);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        // // TODO validar se o e-mail existe no banco
        
        GenerateCode generateCodeObj = new GenerateCode();
        int cod_gerado = generateCodeObj.randomic();
        System.out.println(cod_gerado);
        // // TODO enviar para este e-mail um código aleatório para ter acesso a redefinição de senha

        int cod_digitado = Integer.parseInt(request.getParameter("cod"));

        if (cod_gerado == cod_digitado) {
            request.setAttribute("user", "<id do usuário>");

            // // Obtém o RequestDispatcher
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Servlet2");

            // Encaminha a solicitação para Servlet2
            dispatcher.forward(request, response);
            response.sendRedirect("/change-password.html");
        }else {
            response.sendRedirect("/código-inválido.html");
        }

        System.out.println(email);
        System.out.println(cod_digitado);
    }

}
