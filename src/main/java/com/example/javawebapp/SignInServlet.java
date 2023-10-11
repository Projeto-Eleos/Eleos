package com.example.javawebapp;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signIn", value = "/signIn")
public class SignInServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email").strip();
        String password = req.getParameter("password").strip();
        
        String errors = User.logar(email, password);
        if( errors.isBlank()){
            RequestDispatcher dispatcher = req.getRequestDispatcher("./welcome.jsp");
            req.setAttribute("email", email);
            dispatcher.forward(req, res);
        }else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/sing-in.jsp");
            req.setAttribute("erros", errors);
            dispatcher.forward(req, res);
        } 
    }
}
