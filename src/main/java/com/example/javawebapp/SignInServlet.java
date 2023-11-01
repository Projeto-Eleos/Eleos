package com.example.javawebapp;

import java.io.IOException;
import java.util.Set;

import jakarta.validation.ConstraintViolation;

import com.example.javawebapp.forms.SignInForm;
import com.example.javawebapp.forms.ownsvalidations.ValidatorUtil;

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

        SignInForm signInForm = new SignInForm(email, password);

        Set<ConstraintViolation<SignInForm>> violations = ValidatorUtil.validateObject(signInForm);

        if (violations.isEmpty()) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("./welcome.jsp");
            req.setAttribute("email", email);
            dispatcher.forward(req, res);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/sign-in.jsp");
            req.setAttribute("erros", violations);
            req.setAttribute("email", email);
            req.setAttribute("senha", password);
            dispatcher.forward(req, res);
        }
    }
}
