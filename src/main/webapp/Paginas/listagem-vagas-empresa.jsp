<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HireHub - Lista de Vagas</title>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Recursos/Css/listagem-vagas-empresa.css">	
</head>
<body>
	<div>
		<header>
			<div class="navbar">
				<div class="voltar">☰</div>
				<div class="nome">Hirehub</div>
				<img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="perfil" class="iconeperfil">
			</div>
		</header>
		<div>
			<h2>Lista de Vagas</h2>

			<table id="lista-vaga">
				<thead>
					<tr>
						<th>Código da Vaga</th>
						<th>Vaga</th>
						<th>Contratação</th>
						<th>Descrição da Vaga</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vagas" items="${vagas}">

						<tr>
							<td><c:out value="${vagas.codigo}" /></td>
							<td><c:out value="${vagas.nome}" /></td>
							<td><c:out value="${vagas.contratacao}" /></td>
							<td><c:out value="${vagas.descricao}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="info-container">
			<div class="button">
				<input type="button" value="Editar Vaga">
			</div>
		</div>
	</div>
</body>