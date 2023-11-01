package com.example.javawebapp;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import jakarta.validation.ConstraintViolation;

import com.example.javawebapp.forms.SignUpUserForm;
import com.example.javawebapp.forms.ownsvalidations.ValidatorUtil;

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
        String firstname = req.getParameter("firstname") != null ? req.getParameter("firstname").strip() : null;
        String lastname = req.getParameter("lastname") != null ? req.getParameter("lastname").strip() : null;
        String phone = req.getParameter("phone") != null ? req.getParameter("phone").strip() : null;
        String cpf = req.getParameter("cpf") != null ? req.getParameter("cpf").strip() : null;
        String email = req.getParameter("email") != null ? req.getParameter("email").strip() : null;
        String birthdate = req.getParameter("birthdate") != null ? req.getParameter("birthdate").strip() : null;
        String password = req.getParameter("password") != null ? req.getParameter("password").strip() : null;
        String confirmPassword = req.getParameter("confirm-password") != null ? req.getParameter("confirm-password").strip() : null;

        boolean acceptedTerms = req.getParameter("conditions-and-terms") != null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); dateFormat.setLenient(false);
        Date birthdateDate = null;
        try {
            if (birthdate != null && !birthdate.isEmpty()) {
                if (birthdate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    birthdateDate = dateFormat.parse(birthdate);
                } else {
                    throw new ParseException("Data de nascimento em formato inválido", 0);
                }
            }
        } catch (ParseException e) {
            res.sendError(0, "Erro no formato da data de nascimento: " + e.getMessage());
        }

        SignUpUserForm signUpForm = new SignUpUserForm(phone, email, password, confirmPassword, firstname, lastname, cpf, birthdateDate);
     
        Set<ConstraintViolation<SignUpUserForm>> violations = ValidatorUtil.validateObject(signUpForm);

        if( !violations.isEmpty() || !acceptedTerms){
            RequestDispatcher dispatcher = req.getRequestDispatcher("./sign-up.jsp");
            if(! (acceptedTerms))
            req.setAttribute("termos", "Aceite os termos para continuar!");
            req.setAttribute("telefone", phone);
            req.setAttribute("cpf", cpf);
            req.setAttribute("sobrenome", lastname);
            req.setAttribute("nome", firstname);
            req.setAttribute("email", email);
            req.setAttribute("dataNascimento", birthdate);
            req.setAttribute("termos", acceptedTerms);
            req.setAttribute("erros", violations);
            dispatcher.forward(req, res);
        }else{
            res.sendRedirect("./sign-in.jsp");
        }    
    }
}