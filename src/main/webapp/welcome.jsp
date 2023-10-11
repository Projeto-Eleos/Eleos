<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Inicial</title>
    <link rel="stylesheet" href="./styles/home.css">
    <link rel="stylesheet" href="./styles/global.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <header>
        <a class="logo" href="./index.jsp">Eleos</a>
        <div class="header-right">
            <a class="active" href="#home">Página Inicial</a>
            <a id="item" href="./campaigns.html">Campanhas</a>
            <a id="item" href="./contacts.html">Contato</a>
            <a id="item" href="#"><%=request.getAttribute("email")%></a>
        </div>
    </header>
    <div class="conteiner">
        <div class="left">
            <span>Bem vindo à Eleos!</span>
            <h1>JUNTOS, PODEMOS TRANSFORMAR VIDAS!</h1>
            <p class="descricao">Junte-se a nós nesta jornada de solidariedade. Sua contribuição é a esperança que alguém precisa, o suporte que uma causa necessita e o combustível para um mundo melhor.<br><br>Faça a diferença hoje conosco.</p>
            <div class="left-flex">
                <a href="./sign-in.html"><button>QUERO MUDAR O MUNDO!</button></a>
                <a href="#donation"><span id="span">Saiba mais</span></a>
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
    </div></div>
    
    <div class="donation" id="donation">
        <div class="textos"><h2>Como realizar uma doação</h2>
        <p class="para">Queremos tornar o processo de doação o mais fácil e eficiente possível. Para ajudá-lo nessa jornada de generosidade, criamos um simples passo a passo que permite que você faça suas doações de forma rápida e conveniente. <b>Veja como funciona:</b></p></div>
    <div class="cards-container">
        <div class="card">
            <img class="img-tuto" src="./public//images/Account-amico.svg" alt="Ilustração de Acesso à Conta">
            <h3>Acesso à Conta</h3>
            <p >O usuário entra em sua conta pessoal no sistema, utilizando seu nome de usuário e senha.</p>
        </div>
        <div class="card">
            <img class="img-tuto" src="./public//images/Charity-amico.svg" alt="Ilustração de Acesso à Conta">
            <h3>Selecione a Campanha</h3>
            <p >O usuário escolhe a causa que deseja apoiar entre várias opções disponíveis.</p>
        </div>
        <div class="card">
            <img class="img-tuto" src="./public//images/Forms-amico.svg" alt="Ilustração de Acesso à Conta">
            <h3>Formulário de doação</h3>
            <p >O usuário preenche um pequeno formulário com informações sobre o que deseja doar.</p>
        </div>
        <div class="card">
            <img class="img-tuto" src="./public/images/Editorial-commision-bro.svg" alt="Ilustração de Acesso à Conta">
            <h3>Verificação e orientações</h3>
            <p >Após o envio do formulário, a equipe do Eleos realiza a verificação das informações fornecidas.</p>
        </div>
    </div>
</div>
<div class="sobrenos">
    <div class="sobre-content"><h2>Sobre nós.</h2>
<p class="para">
    Aqui, acreditamos no poder transformador das pequenas ações. Estamos comprometidos em conectar pessoas generosas a organizações que fazem a diferença em nossas comunidades.<br><br>
Junte-se a nós nessa jornada de solidariedade e empatia. Cada doação que você fizer através do nosso sistema terá um impacto real, ajudando a melhorar vidas, preservar o meio ambiente e construir um mundo mais justo.
Nós acreditamos que todos têm o poder de fazer mudanças significativas, não importa o tamanho da contribuição. Cada gesto de generosidade conta, e juntos podemos criar um impacto duradouro.<br><br>
Explore nosso sistema e descubra as incríveis ONGs parceiras que estão transformando o mundo com seu trabalho incansável.<br><br>
Não espere mais para começar a fazer parte dessa corrente do bem. Sua doação pode ser a esperança que alguém precisa, o apoio que uma causa necessita ou a mudança que o mundo anseia.
A equipe Eleos
</p>
</div>

</div>
<footer>
    <div class="container">
        <h1 class="Logo2">Eleos.</h1>
        <p>A Eleos é uma organização dedicada a fazer a diferença no mundo. Nossa missão é oferecer apoio e esperança àqueles que mais precisam, através de nossos programas de entrega de doações. Com a generosidade de pessoas como você, conseguimos impactar positivamente inúmeras vidas.</p>
        <a href="#">Informações</a>
        <a href="./politics-and-privacity.html">| Política de Privacidade |</a>
        <a href="./contacts.html">Entre em contato</a>
    </div>
    <p class="copyright">&copy; 2023 Doações Eleos | Eleos</p>
</footer>
</body>
