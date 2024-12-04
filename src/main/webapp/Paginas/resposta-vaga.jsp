<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Resposta</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/proposta-resposta.css">
</head>

<body>
    <div class="container">
        <button type="button" onclick="window.history.back()" class="voltar-btn">
            <img src="${pageContext.request.contextPath}/Recursos/Vetores/voltar-proposta.svg" alt="Voltar" class="voltar-img"> Resposta Vaga
        </button>

        <div class="formulario-conteudo">
            <div class="secao-esquerda">
                <input type="text" placeholder="Nome da vaga" name="nomevaga" id="nomevaga">
                <input type="text" placeholder="Código da vaga" name="codigovaga" id="codigovaga">

                <label for="modalidadecontratacao">Modalidade de contratação</label>
                <select name="modalidadecontratacao" id="modalidadecontratacao">
                    <option value="estagio">Estágio</option>
                    <option value="integral">Integral</option>
                    <option value="meio_periodo">Meio-Período</option>
                </select>

                <textarea id="descricao" placeholder="Detalhes sobre a vaga..."></textarea>

                <div class="botoes">
                    <button type="button" class="aceitar">Aceitar</button>
                    <button type="button" class="recusar">Recusar</button>
                </div>

                <textarea placeholder="Resposta da Vaga..."></textarea>
            </div>

            <div class="secao-direita">
                <img src="https://via.placeholder.com/150" alt="Imagem Instituição">
                <h3>Nome da Instituição</h3>
            </div>
        </div>

        <div class="acao-formulario">
            <button type="submit">✔ Salvar Resposta</button>
        </div>
    </div>
</body>

</html>