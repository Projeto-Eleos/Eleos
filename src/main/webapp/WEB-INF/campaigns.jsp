<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="general.campaign"/></title>
    <link rel="stylesheet" href="./styles/campaigns.css">
    <link rel="stylesheet" href="./styles/global.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <header>
        <a class="logo" href="./home">Eleos</a>
        <div class="header-right">
            <a id="item" href="./home"><fmt:message key="general.home"/></a>
            <a class="active" href="./campaigns"><fmt:message key="general.campaign"/></a>
            <a id="item" href="./contacts"><fmt:message key="general.contact"/></a>
            <a class="logado" id="item" href="#"><i class="bx bx-user"></i></a>
        </div>
    </header>
    <div class="container">
        <div class="sidebar">
            <h2><fmt:message key="campaign.filter"/></h2>
            <h3><fmt:message key="campaign.type"/></h3>
            <ul>
                <li><a href="?donationType=alimento"><fmt:message key="campaign.type1"/></a></li>
                <li><a href="?donationType=roupa"><fmt:message key="campaign.type2"/></a></li>
                <li><a href="?donationType=brinquedo"><fmt:message key="campaign.type3"/></a></li>
                <li><a href="?donationType=higiene"><fmt:message key="campaign.type4"/></a></li>
                <li><a href="?donationType=escola"><fmt:message key="campaign.type4"/></a></li>
            </ul>
            <h3><fmt:message key="campaign.category"/></h3>
            <ul>
                <li><a href="#"><fmt:message key="campaign.category1"/></a></li>
                <li><a href="#"><fmt:message key="campaign.category2"/></a></li>
                <li><a href="#"><fmt:message key="campaign.category3"/></a></li>
                <li><a href="#"><fmt:message key="campaign.category4"/></a></li>
                <li><a href="#"><fmt:message key="campaign.category5"/></a></li>
            </ul>
        </div>
        <div class="content">
            <div class="product">
                <img src="./public/images/doação-alimentos1.jpg" alt="Produto 1">
                <h3><fmt:message key="campaign.campaigntitle1"/></h3>
                <p><fmt:message key="campaign.description1"/></p>
                <button><fmt:message key="campaign.join"/></button>
            </div>
            <div class="product">
                <img src="./public/images/doação-roupas.jpg" alt="Produto 2">
                <h3><fmt:message key="campaign.campaigntitle2"/></h3>
                <p><fmt:message key="campaign.description2"/></p>
                <button><fmt:message key="campaign.join"/></button>
            </div>
            <div class="product">
                <img src="./public/images/doação-brinquedos.jpg" alt="Produto 1">
                <h3><fmt:message key="campaign.campaigntitle3"/></h3>
                <p><fmt:message key="campaign.description3"/></p>
                <button><fmt:message key="campaign.join"/></button>
            </div>
            <div class="product">
                <img src="./public/images/doação-higiene.jpg" alt="Produto 2">
                <h3><fmt:message key="campaign.campaigntitle4"/></h3>
                <p><fmt:message key="campaign.description4"/></p>
                <button><fmt:message key="campaign.join"/></button>
            </div><div class="product">
                <img src="./public/images/doação-material.jpg" alt="Produto 1">
                <h3><fmt:message key="campaign.title5"/></h3>
                <p><fmt:message key="campaign.description5"/></p>
                <button><fmt:message key="campaign.join"/></button>
            </div>
            <div class="product">
                <img src="./public/images/doação-roupas.jpg" alt="Produto 2">
                <h3><fmt:message key="campaign.campaigntitle6"/></h3>
                <p><fmt:message key="campaign.description6"/></p>
                <button><fmt:message key="campaign.join"/></button>
            </div>
</body>
</html>