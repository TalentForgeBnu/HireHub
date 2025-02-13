<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Perfil</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/perfil-instituicao.css">	
</head>
<body>
    <header>
        <div><a id="voltar" href="${pageContext.request.contextPath}/instituicao-logado.jsp">←</a></div>
        <div id="nome">Hirehub</div>
        <div id="excluir">🗑️</div>
    </header>
    <div id="container">
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="Foto de Perfil">
            <div class="editarbotao">Editar</div>
        <form action="<%=request.getContextPath()%>/atualizar-perfil-instituicao" method="post">
		    <input type="hidden" id="id" name="id" value="${instituicao.id}" class="itens">
            <input type="text" class="itens" value="${instituicao.id}" placeholder="cnpj">
            <input type="text" placeholder="Nome da Instituição" id="nome" name="nomeempresa" class="itens" value="${instituicao.nome}">
            <input type="text" placeholder="Descrição" name="descricaoempresa" id="descricao" class="itens" value="${instituicao.descricao}">
            <input type="date" placeholder="Data de Fundação" id="dataFundacao" name="dataFundacao" class="itens" value="${instituicao.dataFundacao}">
            <input type="text" name="bairro" placeholder="Bairro" class="itens" value="${endereco.bairro}">
            <input type="text" name="numero" placeholder="Número" class="itens" value="${endereco.numero}">
            <input type="text" name="cep" placeholder="CEP" class="itens" value="${endereco.cep}">
            <input type="text" name="logradouro" placeholder="Logradouro" class="itens" value="${endereco.logradouro}">
            <input type="text" name="via" placeholder="Via" class="itens" value="${endereco.tipoVia}">
            <input type="text" name="complemento" placeholder="Complemento" class="itens" value="${endereco.complemento}">
     
			<button type="submit" class="botao">Atualizar</button>
		</form>
    </div>
</body>
</html>