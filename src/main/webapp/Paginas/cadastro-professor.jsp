<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Cadastro</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/cadastro.css">
</head>

<body>
    <img src="${pageContext.request.contextPath}/Recursos/Imagens/cadastro-professor.png"
        alt="Ilustração de uma professora">
    <div class="formulario">
        <div class="topo">
            <h1>CADASTRO</h1>
            <p>Olá, professor! Por favor preencha suas informações.</p>
        </div>
        <form action="<%=request.getContextPath()%>/inserir-professor" method="post">
            <input type="text" name="nome" placeholder="Nome" required>
            <input type="text" name="sobrenome" placeholder="Sobrenome" required>
            <input type="text" name="nome-social" placeholder="Nome Social">
            <input type="email" name="email" placeholder="Email" required>
            <input type="text" name="cpf" placeholder="CPF" required>

            <div class="grupo-input">
                <select name="estado" required>
                    <option value="" disabled selected>Estado</option>
                    <option value="SC">Santa Catarina</option>
                    <!-- Coloque aqui as opções de estado -->
                </select>
                <select name="cidade" required>
                    <option value="" disabled selected>Cidade</option>
                    <option value="blumenau">Blumenau</option>
                    <!-- Coloque aqui as opções de cidade -->
                </select>
            </div>

            <input type="text" name="cep" placeholder="CEP" required>

            <div class="grupo-input">
                <input type="text" name="bairro" placeholder="Bairro" required>
                <input type="text" name="numero" placeholder="Número" required>
            </div>

            <div class="grupo-input">
                <input type="text" name="logradouro" placeholder="Logradouro" required>
                <input type="text" name="complemento" placeholder="Complemento" required>
                <input type="text" name="via" placeholder="Via" required>
            </div>

            <select id="etnia" name="etnia" required>
                <option value="" disabled selected>Etnia</option>
                <option value="branco">Branco</option>
                <option value="pardo">Pardo</option>
                <option value="preto">Preto</option>
                <option value="indigena">Indígena</option>
                <option value="asiatico">Asiático</option>
            </select>

            <select id="sexo" name="sexo" required>
                <option value="" disabled selected>Sexo</option>
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
                <option value="Outro">Outro</option>
            </select>

            <input type="date" name="data-nascimento" placeholder="Data de Nascimento" require>
            <input type="password" name="senha" id="senha" placeholder="Senha" required>
            <input type="password" name="confirmar-senha" id="confirmar-senha" placeholder="Confirme sua Senha"
                required>
            <input type="tel" name="telefone" placeholder="Número de Telefone" required>

            <div class="termos">
                <input type="checkbox" required> Li e concordo com os <a href="#">termos de uso</a>.
            </div>
            <div class="acoes-form">
                <button type="button" class="cancelar">Cancelar</button>
                <button type="submit" class="cadastrar">Cadastrar-se</button>
            </div>
        </form>
        <footer>
            <p>Já possui uma conta? <a href="#">Entrar</a></p>
        </footer>
    </div>

</body>

</html>