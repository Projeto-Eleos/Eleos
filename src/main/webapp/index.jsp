<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="public/favicon.svg" type="image/svg+xml">
        <link rel="stylesheet" href="styles/home.css" type="text/css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <title>Página Inicial</title>
    </head>
    <body>
        <header>
            <h1><a  class="logo" href="#">Eleos</a></h1>
            <nav>
                <ul>
                    <li><a href="#">Página Inicial</a></li>
                    <li><a href="campaigns.html">Campanhas</a></li>
                    <li><a href="contacts.html">Contato</a></li>
                </ul>
                <div class="header-buttons">
                    <a href="sign-in.html" class="sign-in">Login</a>
                    <a href="sign-up.html" class="sign-up">Cadastre-se</a>
                </div>
            </nav>
        </header>
        <div class="container">
            <div class="left">
                <span>Bem vindo à Eleos!</span>
                <h1>JUNTOS, PODEMOS TRANSFORMAR VIDAS!</h1>
                <p class="descricao">Junte-se a nós nesta jornada de solidariedade. Sua contribuição é a esperança que alguém precisa, o suporte que uma causa necessita e o combustível para um mundo melhor.<br><br>Faça a diferença hoje conosco.</p>
                <div class="left-flex">
                    <button>QUERO MUDAR O MUNDO!</button>
                    <span id="span">Saiba mais</span>
                </div>
            </div>
            <div class="right">
                <img src="public/images/Charity-amico.svg" alt="">
            </div>
        </div>
        <div class="grid-container">
            <div class="grid-item">
                <i class='bx bx-current-location'></i>
                <div class="description">SUPORTE ÀS ONGS LOCAIS</div>
            </div>
            <div class="grid-item">
                <i class='bx bx-heart'></i>
                <div class="description">DIVERSIDADE DE CAUSAS</div>
            </div>
            <div class="grid-item">
                <i class='bx bxs-package'></i>
                <div class="description">ACOMPANHAMENTO TRANSPARENTE</div>
            </div>
            <div class="grid-item">
                <i class='bx bx-home'></i>
                <div class="description">FACILIDADE E CONVENIÊNCIA</div>
            </div>
            <div class="grid-item">
                <i class='bx bx-group'></i>
                <div class="description">IMPACTO DIRETO</div>
            </div>
            <div class="grid-item">
                <i class='bx bx-id-card'></i>
                <div class="description">OPORTUNIDADES DE VOLUNTARIADO</div>
            </div>
        </div>
        <div class="donation">
        <div class="cards-container">
            <div class="textos"><h2>Como realizar uma doação</h2>
            <p class="para">Queremos tornar o processo de doação o mais fácil e eficiente possível. Para ajudá-lo nessa jornada de generosidade, criamos um simples passo a passo que permite que você faça suas doações de forma rápida e conveniente. <b>Veja como funciona:</b></p></div>
                
            <div class="card">
                <img class="img-tuto" src="public/images/Account-amico.svg" alt="Ilustração de Acesso à Conta">
                <h3>Acesso à Conta</h3>
                <p >O usuário entra em sua conta pessoal no sistema, utilizando seu nome de usuário e senha.</p>
            </div>
            <div class="card">
                <img class="img-tuto" src="public/images/Forms-amico.svg" alt="Ilustração de Acesso à Conta">
                <h3>Formulário de doação</h3>
                <p >O usuário preenche um pequeno formulário com informações sobre o que deseja doar.</p>
            </div>
            <div class="card">
                <img class="img-tuto" src="public/images/Editorial-commision-bro.svg" alt="Ilustração de Acesso à Conta">
                <h3>Verificação e orientações</h3>
                <p >Após o envio do formulário, a equipe do Eleos realiza a verificação das informações fornecidas.</p>
            </div>
        </div>
        </div>
    
        <div class="footer">
            <h3>Eleos.</h3>
            <p>Informações Contatos Sobre Nós Política de Privacidade Termos de Uso</p>
            <p>&copy; 2023 Doações Eleos.</p>
        </div>
    </body>
</html>