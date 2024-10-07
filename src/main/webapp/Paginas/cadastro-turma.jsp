<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Turma</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            max-width: 900px;
            width: 100%;
            display: flex;
            overflow: hidden;
        }

        .form-section {
            flex: 1;
            padding: 40px;
        }

        .form-section h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 20px;
	    padding: 20px;	
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }

        .form-group input, 
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            color: #333;
        }

        .form-group input:focus, 
        .form-group textarea:focus {
            outline: none;
            border-color: #0066cc;
        }

        .form-group textarea {
            resize: none;
        }

        .submit-button {
            width: 100%;
            padding: 15px;
            background-color: #0066cc;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .submit-button:hover {
            background-color: #004da1;
        }

        .image-section {
            flex: 0.7;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .image-section img {
            width: 100%;
            height: auto;
            border-top-left-radius: 10px;
            border-bottom-left-radius: 10px;
            object-fit: cover;
        }

        @media (max-width: 768px) {
            .container {
                flex-direction: column;
            }

            .image-section {
                display: none;
            }

            .form-section {
                padding: 20px;
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
	    }
    </style>
</head>
<body>
    <div class="container">
        <div class="image-section">
            <img src="CadastroTurma.jpg" alt="Imagem da turma">
        </div>
        <div class="form-section">
            <h2>Adicionar Turma</h2>
            <form action="submitTurma" method="post">
                <div class="form-group">
                    <input type="text" id="nome" name="nome" placeholder="Nome da turma">
                </div>
                <div class="form-group">
                    <input type="text" id="codigo" name="codigo" placeholder="CÃ³digo da turma">
                </div>
                <div class="form-group">
                    <input type="number" id="tamanho" name="tamanho" placeholder="Tamanho da turma">
                </div>
                <div class="form-group">
                    <select id="turno" name="turno" required>
                        <option value="" disabled selected>Turno</option>
                        <option value="matutino">Matutino</option>
                        <option value="vespertino">Vespertino</option>
                        <option value="noturno">Noturno</option>
                    </select>
                </div>
                <div class="form-actions">
                    <button type="submit">Salvar Turma</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
