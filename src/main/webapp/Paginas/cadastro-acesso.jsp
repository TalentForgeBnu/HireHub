<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Recursos/Css/cadastro-acesso.css">
</head>
<body>

	<div class="container">
		<h1>CADASTRO</h1>
		<p>Antes de começar, queremos saber quem está cadastrando</p>

		<div class="option">
			<img src="https://via.placeholder.com/24" alt="Ícone Aluno">
			Aluno
		</div>
		<div class="option">
			<img src="https://via.placeholder.com/24" alt="Ícone Professor">
			Professor
		</div>
		<div class="option">
			<img src="https://via.placeholder.com/24" alt="Ícone Empresa">
			Empresa
		</div>
		<div class="option">
			<img src="https://via.placeholder.com/24" alt="Ícone Instituição">
			Instituição
		</div>

		<div class="form-actions">
			<button type="button" class="back">Voltar</button>
			<button type="button" class="next">Próximo</button>
		</div>

		<div class="form-footer">
			<p>
				Já possui uma conta? <a href="#">Entrar</a>
			</p>
		</div>
	</div>

</body>
</html>
