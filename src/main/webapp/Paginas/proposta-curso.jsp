<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proposta de Curso</title>
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
            width: 80%;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            flex-direction: column;
        }
        
        h1 {
		    font-size: 36px;
		    color: #3B82F6;
		    margin-bottom: 10px;
		}

        .form-content {
            display: flex;
            justify-content: space-between;
            width: 100%;
        }

        .left-section {
            width: 60%;
        }

        .left-section input, 
        .left-section textarea, 
        .left-section select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        .left-section textarea {
            height: 100px;
            resize: none;
        }

        .input-group {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }

        .input-group select {
            width: 48%;
        }

        .right-section {
            width: 30%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .right-section img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            margin-bottom: 10px;
        }

        .right-section h3 {
            margin: 0;
            text-align: center;
        }

        .form-actions {
            display: flex;
            justify-content: flex-end;
            margin-top: 20px;
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
        <h1>Proposta de Curso</h1>
        <div class="form-content">
            <div class="left-section">
                <input type="text" placeholder="Nome do Curso" required>
                <input type="text" placeholder="Código do Curso" required>
                <input type="text" placeholder="Área de Atuação" required>
                <textarea placeholder="Descrição do curso" required></textarea>

                <div class="input-group">
                    <select required>
                        <option value="" disabled selected>Data de Início</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                    <select required>
                        <option value="" disabled selected>Horário de Início</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                </div>

                <div class="input-group">
                    <select required>
                        <option value="" disabled selected>Data de Término</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                    <select required>
                        <option value="" disabled selected>Horário de Término</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                </div>
            </div>
            <div class="right-section">
                <img src="https://via.placeholder.com/150" alt="Instituição">
                <h3>Nome da Instituição</h3>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit">✔ Enviar Proposta</button>
        </div>
    </div>

</body>
</html>
