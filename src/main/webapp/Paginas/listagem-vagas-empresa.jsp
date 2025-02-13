<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Lista de Vagas</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/listagem-vagas-empresa.css">
</head>
<body>
    <header>
        <div class="lado-esquerdo">
                <div class="voltar">☰</div>
                <div class="nome">HireHub</div>
        </div>
        <img src="${pageContext.request.contextPath}/Recursos/Vetores/avatar-padrao.svg" width="48px">
    </header>

    <h2>Lista de Vagas</h2>

    <table class="lista">
        <thead>
            <tr class="classificacao">
                <th>Código da Vaga</th>
                <th>Vaga</th>
                <th>Contratação</th>
                <th>Descrição da Vaga</th>
                <th>Proposta</th>
            </tr>
        </thead>
        <c:forEach var="vagas" items="${vagas}">
            <tbody>
                <tr class="info">
                    <td>${vagas.codigo}</td>
                    <td>${vagas.nome}</td>
                    <td>${vagas.contratacao}</td>
                    <td>${vagas.descricao}</td>
                    <td>
                        <div class="container-botao">
                            <form action="<%=request.getContextPath()%>/recuperar-curso-pagina" method="post">
                                <input type="hidden" name="vaga-id" value="${vagas.id}">
                                <button type="submit">Proposta</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </tbody>
        </c:forEach>
    </table>
</body>
</html>
