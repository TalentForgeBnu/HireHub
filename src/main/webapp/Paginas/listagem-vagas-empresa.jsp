<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Vagas</title>
<head>
    <style>
         body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #4A90E2;
            padding: 10px;
            color: white;
            display: flex;
            align-items: center;
        }
        .navbar .menu-icon {
            font-size: 24px;
            cursor: pointer;
            margin-right: 10px;
        }
        .navbar .nome {
            flex-grow: 1;
            font-size: 20px;
        }
        .navbar .perfil {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background-color: #ccc;
        }
        .lista {
            padding: 10px;
            text-align: left;
        }
        .label-container{
            color: #64748B;
            margin-right: 80px;
            display: inline-block;
            margin-left: 20px;
        }
        .info-container{
            margin-right: 80px;
            display: inline-block;
            margin-left: 35px;
        }
        .button{
            display: inline-block;
            width: 48%;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div>
        <div class="navbar">
            <div class="menu-icon">☰</div>
            <div class="nome">Hire Hub</div>
            <div class="perfil" onclick=""></div>
        </div>
        <div class="lista">
            <h3>Lista de Vagas</h3>
        </div>
        <div class="label-container">
            <label>Código</label>
        </div>
        <div class="label-container">
            <label>Nome da Vaga</label>
        </div>
        <div class="label-container">
            <label>Modalidade de Contratação</label>
        </div>
        <div class="label-container">
            <label>Descrição</label>
        </div>
        </div>
        <div>
        <div class="info-container">
            <label for="codigovaga">01</label>
        </div>
        <div class="info-container">
        <label for="nomevaga">Programador Full Stack</label>
        </div>
        <div class="info-container">
        <label for="modalidadecontratacao">Estágio</label>
        </div>
        <div class="info-container">
        <label for="descricaovaga">Estágio em desenvolvimento web, com foco em front-end e back-end.</label>
        </div>
        <div class="info-container">
            <div class="button">
            <input type="button" value="Editar Vaga">
            </div>
        </div>
        </div>
    </div>
</body>