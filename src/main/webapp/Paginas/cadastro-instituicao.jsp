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
    <img src="${pageContext.request.contextPath}/Recursos/Imagens/cadastro-instituicao.png"
        alt="Ilustração de prédio institucional">
    <div class="formulario">
        <div class="topo">
            <h1>CADASTRO</h1>
            <p>Por favor, preencha as informações da Instituição.</p>
        </div>
        <form action="<%=request.getContextPath()%>/inserir-instituicao" method="POST">
            <input type="text" name="nome-instituicao" placeholder="Nome da Instituição" required>
            <input type="text" name="cnpj" placeholder="CNPJ" required>
            <input type="email" name="email" placeholder="Email" name="email" required>

            <div class="grupo-input">
                <select id="estado" name="estado" required>
                    <option value="" disabled selected>Estado</option>
                    <option value="SP">São Paulo</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <!-- Mais opções de estado -->
                </select>
                <select id="cidade" name="cidade" required>
                    <option value="" disabled selected>Cidade</option>
                    <option value="São Paulo">São Paulo</option>
                    <option value="Rio de Janeiro">Rio de Janeiro</option>
                    <!-- Mais opções de cidade -->
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

            <input type="date" name="data-fundacao" placeholder="Data de Fundação" required>
            <input type="password" name="senha" id="senha" placeholder="Senha" required>
            <input type="password" name="confirmar-senha" id="confirmar-senha" placeholder="Confirme sua Senha"
                required>
            <input type="tel" name="telefone" placeholder="Telefone" required>

            <textarea rows="4" name="descricao-instituicao"
                placeholder="Adicione uma descrição da sua Instituição" required></textarea>

            <div class="termos">
                <input type="checkbox" name="termos" required>
                <label>Li e concordo com os <a href="#">termos de uso</a>.</label>
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
    </div>

</body>
</html>