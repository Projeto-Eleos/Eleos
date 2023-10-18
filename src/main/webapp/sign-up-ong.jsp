<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                        <h1>Cadastro de Instituições</h1>
                        <p>Ao registrar sua instituição, você poderá aproveitar os recursos e oportunidades disponíveis para promover ações de caridade e causas significativas. Este é um passo importante para se juntar a nossa comunidade solidária e fazer a diferença.</p>
                        <div style="display: flex; flex-direction: column;">
                            <span>Já tem uma conta? <a href="sign-in.jsp" onclick="login()">Login</a></span>
                            <span>É um doador? <a href="sign-up.jsp" onclick="login()">Cadastro de 
                            Doadores</a></span>
                        </div>
                    </div>
                    <% 
                        String errors = (String) request.getAttribute("erros");
                        if (errors != null && !errors.isBlank()) {   
                            String[] erroArray = errors.split(";");
                            for (String erro : erroArray) {
                        %>
                                <div class="error-box">
                                    <i class='bx bx-info-circle icon' style='color:#ffffff'  ></i>
                                    <span class="erros"><%= erro %></span>
                                </div>
                        <%
                            }
                        }
                    %>
                    <form method="POST" action="signUpOng">
                        <div class="two-forms">
                            <div class="input-box">
                                <label for="razaoSocial">Razão Social:</label>
                                <input type="text" class="input-field" name="razaoSocial" placeholder="Digite a razão social" value="${razaoSocial}" required>
                                <i class="bx bx-user"></i>
                            </div>
                            <div class="input-box">
                                <label for="phone">Telefone:</label>
                                <input type="text" class="input-field" name="phone" placeholder="Telefone de contato" value="${telefone}" required>
                                <i class='bx bx-phone'></i>
                            </div>
                        </div>
                        <div class="input-box">
                            <label for="email">Email:</label>
                            <input type="email" class="input-field" name="email" placeholder="Digite seu endereço de email" value="${email}" required>
                            <i class="bx bx-envelope"></i>
                        </div>
                        <div class="input-box">
                            <label for="adress">Endereço:</label>
                            <input type="text" class="input-field" name="adress" placeholder="Digite o endereço da instituição" value="${endereco}" required>
                            <i class='bx bx-map' ></i>
                        </div>
                        <div class="input-box">
                            <label for="date">CNPJ:</label>
                            <input type="text" class="input-field" name="cnpj" placeholder="Digite o CNPJ da instituição" value="${CNPJ}" required>
                            <i class='bx bx-info-circle'></i>
                        </div>
                        <div class="input-box">
                            <label for="senha">Senha:</label>
                            <input type="password" class="input-field" name="password" placeholder="Digite sua senha" required>
                            <i class='bx bx-lock-open-alt' ></i>
                        </div>
                        <div class="input-box">
                            <label for="senha">Confirme sua senha:</label>
                            <input type="password" class="input-field" name="confirm-password" placeholder="Confirme sua senha" required>
                            <i class='bx bx-lock-alt' ></i>
                        </div>
                        <div class="col">
                            <div class="one">
                                <input type="checkbox" name="conditions-and-terms" id="termos">
                                <label for="termos"> Declaro que li e concordo com os <a href="#">Termos de Uso</a> de “Doações Eleos”.</label>
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