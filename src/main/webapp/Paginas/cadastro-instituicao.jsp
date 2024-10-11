<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Cadastro - Instituição</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/Css/cadastro-instituicao.css">
</head>
<body>

    <div class="container">
        <div class="left-section">
            <img src="../Recursos/Imagens/cadastro-instituicao.png" alt="Ilustração de prédio institucional">
        </div>
        <div class="right-section">
            <h1>CADASTRO</h1>
            <p>Por favor preencha as informações da Instituição.</p>
            <form action="<%=request.getContextPath()%>/inserir-instituicao" method="POST">
                <input type="text" name="cnpj" placeholder="CNPJ" required>
                <input type="text" name="nome-instituicao" placeholder="Nome da Instituição" required>
                <div class="form-group">
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
                <div class="form-group">
                    <input type="text" name="bairro" placeholder="Bairro" required>
                    <input type="text" name="numero" placeholder="Número" required>
                </div>
                 <div class="form-group">
                     <input type="text" name="logradouro" placeholder="Logradouro" required>
                     <input type="text" name="complemento" placeholder="Complemento" required>
                     <input type="text" name="via" placeholder="Via" required>
                 </div>
                    <input type="text" name="cep" placeholder="CEP" required>
                    <input type="email" name="email" placeholder="Email" name="email" required>
                    <input type="password" name="senha" name="senha" placeholder="Senha" required>
                    <input type="password" name="confimarsenha" placeholder="Confirme sua Senha" required>
                    <input type="date" name="data-fundacao" placeholder="Data de Fundação" required>
                    <input type="text" name="telefone" placeholder="Telefone" required>
                <textarea rows="4" name="descricao-instituicao" placeholder="Adicione uma descrição da sua Instituição" required></textarea>
                <div>
                    <input type="checkbox" required> Li e concordo com os <a href="#">termos de uso</a>.
                </div>
                <div class="form-actions">
                    <button type="button" class="cancel">Cancelar</button>
                    <button type="submit" class="submit">Cadastrar-se</button>
                </div>
            </form>
            <div class="form-footer">
                <p>Já possui uma conta? <a href="#">Entrar</a></p>
            </div>
        </div>
    </div>

</body>
</html>
