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
        <c:forEach var="cursos" items="${cursos}">
        <div> 
            <label for="nomecurso"><c:out value="${cursos.nome}"/></label>
        </div>
        <div>
            <label for="descricaocurso"><c:out value="${cursos.descricao}"/></label>
        </div>
        <div>
            <a href="<%=request.getContextPath()%>/Paginas/cadastro-turma.jsp?id=<c:out value='${cursos.id}'/>">Cadastro Turma</a>
        </div>
        </c:forEach>
        </div> 
        </form>      
</body>
</head>