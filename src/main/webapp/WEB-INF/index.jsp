<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="homepage.home"/></title>
    <link rel="stylesheet" href="./styles/home.css">
    <link rel="stylesheet" href="./styles/global.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body> 
    <header>
        <a class="logo" href="./home">Eleos</a>
        <div class="header-right">
            <a class="active" href="/home"><fmt:message key="homepage.home"/></a>
            <a id="item" href="./campaigns"><fmt:message key="homepage.campaign"/></a>
            <a id="item" href="./contacts"><fmt:message key="homepage.contact"/></a>
            <a  href="./login" class="login"><fmt:message key="homepage.sign-in"/></a>
            <a href="./sign-up-donor" class="cadastro"><fmt:message key="homepage.sign-up"/></a>
        </div>
    </header>
    <div class="conteiner">
        <div class="left">
            <span><fmt:message key="homepage.welcome"/></span>
            <h1><fmt:message key="homepage.slogan"/></h1>
            <p class="descricao"><fmt:message key="homepage.description-pt-1"/><br><br><fmt:message key="homepage.description-pt-2"/></p>
            <div class="left-flex">
                <a href="./login"><button><fmt:message key="homepage.slogan-description"/></button></a>
                <a href="./campaigns"><span id="span"><fmt:message key="homepage.learn-more"/></span></a>
            </div>
        </div>
        <div class="right">
            <img src="./public//images/Charity-amico.svg" alt="">
        </div>
    </div>
    <div class="beneficios">
    <div class="grid-container">
        <div class="grid-item">
            <i class='bx bx-current-location'></i>
            <div class="description"><fmt:message key="homepage.grid1"/></div>
        </div>
        <div class="grid-item">
            <i class='bx bx-heart'></i>
            <div class="description"><fmt:message key="homepage.grid2"/></div>
        </div>
        <div class="grid-item">
            <i class='bx bxs-package'></i>
            <div class="description"><fmt:message key="homepage.grid3"/></div>
        </div>
        <div class="grid-item">
            <i class='bx bx-home'></i>
            <div class="description"><fmt:message key="homepage.grid4"/></div>
        </div>
        <div class="grid-item">
            <i class='bx bx-group'></i>
            <div class="description"><fmt:message key="homepage.grid5"/></div>
        </div>
        <div class="grid-item">
            <i class='bx bx-id-card'></i>
            <div class="description"><fmt:message key="homepage.grid6"/></div>
        </div>
    </div></div>
    
    <div class="donation" id="donation">
        <div class="textos"><h2><fmt:message key="homepage.title2"/></h2>
        <p class="para"><fmt:message key="homepage.description2"/><b><fmt:message key="homepage.slogan-description2"/></b></p></div>
    <div class="cards-container">
        <div class="card">
            <img class="img-tuto" src="./public//images/Account-amico.svg" alt="Ilustração de Acesso à Conta">
            <h3><fmt:message key="homepage.step-title-1"/></h3>
            <p ><fmt:message key="homepage.step-1"/></p>
        </div>
        <div class="card">
            <img class="img-tuto" src="./public//images/Charity-amico.svg" alt="Ilustração de Acesso à Conta">
            <h3><fmt:message key="homepage.step-title-2"/></h3>
            <p ><fmt:message key="homepage.step-2"/></p>
        </div>
        <div class="card">
            <img class="img-tuto" src="./public//images/Forms-amico.svg" alt="Ilustração de Acesso à Conta">
            <h3><fmt:message key="homepage.step-title-3"/></h3>
            <p ><fmt:message key="homepage.step-3"/></p>
        </div>
        <div class="card">
            <img class="img-tuto" src="./public/images/Editorial-commision-bro.svg" alt="Ilustração de Acesso à Conta">
            <h3><fmt:message key="homepage.step-title-4"/></h3>
            <p ><fmt:message key="homepage.step-4"/></p>
        </div>
    </div>
</div>
<div class="sobrenos">
    <div class="sobre-content"><h2><fmt:message key="homepage.about-us"/></h2>
<p class="para">
    <fmt:message key="homepage.about-us-description-pt1"/><br><br>
    <fmt:message key="homepage.about-us-description-pt2"/><br><br>
    <fmt:message key="homepage.about-us-description-pt3"/><br><br>
    <fmt:message key="homepage.about-us-description-pt4"/>
</p>
</div>

</div>
<footer>
    <div class="container">
        <h1 class="Logo2">Eleos.</h1>
        <p><fmt:message key="homepage.description-3"/></p>
        <a href="#"><fmt:message key="homepage.tag1"/></a>
        <a href="./politics-privacity">| <fmt:message key="homepage.tag2"/> |</a>
        <a href="./contacts"><fmt:message key="homepage.tag3"/></a>
    </div>
    <p class="copyright">&copy; 2023 Doações Eleos | Eleos</p>
</footer>
</body>
