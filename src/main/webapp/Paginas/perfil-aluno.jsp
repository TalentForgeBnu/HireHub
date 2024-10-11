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
	<form action="<%=request.getContextPath()%>/atualizar-perfil-aluno" method="post">

		<input type="hidden" value="${aluno.id}" id="id" name="id">

		<div>
			<input type="text" value="${aluno.cpf}" id="cpf" name="cpf" disabled>
			<input type="text" value="${aluno.nome}" placeholder="Nome" id="nome" name="nome">
			<input type="text" value="${aluno.sobrenome}" placeholder="Sobrenome" id="sobrenome" name="sobrenome">
			<input type="text" placeholder="Nome Social" id="nome-social"name="nome-social" value="${aluno.nomeSocial}">
			<input type="date" placeholder="Data de Nascimento" id="data-nascimento" name="data-nascimento" value="${aluno.dataNascimento}">
			<input type="text" placeholder="Senha" id="senha" name="senha" value="${aluno.senha}">
		</div>

		<div>
			<select required>
				<option value="" disabled selected> value="${aluno.rendaFamiliar}" </option>
				<option value="ate-1-salario-minimo">Menos de um salario minimo</option>
				<option value="entre-1-a-2-salarios-minimos">Entre um a dois salarios minimos</option>
				<option value="entre-2-a-4-salarios-minimos">Entre dois a quatro salarios minimos</option>
				<option value="entre-4-a-6-salarios-minimos">Entre quatro a seis salarios minimos</option>
				<option value="acima-de-6-salarios-minimos">Acima de seis salarios minimos</option>
			</select>
		</div>

		<div>
			<select name="Etnia" id="etnia">
				<option value="" disabled selected> value="${aluno.etnia}" </option>
				<option value="branco">Branco</option>
				<option value="preto">Preto</option>
				<option value="pardo">Pardo</option>
				<option value="indigena">Indígena</option>
				<option value="Asiatico">Asiático</option>
			</select>
		</div>

		<div>
			<select name="Sexo" id="sexo">
				<option value="" disabled selected> value="${aluno.sexo}" </option>
				<option value="Masculino">Masculino</option>
				<option value="Feminino">Feminino</option>
				<option value="Outros">Outros</option>
			</select>
		</div>

		<div>
			<input type="text" placeholder="Endereço" id="endereco" name="endereco">
		</div>

		<button type="submit">Atualizar</button>
	</form>
</body>
</html>