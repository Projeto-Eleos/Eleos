package com.example.javawebapp;

import java.io.IOException;
import java.util.Set;

import jakarta.validation.ConstraintViolation;

import com.example.javawebapp.DAO.OrganizationDAO;
import com.example.javawebapp.forms.SignUpOngForm;
import com.example.javawebapp.forms.ownsvalidations.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signUpOng", value = "/sign-up-ong")
public class SignUpOngServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/sign-up-ong.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Pegando os dados da requisição
        String razaoSocial = req.getParameter("razaoSocial");
        razaoSocial = (razaoSocial != null) ? razaoSocial.strip() : null;

        String phone = (req.getParameter("phone") != null) ? req.getParameter("phone").strip() : null;
        String address = (req.getParameter("address") != null) ? req.getParameter("address").strip() : null;
        String CNPJ = (req.getParameter("cnpj") != null) ? req.getParameter("cnpj").strip() : null;
        String email = (req.getParameter("email") != null) ? req.getParameter("email").strip() : null;
        String password = (req.getParameter("password") != null) ? req.getParameter("password").strip() : null;
        String confirmPassword = (req.getParameter("confirm-password") != null) ? req.getParameter("confirm-password").strip() : null;
        boolean acceptedTerms = req.getParameter("conditions-and-terms") != null;
        
        SignUpOngForm signUpForm = new SignUpOngForm(phone, email, password, confirmPassword, razaoSocial, address, CNPJ);
        
        Set<ConstraintViolation<SignUpOngForm>> violations = ValidatorUtil.validateObject(signUpForm);

        if( !violations.isEmpty() || OrganizationDAO.existeComEmail(email) || ! (acceptedTerms)){
            if(! (acceptedTerms)){
                req.setAttribute("termosErro", true);
            }
            if (OrganizationDAO.existeComEmail(email)) {
                req.setAttribute("emailDuplicado", "Já existe uma conta com esse e-mail");
            }
            req.setAttribute("telefone", phone);
            req.setAttribute("CNPJ", CNPJ);
            req.setAttribute("endereco", address);
            req.setAttribute("razaoSocial", razaoSocial);
            req.setAttribute("email", email);
            req.setAttribute("termos", acceptedTerms);
            req.setAttribute("erros", violations);
            req.getRequestDispatcher("WEB-INF/sign-up-ong.jsp").forward(req, res);
        }else{
            OrganizationDAO.cadastrar(phone, email, password, razaoSocial, address, CNPJ);
            res.sendRedirect("./login");
        }     
    }
}
