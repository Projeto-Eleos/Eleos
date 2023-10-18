<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="public/favicon.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/login.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Login</title>
</head>
<body>
    <main>
      <div class="left-side">
        <form class="content" method="post" action="signIn">
            <!-- Conteúdo do lado esquerdo -->
            <h1 id="title1">Bem-Vindo</h1>
            <p>Faça login e ajude a fazer a diferença!</p>
            <div class="input-box">
              <label for="email">Email:</label>
              <input type="email" class="input-field" name="email" placeholder="Digite seu endereço de email" value="${email}" required>
              <i class="bx bx-envelope"></i><br>
            </div>
            <div class="input-box">
              <label for="senha">Senha:</label>
              <div class="password-input">
                <i class='bx bx-lock-open-alt' id="cadeado"></i>
                <input type="password" class="input-field password" name="password" placeholder="Digite sua senha" value="${senha}" required>
                <i class="custom-icon" id="ver_desver"><img src="public/images/closed-eye.png" alt=""></i>
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
            <br>
            <a href="password-recover.html">Esqueceu sua senha?</a>
            <div class="input-box">
              <input type="submit" class="submit" value="Entrar" id="button">
            </div>  
        </form>
      </div>
      <div class="right-side">
        <div class="content">
              <!-- Conteúdo do lado direito -->
            <h1 id="title2">É novo aqui?</h1>
            <p id="subtitle">Junte-se à comunidade do Eleos! Crie sua conta e comece a fazer a diferença!</p>
          <div class="input-box">
            <a href="sign-up.jsp"><input type="submit" class="submit2" value="Comece por aqui"></a>
          </div> 
        </div>
      </div>
    </main>
    <script>
      //Botão para exibir e esconder a senha
      const icone = document.querySelector("#ver_desver");
      const passwordInput = document.querySelector('[name="password"]');
      const imagem = document.querySelector("img")
      icone.addEventListener("click", () => {
        if (passwordInput.type === 'password') {
          passwordInput.type = 'text';
          imagem.src = "public/images/eye.png"
        } else {
          passwordInput.type = 'password';
          imagem.src = "public/images/closed-eye.png"
        }
      });

      const button = document.querySelector("#button")

      //validar e-mail
      const email = document.querySelector("[name=\"email\"]").value
      var emailInput = document.querySelector("#email");
      var emailError = document.querySelector("#email-error");
      if(email.split("@").count(".") == 0){
        button.addEventListener("click",(e)=>{
          e.preventDefault();
          senhaError.style.display = "block";
          senhaInput.classList.add("input-error");
        })
      }else{
        emailError.style.display = "none";
        emailInput.classList.remove("input-error");
      }
      //validar senha
      function validarSenha(senha) {
        
        if (senha.length < 8) {
          return false;
        }

        // Verificar se a senha contém pelo menos um número
        if (!/[0-9]/.test(senha)) {
          return false;
        }

        // Verificar se a senha contém pelo menos uma letra maiúscula
        if (!/[A-Z]/.test(senha)) {
          return false;
        }

        // Verificar se a senha contém pelo menos um caractere especial
        if (!/[\W_]/.test(senha)) {
          return false;
        }

        return true;
      }

      var senhaInput = document.querySelector("#senha");
      var senhaError = document.querySelector("#senha-error");
      const senha = passwordInput.value
      if (validarSenha(senha)) {
                senhaError.style.display = "none";
                senhaInput.classList.remove("input-error");
            }
            else{
              button.addEventListener("click",(e)=>{
                e.preventDefault();
                senhaError.style.display = "block";
                senhaInput.classList.add("input-error");
                })
            }
    </script>
</body>
</html>