<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proposta de Vaga</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/proposta-vaga.css">
</head>
<body>

    <div class="container">
        <h1>Proposta de Vaga</h1>
        <div class="form-content">
            <div class="left-section">
                <input type="text" placeholder="Nome da Vaga" required>
                <input type="text" placeholder="Código da Vaga" required>
                <select name="modalidade-contratacao" id="modalidade-contratacao" required>
                    <option value="estagio">Estágio</option>
                    <option value="meio_periodo">Meio-Período</option>
                    <option value="integral">Integral</option>
                </select>
                <textarea placeholder="Descrição da vaga" required></textarea>
            </div>
            <div class="right-section">
                <img src="https://via.placeholder.com/150" alt="Empresa">
                <h3>Nome da Empresa</h3>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit">✔ Enviar Proposta</button>
        </div>
    </div>

</body>
</html>
