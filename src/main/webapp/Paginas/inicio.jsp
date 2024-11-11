<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/inicio.css">
</head>

<body>
    <header>
        <div class="voltar">☰</div>
        <div class="nome">Hirehub</div>
        <div class="botao" onclick="window.location.href='${pageContext.request.contextPath}/login'"><img src="#" alt="Login">Login</div>
        <div class="botao" onclick="window.location.href='${pageContext.request.contextPath}/Paginas/cadastro-acesso.jsp'"><img src="#" alt="Cadastro"> Cadastro</div>
    </header>
    <main>
        <img src="#">
        <h1>Plataforma de capacitação e contratação inclusiva</h1>
        <h3>Transformando vidas com acesso a emprego e capacitação</h3>
    </main>
    <div class="caixasobre">
        <img src="#">
        <h1>Sobre Nós</h1>
        <p>No HireHub, nossa missão é promover a inclusão social e econômica de grupos em risco social.
            Trabalhamos para garantir que cada talento tenha uma chance justa de acessar o mercado de trabalho,
            integrando a capacitação com as demandas atuais do mercado. Nosso objetivo é facilitar a construção de
            trajetórias de sucesso
            e aproximar cada vez mais o aprendizado das oportunidades profissionais.</p>
    </div>
    <div class="caixasobrerev">
        <h1>Capacitação</h1>
        <p>Acreditamos que a capacitação é o primeiro passo para transformar vidas.
            O HireHub oferece acesso a cursos e treinamentos, permitindo que os candidatos
            desenvolvam as habilidades necessárias para enfrentar os desafios do mercado de trabalho.</p>
        <img src="#">
    </div>
    <div class="caixasobre">
        <img src="#">
        <h1>Mercado de Trabalho</h1>
        <p>Conectar talentos a oportunidades é o nosso foco. Através de nossa plataforma,
            empregadores podem encontrar candidatos qualificados e comprometidos,
            enquanto os profissionais têm acesso a vagas que correspondem às suas habilidades e aspirações,
            criando uma relação de ganho mútuo.</p>
    </div>
    <div class="caixasobrerev">
        <h1>Inclusão Social</h1>
        <p>Nosso compromisso é com a inclusão de grupos vulneráveis no mercado de trabalho.
            O HireHub trabalha para garantir que as oportunidades cheguem a quem mais precisa,
            promovendo a igualdade de condições e criando uma sociedade mais justa e inclusiva para todos.</p>
        <img src="#">
    </div>

    <footer>
        <p class="Email">talentforgeblu@gmail.com</p>
        <div class="oscoisa">
            <a href="#">Termos de Serviço</a>
            <a href="#">Políticas de Privacidade</a>
        </div>
    </footer>
</body>

</html>