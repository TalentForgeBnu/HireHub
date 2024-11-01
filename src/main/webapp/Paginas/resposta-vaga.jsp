<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resposta da Curso</title>
</head>

<body>
    <div>
        <input type="text" placeholder="Nome da vaga" name="nomevaga" id="nomevaga">
        <input type="text" placeholder="Código da vaga" name="codigovaga" id="codigovaga">
    </div>

    <div>
        <label for="modalidadecontratacao">Modalidade de contratação</label>
        <select name="modalidadecontratacao" id="modalidadecontratacao">
            <option value="estagio">Estágio</option>
            <option value="integral">Integral</option>
            <option value="meio_periodo">Meio-Período</option>
        </select>
        <textarea id="descricao" placeholder="Detalhes sobre a vaga..."></textarea>
    </div>
    <div>
        <button type="button" class="accept">Aceitar</button>
        <button type="button" class="reject">Recusar</button>
    </div>
    <div>
        <textarea placeholder="Resposta da Vaga..."></textarea>
    </div>
    <div>
        <button type="submit">✔ Salvar Resposta</button>
    </div>
</body>

</html>