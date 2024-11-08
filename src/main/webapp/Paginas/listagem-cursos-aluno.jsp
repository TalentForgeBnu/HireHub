<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cursos</title>
</head>
<body>
    <h1>Cursos Disponíveis</h1>
    <div>
        <div>
            <img src="https://via.placeholder.com/150" alt="Curso">
        </div>
        <c:forEach var="cursos" items="${cursos}">
            <div>
                <label for="nomecurso">
                    <c:out value="${cursos.nome}"/>
                </label>
            </div>
            <div>
                <label for="descricaocurso">
                    <c:out value="${cursos.descricao}"/>
                </label>
            </div>
            <div>
                <div>
                    <form action="<%=request.getContextPath()%>/perfil-curso" method="post">
                        <input type="hidden" name="id" value="${cursos.id}"/>
                        <button type="submit">Ver Mais</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
