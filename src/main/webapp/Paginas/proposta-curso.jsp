<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-16"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Proposta</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/proposta-curso.css">
</head>
<body>
    <div class="container">
        <h1>Proposta de Curso</h1>
        <div class="form-content">
            <div class="left-section">
                <input type="hidden" name="vaga-id" value="value="<c:out value='${vaga.id}'/>>
                <input type="text" name="nome-curso" placeholder="Nome do Curso" required>
                <input type="text" name="codigo" placeholder="Código do Curso" required>
                <input type="text" name="areaatuacao" placeholder="Área de Atuação" required>
                <textarea name="descricao" placeholder="Descrição do curso" required></textarea>
                <div class="input-group">
                    <select name="data-inicio" required>
                        <option value="" disabled selected>Data de Início</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                    <select name="data-fim" required>
                        <option value="" disabled selected>Data de Fim</option>
                        <option value="10:00am">10:00am</option>
                        <option value="10:00pm">10:00pm</option>
                    </select>
                    <input type="text" name="proposta" placeholder="Proposta" required>
                    <input type="text" name="valor" placeholder="Valor" required>         
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
