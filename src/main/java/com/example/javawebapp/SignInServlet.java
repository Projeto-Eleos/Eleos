package com.example.javawebapp;

import java.io.IOException;
import java.util.Set;

import jakarta.validation.ConstraintViolation;

import com.example.javawebapp.DAO.DonorDAO;
import com.example.javawebapp.DAO.OrganizationDAO;
import com.example.javawebapp.forms.SignInForm;
import com.example.javawebapp.forms.ownsvalidations.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "login", value = "/login")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/sign-in.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        email = (email != null) ? email.strip() : null;

        String password = req.getParameter("password");
        password = (password != null) ? password.strip() : null;

        SignInForm signInForm = new SignInForm(email, password);

        Set<ConstraintViolation<SignInForm>> violations = ValidatorUtil.validateObject(signInForm);

        if (violations.isEmpty()) {
            if (DonorDAO.login(email, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("Donor", DonorDAO.buscarPorEmail(email));
                session.setAttribute("Organization", null);
                res.sendRedirect("./home");
                return;
            } else if (OrganizationDAO.login(email, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("Donor", null);
                session.setAttribute("Organization", OrganizationDAO.buscarPorEmail(email));
                res.sendRedirect("./home");
                return;
            }else{
                req.setAttribute("email", email);
                req.setAttribute("senha", password);
                req.setAttribute("erros", violations);
                req.setAttribute("erroLogin", "Os dados informados não condizem a uma conta ");
                req.getRequestDispatcher("WEB-INF/sign-in.jsp").forward(req, res);
            }
        }

        req.setAttribute("email", email);
        req.setAttribute("senha", password);
        req.setAttribute("erros", violations);
        req.getRequestDispatcher("WEB-INF/sign-in.jsp").forward(req, res);
                   
    }
}
