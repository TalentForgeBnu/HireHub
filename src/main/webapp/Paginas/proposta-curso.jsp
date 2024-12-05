<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HireHub - Proposta</title>
<link rel="stylesheet" href="Recursos/Css/proposta-curso.css">
</head>
<body>
	<div class="container">
		<h1>Proposta de Curso</h1>
		<form action="<%=request.getContextPath()%>/inserir-proposta"
				method="post">
		<div class="form-content">
			<div class="left-section">
				<input type="hidden" name="vaga-id" value="${vaga.id}"/>
				<input type="hidden" name="curso-id" value="${curso.id}"/>
				<label for="curso">${curso.nome}</label> 
				<label for="curso"> ${curso.areaAtuacao}</label> 
				<label for="curso">${vaga.nome}</label> 
				<textarea disabled="disabled">${curso.descricao}</textarea> 
				<label for="data">Data de Ínicio</label>
				<label for="data"> ${curso.dataInicio}</label> 
				<label for="data">Data de Término</label>
				<label for="data"> ${curso.dataFim}</label> 
				<input type="text" id="proposta" name="proposta"
						placeholder="R$" required>
			</div>
			<div class="right-section">
				<img src="https://via.placeholder.com/150" alt="Instituição">
				<h3>Nome da Instituição</h3>
			</div>
		</div>
		<div class="form-actions">		
			<button type="submit">✔ Enviar Proposta</button>
		</div>
		</form>
	</div>

</body>
</html>
