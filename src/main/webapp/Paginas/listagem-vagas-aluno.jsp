<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Vagas</title>
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Recursos/Css/listagem-vagas-aluno.css">
</head>
<body>
    <header>
        <div class="navbar">
            <div class="voltar">☰</div>
            <div class="nome">Hirehub</div>
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="perfil" class="iconeperfil">
        </div>
    </header>
        <div>
            <h2 class="titulo" style="color: #4A90E2;">Vagas</h2>
            <c:forEach var="vagas" items="${vagas}">
                <div class="container">
                    <div>
                        <img src="${vagas.imagem}" alt="Imagem da Vaga">
                    <div>
                        <h5><c:out value="${vagas.nome}"/></h5>
                        <p><c:out value="${vagas.descricao}"/></p>
                    </div>
                    </div>
                    <form action="<%=request.getContextPath()%>/perfil-vaga" method="post">
                        <input type="hidden" name="id" value="${vagas.id}"/>
                        <button type="submit">Expandir</button>
                    </form>
                </div>
            </c:forEach>
        </div>
</body>
</html>	