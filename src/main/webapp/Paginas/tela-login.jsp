<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Login</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/Recursos/Css/tela-login.css">
</head>

<body>
    <div class="container">
        <div class="left-section">
            <img src="https://via.placeholder.com/300" alt="Ilustração de login">
        </div>
        <div class="right-section">
            <h1>LOGIN</h1>
            <form action="<%=request.getContextPath()%>/usuario-login" method="POST">
                <p>${erro}</p>
                <input type="email" name="email" placeholder="Email ou Nome do Usuário" required>
                <input type="password" name="senha" placeholder="Senha" required>
                <a href="#">Esqueceu sua Senha?</a>

                <div class="form-actions">
                    <button type="button" class="back" onclick="window.location.href='${pageContext.request.contextPath}/Paginas/inicio.jsp'">Voltar</button>
                    <button type="submit" class="submit">Entrar</button>
                </div>
            </form>

            <div class="form-footer">
                <p>Não possui uma conta? <a href="${pageContext.request.contextPath}/Paginas/cadastro-acesso.jsp">Cadastre-se!</a></p>
            </div>
        </div>
    </div>

</body>

</html>