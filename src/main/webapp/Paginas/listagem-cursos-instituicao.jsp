<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<body>
<form action="<%=request.getContextPath()%>/recuperar-curso" method="post">
    <h1>Seus Cursos</h1>
    <div>
        <div>
            <img src="https://via.placeholder.com/150" alt="Curso">
        </div>
        <div>
            <input type="hidden" name="id" id="id" value="${curso.id}">
            <label for="nome-curso">${curso.nome}</label>
        </div>
        <div>
            <label for="descricao-curso">${curso.descricao}</label>
        </div>
        <div>
            <input type="button" value="☆">
        </div>
        <div>
            <input type="button" value="Editar">
            <input type="button" value="Expandir">
        </div>
        </div>
</form>
</body>
</head>