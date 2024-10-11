<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resposta do Curso</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/resposta-curso.css">
</head>
<body>
    <div class="container">
        <div class="form-content">
            <!-- SeÃ§Ã£o Esquerda -->
            <div class="left-section">
                <label for="descricao">DescriÃ§Ã£o da vaga</label>
                <textarea id="descricao" placeholder="DescriÃ§Ã£o da vaga"></textarea>
                <div class="input-group">
                    <select required>
                        <option value="" disabled selected>Data de InÃ­cio</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                    <select required>
                        <option value="" disabled selected>HorÃ¡rio de InÃ­cio</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                </div>
                <div class="input-group">
                    <select required>
                        <option value="" disabled selected>Data de TÃ©rmino</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                    <select required>
                        <option value="" disabled selected>HorÃ¡rio de TÃ©rmino</option>
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
            <!-- SeÃ§Ã£o Direita -->
            <div class="right-section">
                <img src="https://via.placeholder.com/150" alt="InstituiÃ§Ã£o">
                <h3>Nome da InstituiÃ§Ã£o</h3>
            </div>
        </div>
        <!-- BotÃ£o Salvar Resposta -->
        <div class="form-actions">
            <button type="submit">â Salvar Resposta</button>
        </div>
    </div>
</body>
</html>
