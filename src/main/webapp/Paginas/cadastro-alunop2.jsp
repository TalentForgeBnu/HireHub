<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Cadastro - Quase Lá!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }

        .container {
            display: flex;
            justify-content: space-between;
            background-color: white;
            width: 70%;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        .left-section {
            width: 40%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .left-section img {
            max-width: 100%;
        }

        .right-section {
            width: 55%;
        }

        .right-section h1 {
            font-size: 36px;
            color: #4a90e2;
            margin-bottom: 10px;
        }

        .right-section p {
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input {
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        .form-actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .form-actions button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .form-actions button.cancel {
            background-color: white;
            border: 1px solid black;
        }

        .form-actions button.submit {
            background-color: #4a90e2;
            color: white;
        }

        .form-footer {
            margin-top: 10px;
            text-align: center;
        }

        .form-footer a {
            color: black;
            text-decoration: none;
        }

    </style>
</head>
<body>

    <%
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String nomeSocial = request.getParameter("nomesocial");
        String cpf = request.getParameter("cpf");

        String dataNascimento = request.getParameter("datanascimento");

        String etnia = request.getParameter("etnia");
        String sexo = request.getParameter("sexo");

        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String logadouro = request.getParameter("logadouro");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String numero = request.getParameter("numero");
    %>

    <div class="container">
        <div class="left-section">
            <img src="../Resources/Images/cadastroAluno.png" alt="Ilustração de pessoa em cadeira de rodas">
        </div>
        <div class="right-section">
            <h1>QUASE LÁ!</h1>
            <p>Preencha o resto das informações para cadastrar!</p>
            <form action="<%=request.getContextPath()%>/aluno/inserir" method="POST">
                <input type="hidden" name="nome" value="<%= nome %>">
                <input type="hidden" name="sobrenome" value="<%= sobrenome %>">
                <input type="hidden" name="nomesocial" value="<%= nomeSocial %>">
                <input type="hidden" name="cpf" value="<%= cpf %>">
                <input type="hidden" name="datanascimento" value="<%= dataNascimento %>">
                <input type="hidden" name="etnia" value="<%= etnia %>">
                <input type="hidden" name="sexo" value="<%= sexo %>">
                <input type="hidden" name="estado" value="<%= estado %>">
                <input type="hidden" name="cidade" value="<%= cidade %>">
                <input type="hidden" name="logadouro" value="<%= logadouro %>">
                <input type="hidden" name="bairro" value="<%= bairro %>">
                <input type="hidden" name="cep" value="<%= cep %>">
                <input type="hidden" name="numero" value="<%= numero %>">
                <input type="email" placeholder="Email" name="email" required>
                <input type="password" name="senha" placeholder="Senha" required>
                <input type="password" name="confimarsenha" placeholder="Confirme sua Senha" required>
                <input type="tel" name="telefone" placeholder="Número de Telefone" required>
                <select required>
                    <option value="" disabled selected>Renda Familiar</option>
                    <option value="Menos de um salario mínimo">Menos de um salario mínimo</option>
                    <option value="Entre um á dois salarios mínimos">Entre um á dois salarios mínimos</option>
                    <option value="Entre dois á quatro salarios mínimos">Entre dois á quatro salarios mínimos</option>
                    <option value="Entre quatro á seis salarios mínimos">Entre quatro á seis salarios mínimos</option>
                    <option value="Mais de seis salarios mínimos">Mais de seis salarios mínimos</option>
                    <!-- Mais opções -->
                </select>

                <div class="form-actions">
                    <button type="button" class="voltar">Voltar</button>
                    <button type="submit" class="submit">Cadastrar-se</button>
                </div>
            </form>
            <div class="form-footer">
                <p>Já possui uma conta? <a href="#">Entrar</a></p>
            </div>
        </div>
    </div>
</body>
</html>
