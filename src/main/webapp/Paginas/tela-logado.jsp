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
        <header>
            <div class="navbar">
                <div class="voltar">☰</div>
                <div class="nome">Hirehub</div>
                <img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="perfil" class="iconeperfil">
            </div>
        </header>
    </header>
    <div>
        <p>Olá, <c:out value="${usuario.nome}"/>! Seja bem-vindo(a)!</p>
    </div>

    <div class="areadosbotoes">
        Aluno
        <div class="botao">
            Cursos
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        <div class="botao">
            Vagas
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        <div class="botao">
            Currículo
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        Professor
        <div class="botao">
            Turmas
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        <div class="botao">
            Alunos
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        <div class="botao">
            Dossiê
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        Empresa
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
        Instituição
        <div class="botao">
            Cadastrar Curso
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
        <div class="botao">
            Cadastrar Turma
            <img src="https://via.placeholder.com/250" alt="perfil" class="icone">
            <button>Visualizar</button>
        </div>
    </div>
</body>
</html>
