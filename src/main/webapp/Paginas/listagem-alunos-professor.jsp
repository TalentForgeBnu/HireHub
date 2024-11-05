<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hire Hub - Lista de Alunos</title>
</head>
<body>
	<div>
		<h1>Hire Hub</h1>
	</div>
	<div>
		<h2>Lista de Alunos</h2>
		<table id="lista-alunos">
			<thead>
				<tr>
					<th>Matrícula</th>
					<th>Aluno</th>
					<th>Data de Nascimento</th>
					<th>Dossiê</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="alunos" items="${alunos}">
					<tr>
						<td>${alunos.matricula}</td>
						<td>${alunos.nome}</td>
						<td>${alunos.dataNascimento}</td>
						<td>
							<form action="<%=request.getContextPath()%>/Paginas/cadastro-dossie.jsp"
								method="post">
								<input type="hidden" name="id-aluno" value="${alunos.id}" /> <input
									type="hidden" name="aluno-cpf" value="${alunos.cpf}" />
								<button type="submit">Cadastrar Dossie</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>