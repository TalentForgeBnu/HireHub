<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Vaga</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/cadastro-vaga.css">
</head>
<body>
    <div class="container">
        <!-- Seção da Imagem à Esquerda -->
        <div class="left-section">
            <img src="../Resources/Images/cadastroVagas.jpg" alt="Imagem de processo de entrevista">
        </div>
        <!-- Seção do Formulário à Direita -->
        <div class="right-section">
            <h2>Adicionar Vaga</h2>
            <form action="<%=request.getContextPath()%>/inserir-vaga" method="post">
                <input type="text" placeholder="Nome da Vaga" name="nome" required>
                <input type="text" placeholder="Descrição da vaga" name="descricao-vaga" required>
                <select name="modalidade-contratacao" required>
                    <option value="" id="modalidade-contratacao" disabled selected>Modalidade da Contratação</option>
                    <option value="estagio">Estágio</option>
                    <option value="integral">Integral</option>
                    <option value="meio_periodo">Meio Período</option>
                </select>
                <input type="text" name="codigo-vaga" placeholder="codigo-vaga" required>
                <input type="file" name="imagem" placeholder="Anexar Imagem" accept="image/*">
                <div class="form-actions">
                    <button type="submit">✔ Enviar Oferta de Vaga</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
