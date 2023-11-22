<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/addCampaign.css">
    <link rel="stylesheet" href="./styles/global.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Adicionar Campanhas</title>
</head>
<body>
    <header>
        <a class="logo" href="/Home/index.html">Eleos</a>
        <div class="header-right">
            <a id="item" href="./home"><fmt:message key="general.home"/></a>
            <a class="active" href="./campaigns"><fmt:message key="general.campaign"/></a>
            <a id="item" href="./contacts"><fmt:message key="general.contact"/></a>
            <a href="./logout" id="item"><fmt:message key="addcampaign.logout"/></a>
            <a href="./home" id="item">${sessionScope.Organization.razaoSocial}</a>
            <a class="logado" id="item" href="./home"><i class="bx bx-user"></i></a>
        </div>
    </header>
<div class="container">
<div class="criarCampanha">
    <c:if test="${erros != null}">
            <c:forEach var="erro" items="${erros}">
                <div class="error-box">
                    <i class='bx bx-info-circle icon' style='color:#ffffff'  ></i>
                    <span class="erros">${erro.propertyPath} - ${erro.message}</span>
                </div>
            </c:forEach>
    </c:if>
    <form id="campaign-form"  method="post" action="addCampaign">
    <h1><fmt:message key="addcampaign.title"/></h1>
    <p><fmt:message key="addcampaign.doform"/></p>
    <hr>
    <label for="campaign-name"><fmt:message key="addcampaign.name"/></label>
        <input type="text" id="campaign-name" placeholder="Nome da Campanha" name="titulo" value="${titulo}" required>
    <label for="campaign-description"><fmt:message key="addcampaign.description"/></label>
        <textarea rows="5" id="campaign-description" name="descricao" value="${descricao}" required><fmt:message key="addcampaign.descriptionandproject"/></textarea>
    <label for="campaign-goal"><fmt:message key="addcampaign.goal"/></label>
        <input type="number" id="campaign-goal" name="meta" value="${meta}" placeholder="Digite a quantidade de arrecadações esperadas" required>
    <label for="campaign-type"><fmt:message key="addcampaign.type"/></label>
        <select name="campaign-type" value="${campaign-type}" id="campaign-type">
            <option value="Alimentos"><fmt:message key="addcampaign.type1"/></option>
            <option value="Brinquedos"><fmt:message key="addcampaign.type2"/></option>
            <option value="Roupas"><fmt:message key="addcampaign.type3"/></option>
            <option value="Produtos de Higiene"><fmt:message key="addcampaign.type4"/></option>
            <option value="Material Escolar"><fmt:message key="addcampaign.type5"/></option>
            <option value="Remédios"><fmt:message key="addcampaign.type6"/></option>
            <option value="Outros"><fmt:message key="addcampaign.type7"/></option>
        </select>
    <label for="campaign-category"><fmt:message key="addcampaign.category"/></label>
        <select name="campaign-category" value="${campaign-category}" id="campaign-category">
            <option value="Saúde"><fmt:message key="addcampaign.category1"/></option>
            <option value="Educação"><fmt:message key="addcampaign.category2"/></option>
            <option value="Assistência Social"><fmt:message key="addcampaign.category3"/></option>
            <option value="Meio Ambiente"><fmt:message key="addcampaign.category4"/></option>
            <option value="Cultura"><fmt:message key="addcampaign.category5"/></option>
            <option value="Outros"><fmt:message key="addcampaign.type7"/></option>
        </select>
    <label for="campaign-date"><fmt:message key="addcampaign.date"/></label>
        <input type="date" value="${vencimento}" id="campaign-date" name="vencimento" required>
    <button id="campaign-submit"><fmt:message key="addcampaign.save"/></button>
    <input type="hidden" id="campaign-id">
    <a href="campaignManagement"><fmt:message key="addcampaign.view"/></a>
    </form>
</div>
</body>
</html>