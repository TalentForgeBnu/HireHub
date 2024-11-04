<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Turma</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/cadastro-turma.css">
</head>

<body>

<div class="container">

    <div class="image-section">
        <img src="CadastroTurma.jpg" alt="Imagem da turma">
    </div>

    <div class="form-section">

        <h2>Adicionar Turma</h2>

        <form action="<%=request.getContextPath()%>/inserir-turma" method="post">

            <div class="form-group">
                <input type="text" id="nome" name="nome" placeholder="Nome da turma">
            </div>

            <div class="form-group">
                <input type="number" id="tamanho" name="tamanho" placeholder="Tamanho da turma">
            </div>

            <div class="form-group">
                <input type="hidden" name="id" value="<c:out value='${curso.id}'/>" />
                <label>Dados do Curso</label>
                <div>
                    <label>Nome: ${curso.nome}</label>
                    <label>Area de Atuação: ${curso.areaAtuacao}</label>
                    <p>${curso.descricao}</p>
                </div>
            </div>

            <div class="form-group">
                <select id="professor" name="professor" required>
                    <option value="" disabled selected>Selecione o professor</option>
                    <c:forEach var="professor" items="${professores}">
                        <option value="${professor.id}">${professor.nome} ${professor.sobrenome}</option>
                    </c:forEach>
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
