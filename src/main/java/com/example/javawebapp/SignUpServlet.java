package com.example.javawebapp;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signUp", value = "/signUp")
public class SignUpServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String firstname = req.getParameter("firstname").strip();
        String lastname = req.getParameter("lastname").strip();
        String phone = req.getParameter("phone").strip();
        String cpf = req.getParameter("cpf").strip();
        String email = req.getParameter("email").strip();
        String birthdate = req.getParameter("birthdate").strip();
        String password = req.getParameter("password").strip();
        String confirmPassword = req.getParameter("confirm-password").strip();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); dateFormat.setLenient(false);
        Date birthdateDate = null;
        try{
            birthdateDate = dateFormat.parse(birthdate);
        }catch(ParseException e){
            res.sendError(0, e.getMessage());
        }
        
        var user = Donor.singUpDonnor(phone, email, password, firstname, lastname, cpf, false, birthdateDate, confirmPassword);
        if(! (user instanceof Donor)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("./sign-up.jsp");
            req.setAttribute("erros", user);
            dispatcher.forward(req, res);
        }else{
            res.sendRedirect("./sign-in.html");
        }    
    }
}
