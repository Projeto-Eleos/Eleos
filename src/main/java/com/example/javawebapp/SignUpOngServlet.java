package com.example.javawebapp;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signUpOng", value = "/signUpOng")
public class SignUpOngServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String razaoSocial = req.getParameter("razaoSocial");
        razaoSocial = (razaoSocial != null) ? razaoSocial.strip() : null;

        String phone = req.getParameter("phone");
        phone = (phone != null) ? phone.strip() : null;

        String adress = req.getParameter("adress");
        adress = (adress != null) ? adress.strip() : null;

        String CNPJ = req.getParameter("cnpj");
        CNPJ = (CNPJ != null) ? CNPJ.strip() : null;

        String email = req.getParameter("email");
        email = (email != null) ? email.strip() : null;

        String password = req.getParameter("password");
        password = (password != null) ? password.strip() : null;

        String confirmPassword = req.getParameter("confirm-password");
        confirmPassword = (confirmPassword != null) ? confirmPassword.strip() : null;

        String terms = req.getParameter("conditions-and-terms");
        boolean aceptedTerms;
        
        if(terms == null){
            aceptedTerms = false;
        }else{
            aceptedTerms = true;
        }
        
        var user = Organization.singUpOrganization(phone, email, password, razaoSocial, CNPJ, adress, confirmPassword);
        
        if(! (user instanceof Organization) || ! (aceptedTerms)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("./sign-up-ong.jsp");
            if(! (aceptedTerms))
            user += "Aceite os termos para continuar!";
            req.setAttribute("telefone", phone);
            req.setAttribute("CNPJ", CNPJ);
            req.setAttribute("endereco", adress);
            req.setAttribute("razaoSocial", razaoSocial);
            req.setAttribute("email", email);
            req.setAttribute("erros", user);
            dispatcher.forward(req, res);
        }else{
            res.sendRedirect("./sign-in.jsp");
        }    
    }
}
