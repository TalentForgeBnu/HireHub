<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Registrar Curso</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/adicionar.css">
</head>

<body>
    <div class="container">
        <div class="imagem">
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/turmas.png" alt="Imagem de um curso">
        </div>
        <div class="formulario">
            <div class="topo">
                <button type="button"><</button>
                <h2>Registrar Curso</h2>
            </div>
            <form action="<%=request.getContextPath()%>/inserir-curso" method="post">
                <input type="text" name="nome-curso" placeholder="Nome do Curso" required>
                <input type="text" name="area-atuacao" placeholder="Área de Atuação" required>
                <label>Data de Inicio</label>
                <input type="date" name="data-inicio" required>
                <label>Data de Término</label>
                <input type="date" name="data-termino" required>
                <textarea name="descricao-curso" rows="8" placeholder="Descrição do curso" required></textarea>

                <div class="form-acoes">
                    <button type="submit">✔ Criar Curso</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>