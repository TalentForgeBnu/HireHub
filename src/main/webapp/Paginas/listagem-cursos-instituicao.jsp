<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<body>
    <h1>Seus Cursos</h1>
    <div>
        <div>
            <img src="https://via.placeholder.com/150" alt="Curso">
        </div>
        <div>
            <input type="hidden" name="id" id="id">
            <label for="nomecurso">Nome do Curso</label>
        </div>
        <div>
            <label for="descricaocurso">Descrição do curso</label>
        </div>
        <div>
            <input type="button" value="☆">
        </div>
        <div>
            <input type="button" value="Editar">
            <input type="button" value="Expandir">
        </div>
        </div>
</body>
</head>