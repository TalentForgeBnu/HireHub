<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HireHub - Cadastro</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/Recursos/Css/cadastro.css">
</head>

<body>
    <div class="imagem">
        <img src="${pageContext.request.contextPath}/Recursos/Imagens/cadastro-empresa.png" alt="Ilustração de prédio empresarial">
    </div>
    <div class="formulario">
        <div class="topo">
            <h1>TRIVAGO CADASTROS</h1>
            <p>Por favor, preencha as informações da empresa.</p>
        </div>
        <form action="<%=request.getContextPath()%>/inserir-empresa" method="post">
            <input type="text" name="nome" placeholder="Nome da Empresa" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="text" name="cnpj" placeholder="CNPJ" required>

            <div class="input-group">
                <select id="estado" name="estado" required>
                    <option value="" disabled selected>Estado</option>
                    <option value="SP">SÃ£o Paulo</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <!-- Mais opÃ§Ãµes de estado -->
                </select>
                <select id="cidade" name="cidade" required>
                    <option value="" disabled selected>Cidade</option>
                    <option value="São Paulo">São Paulo</option>
                    <option value="Rio de Janeiro">Rio de Janeiro</option>
                    <!-- Mais opÃ§Ãµes de cidade -->
                </select>
            </div>

            <input type="text" name="cep" placeholder="CEP" required>

            <div class="input-group">
                <input type="text" name="bairro" placeholder="Bairro" required>
                <input type="text" name="numero" placeholder="Numero" required>
            </div>

            <div class="input-group">
                <input type="text" name="complemento" placeholder="Complemento">
                <input type="text" name="via" placeholder="Via">
                <input type="text" name="logradouro" placeholder="Logradouro">
            </div>

            <input type="date" name="data-fundacao" placeholder="Data de Fundação" required>
            <input type="password" name="senha" id="senha" placeholder="Senha" required>
            <input type="password" name="confirmar-senha" id="confirmar-senha" placeholder="Confirme sua Senha" required>
            <input type="tel" name="telefone" placeholder="Telefone" required>
            
            <textarea rows="4" name="descricao" placeholder="Adicione uma descrição da sua empresa" required></textarea>

            <div>
                <input type="checkbox" name="termos" required>
                <label>Li e concordo com os <a href="#">termos de uso</a>.</label>
            </div>
            <div class="form-acoes">
                <button type="button" class="cancelar">Cancelar</button>
                <button type="submit" class="cadastrar">Cadastrar-se</button>
            </div>
        </form>
        <footer>
            <p>Já possui uma conta? <a href="${pageContext.request.contextPath}/login">Entrar</a></p>
        </footer>
    </div>
</body>

</html>