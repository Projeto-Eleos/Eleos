package com.example.javawebapp;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signIn", value = "/signIn")
public class SignInServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        email = (email != null) ? email.strip() : null;

        String password = req.getParameter("password");
        password = (password != null) ? password.strip() : null;

        
        var errors = User.logar(email, password);
        if( errors == null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("./welcome.jsp");
            req.setAttribute("email", email);
            dispatcher.forward(req, res);
        }else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/sign-in.jsp");
            req.setAttribute("erros", errors);
            req.setAttribute("email", email);
            req.setAttribute("senha", password);
            dispatcher.forward(req, res);
        } 
    }
}
