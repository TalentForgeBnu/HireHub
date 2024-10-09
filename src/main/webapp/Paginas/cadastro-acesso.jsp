<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
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
            background-color: white;
            width: 50%;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            font-size: 36px;
            color: #4a90e2;
            margin-bottom: 10px;
        }

        p {
            margin-bottom: 20px;
        }

        .option {
            display: flex;
            justify-content: flex-start;
            align-items: center;
            background-color: white;
            padding: 15px;
            border-radius: 5px;
            border: 2px solid #ccc;
            margin-bottom: 15px;
            cursor: pointer;
            font-size: 18px;
        }

        .option img {
            margin-right: 10px;
        }

        .option:hover {
            border-color: #4a90e2;
        }

        .form-actions {
            display: flex;
            justify-content: space-between;
        }

        .form-actions button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .form-actions button.back {
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
        <h1>CADASTRO</h1>
        <p>Antes de começar, queremos saber quem está cadastrando</p>

        <div class="option">
            <img src="https://via.placeholder.com/24" alt="Ícone Aluno">
            Aluno
        </div>
        <div class="option">
            <img src="https://via.placeholder.com/24" alt="Ícone Professor">
            Professor
        </div>
        <div class="option">
            <img src="https://via.placeholder.com/24" alt="Ícone Empresa">
            Empresa
        </div>
        <div class="option">
            <img src="https://via.placeholder.com/24" alt="Ícone Instituição">
            Instituição
        </div>

        <div class="form-actions">
            <button type="button" class="back">Voltar</button>
            <button type="button" class="next">Próximo</button>
        </div>

        <div class="form-footer">
            <p>Já possui uma conta? <a href="#">Entrar</a></p>
        </div>
    </div>

</body>
</html>
