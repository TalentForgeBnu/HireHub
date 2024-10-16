<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/atualizar-perfil-empresa" method="post">

		<input type="hidden" value="${empresa.id}" id="id" name="id">

		<div>
			<input type="text" value="${empresa.cnpj}" id="cnpj" name="cnpj" disabled>
			<input type="text" value="${empresa.nome}" placeholder="Nome" id="nome" name="nome">
			<input type="text" value="${empresa.descricao}" placeholder="Descrição" id="descricao" name="descricao">
			<input type="date" value="${empresa.dataFundacao}" placeholder="Data de Fundação" id="data-fundacao" name="data-fundacao" >
			<input type="text" value="${empresa.senha}" placeholder="Senha" id="senha" name="senha">
		</div>

		<div>
			<input type="text" placeholder="Endereço" id="endereco" name="endereco">
		</div>

		<button type="submit">Atualizar</button>
	</form>
</body>
</html>	