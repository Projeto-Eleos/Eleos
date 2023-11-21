package com.example.javawebapp;

import java.io.IOException;

import com.example.javawebapp.DAO.CampaignDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CampaignManagement", value = "/campaignManagement")
public class CampaignManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("campanhas", CampaignDAO.buscarCampanhas(req));
        req.getRequestDispatcher("WEB-INF/campaign-management.jsp").forward(req, res);
    }
}