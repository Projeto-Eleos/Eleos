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
    <link rel="stylesheet" href="styles/register.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Cadastro</title>
</head>
<body>
    <main>
        <div class="container">
            <div class="form-box">
                <div class="register-container">
                    <div class="top">
                        <h1><fmt:message key="signup.first"/></h1>
                        <p><fmt:message key="signup.happy"/> <b>Eleos</b><fmt:message key="signup.place"/></p>
                        <div style="display: flex; flex-direction: column;">
                            <span><fmt:message key="signup.account"/> <a href="login" onclick="login()"><fmt:message key="signup.login"/></a></span>
                            <span><fmt:message key="signup.ong"/> <a href="sign-up-ong" onclick="login()"><fmt:message key="signup.ongregister"/></a></span>
                        </div>
                    </div>
                    <br>
                    <c:if test="${emailDuplicado != null}">
                        <div class="error-box">
                            <i class='bx bx-info-circle icon' style='color:#ffffff'  ></i>
                            <span class="erros">${emailDuplicado}</span>
                        </div>
                    </c:if>
                    <c:if test="${termosErro != null && termosErro}">
                        <div class="error-box">
                            <i class='bx bx-info-circle icon' style='color:#ffffff'  ></i>
                            <span class="erros"><fmt:message key="signup.accept"/></span>
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
                    <form method="POST" action="sign-up-donor">
                        <div class="two-forms">
                            <div class="input-box">
                                <label for="nome"><fmt:message key="signup.name"/></label>
                                <input type="text" class="input-field" name="firstname" placeholder="Digite seu nome" value="${nome}" autocomplete="given-name" maxlength="255">
                                <i class="bx bx-user"></i>
                            </div>
                            <div class="input-box">
                                <label for="sobrenome"><fmt:message key="signup.surname"/></label>
                                <input type="text" class="input-field" name="lastname" placeholder="Digite seu sobrenome" value="${sobrenome}" autocomplete="last-name" maxlength="255">
                                <i class='bx bx-user-circle'></i>
                            </div>
                        </div>
                        <div class="two-forms">
                            <div class="input-box">
                                <label for="phone"><fmt:message key="signup.phone"/></label>
                                <input type="text" class="input-field" id="phone"  name="phone" placeholder="Digite seu telefone" value="${telefone}" autocomplete="tel" maxlength="255">
                                <i class="bx bx-support"></i>
                            </div>
                            <div class="input-box">
                                <label for="cpf"><fmt:message key="signup.cpf"/></label>
                                <input type="text" class="input-field" id="cpf" name="cpf" placeholder="Digite seu CPF" value="${cpf}" autocomplete="on">
                                <i class='bx bx-user-circle'></i>
                            </div>
                        </div>
                        <div class="input-box">
                            <label for="email"><fmt:message key="signup.email"/></label>
                            <input type="email" class="input-field" id="email" name="email" placeholder="Digite seu endereço de email" value="${email}" autocomplete="email" maxlength="255">
                            <i class="bx bx-envelope"></i>
                        </div>
                        <div class="input-box">
                            <label for="birthdate"><fmt:message key="signup.datebirth"/></label>
                            <input type="date" class="input-field" id="birthdate" name="birthdate" placeholder="Data de nascimento"  value="${dataNascimento}" autocomplete="bday">
                            <i class='bx bxs-calendar' ></i>
                        </div>
                        <div class="input-box">
                            <label for="password"><fmt:message key="signup.password"/></label>
                            <input type="password" class="input-field" id="password" name="password" placeholder="Digite sua senha" autocomplete="current-password" >
                            <i class='bx bx-lock-open-alt' ></i>
                        </div>
                        <div class="input-box">
                            <label for="confirm-password"><fmt:message key="signup.confirmpassword"/></label>
                            <input type="password" class="input-field" id="confirm-password" name="confirm-password" placeholder="Confirme sua senha" autocomplete="new-password">
                            <i class='bx bx-lock-alt' ></i>
                        </div>
                        
                        <div class="two-col">
                            <div class="one">
                                <input type="checkbox" name="conditions-and-terms" id="termos">
                                <label for="termos"> <fmt:message key="signup.declaration"/> <a href="politics-privacity"><fmt:message key="signup.declaration1"/></a> <fmt:message key="signup.declaration2"/></label>
                            </div>
                            <div class="two">
                                <input type="checkbox" name="notificacions" id="notificacoes" value="${termos}">
                                <label for="notificacoes"> <fmt:message key="signup.notification"/></label>
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