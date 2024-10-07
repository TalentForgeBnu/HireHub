<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela Perfil Aluno</title>
</head>
<body>
    <img src="../Resources/Images/Component 8.png" alt="IlustraÃ§Ã£o de Aluno" width="204" height="200">

    <form action="TelaPerfilAluno.html">
    <div>
        <input type="text" placeholder="Nome" id="nome" name="nome">
        <input type="text" placeholder="Sobrenome" id="sobrenome" name="sobrenome">
        <input type="text" placeholder="Nome Social" id="nomeSocial" name="nomeSocial">
        <input type="date" placeholder="Data de Nascimento" id="dataNasc" name="dataNascimento">

        <select required>
            <option value="" disabled selected>Renda Familiar</option>
            <option value="Menos de um salario mÃ­nimo">AtÃ© 1 salario mÃ­nimo</option>
            <option value="Entre um Ã¡ dois salarios mÃ­nimos">Entre 1 a 2 salarios mÃ­nimos</option>
            <option value="Entre dois Ã¡ quatro salarios mÃ­nimos">Entre 2 a 4 salarios mÃ­nimos</option>
            <option value="Entre quatro Ã¡ seis salarios mÃ­nimos">Entre 4 a 6 salarios mÃ­nimos</option>
            <option value="Mais de seis salarios mÃ­nimos">Mais de 6 salarios mÃ­nimos</option>
        </select>
        <select name="Etnia" id="etnia">
            <option value="branco">Branco</option>
            <option value="preto">Preto</option>
            <option value="pardo">Pardo</option>
            <option value="indigena">IndÃ­gena</option>
            <option value="Asiatico">AsiÃ¡tico</option>
        </select>
        
        <input type="text" placeholder="EndereÃ§o" id="endereco" name="endereco">
    </div>
</form>
</body>
</html>