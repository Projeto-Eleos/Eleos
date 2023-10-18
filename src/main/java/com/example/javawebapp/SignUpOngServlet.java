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

        String phone = (req.getParameter("phone") != null) ? req.getParameter("phone").strip() : null;
        String address = (req.getParameter("address") != null) ? req.getParameter("address").strip() : null;
        String CNPJ = (req.getParameter("cnpj") != null) ? req.getParameter("cnpj").strip() : null;
        String email = (req.getParameter("email") != null) ? req.getParameter("email").strip() : null;
        String password = (req.getParameter("password") != null) ? req.getParameter("password").strip() : null;
        String confirmPassword = (req.getParameter("confirm-password") != null) ? req.getParameter("confirm-password").strip() : null;


        boolean acceptedTerms = req.getParameter("conditions-and-terms") != null;
        
        var user = Organization.singUpOrganization(phone, email, password, razaoSocial, CNPJ, address, confirmPassword);
        
        if(! (user instanceof Organization) || ! (acceptedTerms)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("./sign-up-ong.jsp");
            if(! (acceptedTerms))
            user += "Aceite os termos para continuar!";
            req.setAttribute("telefone", phone);
            req.setAttribute("CNPJ", CNPJ);
            req.setAttribute("endereco", address);
            req.setAttribute("razaoSocial", razaoSocial);
            req.setAttribute("email", email);
            req.setAttribute("termos", acceptedTerms);
            req.setAttribute("erros", user);
            dispatcher.forward(req, res);
        }else{
            res.sendRedirect("./sign-in.jsp");
        }    
    }
}
