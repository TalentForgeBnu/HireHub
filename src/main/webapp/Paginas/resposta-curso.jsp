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
            <img src="${pageContext.request.contextPath}/Recursos/Vetores/voltar-proposta.svg" alt="Voltar" class="voltar-img"> Resposta Curso
        </button>
        <div class="formulario-conteudo">
            <div class="secao-esquerda">
                <textarea id="descricao" placeholder="Descrição da vaga"></textarea>

                <div class="grupo-inputs">
                    <select required>
                        <option value="" disabled selected>Data de Início</option>
                        <option value="10/10/2024">10/10/2024</option>
                        <option value="11/11/2024">11/11/2024</option>
                    </select>
                    <select required>
                        <option value="" disabled selected>Horário de Início</option>
                        <option value="08:00">08:00</option>
                        <option value="09:00">09:00</option>
                        <option value="10:00">10:00</option>
                    </select>
                </div>

                <div class="grupo-inputs">
                    <select required>
                        <option value="" disabled selected>Data de Término</option>
                        <option value="20/12/2024">20/12/2024</option>
                        <option value="30/12/2024">30/12/2024</option>
                    </select>
                    <select required>
                        <option value="" disabled selected>Horário de Término</option>
                        <option value="12:00">12:00</option>
                        <option value="14:00">14:00</option>
                        <option value="16:00">16:00</option>
                    </select>
                </div>

                <div class="botoes">
                    <button type="button" class="aceitar">Aceitar</button>
                    <button type="button" class="recusar">Recusar</button>
                </div>

                <textarea placeholder="Resposta do Curso..."></textarea>
            </div>
            <div class="secao-direita">
                <img src="https://via.placeholder.com/150" alt="Instituição">
                <h3>Nome da Instituição</h3>
            </div>
        </div>

        <div class="acao-formulario">
            <button type="submit">✔ Salvar Resposta</button>
        </div>
    </div>
</body>
</html>