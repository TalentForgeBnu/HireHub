<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Aluno</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Recursos/Css/cadastro-aluno.css">
</head>
<body>
    <div class="container">
        <div class="image-section">
            <img src="${pageContext.request.contextPath}/Recursos/Imagens/cadastro-aluno.png" alt="Ilustração">
        </div>

        <div class="form-section">
            <h1>CADASTRO</h1>
            <p>Olá, aluno! Por favor preencha suas informações.</p>

            <form action="<%=request.getContextPath()%>/inserir-aluno" method="POST">
                <input type="text" name="nome" placeholder="Nome" required>
                <input type="text" name="sobrenome" placeholder="Sobrenome" required>
                <input type="text" name="nome-social" placeholder="Nome Social">
                <input type="email" name="email" placeholder="Email" required>
                <input type="text" name="cpf" placeholder="Cpf" required>

                <div class="input-group">
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

                <div class="input-group">
                    <input type="text" name="bairro" placeholder="Bairro">
                    <input type="text" name="numero" placeholder="Número">
                </div>

                <input type="text" name="cep" placeholder="CEP">
                <input type="text" name="logradouro" placeholder="Logradouro">
                <input type="text" name="via" placeholder="Via">
                <input type="text" name="complemento" placeholder="Complemento">

                <input type="date" name="data-nascimento" placeholder="Data de Nascimento" required>

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

                <input type="password" name="senha" placeholder="Senha" required>
                <input type="password" name="confirmar_senha" placeholder="Confirme sua Senha" required>
                <input type="tel" name="telefone" placeholder="Número de Telefone" required>

                <select id="renda-familiar" name="renda-familiar" required>
                    <option value="" disabled selected>Renda Familiar</option>
                    <option value="ate-1-salario-minimo">Menos de um salario minimo</option>
                    <option value="entre-1-a-2-salarios-minimos">Entre um a dois salarios minimos</option>
                    <option value="entre-2-a-4-salarios-minimos">Entre dois a quatro salarios minimos</option>
                    <option value="entre-4-a-6-salarios-minimos">Entre quatro a seis salarios minimos</option>
                    <option value="acima-de-6-salarios-minimos">Acima de seis salarios minimos</option>
                </select>

                <div class="checkbox-container">
                    <input type="checkbox" name="termos" required>
                    <label>Li e concordo com os <a href="#">termos de uso</a>.</label>
                </div>

                <div class="form-actions">
                    <button type="button" class="cancelar">Cancelar</button>
                    <button type="submit" class="cadastrar">Cadastrar-se</button>
                </div>
            </form>

            <div class="form-footer">
                <p>Já possui uma conta? <a href="#">Entrar</a></p>
            </div>
        </div>
    </div>
</body>
</html>
