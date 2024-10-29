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
                    <input type="text" id="codigo" name="codigo" placeholder="Código da turma">
                </div>
                <div class="form-group">
                    <input type="number" id="tamanho" name="tamanho" placeholder="Tamanho da turma">
                </div>
                <div class="form-group">
                    <input type="text" id="professor-cpf" name="professor-cpf" placeholder="CPF do professor da turma">
                </div>
                <div class="form-group">
                    <select id="turno" name="turno" required>
                        <option value="" disabled selected>Turno</option>
                        <option value="matutino">Matutino</option>
                        <option value="vespertino">Vespertino</option>
                        <option value="noturno">Noturno</option>
                        <option value="integral">Integral</option>
                    </select>
                    <input type="hidden" name="id" value="<c:out value='${cursos.id}'/>" />
                </div>
                <div class="form-actions">
                    <button type="submit">Salvar Turma</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
