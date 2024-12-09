<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Cursos Cadastrados</title>
    <link rel="stylesheet" href="Recursos/Css/listagem-cursos.css">
</head>

<body>
    <header>
        <div class="navbar">
            <div class="menu">☰</div>
            <div class="nome">Hirehub</div>
            <img src="https://via.placeholder.com/50" alt="perfil" class="iconeperfil">
        </div>
    </header>

    <div class="cursos">
        <c:set var="usuarioLogado" value="${sessionScope['usuario-logado']}" />

        <c:if test="${usuarioLogado.papel.funcao == 'instituicao'}">
            <h1>Seus Cursos</h1>
        </c:if>
    
        <c:if test="${usuarioLogado.papel.funcao == 'aluno'}">
            <h1>Cursos</h1>
        </c:if>

        <div class="listagem">

            <c:forEach var="cursos" items="${cursos}">

                <div class="curso">
                    <img src="https://via.placeholder.com/50">
                    
                    <div class="descricao">
                        <p class="nome-curso" for="nomecurso">${cursos.nome}</p>
                        <p class="descricao-curso" for="descricaocurso">${cursos.descricao}</p>
                    </div>

                    <div class="botao">

                        <c:if test="${usuarioLogado.papel.funcao == 'instituicao'}">
                            <form action="<%=request.getContextPath()%>/cadastro-turma" method="post">
                                <input type="hidden" name="id" value="${cursos.id}"/>
                                <button type="submit">Cadastrar Turma</button>
                            </form>
                        </c:if>

                        <c:if test="${usuarioLogado.papel.funcao == 'aluno'}">               
                            <form action="<%=request.getContextPath()%>/perfil-curso" method="post">
                                <input type="hidden" name="id" value="${cursos.id}"/>
                                <button type="submit">Ver Mais</button>
                            </form>
                        </c:if>
            
                    </div>

                </div>

            </c:forEach>

        </div>

        <button class="voltar" type="button" id="voltar">Voltar</button>
        <button class="proximo" type="button" id="proximo">Próximo</button>

        <script src="<%=request.getContextPath()%>/Recursos/Scripts/lista-curso.js"></script>

    </div>
  
</body>
</html>