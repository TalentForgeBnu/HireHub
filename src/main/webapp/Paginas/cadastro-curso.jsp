<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Curso</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/cadastro-curso.css">
</head>
<body>
    <div class="container">
        <div class="image-section">
            <img src="" alt="Imagem do Curso">
        </div>
        <div class="form-section">
            <h2>Adicionar Curso</h2>
            <form action="<%=request.getContextPath()%>/inserir-curso" method="post">

                <div class="form-group">
                    <input type="text" id="nome-curso" name="nome-curso" placeholder="Nome do Curso" required>
                </div>
                <div class="form-group">
                    <input type="text" id="area-atuacao" name="area-atuacao" placeholder="Área de Atuação" required>
                </div>
                <div class="form-group">
                    <label>Data de Inicio</label>
                    <input type="date" id="data-inicio" name="data-inicio" required>
                </div>
                <div class="form-group">
                    <label>Data de Término</label>
                    <input type="date" id="data-termino" name="data-termino" required>
                </div>
                <div class="form-group">
                    <textarea id="descricao-curso" name="descricao-curso" rows="4" placeholder="Descrição do curso" required></textarea>
                </div>
                <button type="submit" class="submit-button">Enviar Oferta do Curso</button>
            </form>
        </div>
    </div>
</body>
</html>
