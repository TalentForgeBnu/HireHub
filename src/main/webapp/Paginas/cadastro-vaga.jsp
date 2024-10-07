<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Vaga</title>
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
            background-color: white;
            width: 70%;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        .left-section {
            width: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .left-section img {
            max-width: 100%;
            border-radius: 10px;
        }

        .right-section {
            width: 50%;
            padding-left: 20px;
        }

        .right-section h2 {
            font-size: 24px;
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

        input[type="file"] {
            padding: 3px;
        }

        .form-actions {
            display: flex;
            justify-content: flex-end;
        }

        .form-actions button {
            padding: 10px 20px;
            background-color: #4a90e2;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .form-actions button:hover {
            background-color: #357ABD;
        }

    </style>
</head>
<body>
    <div class="container">
        <!-- Seção da Imagem à Esquerda -->
        <div class="left-section">
            <img src="../Resources/Images/cadastroVagas.jpg" alt="Imagem de processo de entrevista">
        </div>
        <!-- Seção do Formulário à Direita -->
        <div class="right-section">
            <h2>Adicionar Vaga</h2>
            <form>
                <input type="text" placeholder="Nome da Vaga" name="nome" required>
                <input type="text" placeholder="Descrição da vaga" name="descricao-vaga" required>
                <select required>
                    <option value="" id="modalidade-contratacao" disabled selected>Modalidade da Contratação</option>
                    <option value="estagio">Estágio</option>
                    <option value="integral">Integral</option>
                    <option value="meioperiodo">Meio Período</option>
                </select>
                <input type="text" name="codigo-vaga" placeholder="codigo-vaga" required>
                <input type="file" name="imagem" placeholder="Anexar Imagem" accept="image/*">
                <div class="form-actions">
                    <button type="submit">✔ Enviar Oferta de Vaga</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
