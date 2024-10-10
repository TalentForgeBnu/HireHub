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
				<input type="text" <c:out value="${aluno.cpf}"/> id="cpf" name="cpf" disabled>
				<input type="text" <c:out value="${aluno.nome}"/> placeholder="Nome"
					id="nome" name="nome">
				<input type="text" <c:out value="${aluno.sobrenome}"/>placeholder="Sobrenome" id="sobrenome"
					name="sobrenome" >
				<input type="text" placeholder="Nome Social" id="nomeSocial"
					name="nomesocial" <c:out value="${aluno.nomeSocial}"/>>
				<input type="date" placeholder="Data de Nascimento" id="dataNasc"
					name="datanascimento" <c:out value="${aluno.dataNascimento}"/>>
				<select required>
					<option value="" disabled selected><c:out value="${aluno.rendaFamiliar}"/></option>
					<option value="Menos de um salario mínimo">Até 1 salario
						mínimo</option>
					<option value="Entre um á dois salarios mínimos">Entre 1 a
						2 salarios mínimos</option>
					<option value="Entre dois á quatro salarios mínimos">Entre
						2 a 4 salarios mínimos</option>
					<option value="Entre quatro á seis salarios mínimos">Entre
						4 a 6 salarios mínimos</option>
					<option value="Mais de seis salarios mínimos">Mais de 6
						salarios mínimos</option>
				</select>
				<select name="Etnia" id="etnia">
					<option value="" disabled selected><c:out value="${aluno.etnia}"/></option>
					<option value="branco">Branco</option>
					<option value="preto">Preto</option>
					<option value="pardo">Pardo</option>
					<option value="indigena">Indígena</option>
					<option value="Asiatico">Asiático</option>
				</select>
				<select name="Sexo" id="sexo">
					<option value="" disabled selected><c:out value="${aluno.sexo}"/></option>
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