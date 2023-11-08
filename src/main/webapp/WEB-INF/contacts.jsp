<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <c:if test="${!(sessionScope.user != null)}">
                <a  href="./login" class="login"><fmt:message key="general.sign-in"/></a>
                <a href="./sign-up-donor" class="cadastro"><fmt:message key="general.sign-up"/></a>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <a class="logado" id="item" href="#"><i class="bx bx-user"></i></a>
            </c:if>
        </div>
    </header>
    <main>
            <div class="conteiner">
                <div class="left">
                    <h1>Contatos</h1>
                    <p class="descricao">Nossa equipe está ansiosa para ouvir você e trabalhar juntos para causar um impacto positivo no mundo. Seja uma pergunta, sugestão ou desejo de se envolver, estamos aqui para ajudar. Não hesite, entre em contato conosco hoje mesmo e junte-se à nossa missão de mudar vidas!<br><br>
                        <i class='bx bx-envelope'></i>E-mail: projetoeleos@gmail.com<br>
                        <i class='bx bx-phone'></i>Telefone: (11) 5588-2112 | (11) 99151-9861
                    </p>

                </div>
                <div class="right">
                    <img src="./public/images/Messages-pana.svg" alt="">
                </div>
            </div>
    </main>   
</body>
</html>