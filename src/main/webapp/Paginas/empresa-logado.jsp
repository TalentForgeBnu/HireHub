<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/Recursos/Css/tela-logado.css">
</head>
<body>
    <header>
        <div class="navbar">
            <div class="voltar">☰</div>
            <div class="nome">Hirehub</div>
            <img src="https://via.placeholder.com/50" alt="perfil" class="iconeperfil">
        </div>
    </header>
    <div>
        <p>Olá, <c:out value="${empresa.nome}"/>! Seja bem-vindo(a)!</p>
    </div>

    <div class="areadosbotoes">
        <div class="botao">
            Adicionar Vagas
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        <div class="botao">
            Vagas
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
    </div>
</body>
</html>
