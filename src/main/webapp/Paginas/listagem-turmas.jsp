<!-- Me substitua por recuperar-lista-turma no index.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Turmas - Hire Hub</title>
</head>
<body>

	<header>
		<h1>Hire Hub</h1>
		<div class="profile-icon">
			<img src="https://via.placeholder.com/50" alt="Profile">
		</div>
	</header>
	<div class="content">
		<table id="lista-turmas">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Código</th>
					<th>Alunos</th>
				</tr>
			</thead>
			<c:forEach var="turmas" items="${turmas}">
				<tr>
					<td><c:out value="${turmas.codigo}" /></td>
					<td><c:out value="${turmas.nome}" /></td>
					<td><a
						href="<%=request.getContextPath()%>/recuperar-lista-alunos?id=<c:out value='${turmnas.id}'/>"></a>
					</td>
				<tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
