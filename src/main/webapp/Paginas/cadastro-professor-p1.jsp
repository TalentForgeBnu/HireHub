<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Cadastro - Professor</title>
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

        input, select {
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        input[type="checkbox"] {
            margin-right: 10px;
        }

        .form-group {
            display: flex;
            justify-content: space-between;
        }

        .form-group select, .form-group input {
            width: 48%;
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

        .form-actions button.next {
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
            <img src="../Resources/Images/cadastroProfessor.png" alt="IlustraÃ§Ã£o de pessoa em cadeira de rodas">
        </div>
        <div class="right-section">
            <h1>CADASTRO</h1>
            <p>OlÃ¡, professor! Por favor preencha suas informaÃ§Ãµes.</p>
            <form>
                <input type="text" placeholder="Nome" required>
                <input type="text" placeholder="Sobrenome" required>
                <input type="email" placeholder="Email" required>
                <div class="form-group">
                    <select required>
                        <option value="" disabled selected>Estado</option>
                        <option value="SP">SÃ£o Paulo</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <!-- Mais opÃ§Ãµes de estado -->
                    </select>
                    <select required>
                        <option value="" disabled selected>Cidade</option>
                        <option value="SÃ£o Paulo">SÃ£o Paulo</option>
                        <option value="Rio de Janeiro">Rio de Janeiro</option>
                        <!-- Mais opÃ§Ãµes de cidade -->
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Bairro" required>
                    <input type="text" placeholder="NÃºmero" required>
                    <input type="text" name="complemento" placeholder="Complemento">
                    <input type="text" name="via" placeholder="Via"> 
                </div>
                <input type="text" placeholder="CEP" required>
                <input type="date" placeholder="Data de Nascimento" required>
                <select required>
                    <option value="" disabled selected>Etnia</option>
                    <option value="Branco">Branco</option>
                    <option value="Preto">Preto</option>
                    <option value="Pardo">Pardo</option>
                    <option value="IndÃ­gena">IndÃ­gena</option>
                    <option value="Amarelo">Amarelo</option>
                    <!-- Mais opÃ§Ãµes -->
                </select>
                <select required>
                    <option value="" disabled selected>Sexo</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Feminino">Feminino</option>
                    <!-- Mais opÃ§Ãµes -->
                </select>
                <div>
                    <input type="checkbox" required> Li e concordo com os <a href="#">termos de uso</a>.
                </div>
                <div class="form-actions">
                    <button type="button" class="cancel">Cancelar</button>
                    <button type="submit" class="next">PrÃ³ximo</button>
                </div>
            </form>
            <div class="form-footer">
                <p>JÃ¡ possui uma conta? <a href="#">Entrar</a></p>
            </div>
        </div>
    </div>

</body>
</html>