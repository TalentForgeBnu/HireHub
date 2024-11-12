<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>HireHub</title>
</head>
<body>

<c:set var="usuarioLogado" value="${sessionScope['usuario-logado']}" />

<c:choose>
    <c:when test="${usuarioLogado != null}">
        <h2>Listagem</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/recuperar-lista-alunos">Listagem Alunos</a></li>
            <li><a href="${pageContext.request.contextPath}/recuperar-lista-cursos">Listagem Cursos</a></li>
            <li><a href="${pageContext.request.contextPath}/recuperar-lista-turma">Listagem Turmas</a></li>
            <li><a href="${pageContext.request.contextPath}/recuperar-lista-vagas">Listagem Vagas</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-curriculo.jsp">Cadastro Currículo</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-curso.jsp">Cadastro Curso</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-dossie.jsp">Cadastro Dossiê</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-turma.jsp">Cadastro Turma</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-vaga.jsp">Cadastro Vaga</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-professor.jsp">Cadastro Professor</a></li>
        </ul>

        <h2>Perfis</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
        </ul>

        <h2>Logout</h2>
        <ul>
            <li><a href="<%=request.getContextPath()%>/usuario-logout">Logout</a></li>
        </ul>
    </c:when>

    <c:otherwise>
        <h2>Cadastro</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-aluno.jsp">Cadastro Aluno</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-empresa.jsp">Cadastro Empresa</a></li>
            <li><a href="${pageContext.request.contextPath}/Paginas/cadastro-instituicao.jsp">Cadastro Instituição</a></li>
        </ul>

        <h2>Login</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
        </ul>
    </c:otherwise>
</c:choose>

</body>
</html>