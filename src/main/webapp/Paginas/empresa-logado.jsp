<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub</title>
    <link rel="stylesheet" href="Recursos/Css/tela-empresa-logado.css">
</head>
<body>
    <header>
        <div class="navbar">
            <div class="voltar">☰</div>
            <div class="nome">Hirehub</div>
            <img src="https://via.placeholder.com/50" alt="perfil" class="iconeperfil">
        </div>
    </header>
    <div>
        <p>Olá, <c:out value="${empresa.nome}"/>! Seja bem-vindo(a)!</p>
    </div>

    <div class="areadosbotoes">
        <div class="botao">
            <a href="${pageContext.request.contextPath}/lista-cursos">
            <img src="Recursos/Vetores/logado-empresa-vagas-cursos.svg" alt="perfil" class="icone">
            </a>
            <label for="cursos">Cursos</label>
        </div>
        <div class="botao">
            <a href="${pageContext.request.contextPath}/cadastro-vaga">
            <img src="Recursos/Vetores/logado-empresa-vagas-cursos.svg" alt="perfil" class="icone">
            </a>
            <label for="vagas">Vagas</label>
        </div>  
         
        <div class="listas">

        <div class="vagas">
            <label for="vaga">Suas Vagas</label>
              <c:forEach var="vagas" items="${vagas}">
                      <label for="nomevaga">${vagas.nome}</label>
                  </c:forEach>               
               <a href="${pageContext.request.contextPath}/recuperar-lista-vagas">
              <button>Ver Mais</button>
               </a>             
      </div> 

      <div class="vagas">
        <label for="proposta">Suas Propostas</label>
        <c:forEach var="propostas" items="${propostas}">
                <label for="nomevaga">${propostas.andamentoOferta}</label>
            </c:forEach>               
         <a href="${pageContext.request.contextPath}/recuperar-lista-propostas">
        <button>Ver Mais</button>
         </a>
        </div>               
       </div> 
      </div>
</body>
</html>
