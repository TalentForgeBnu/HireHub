<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Registrar Turma</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/adicionar.css">
</head>

<body>
    <div class="container">
        <div class="imagem">
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/turmas.png" alt="Imagem de uma turma">
        </div>

        <div class="formulario">
            <div class="topo">
                <button type="button"><</button>
                <h2>Registrar Turma</h2>
            </div>
            <form action="<%=request.getContextPath()%>/inserir-turma" method="post">
                <input type="hidden" name="id-curso" value="${curso.id}"/>
                <input type="text" name="nome" placeholder="Nome da turma" required>
                <input type="text" name="codigo" placeholder="Código da turma" required>
                <input type="number" name="tamanho" placeholder="Tamanho da turma" required>
                <select name="cpf-professor" required>
                    <option value="" disabled selected>Professor</option>
                    <c:forEach var="professor" items="${professores}">
                        <option value="${professor.cpf}">${professor.nome} ${professor.sobrenome}</option>
                    </c:forEach>
                </select>
                <select id="turno" name="turno" required>
                    <option value="" disabled selected>Turno</option>
                    <option value="matutino">Matutino</option>
                    <option value="vespertino">Vespertino</option>
                    <option value="noturno">Noturno</option>
                    <option value="integral">Integral</option>
                </select>
                
                <div class="form-acoes">
                    <button type="submit">✔ Criar Turma</button>
                </div>
            </form>
            <div class="descricao-curso">
                <input type="hidden" name="id-curso" value="${curso.id}"/>
                <h2>Dados do Curso</h2>
                <div>
                    <p>Nome: ${curso.nome}</p>
                    <p>Area de Atuação: ${curso.areaAtuacao}</p>
                    <p>Descrição: ${curso.descricao}</p>
                </div>
            </div>
        </div>
    </div>

</body>

</html>