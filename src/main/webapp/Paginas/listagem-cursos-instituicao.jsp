<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Cursos Cadastrados</title>
</head>
<body>
    <header>
        <div class="navbar">
            <div class="voltar">☰</div>
            <div class="nome">Hirehub</div>
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/avatar-padrao.png" alt="perfil" class="iconeperfil">
        </div>
    </header>
    <h1>Seus Cursos</h1>
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
            <c:set var="usuarioLogado" value="${sessionScope['usuario-logado']}" />
            
            <c:if test="${usuarioLogado.papel.funcao == 'instituicao'}">
                <div>
                    <form action="<%=request.getContextPath()%>/cadastro-turma" method="post">
                        <input type="hidden" name="id" value="${cursos.id}"/>
                        <button type="submit">Cadastrar Turma</button>
                    </form>
                </div>
                </c:if>
                <c:if test="${usuarioLogado.papel.funcao == 'aluno'}">               
                <div>
                    <form action="<%=request.getContextPath()%>/recuperar-perfil-curso" method="post">
                        <input type="hidden" name="id" value="${cursos.id}"/>
                        <button type="submit">Ver Mais</button>
                    </form>
                </div>
                </c:if>
            </div>

        </c:forEach>
    </div>
</body>
</html>