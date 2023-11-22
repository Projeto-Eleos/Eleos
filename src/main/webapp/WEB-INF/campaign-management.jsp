<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/campaign-management.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Gerenciar Campanhas</title>
</head>
<body>
    <header>
        <a class="logo" href="/Home/index.html">Eleos</a>
        <div class="header-right">
            <a id="item" href="./home"><fmt:message key="general.home"/></a>
            <a class="active" href="./campaigns"><fmt:message key="general.campaign"/></a>
            <a id="item" href="./contacts"><fmt:message key="general.contact"/></a>
            <a href="./logout" id="item"><fmt:message key="campaignmanagement.logout"/></a>
            <a href="./home" id="item">${sessionScope.Organization.razaoSocial}</a>
            <a class="logado" id="item" href="./home"><i class="bx bx-user"></i></a>
        </div>
    </header>
    <div class="container">
        <div class="flex">
            <h1><fmt:message key="campaignmanagement.campaign"/></h1>
            <a class="btn" href="addCampaign"><fmt:message key="campaignmanagement.newcampaign"/></a>
        </div>
        <table>
            <thead>
                <th><fmt:message key="campaignmanagement.namecampaign"/></th>
                <th><fmt:message key="campaignmanagement.descriptioncampaign"/></th>
                <th><fmt:message key="campaignmanagement.goalcampaign"/></th>
                <th><fmt:message key="campaignmanagement.type"/></th>
                <th><fmt:message key="campaignmanagement.category"/></th>
                <th><fmt:message key="campaignmanagement.maturity"/></th>
                <th><fmt:message key="campaignmanagement.operation"/></th>
            </thead>
            <table>
                <tbody id="itens">
                    <c:forEach var="campanha" items="${campanhas}">
                        <tr>
                            <td>${campanha.titulo}</td>
                            <td>${campanha.descricao}</td>
                            <td>${campanha.meta}</td>
                            <td>${campanha.tipo}</td>
                            <td>${campanha.categoria}</td>
                            <td>${campanha.vencimento}</td>
                            <td>
                                <a href="#"><i class='bx bx-edit-alt'></i></a>
                                <a href="#"><i class='bx bx-trash'></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>                        
        </table>
</div>
