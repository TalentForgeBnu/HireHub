<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub</title>
    <link rel="stylesheet" href="Recursos/Css/tela-logado-aluno.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Recursos/Css/menu.css">
</head>
<body>
    <header>
        <div class="navbar">
       	<div class="voltar">☰</div>
        <div class="nome">HireHub</div>
            <jsp:include page="/Paginas/menu.jsp" />
        <script src="<%=request.getContextPath()%>/Recursos/Scripts/menu.js"></script>
        </div>
    </header>
    <div>
        <p>Olá, <c:out value="${aluno.nome}"/>! Seja bem-vindo(a)!</p>
    </div>

    <div class="areadosbotoes">

        <div class="botao">
            <a href="${pageContext.request.contextPath}/lista-cursos">             
            <img src="Recursos/Vetores/logado-aluno-curso-vaga.svg" alt="perfil" class="icone">
            </a>
            <label for="cursos">Cursos</label>
        </div>
        <div class="botao">
            <a href="${pageContext.request.contextPath}/recuperar-lista-vagas">
            <img src="Recursos/Vetores/logado-aluno-curso-vaga.svg" alt="perfil" class="icone">
            </a>
            <label for="vagas">Vagas</label>
        </div>  
        
        <div class="cursos">
            <label for="curso">Cursos</label>
  
                  <div>
                      <label for="nomecurso">
                          ${cursos.nome}
                      </label>
                  </div>
             
               <a href="${pageContext.request.contextPath}/recuperar-lista-cursos">
              <button>Ver Mais</button>
               </a>             
      </div>    
    </div>
</body>
</html>
