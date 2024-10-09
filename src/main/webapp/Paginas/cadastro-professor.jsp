<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CADASTRO</title>
</head>
<style>



body {
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 0;
	background-color: #f4f4f9;
}
 
.container {
	display: flex;
	justify-content: space-between;
	background-color: white;
	width: 70%;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}
 
.left-section {
	width: 40%;
	display: flex;
	justify-content: center;
	align-items: center;
}
 
.left-section img {
	max-width: 100%;
}
 
.right-section {
	width: 55%;
}
 
.right-section h1 {
	font-size: 36px;
	color: #4a90e2;
	margin-bottom: 10px;
}
 
.right-section p {
	margin-bottom: 20px;
}
 
form {
	display: flex;
	flex-direction: column;
}
.form-section {
		    width: 50%;
		}
		
		h1 {
		    font-size: 36px;
		    color: #3B82F6;
		    margin-bottom: 10px;
		}
 
input, select {
	padding: 10px;
	margin-bottom: 15px;
	border-radius: 5px;
	border: 1px solid #ccc;
	font-size: 16px;
}
 
input[type="checkbox"] {
	margin-right: 10px;
}
 
.form-group {
	display: flex;
	justify-content: space-between;
}
 
.form-group select, .form-group input {
	width: 48%;
}
 
.form-actions {
	display: flex;
	justify-content: space-between;
	align-items: center;
}
 
.form-actions button {
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}
 
.form-actions button.cancel {
	background-color: white;
	border: 1px solid black;
}
 
.form-actions button.next {
	background-color: #4a90e2;
	color: white;
}
 
.form-footer {
	margin-top: 10px;
	text-align: center;
}
 
.form-footer a {
	color: black;
	text-decoration: none;
}
</style>
<body>
	<div>
		<img src="../Resources/Images/cadastroProfessor.png"
			alt="Ilustra��o de pessoa em cadeira de rodas">
	</div>
	<div class="form-section">
		<h1>CADASTRO</h1>
		<p>Olá, professor! Por favor, preencha suas informações.</p>
		<form>
			<input type="text" placeholder="Nome" required> <input
				type="text" placeholder="Sobrenome" required> <input
				type="email" placeholder="Email" required>
			<div class="form-group">
				<select required>
					<option value="" disabled selected>Estado</option>
					<option value="SP">S�o Paulo</option>
					<option value="RJ">Rio de Janeiro</option>
					<!-- Mais op��es de estado -->
				</select> <select required>
					<option value="" disabled selected>Cidade</option>
					<option value="S�o Paulo">S�o Paulo</option>
					<option value="Rio de Janeiro">Rio de Janeiro</option>
					<!-- Mais op��es de cidade -->
				</select> <input type="text" placeholder="Bairro" required> <input
					type="text" placeholder="Numero" required>
			</div>
			<input type="text" name="complemento" placeholder="complemento">
			<input type="text" name="logradouro" placeholder="logradouro">
			<input type="text" placeholder="CEP" required> <input
				type="date" placeholder="Data de Nascimento" required> <select
				required>
				<option value="" disabled selected>Etnia</option>
				<option value="Branco">Branco</option>
				<option value="Preto">Preto</option>
				<option value="Pardo">Pardo</option>
				<option value="Indigena">Indigena</option>
				<option value="Amarelo">Amarelo</option>
				<!-- Mais op��es -->
			</select> <select required>
				<option value="" disabled selected>Sexo</option>
				<option value="Masculino">Masculino</option>
				<option value="Feminino">Feminino</option>
				<!-- Mais op��es -->
			</select> <input type="password" placeholder="Senha" required> <input
				type="password" placeholder="Confirme sua Senha" required> <input
				type="text" placeholder="Nome Social" required> <input
				type="email" placeholder="E-mail para Recupera��o de Senha" required>
			<input type="tel" placeholder="Numero de Telefone" required>
			<div class="form-actions">
				<button type="button" class="cancel">Cancelar</button>
				<button type="submit" class="next">Próximo</button>
			</div>
		</form>
	</div>
	<div>
		<input type="checkbox" required> Li e concordo com os <a
			href="#">termos de uso</a>.
	</div>
	<div class="form-footer">
		<p>
			Já possui uma conta? <a href="#">Entrar</a>
		</p>
	</div>
</body>
</html>