<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>HireHub - Registrar Vaga</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/adicionar.css">
</head>

<body>
    <div class="container">
        <div class="imagem">
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/vagas.png" alt="Imagem de processo de entrevista" />
        </div>

        <div class="formulario">
            <div class="topo">
                <button type="button"><</button>
                <h2>Registrar Vaga</h2>
            </div>
            <form action="<%=request.getContextPath()%>/inserir-vaga" method="post">
                <input type="text" placeholder="Nome da Vaga" name="nome" required />
                <textarea id="descricao-vaga" name="descricao-vaga" rows="8" placeholder="Descrição da Vaga" required></textarea>
                <select name="modalidade-contratacao" required>
                    <option value="" id="modalidade-contratacao" disabled selected>
                        Modalidade da Contratação
                    </option>
                    <option value="estagio">Estágio</option>
                    <option value="integral">Integral</option>
                    <option value="meio_periodo">Meio Período</option>
                </select>
                <input type="text" name="codigo-vaga" placeholder="Código da Vaga" required />
                <input type="file" name="imagem" placeholder="Anexar Imagem" accept="image/*" />

                <div class="form-acoes">
                    <button type="submit">✔ Criar Vaga</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>