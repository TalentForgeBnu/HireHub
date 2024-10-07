<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro Dossie</title>
</head>
<body>
    <form action="CadastroDossie.html">
        <div>
            <textarea placeholder="Escreva o Dossiê" id="conteudo" name="conteudo"></textarea>
            <input type="button" value="Cadastrar Apontamento">
            <input type="button" value="Retornar">
            <input type="submit" value="Cadastrar">
        </div>
        <div>
            <h1>Apontamento</h1>
            <textarea placeholder="Escreva o Apontamento" name="apontamento" id="apontamento"></textarea>
            <input type="date" name="datacriacao" id="datacriacao">
        </div>
    </form>
</body>
</html>