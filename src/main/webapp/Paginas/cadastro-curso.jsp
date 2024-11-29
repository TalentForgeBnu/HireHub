<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HireHub - Registrar Curso</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/adicionar.css">
</head>

<body>
	<div class="container">
		<div class="imagem">
			<img src="${pageContext.request.contextPath}/Recursos/Imagens/turmas.png" alt="Imagem de uma turma">
		</div>
		<div class="formulario">
			<div class="topo">
				<button type="button"><</button>
				<h2>Registrar Curso</h2>
			</div>
			<form action="<%=request.getContextPath()%>/inserir-curso" method="post">

				<input type="hidden" name="vaga-id" id="curso-input" value="value=" <c:out value='${vaga.id}'/>>
				<input type="text" name="nome-curso" id="curso-input" placeholder="Nome do Curso" required>
				<input type="text" name="area-atuacao" id="curso-input" placeholder="Área de Atuação" required>
				<h4>Data de Inicio</h4>
				<input type="date" name="data-inicio" id="curso-input" required>
				<div class="grupo-input">
					<input type="time" name="tempo-inicio-inicio" class="curso-input">
					<input type="time" name="tempo-inicio-termino" class="curso-input">
                </div>
				<h4>Data de Termino</h4>
				<input type="date" class="curso-input" name="data-termino" required>
				<div class="grupo-input">
					<input type="time" name="tempo-termino-inicio" class="curso-input">
					<input type="time" name="tempo-termino-termino" class="curso-input">
                </div>
				<textarea id="descricao-curso" name="descricao-curso" rows="4" placeholder="Descrição do curso" required></textarea>
				
				<div class="form-acoes">
                    <button type="submit">✔ Criar Curso</button>
                </div>
			</form>
		</div>
	</div>
</body>

</html>