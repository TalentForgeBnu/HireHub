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
	href="${pageContext.request.contextPath}/Recursos/Css/listagem.css">
</head>
<body>
	<header>
		<div class="lado-esquerdo">
			<img class="menu" src="${pageContext.request.contextPath}/Recursos/Vetores/icone-menu.svg">
			<img class="logo" src="${pageContext.request.contextPath}/Recursos/Vetores/logo.svg">
		</div>
		<img src="${pageContext.request.contextPath}/Recursos/Vetores/avatar-padrao.svg" width=48px>
	</header>

    <h2>Lista de Vagas</h2>

    <table class="lista">
        <thead>
            <tr class="classificacao">
				<th>Código da Vaga</th>
                <th>Vaga</th>
                <th>Contratação</th>
                <th>Descrição da Vaga</th>
            </tr>
        </thead>
		<c:forEach var="vagas" items="${vagas}">
			<tbody>
				<tr class="info">
					<td>${vagas.codigo}</td>
					<td>${vagas.nome}</td>
					<td>${vagas.contratacao}</td>
					<td>${vagas.descricao}</td>
					<td>
					<div class="container-botao">
					<form action="<%=request.getContextPath()%>/recuperar-curso-pagina" method="post">
                        <input type="hidden" name="vaga-id" value="${vagas.id}"/>
                        <button type="submit">Proposta</button>
                    </form>
                    </div>
                    </td>
				</tr>
		</c:forEach>
			</tbody>
	
    </table>
</body>