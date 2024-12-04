<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <link rel="stylesheet" href="Recursos/Css/tela-login.css">

</head>
<body>

    <div class="container">

        <div class="imagem">
            <img src="Recursos/Imagens/login.png">
        </div>

        <div class="login">
            <h1>LOGIN</h1>
            <form action="<%=request.getContextPath()%>/usuario-login" method="post">

                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="senha" placeholder="Senha" required>
                <a href="#">Esqueceu sua Senha?</a>

                <div class="botoes">
                    <button type="button">Voltar</button>
                    <button type="submit">Entrar</button>
                </div>

            </form>

            <div class="cadastra-se">
                <p>Não possui uma conta? <a href="#">Cadastre-se!</a></p>
            </div>
        </div>
    </div>

</body>
</html>
