<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resposta do Curso</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: flex-start;
	    height: 100vh;
	    margin-top: 150px;
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

        .form-content {
            display: flex;
            justify-content: space-between;
            width: 100%;
        }

        .left-section {
            width: 60%;
        }

        .left-section textarea {
            width: 100%;
            height: 150px;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
            resize: none;
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
        }

        .input-group {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }

        .input-group select {
            width: 48%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .buttons {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }

        .buttons button {
            width: 48%;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .buttons button.accept {
            background-color: #4CAF50;
            color: white;
        }

        .buttons button.reject {
            background-color: #f44336;
            color: white;
        }

        textarea {
            width: 100%;
            height: 100px;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
            resize: none;
        }

        .form-actions {
            display: flex;
            justify-content: flex-end;
            width: 100%;
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
        <div class="form-content">
            <!-- Seção Esquerda -->
            <div class="left-section">
                <label for="descricao">Descrição da vaga</label>
                <textarea id="descricao" placeholder="Descrição da vaga"></textarea>
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
                <div class="buttons">
                    <button type="button" class="accept">Aceitar</button>
                    <button type="button" class="reject">Recusar</button>
                </div>
                <textarea placeholder="Resposta do Curso..."></textarea>
            </div>
            <!-- Seção Direita -->
            <div class="right-section">
                <img src="https://via.placeholder.com/150" alt="Instituição">
                <h3>Nome da Instituição</h3>
            </div>
        </div>
        <!-- Botão Salvar Resposta -->
        <div class="form-actions">
            <button type="submit">✔ Salvar Resposta</button>
        </div>
    </div>
</body>
</html>
