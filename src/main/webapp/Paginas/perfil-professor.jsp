<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tela Perfil Professor</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/atualizar-perfil-professor" method="post">

        <input type="hidden" value="${professor.id}" id="id" name="id">

        <div>
            <input type="text" value="${professor.cpf}" id="cpf" name="cpf" disabled>
            <input type="text" value="${professor.nome}" placeholder="Nome" id="nome" name="nome">
            <input type="text" value="${professor.sobrenome}" placeholder="Sobrenome" id="sobrenome" name="sobrenome">
            <input type="text" placeholder="Nome Social" id="nome-social" name="nome-social" value="${professor.nomeSocial}">
            <input type="date" placeholder="Data de Nascimento" id="data-nascimento" name="data-nascimento" value="${professor.dataNascimento}">
            <input type="text" placeholder="Senha" id="senha" name="senha" value="${professor.senha}">
        </div>

        <div>
            <select name="Etnia" id="etnia">
                <option value="" disabled selected> value="${professor.etnia}" </option>
                <option value="branco">Branco</option>
                <option value="preto">Preto</option>
                <option value="pardo">Pardo</option>
                <option value="indigena">Indígena</option>
                <option value="Asiatico">Asiático</option>
            </select>
        </div>

        <div>
            <select name="Sexo" id="sexo">
                <option value="" disabled selected> value="${professor.sexo}" </option>
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
                <option value="Outros">Outros</option>
            </select>
        </div>

        <div>
            <input type="text" placeholder="Endereço" id="endereco" name="endereco" value="${professor.endereco}">
        </div>

        <button type="submit">Atualizar</button>
    </form>
</body>
</html>
