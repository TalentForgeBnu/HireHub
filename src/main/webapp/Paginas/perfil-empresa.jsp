<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HireHub - Perfil</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/perfil.css">
</head>

<body>
	<header>
        <img class="voltar" src="${pageContext.request.contextPath}/Recursos/Vetores/voltar.svg">
        <div class="aba">Perfil</div>
        <button class="excluir">
			<p>Excluir conta</p>
			<img src="${pageContext.request.contextPath}/Recursos/Vetores/lixeiro.svg">
		</button>
	</header>
	<div class="pfp">
		<div class="editar-foto">
			<img src="${pageContext.request.contextPath}/Recursos/Vetores/avatar-padrao.svg"
				alt="Foto de Perfil" width="300" height="300">
			<div class="editarbotao">
				<img src="${pageContext.request.contextPath}/Recursos/Vetores/editar.svg" alt="Editar">
			</div>
		</div>
	</div>
	<div class="container">
		<form action="<%=request.getContextPath()%>/atualizar-perfil-empresa" method="post">
			<input type="hidden" value="${empresa.id}" id="id" name="id">
			<div class="input">
				<h6>CNPJ</h6>
				<input type="text" value="${empresa.cnpj}" disabled>
			</div>
			<div class="input">
				<h6>Nome da Empresa</h6>
				<input type="text" value="${empresa.nome}" placeholder="Nome" id="nome" name="nome">
			</div>
			<div class="input">
				<h6>Descrição da Empresa</h6>
				<textarea value="${empresa.descricao}" placeholder="Descrição" name="descricao" id="descricao" rows="4"></textarea>
			</div>
			<div class="input">
				<h6>Data de Fundação</h6>
				<input type="date" value="${empresa.dataFundacao}" placeholder="Data de Fundação"
					id="data-fundacao" name="data-fundacao">
			</div>
			<div class="input">
				<h6>Senha</h6>
				<input type="text" value="${empresa.senha}" placeholder="Senha" id="senha" name="senha">
			</div>

			<div class="input-group">
				<div class="input">
                    <h6>Estado</h6>
                    <select id="estado" name="estado">
                        <option value="${endereco.estado}" disabled selected>${endereco.estado}</option>
                        <option value="SC">Santa Catarina</option>
                        <!-- Coloque aqui as opções de estado -->
                    </select>
                </div>
                <div class="input">
                    <h6>Cidade</h6>
                    <select id="cidade" name="cidade">
                        <option value="${endereco.cidade}" disabled selected>${endereco.cidade}</option>
                        <option value="blumenau">Blumenau</option>
                        <!-- Coloque aqui as opções de cidade -->
                    </select>
                </div>
				<div class="input">
					<h6>Bairro</h6>
					<input type="text" value="${endereco.bairro}" name="bairro" placeholder="Bairro">
				</div>
				<div class="input">
					<h6>Número</h6>
					<input type="text" value="${endereco.numero}" name="numero" placeholder="Número">
				</div>
			</div>

			<div class="input-group">
				<div class="input">
					<h6>CEP</h6>
					<input type="text" value="${endereco.cep}" name="cep" placeholder="CEP">
				</div>
				<div class="input">
					<h6>Logradouro</h6>
					<input type="text" value="${endereco.logradouro}" name="logradouro"
						placeholder="Logradouro">
				</div>
				<div class="input">
					<h6>Via</h6>
					<input type="text" value="${endereco.tipoVia}" name="via" placeholder="Via">
				</div>
				<div class="input">
					<h6>Complemento</h6>
					<input type="text" value="${endereco.complemento}" name="complemento"
						placeholder="Complemento">
				</div>
			</div>
			<div class="form-acoes">
				<button type="submit">Salvar</button>
			</div>
		</form>
	</div>
	<div class="shh"><textarea rows="5"></textarea></div>
</body>
</html>