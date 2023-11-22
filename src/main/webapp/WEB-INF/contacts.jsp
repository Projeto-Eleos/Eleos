<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="public/favicon.svg" type="image/svg+xml">
    <link rel="stylesheet" href="./styles/contacts.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Contatos</title>
</head>
<body>
    <header>
        <a class="logo" href="./home">Eleos</a>
        <div class="header-right">
            <a id="item" href="./home"><fmt:message key="general.home"/></a>
            <a id="item" href="./campaigns"><fmt:message key="general.campaign"/></a>
            <a class="active" href="./contacts"><fmt:message key="general.contact"/></a>
            <c:if test="${(sessionScope.Donor == null) && (sessionScope.Organization == null)}">
                <a  href="./login" class="login"><fmt:message key="general.sign-in"/></a>
                <a href="./sign-up-donor" class="cadastro"><fmt:message key="general.sign-up"/></a>
            </c:if>
            <c:if test="${sessionScope.Donor != null}">
                <a href="./logout" id="item"><fmt:message key="homepage.logout"/></a>
                <a href="./home" id="item">${sessionScope.Donor.name}</a>
                <a class="logado" id="item" href="./home"><i class="bx bx-user"></i></a>
            </c:if>
            <c:if test="${sessionScope.Organization != null}">
                <a href="./logout" id="item"><fmt:message key="homepage.logoutong"/></a>
                <a href="./home" id="item">${sessionScope.Organization.razaoSocial}</a>
                <a class="logado" id="item" href="./home"><i class="bx bx-user"></i></a>
            </c:if>
        </div>
    </header>
    <main>
            <div class="conteiner">
                <div class="left">
                    <h1><fmt:message key="contact.contacts"/></h1>
                    <p class="descricao"><fmt:message key="contact.description"/><br><br>
                        <i class='bx bx-envelope'></i><fmt:message key="contact.email"/><br>
                        <i class='bx bx-phone'></i><fmt:message key="contact.phone"/>
                    </p>

                </div>
                <div class="right">
                    <img src="./public/images/Messages-pana.svg" alt="">
                </div>
            </div>
    </main>   
</body>
</html>