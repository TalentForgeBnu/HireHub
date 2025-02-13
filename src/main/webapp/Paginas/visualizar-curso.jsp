<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html>
	<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil curso</title>
		<link rel="stylesheet" href="Recursos/Css/visualizar-curso.css">
	</head>
	<body>

		<header>
			<div class="navbar">
				<div class="menu">☰</div>
				<div class="nome">Hirehub</div>
				<img src="https://via.placeholder.com/50" alt="perfil" class="iconeperfil">
			</div>
		</header>

		<div class="pagina">

			<div class="curso">

				<h1>Curso</h1>
				<div class="dado-pt1">

					<div class="dados">

						<label>Nome</label>
						<div class="linha">
							<p>${curso.nome}</p>
						</div>

						<label>Disponibilidade</label>
						<div class="linha">
							<p>${curso.disponibilidade}</p>
						</div>

						<label>Area de Atuação</label>
						<div class="linha">
							<p>${curso.areaAtuacao}</p>
						</div>

						<label>Inicio do Curso</label>
						<div class="linha-data">
							<p>${curso.dataInicio}</p>
						</div>

						<label>Termino do Curso</label>
						<div class="linha-data">
							<p>${curso.dataFim}</p>
						</div>

					</div>

					<img src="https://via.placeholder.com/50">
				</div>

				<div class="dado-pt2">
					<h2>Descrição</h2>
					<div class="descricao">
						<textarea disabled>${curso.descricao}</textarea>
					</div>
				</div>

				<div class="botao">
					<button>candidatar-se</button>
				</div>

			</div>

		</div>

	</body>
</html>