<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<div class="icone" id="hamburguer" onclick="alternarDropdown()">
<img src="${pageContext.request.contextPath}/Recursos/Vetores/avatar-padrao.svg" 
         alt="Menu" 
         class="iconeperfil">	
    <div class="dropdown" id="menu-dropdown">
        <a href="${pageContext.request.contextPath}/perfil">Perfil</a>
        <a href="${pageContext.request.contextPath}/usuario-logout">Logout</a>
    </div>
</div>