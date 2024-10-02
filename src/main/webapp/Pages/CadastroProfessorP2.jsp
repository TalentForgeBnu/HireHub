<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <div class="container">
        <div class="left-section">
            <img src="../Resources/Images/cadastroProfessor.png" alt="Ilustração de pessoa em cadeira de rodas">
        </div>
        <div class="right-section">
            <h1>QUASE LÁ!</h1>
            <p>Preencha o resto das informações para cadastrar!</p>
            <form action="processaCadastroProfessor.jsp" method="post">
                <input type="password" name="senha" placeholder="Senha" required>
                <input type="password" name="confirmaSenha" placeholder="Confirme sua Senha" required>
                <input type="text" name="nomeSocial" placeholder="Nome Social" required>
                <input type="email" name="emailRecuperacao" placeholder="E-mail para Recuperação de Senha" required>
                <input type="tel" name="telefone" placeholder="Número de Telefone" required>
                
                <div class="form-actions">
                    <button type="button" class="cancel">Cancelar</button>
                    <button type="submit" class="submit" id="submitBtn" onclick="desabilitarBotao()">Cadastrar-se</button>
                </div>
            </form>
            <div class="form-footer">
                <p>Já possui uma conta? <a href="#">Entrar</a></p>
            </div>
        </div>
    </div>

    <script>
        function desabilitarBotao() {
            var botao = document.getElementById('submitBtn');
            botao.disabled = true;  // Desabilita o botão
            botao.innerText = 'Processando...';  // Opcional: altera o texto do botão para indicar o processo
        }
    </script>

</body>
</html>
