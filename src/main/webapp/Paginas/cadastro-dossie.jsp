<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro do aluno</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/cadastro-dossie.css">
</head>
<body>
    <h1>Registros do Aluno</h1>
    <c:if test="${dossie == null}">
        <form action="<%=request.getContextPath()%>/inserir-dossie" method="post">
    </c:if>
    <c:if test="${dossie != null}">
        <form action="<%=request.getContextPath()%>/atualizar-dossie" method="post">
    </c:if>
        <div>
            <h2>Dossie</h2>
            <input type="hidden" name="id-aluno" value="${aluno.id}">
            <input type="hidden" name="aluno-cpf" value="${aluno.cpf}">
            <input type=hidden name="id-dossie" value="${dossie.id}">
            <textarea placeholder="Escreva o Dossiê" id="conteudo" name="conteudo">${dossie.conteudo}</textarea>
            <input type="submit" value="Cadastrar">
        </div>
    </form>

    <form action="<%=request.getContextPath()%>/inserir-apontamento" method="post">
        <div>
            <h2>Apontamento</h2>
            <textarea placeholder="Escreva o Apontamento" name="apontamento" id="apontamento"></textarea>
            <div><input type="date" name="data-criacao" id="data-criacao"></div>
            <input type="submit" value="Cadastrar">
        </div>
    </form>
</body>
</html>