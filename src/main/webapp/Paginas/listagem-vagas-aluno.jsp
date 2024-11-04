<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hire Hub - Vagas</title>
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Recursos/Css/listagem-vagas-aluno.css">
</head>
<body>
    <div class="navbar">
        <div class="menu-icon">☰</div>
        <div class="nome">Hire Hub</div>
        <div class="perfil" onclick=""></div>
    </div>
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