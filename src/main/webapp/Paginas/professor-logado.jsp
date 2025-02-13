<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub</title>
    <link rel="stylesheet" href="Recursos/Css/tela-professor-logado.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Recursos/Css/menu.css">
    
</head>
<body>
    <header>
            <div class="navbar">
       	<div class="voltar">☰</div>
        <div class="nome">HireHub</div>
            <jsp:include page="/Paginas/menu.jsp" />
        <script src="<%=request.getContextPath()%>/Recursos/Scripts/menu.js"></script>
        </div>
        </header>
    <div>
        <p>Olá, ${professor.nome} Seja bem-vindo(a)!</p>
    </div>

    <div class="areadosbotoes">
        <div class="botao">
        <a href="${pageContext.request.contextPath}/recuperar-lista-alunos">
            <img src="Recursos/Vetores/logado-professor-alunos.svg" alt="perfil" class="icone">
            </a>
            <label for="Alunos">Alunos</label>
        </div>
        <div class="botao">
        <a href="${pageContext.request.contextPath}/recuperar-lista-turmas">
            <img src="Recursos/Vetores/logado-professor-alunos.svg" alt="perfil" class="icone">
            </a>
            <label for="Turmas">Turmas</label>
        </div>
        <div class="botao">
        <a href="${pageContext.request.contextPath}/recuperar-lista-alunos">
            <img src="Recursos/Vetores/logado-professor-dossie.svg" alt="perfil" class="icone">
            </a>
            <label for="Dossie">Dossiê</label>
    </div>
    </div>
</body>
</html>
