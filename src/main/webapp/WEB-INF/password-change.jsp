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
    <link rel="stylesheet" href="styles/password-change.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Recuperação de senha</title>
</head>
<body>
    <main>
        <div class="container">
            <div class="form-box">
                <div class="register-container">
                    <div class="top">
                        <h1><fmt:message key="passwordchange.reset"/></h1>
                        <p><fmt:message key="passwordchange.description"/></p>
                    </div>
                    <form method="POST" action="authPasswordChange">
                        <div class="input-box">
                            <label for="password"><fmt:message key="passwordchange.password"/></label>
                            <input type="password" class="input-field" name='password' placeholder="Digite a sua nova senha!" required>
                            <i class='bx bx-key'></i>
                        </div>
                        <div class="input-box" id="input_cod" style="display: none;">
                            <label for="cod"><fmt:message key="passwordchange.confirmpassword"/></label>
                            <input type="password" class="input-field" name="confirmpassword" placeholder="Confirme a nova senha!" required>
                            <i class='bx bx-key'></i>
                            <i class="fa-regular fa-id-card"></i>
                            <span class="invalid-password"><fmt:message key="passwordchange.invalidpassword"/></span>
                        </div>
                        <div class="input-box">
                            <input type="submit" class="submit" id="button" value="Continuar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <script>
        function validarSenha(password) {
            // Expressão regular para verificar o formato da senha
            var re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=]).{8,}$/;
;
            return re.test(password);
        }
    
        let button = document.querySelector("#button");
        button.addEventListener("click", (e) => {
            e.preventDefault(); // Evita o envio do formulário
    
            const password = document.querySelector("[name='password']").value; // Corrija o seletor aqui
            const password_invalid = document.querySelector("span.invalid-password");
            const inputCod = document.querySelector("#input_cod");
    
            if (!validarSenha(password)) {
                password_invalid.style.display = "flex"; // Corrija o nome da variável aqui
                inputCod.style.display = "none"; // Oculta o campo de código se a senha for inválida
            } else {
                password_invalid.style.display = "none"; // Oculta o <span> de senha inválida
                inputCod.style.display = "block"; // Exibe o campo de código se a senha for válida
            }
        });
    </script>
    
</body>
</html>