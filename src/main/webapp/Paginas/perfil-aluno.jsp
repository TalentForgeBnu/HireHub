<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela Perfil Aluno</title>
</head>
<body>                                
    <form action="TelaPerfilAluno.html">
    <div>
        <input type="hidden" id="id" name="id">
        <input type="text" placeholder="Nome" id="nome" name="nome">
        <input type="text" placeholder="Sobrenome" id="sobrenome" name="sobrenome">
        <input type="text" placeholder="Nome Social" id="nomeSocial" name="nomesocial">
        <input type="date" placeholder="Data de Nascimento" id="dataNasc" name="datanascimento">
        <select required>
            <option value="" disabled selected>Renda Familiar</option>
            <option value="Menos de um salario mínimo">Até 1 salario mínimo</option>
            <option value="Entre um á dois salarios mínimos">Entre 1 a 2 salarios mínimos</option>
            <option value="Entre dois á quatro salarios mínimos">Entre 2 a 4 salarios mínimos</option>
            <option value="Entre quatro á seis salarios mínimos">Entre 4 a 6 salarios mínimos</option>
            <option value="Mais de seis salarios mínimos">Mais de 6 salarios mínimos</option>
        </select>
        <select name="Etnia" id="etnia">
            <option value="branco">Branco</option>
            <option value="preto">Preto</option>
            <option value="pardo">Pardo</option>
            <option value="indigena">Indígena</option>
            <option value="Asiatico">Asiático</option>
        </select>
        <input type="text" placeholder="Endereço" id="endereco" name="endereco">
    </div>
</form>
</body>
</html>