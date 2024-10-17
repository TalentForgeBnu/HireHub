<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hire Hub - Vagas</title>
</head>
<body>
    <div>
        <div>
            <h2>Hire Hub</h2>
            <img src="" alt="perfil" class="iconeperfil">
        </div>
 
        <div>
            <h3>Vagas</h3>
 
            <c:forEach var="vaga" items="${vagas}">
                <div>
                    <div>
                        <img src="${vaga.imagem}" alt="Imagem da Vaga">
                        <div>
                            <h5><c:out value="${vaga.nome}"/></h5>
                            <p><c:out value="${vaga.descricao}"/></p>
                        </div>
                    </div>
                    <div>
                        <button >Enviar Currículo</button>
                        <button >Expandir</button>
                        <button ><i ></i></button>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>	