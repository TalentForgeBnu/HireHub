<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Curso</title>
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
        }
    </style>
</head>
<body>
    <div class="container">
w        <div class="image-section">
            <img src="" alt="Imagem do Curso">
        </div>
        <div class="form-section">
            <h2>Adicionar Curso</h2>
            <form action="submitCurso" method="post">
                <div class="form-group">
                    <input type="text" id="nomecurso" name="nomeCurso" placeholder="Nome do Curso" required>
                </div>
                <div class="form-group">
                    <input type="text" id="areaatuacao" name="areaAtuacao" placeholder="Área de Atuação" required>
                </div>
                <div class="form-group">
                	<label for="dataTermino">Data de Término</label>
                    <input type="datetime-local" id="datainicio" name="dataInicio" required>
                </div>
                <div class="form-group">
                    <label for="dataTermino">Data de Término</label>
                    <input type="datetime-local" id="datatermino" name="dataTermino" required>
                </div>
                <div class="form-group">
                    <textarea id="descricao" name="descricaocurso" rows="4" placeholder="Descrição do curso" required></textarea>
                </div>
                <button type="submit" class="submit-button">Enviar Oferta do Curso</button>
            </form>
        </div>
    </div>
</body>
</html>
