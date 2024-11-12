<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Perfil</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/perfil-aluno.css">
</head>
<body>
    <header>
        <div class="voltar">←</div>
        <div class="nome">Hirehub</div>
        <div class="excluir">Excluir conta <img src="#" alt="Excluir conta"></div>
	</header>
	<div class="pfp">
        <div class="foto">
            <img src="${pageContext.request.contextPath}/Recursos/Paginas/avatar-padrao.png" alt="Foto de Perfil">
            <div class="editarbotao">Editar</div>
        </div>
	</div>
	<div class="container">
        <form action="<%=request.getContextPath()%>/atualizar-perfil-instituicao" method="post"></form>
		    <input type="hidden" value="${instituicao.id}" id="id" name="id">
            <input type="text" value="${instituicao.cnpj}" disabled>
            <input type="text" value="${instituicao.nome}" placeholder="Nome da Instituição" id="nome" name="nomeempresa">
            <textarea placeholder="Descrição" name="descricaoempresa" id="descricao" >${instituicao.descricao}</textarea>
            <input type="date" value="${instituicao.dataFundacao}" placeholder="Data de Fundação" id="dataFundacao" name="dataFundacao">

            <div class="input-group">
                <input type="text" value="${endereco.bairro}" name="bairro" placeholder="Bairro">
                <input type="text" value="${endereco.numero}" name="numero" placeholder="Número">
            </div>

            <div class="input-group">
                <input type="text" value="${endereco.cep}" name="cep" placeholder="CEP">
                <input type="text" value="${endereco.logradouro}" name="logradouro" placeholder="Logradouro">
                <input type="text" value="${endereco.tipoVia}" name="via" placeholder="Via">
                <input type="text" value="${endereco.complemento}" name="complemento" placeholder="Complemento">
            </div>

			<button type="submit">Atualizar</button>
		</form>
	</div>
</body>
</html>