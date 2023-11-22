<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="public/favicon.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/registerOng.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Cadastro</title>
</head>
<body>
    <main>
        <div class="container">
            <div class="form-box">
                <div class="register-container">
                    <div class="top">
                        <h1><fmt:message key="signupong.ongregister"/></h1>
                        <p><fmt:message key="signupong.ongregisterdescription"/></p>
                        <div style="display: flex; flex-direction: column;">
                            <span><fmt:message key="signupong.account"/> <a href="login" onclick="login()"><fmt:message key="signupong.login"/></a></span>
                            <span><fmt:message key="signupong.donor"/> <a href="sign-up-donor" onclick="login()"><fmt:message key="signupong.donorregister"/></a></span>
                        </div>
                    </div>
                    <br>
                    <c:if test="${termosErro != null && termosErro}">
                        <div class="error-box">
                            <i class='bx bx-info-circle icon' style='color:#ffffff'  ></i>
                            <span class="erros"><fmt:message key="signupong.accept"/></span>
                        </div>
                    </c:if>
                    <c:if test="${erros != null}">
                        <c:forEach var="erro" items="${erros}">
                            <div class="error-box">
                                <i class='bx bx-info-circle icon' style='color:#ffffff'  ></i>
                                <span class="erros">${erro.message}</span>
                            </div>
                        </c:forEach>
                    </c:if>
                    <br>
                    <form method="POST" action="sign-up-ong">
                        <div class="two-forms">
                            <div class="input-box">
                                <label for="razaoSocial"><fmt:message key="signupong.social"/></label>
                                <input type="text" class="input-field" name="razaoSocial" placeholder="Digite a razão social" value="${razaoSocial}" autocomplete="organization-title" maxlength="255">
                                <i class="bx bx-user"></i>
                            </div>
                            <div class="input-box">
                                <label for="phone"><fmt:message key="signupong.phone"/></label>
                                <input type="text" class="input-field" name="phone" placeholder="Telefone de contato" value="${telefone}" autocomplete="tel" maxlength="255">
                                <i class='bx bx-phone'></i>
                            </div>
                        </div>
                        <div class="input-box">
                            <label for="email"><fmt:message key="signupong.email"/></label>
                            <input type="email" class="input-field" name="email" placeholder="Digite seu endereço de email" value="${email}" autocomplete="email" maxlength="255">
                            <i class="bx bx-envelope"></i>
                        </div>
                        <div class="input-box">
                            <label for="address"><fmt:message key="signupong.address"/></label>
                            <input type="text" class="input-field" name="address" placeholder="Digite o endereço da instituição" value="${endereco}" autocomplete="address-level1" maxlength="255">
                            <i class='bx bx-map' ></i>
                        </div>
                        <div class="input-box">
                            <label for="date"><fmt:message key="signupong.cnpj"/></label>
                            <input type="text" class="input-field" name="cnpj" placeholder="Digite o CNPJ da instituição" value="${CNPJ}" autocomplete="on">
                            <i class='bx bx-info-circle'></i>
                        </div>
                        <div class="input-box">
                            <label for="senha"><fmt:message key="signupong.password"/></label>
                            <input type="password" class="input-field" name="password" placeholder="Digite sua senha" autocomplete="current-password" maxlength="255">
                            <i class='bx bx-lock-open-alt' ></i>
                        </div>
                        <div class="input-box">
                            <label for="senha"><fmt:message key="signupong.confirmpassword"/></label>
                            <input type="password" class="input-field" name="confirm-password" placeholder="Confirme sua senha" autocomplete="new-password" maxlength="255">
                            <i class='bx bx-lock-alt' ></i>
                        </div>
                        <div class="col">
                            <div class="one">
                                <input type="checkbox" name="conditions-and-terms" id="termos" value="${termos}">
                                <label for="termos"> <fmt:message key="signupong.declaration"/> <a href="politics-privacity"><fmt:message key="signupong.declaration1"/></a> <fmt:message key="signupong.declaration2"/></label>
                            </div>
                            <div class="input-box">
                            <input type="submit" class="submit" value="Criar Conta">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>
</html>