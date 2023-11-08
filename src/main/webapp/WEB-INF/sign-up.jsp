<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <h1>Primeira vez por aqui?</h1>
                        <p>Estamos felizes em recebê-lo no <b>Eleos</b>, um lugar onde a generosidade encontra o poder de transformar vidas. Ao criar sua conta, você terá acesso a uma plataforma que conecta doadores como você às ONGs que estão fazendo um impacto real no mundo. Vamos começar a fazer a diferença juntos!</p>
                        <div style="display: flex; flex-direction: column;">
                            <span>Já tem uma conta? <a href="login" onclick="login()">Login</a></span>
                            <span>É uma instituiçao? <a href="sign-up-ong" onclick="login()">Cadastro de 
                            Instituiçoes</a></span>
                        </div>
                    </div>
                    <br>
                    <c:if test="!${erros.isEmpty()}">
                        <c:forEach var="erro" items="${erros}">
                            <div class="error-box">
                                <i class='bx bx-info-circle icon' style='color:#ffffff'  ></i>
                                <span class="erros">${erro.propertyPath} - ${erro.message}</span>
                            </div>
                        </c:forEach>
                    </c:if>
                    <br>
                    <form method="POST" action="sign-up-donor">
                        <div class="two-forms">
                            <div class="input-box">
                                <label for="nome">Nome:</label>
                                <input type="text" class="input-field" name="firstname" placeholder="Digite seu nome" value="${nome}" autocomplete="given-name" maxlength="255">
                                <i class="bx bx-user"></i>
                            </div>
                            <div class="input-box">
                                <label for="sobrenome">Sobrenome:</label>
                                <input type="text" class="input-field" name="lastname" placeholder="Digite seu sobrenome" value="${sobrenome}" autocomplete="last-name" maxlength="255">
                                <i class='bx bx-user-circle'></i>
                            </div>
                        </div>
                        <div class="two-forms">
                            <div class="input-box">
                                <label for="phone">Telefone:</label>
                                <input type="text" class="input-field" id="phone"  name="phone" placeholder="Digite seu telefone" value="${telefone}" autocomplete="tel" maxlength="255">
                                <i class="bx bx-support"></i>
                            </div>
                            <div class="input-box">
                                <label for="cpf">CPF:</label>
                                <input type="text" class="input-field" id="cpf" name="cpf" placeholder="Digite seu CPF" value="${cpf}" autocomplete="on">
                                <i class='bx bx-user-circle'></i>
                            </div>
                        </div>
                        <div class="input-box">
                            <label for="email">Email:</label>
                            <input type="email" class="input-field" id="email" name="email" placeholder="Digite seu endereço de email" value="${email}" autocomplete="email" maxlength="255">
                            <i class="bx bx-envelope"></i>
                        </div>
                        <div class="input-box">
                            <label for="birthdate">Data de Nascimento:</label>
                            <input type="date" class="input-field" id="birthdate" name="birthdate" placeholder="Data de nascimento"  value="${dataNascimento}" autocomplete="bday">
                            <i class='bx bxs-calendar' ></i>
                        </div>
                        <div class="input-box">
                            <label for="password">Senha:</label>
                            <input type="password" class="input-field" id="password" name="password" placeholder="Digite sua senha" autocomplete="current-password" >
                            <i class='bx bx-lock-open-alt' ></i>
                        </div>
                        <div class="input-box">
                            <label for="confirm-password">Confirme sua senha:</label>
                            <input type="password" class="input-field" id="confirm-password" name="confirm-password" placeholder="Confirme sua senha" autocomplete="new-password">
                            <i class='bx bx-lock-alt' ></i>
                        </div>
                        
                        <div class="two-col">
                            <div class="one">
                                <input type="checkbox" name="conditions-and-terms" id="termos">
                                <label for="termos"> Declaro que li e concordo com os <a href="politics-privacity">Termos de Uso</a> de “Doações Eleos”.</label>
                            </div>
                            <div class="two">
                                <input type="checkbox" name="notificacions" id="notificacoes" value="${termos}">
                                <label for="notificacoes"> Desejo receber notificações por E-mail relacionadas às minhas doações, atualizações de campanhas e novidades sobre as ONGs.</label>
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