<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HireHub - Turmas</title>
</head>
<body>
	<header>
        <div class="navbar">
            <div class="voltar">☰</div>
            <div class="nome">Hirehub</div>
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="perfil" class="iconeperfil">
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
					<td><form action="<%=request.getContextPath()%>/listagem-alunos-turma"
								method="post">
								<input type="hidden" name="id-turma" value="${turmas.id}" />
								<button type="submit">Ver alunos</button>
							</form>
					</td>
				<tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
