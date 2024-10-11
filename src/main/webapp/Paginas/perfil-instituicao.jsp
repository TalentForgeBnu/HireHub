<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil Instituição</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/atualizar-perfil-instituicao" method="post">
    
    <input type="hidden" value="${instituicao.id}" id="id" name="id">
        <div>
        <input type="text" value="${instituicao.cnpj}" placeholder="CNPJ" id="cnpj" name="cnpj" disabled>
        <input type="text" value="${instituicao.nome}" placeholder="Nome da Instituição" id="nome" name="nomeempresa">
        <textarea placeholder="Descrição" name="descricaoempresa" id="descricao" >${instituicao.descricao}</textarea>
        <input type="date" value="${instituicao.dataFundacao}" placeholder="Data de Fundação" id="dataFundacao" name="dataFundacao">
        <input type="text" placeholder="Endereço" id="endereco" name="endereco">
        </div>
    </form>
</body>
</html>