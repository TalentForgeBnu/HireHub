<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub</title>
    <link rel="stylesheet" href="Recursos/Css/tela-instituicao-logado.css">
</head>
<body>
    <header>
            <div class="navbar">
                <div class="voltar">☰</div>
                <div class="nome">Hirehub</div>
                <img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="perfil" class="iconeperfil">
            </div>
        </header>
    <div>
        <p>Olá, ${instituicao.nome} Seja bem-vindo(a)!</p>
    </div>

    <div class="areadosbotoes">
        <div class="botao">
        <a href="${pageContext.request.contextPath}/recuperar-lista-turmas">
            <img src="Recursos/Imagens/logado-instituicao-turmas.png" alt="perfil" class="icone">
            </a>
            <label for="Turmas">Turmas</label>
        </div>
        <div class="botao">
        <a href="${pageContext.request.contextPath}/recuperar-lista-cursos">
            <img src="Recursos/Imagens/logado-instituicao-cursos.png" alt="perfil" class="icone">
            </a>
            <label for="Turmas">Cursos</label>
        </div>
        <div class="botao">
        <a href="${pageContext.request.contextPath}/recuperar-lista-vagas">
            <img src="Recursos/Imagens/logado-instituicao-turmas.png" alt="perfil" class="icone">
            </a>
            <label for="Vagas">Vagas</label>
    </div>
    </div>
</body>
</html>
