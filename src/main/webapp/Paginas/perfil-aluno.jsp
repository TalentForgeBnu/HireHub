<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tela Perfil Aluno</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/atualizar-aluno">
		<div>
			<c:forEach var="aluno" items="${aluno}">
				<input type="hidden" <c:out value="${aluno.id}"/> id="id" name="id">
				<input type="text" <c:out value="${aluno.cpf}"/> id="cpf" name="cpf"
					disabled>
				<input type="text" <c:out value="${aluno.nome}"/> placeholder="Nome"
					id="nome" name="nome">
				<input type="text" <c:out value="${aluno.sobrenome}"/>
					placeholder="Sobrenome" id="sobrenome" name="sobrenome">
				<input type="text" placeholder="Nome Social" id="nomeSocial"
					name="nomesocial" <c:out value="${aluno.nomeSocial}"/>>
				<input type="date" placeholder="Data de Nascimento" id="dataNasc"
					name="datanascimento" <c:out value="${aluno.dataNascimento}"/>>
				<select required>
					<option value="" disabled selected><c:out
							value="${aluno.rendaFamiliar}" /></option>
					<option value="ate-1-salario-minimo">Menos de um salario
						minimo</option>
					<option value="entre-1-a-2-salarios-minimos">Entre um a
						dois salarios minimos</option>
					<option value="entre-2-a-4-salarios-minimos">Entre dois a
						quatro salarios minimos</option>
					<option value="entre-4-a-6-salarios-minimos">Entre quatro
						a seis salarios minimos</option>
					<option value="acima-de-6-salarios-minimos">Acima de seis
						salarios minimos</option>
				</select>
				<select name="Etnia" id="etnia">
					<option value="" disabled selected><c:out
							value="${aluno.etnia}" /></option>
					<option value="branco">Branco</option>
					<option value="preto">Preto</option>
					<option value="pardo">Pardo</option>
					<option value="indigena">Indígena</option>
					<option value="Asiatico">Asiático</option>
				</select>
				<select name="Sexo" id="sexo">
					<option value="" disabled selected><c:out
							value="${aluno.sexo}" /></option>
					<option value="Masculino">Masculino</option>
					<option value="Feminino">Feminino</option>
					<option value="Outros">Outros</option>
				</select>
				<input type="text" placeholder="Endereço" id="endereco"
					name="endereco">
			</c:forEach>
		</div>
	</form>
</body>
</html>