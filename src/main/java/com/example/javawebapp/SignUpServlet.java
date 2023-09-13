package com.example.javawebapp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signUp", value = "/signUp")
public class SignUpServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String birthdate = req.getParameter("birthdate");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(birthdate);
        System.out.println(password);
        System.out.println(confirmPassword);
    }
}
