<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Aluno</title>
    <style>
		    	* {
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		    font-family: Arial, sans-serif;
		}
		
		body {
		    background-color: #f4f4f9;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		}
		
		.container {
		    background-color: #ffffff;
		    padding: 20px;
		    border-radius: 10px;
		    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
		    width: 100%;
		    max-width: 900px;
		    display: flex;
		    align-items: center;
		}
		
		.form-section {
		    width: 50%;
		}
		
		h1 {
		    font-size: 36px;
		    color: #3B82F6;
		    margin-bottom: 10px;
		}
		
		p {
		    font-size: 16px;
		    color: #666;
		    margin-bottom: 20px;
		}
		
		form {
		    display: flex;
		    flex-direction: column;
		}
		
		label {
		    font-size: 16px;
		    margin-bottom: 5px;
		    color: #555555;
		    padding: 10px;
		}
		
		input, select {
		    padding: 10px;
		    margin-bottom: 15px;
		    border: 1px solid #cccccc;
		    border-radius: 5px;
		    font-size: 14px;
		    width: 100%;
		}
		
		input[type="email"], input[type="password"], input[type="tel"], input[type="date"], input[type="text"], select {
		    background-color: #fafafa;
		}
		
		input[type="email"]:focus, input[type="password"]:focus, input[type="tel"]:focus, input[type="date"]:focus, input[type="text"]:focus, select:focus {
		    border-color: #0066cc;
		    outline: none;
		}
		
		.input-group {
		    display: flex;
		    gap: 10px;
		}
		
		.checkbox-container {
		    display: flex;
		    align-items: center;
		    margin-bottom: 20px;
		}
		
		.checkbox-container input[type="checkbox"] {
		    margin-right: 10px;
		}
		
		.form-actions {
		    display: flex;
		    justify-content: space-between;
		}
		
		button {
		    padding: 10px 20px;
		    background-color: #3B82F6;
		    color: #ffffff;
		    border: none;
		    border-radius: 5px;
		    font-size: 16px;
		    cursor: pointer;
		    margin-bottom: 10px;
		}
		
		button:hover {
		    background-color: #005bb5;
		}
		
		button.cancelar {
		    background-color: #cccccc;
		}
		
		button.cancelar:hover {
		    background-color: #b3b3b3;
		}
		
		.form-footer {
		    text-align: center;
		    font-size: 14px;
		    margin-top: 10px;
		}
		
		.form-footer a {
		    color: #3B82F6;
		    text-decoration: none;
		}
		
		.form-footer a:hover {
		    text-decoration: underline;
		}
		
		.image-section {
		    width: 40%;
		    text-align: center;
		}
		
		.image-section img {
		    max-width: 100%;
		    height: auto;
		    border-radius: 10px;
		}
    </style>
</head>
<body>
    <div class="container">
        <div class="image-section">
            <img src="../Recursos/Imagens/cadastro-aluno.png" alt="Ilustração">
        </div>

        <div class="form-section">
            <h1>CADASTRO</h1>
            <p>Olá, aluno! Por favor preencha suas informações.</p>

            <form action="<%=request.getContextPath()%>/inserir-aluno" method="POST">
                <input type="text" name="nome" placeholder="Nome" required>
                <input type="text" name="sobrenome" placeholder="Sobrenome" required>
                <input type="text" name="nome_social" placeholder="Nome Social">
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

                <input type="date" name="data-nascimento" placeholder="Data de Nascimento" require>

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
