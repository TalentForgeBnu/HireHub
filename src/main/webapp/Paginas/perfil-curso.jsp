<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil curso</title>
</head>
<body>
	<div>
		<label for="nomecurso"> 
		<c:out value="${curso.nome}"/>
		</label>
		<label for="areaatuacao">
		<c:out value="${curso.areaAtuacao}"/>
		</label>
		<label for="disponibilidade">
		<c:out value="${curso.disponibilidade}"/>
		</label>
		<label for="datainicio">
		<c:out value="${curso.dataInicio}"/>
		</label>
		<label for="datafim">
		<c:out value="${cursos.dataFim}"/>
		</label>
		<label for="descricao">
		<c:out value="${curso.descricao}"/>
		</label>
	</div>
</body>
</html>