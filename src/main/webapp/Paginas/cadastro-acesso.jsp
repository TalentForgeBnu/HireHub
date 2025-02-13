<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HireHub - Cadastro</title>
	<link rel="stylesheet" href="Recursos/Css/cadastro-acesso.css">
</head>

<body>

	<div class="container">

        <div>
            <h1>CADASTRO</h1>
            <p>Antes de começar, queremos saber quem está cadastrando</p>
        </div>

        <a
            href="<%=request.getContextPath()%>/cadastro-aluno" class="opcao">
            <img src="<%=request.getContextPath()%>/Recursos/Vetores/aluno.svg"
             alt="Ícone Aluno"> Aluno
        </a>

        <a
            href="<%=request.getContextPath()%>/cadastro-empresa" class="opcao">
            <img src="<%=request.getContextPath()%>/Recursos/Vetores/empresas.svg"
            alt="Ícone Empresa"> Empresa
        </a>

        <a
            href="<%=request.getContextPath()%>/cadastro-instituicao" class="opcao">
            <img src="<%=request.getContextPath()%>/Recursos/Vetores/instituicao.svg"
            alt="Ícone Instituição"> Instituição
        </a>

        <div class="login">
            <p>Já possui uma conta? <a href="<%=request.getContextPath()%>/login">Entrar</a></p>
        </div>

    </div>

</body>
</html>