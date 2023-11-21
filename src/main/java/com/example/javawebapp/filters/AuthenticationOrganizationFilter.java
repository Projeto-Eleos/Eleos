package com.example.javawebapp.filters;

import java.io.IOException;

import com.example.javawebapp.Entity.Organization;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(value = {"/addCampaign", "/campaignManagement"})
public class AuthenticationOrganizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Organization ong = (Organization) session.getAttribute("Organization");

        if (ong == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("./login");
            req.setAttribute("authentication", true);
            dispatcher.forward(req, res);
            return;
        }
        chain.doFilter(request, response);
    }
}
