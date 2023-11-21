package com.example.javawebapp;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import jakarta.validation.ConstraintViolation;

import com.example.javawebapp.DAO.DonorDAO;
import com.example.javawebapp.forms.SignUpUserForm;
import com.example.javawebapp.forms.ownsvalidations.ValidatorUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signUp", value = "/sign-up-donor")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/sign-up.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Pegando os dados da requisição
        String firstname = req.getParameter("firstname") != null ? req.getParameter("firstname").strip() : null;
        String lastname = req.getParameter("lastname") != null ? req.getParameter("lastname").strip() : null;
        String phone = req.getParameter("phone") != null ? req.getParameter("phone").strip() : null;
        String cpf = req.getParameter("cpf") != null ? req.getParameter("cpf").strip() : null;
        String email = req.getParameter("email") != null ? req.getParameter("email").strip() : null;
        String birthdate = req.getParameter("birthdate") != null ? req.getParameter("birthdate").strip() : null;
        String password = req.getParameter("password") != null ? req.getParameter("password").strip() : null;
        String confirmPassword = req.getParameter("confirm-password") != null ? req.getParameter("confirm-password").strip() : null;
        boolean acceptedTerms = req.getParameter("conditions-and-terms") != null;

        //Transformando a data que chega como String em Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date birthdateDate = null;

        try {
            if (birthdate != null && !birthdate.isEmpty()) {
                birthdateDate = dateFormat.parse(birthdate);
            } else {
                // Trate o caso em que birthdate é nulo ou vazio
                // Por exemplo, lançar uma exceção ou lidar de acordo com sua lógica
            }
        } catch (ParseException e) {
            res.sendError(0, "Erro no formato da data de nascimento: " + e.getMessage());
        }


        SignUpUserForm signUpForm = new SignUpUserForm(phone, email, password, confirmPassword, firstname, lastname, cpf, birthdateDate);
     
        Set<ConstraintViolation<SignUpUserForm>> violations = ValidatorUtil.validateObject(signUpForm);
        
        if( !violations.isEmpty() || DonorDAO.existeComEmail(email) || !(acceptedTerms))
        {
            if (DonorDAO.existeComEmail(email)) {
                req.setAttribute("emailDuplicado", "Já existe uma conta com esse e-mail");
            }
            if(! (acceptedTerms)){
                req.setAttribute("termosErro", true);
            }
            req.setAttribute("telefone", phone);
            req.setAttribute("cpf", cpf);
            req.setAttribute("sobrenome", lastname);
            req.setAttribute("nome", firstname);
            req.setAttribute("email", email);
            req.setAttribute("dataNascimento", birthdate);
            req.setAttribute("termos", acceptedTerms);
            req.setAttribute("erros", violations);
            req.getRequestDispatcher("WEB-INF/sign-up.jsp").forward(req, res);
        }else{
            DonorDAO.cadastrar(phone, email, password, firstname, lastname, cpf, false, birthdateDate);
            res.sendRedirect("./login");
        }    
    }
}