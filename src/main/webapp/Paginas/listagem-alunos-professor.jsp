<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HireHub - Lista de Alunos</title>
</head>
<body>
	<header>
        <div class="navbar">
            <div class="voltar">☰</div>
            <div class="nome">Hirehub</div>
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="perfil" class="iconeperfil">
        </div>
    </header>
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
							<form action="<%=request.getContextPath()%>/recuperar-lista-apontamentos"
								method="post">
								<input type="hidden" name="id-aluno" value="${alunos.id}" /> <input
									type="hidden" name="cpf-aluno" value="${alunos.cpf}" />
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