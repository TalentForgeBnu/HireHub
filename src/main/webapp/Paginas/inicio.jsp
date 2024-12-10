<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Início</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/inicio.css">
</head>
<body>
    <header>
        <div class="voltar">☰</div>
        <div class="nome">HireHub</div>
        <div class="botao-direita">
            <div class="botao-login">
                <img src="${pageContext.request.contextPath}/Recursos/Vetores/icone-login-home.svg" alt="Login">
                <button onclick="window.location.href='${pageContext.request.contextPath}/login'">Login</button>
            </div>
            <div class="botao-cadastro">
                <img src="${pageContext.request.contextPath}/Recursos/Vetores/icone-cadastro-home.svg" alt="Cadastro">
                <button onclick="window.location.href='${pageContext.request.contextPath}/cadastro'">Cadastro</button>
            </div>
        </div>
    </header>

    <div class="container">
        <div id="titulo">
            <div class="titulo-conteudo">
                <img src="${pageContext.request.contextPath}/Recursos/Imagens/foto-home.png" alt="Imagem do HireHub">
                <h1>HireHub</h1>
            </div>
        </div>
        <div id="cards">
            <div id="inclusao">
                <h2>Inclusão</h2>
                <p>Oferecemos oportunidades para grupos em situação de vulnerabilidade, reduzindo desigualdades no mercado de trabalho.</p>
            </div>
            <div id="capacitacao">
                <h2>Capacitação</h2>
                <p>Cursos personalizados alinhados às demandas do mercado, preparando indivíduos para as exigências atuais.</p>
            </div>
            <div id="contratacao">
                <h2>Contratação</h2>
                <p>Conectamos os candidatos qualificados à empresas, facilitando o processo de contratação inclusiva.</p>
            </div>
        </div>
    </div>

    <div id="sobre-o-hirehub">
        <h2>Sobre o HireHub</h2>
        <p>Nós somos a Talent Forge, uma equipe dedicada a transformar o mercado de trabalho por meio da inclusão e capacitação. Nosso projeto, o HireHub, nasceu do desejo de combater as desigualdades sociais, criando oportunidades reais para grupos vulneráveis. Acreditamos que a educação e a inclusão são ferramentas essenciais para mudar vidas e promover a igualdade.</p>
        <p>Com o HireHub, buscamos conectar empresas, instituições de ensino, professores e alunos em um ecossistema colaborativo. Nossa missão é reduzir barreiras de entrada ao mercado de trabalho e alinhar a capacitação às demandas reais das empresas, garantindo que cada indivíduo tenha acesso a um futuro mais promissor.</p>
        <p>Juntos, estamos moldando um mundo mais inclusivo e acessível para todos.</p>
    </div>

	<footer>
		<p class="Email">talentforgeblu@gmail.com</p>
		<div class="link">
			<a href="#">Termos de Serviço</a>
			<a href="#">Políticas de Privacidade</a>
		</div>
	</footer>
	
</body>
</html>
