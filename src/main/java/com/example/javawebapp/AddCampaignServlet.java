package com.example.javawebapp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.example.javawebapp.DAO.CampaignDAO;
import com.example.javawebapp.Entity.Organization;
import com.example.javawebapp.forms.AddCampaignForm;
import com.example.javawebapp.forms.ownsvalidations.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;

@WebServlet(name = "AddCampaign", value = "/addCampaign")
public class AddCampaignServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/add-campaign.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        titulo = (titulo != null) ? titulo.strip() : null;

        String descricao = req.getParameter("descricao");
        descricao = (descricao != null) ? descricao.strip() : null;

        int meta = Integer.parseInt(req.getParameter("meta"));

        String tipo = req.getParameter("campaign-type");
        tipo = (tipo != null) ? tipo.strip() : null;

        String categoria = req.getParameter("campaign-category");
        categoria = (categoria != null) ? categoria.strip() : null;

        String vencimento = req.getParameter("vencimento") != null ? req.getParameter("vencimento").strip() : null;

                //Transformando a data que chega como String em Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date vencimentoDate = null;

        try {
            if (vencimento != null && !vencimento.isEmpty()) {
                vencimentoDate = dateFormat.parse(vencimento);
            } else {
                // Trate o caso em que vencimento é nulo ou vazio
                // Por exemplo, lançar uma exceção ou lidar de acordo com sua lógica
            }
        } catch (ParseException e) {
            res.sendError(0, "Erro no formato da data de nascimento: " + e.getMessage());
        }

        AddCampaignForm AddCampaignForm = new AddCampaignForm(titulo, descricao, meta, tipo, categoria,vencimentoDate);

        Set<ConstraintViolation<AddCampaignForm>> violations = ValidatorUtil.validateObject(AddCampaignForm);

        if( !violations.isEmpty() || CampaignDAO.existeComTitulo(titulo))
        {
            if (CampaignDAO.existeComTitulo(titulo)) {
                req.setAttribute("tituloDuplicado", "Já existe uma conta com esse e-mail");
            }
            req.setAttribute("titulo", titulo);
            req.setAttribute("descricao", descricao);
            req.setAttribute("meta", meta);
            req.setAttribute("tipo", tipo);
            req.setAttribute("categoria", categoria);
            req.setAttribute("vencimentoDate", vencimentoDate);
            req.setAttribute("erros", violations);
            req.getRequestDispatcher("WEB-INF/add-campaign.jsp").forward(req, res);
        }else{
            HttpSession session = req.getSession();
            Organization user = (Organization) session.getAttribute("Organization");
            CampaignDAO.cadastrar(titulo, vencimentoDate, descricao, user.getId(), categoria, meta, tipo, req);
            res.sendRedirect("./campaignManagement");
        }
    }
}