<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Hirehub - Perfil</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/perfil-aluno.css">
</head>
<body>
	<header>
		<div class="navbar">
			<div class="voltar">←</div>
			<div class="nome">Hirehub</div>
			<div class="excluir">Excluir conta <img src="#" alt="Porta"></div>
		</div>
	</header>

	<div class="pfp">
        <div class="foto">
            <img src="https://via.placeholder.com/250" alt="Foto de Perfil">
            <div class="editarbotao">Editar</div>
        </div>
	</div>
	<div class="container">
		<form action="<%=request.getContextPath()%>/atualizar-perfil-aluno" method="post">
			<input type="hidden" value="${aluno.id}" id="id" name="id">
			<div>
				<input type="text" value="${aluno.cpf}" id="cpf" name="cpf" disabled>
				<input type="text" value="${aluno.nome}" placeholder="Nome" id="nome" name="nome">
				<input type="text" value="${aluno.sobrenome}" placeholder="Sobrenome" id="sobrenome" name="sobrenome">
				<input type="text" value="${aluno.nomeSocial}" placeholder="Nome Social" id="nome-social"name="nome-social">
				<input type="date" value="${aluno.dataNascimento}" placeholder="Data de Nascimento" id="data-nascimento" name="data-nascimento">
				<input type="text" value="${aluno.senha}" placeholder="Senha" id="senha" name="senha">
			</div>
			<div>
				<select id="renda-familiar" name="renda-familiar">
					<option value="${aluno.rendaFamiliar}" disabled selected>${aluno.rendaFamiliar}</option>
					<option value="ate-1-salario-minimo">Menos de um salario minimo</option>
					<option value="entre-1-a-2-salarios-minimos">Entre um a dois salarios minimos</option>
					<option value="entre-2-a-4-salarios-minimos">Entre dois a quatro salarios minimos</option>
					<option value="entre-4-a-6-salarios-minimos">Entre quatro a seis salarios minimos</option>
					<option value="acima-de-6-salarios-minimos">Acima de seis salarios minimos</option>
				</select>
			</div>
			<div>
				<select id="etnia" name="etnia">
					<option value="${aluno.etnia}" disabled selected>${aluno.etnia}</option>
					<option value="branco">Branco</option>
					<option value="preto">Preto</option>
					<option value="pardo">Pardo</option>
					<option value="indigena">Indígena</option>
					<option value="asiatico">Asiático</option>
				</select>
			</div>
			<div>
				<select id="sexo" name="sexo">
					<option value="${aluno.sexo}" disabled selected>${aluno.sexo}</option>
					<option value="masculino">Masculino</option>
					<option value="feminino">Feminino</option>
					<option value="outros">Outros</option>
				</select>
			</div>
            <div class="input-group">
                <select id="estado" name="estado">
                    <option value="${endereco.estado}" disabled selected>${endereco.estado}</option>
                    <option value="SC">Santa Catarina</option>
                    <!-- Coloque aqui as opções de estado -->
                </select>
                <select id="cidade" name="cidade">
                    <option value="${endereco.cidade}" disabled selected>${endereco.cidade}</option>
                    <option value="blumenau">Blumenau</option>
                    <!-- Coloque aqui as opções de cidade -->
                </select>
            </div>

            <div class="input-group">
                <input type="text" value="${endereco.bairro}" name="bairro" placeholder="Bairro">
                <input type="text" value="${endereco.numero}" name="numero" placeholder="Número">
            </div>

            <input type="text" value="${endereco.cep}" name="cep" placeholder="CEP">
            <input type="text" value="${endereco.logradouro}" name="logradouro" placeholder="Logradouro">
            <input type="text" value="${endereco.tipoVia}" name="via" placeholder="Via">
            <input type="text" value="${endereco.complemento}" name="complemento" placeholder="Complemento">

			<button type="submit">Atualizar</button>
		</form>
	</div>
</body>
</html>