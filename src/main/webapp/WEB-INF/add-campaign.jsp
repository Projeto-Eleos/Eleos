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
            <a href="./logout" id="item">sair</a>
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
    <h1>Adicionar Campanhas</h1>
    <p>Preencha o formulário com as seguintes informações da sua campanha:</p>
    <hr>
    <label for="campaign-name">Nome da Campanha</label>
        <input type="text" id="campaign-name" placeholder="Nome da Campanha" name="titulo" value="${titulo}" required>
    <label for="campaign-description">Descrição da Campanha</label>
        <textarea rows="5" id="campaign-description" name="descricao" value="${descricao}" required>Descreva o projeto da campanha e seu impacto na comunidade.</textarea>
    <label for="campaign-goal">Meta de Arrecadações</label>
        <input type="number" id="campaign-goal" name="meta" value="${meta}" placeholder="Digite a quantidade de arrecadações esperadas" required>
    <label for="campaign-type">Tipo de Doação</label>
        <select name="campaign-type" value="${campaign-type}" id="campaign-type">
            <option value="Alimentos">Alimentos</option>
            <option value="Brinquedos">Brinquedos</option>
            <option value="Roupas">Roupas</option>
            <option value="Produtos de Higiene">Produtos de Higiene</option>
            <option value="Material Escolar">Material Escolar</option>
            <option value="Remédios">Remédios</option>
            <option value="Outros">Outros</option>
        </select>
    <label for="campaign-category">Categoria da Doação</label>
        <select name="campaign-category" value="${campaign-category}" id="campaign-category">
            <option value="Saúde">Saúde</option>
            <option value="Educação">Educação</option>
            <option value="Assistência Social">Assistência Social</option>
            <option value="Meio Ambiente">Meio Ambiente</option>
            <option value="Cultura">Cultura</option>
            <option value="Outros">Outros</option>
        </select>
    <label for="campaign-date">Data de Vencimento ou Publicação?</label>
        <input type="date" value="${vencimento}" id="campaign-date" name="vencimento" required>
    <button id="campaign-submit">Salvar</button>
    <input type="hidden" id="campaign-id">
    <a href="campaignManagement">Visualizar campanhas ativas</a>
    </form>
</div>
</body>
</html>