<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Turmas - Hire Hub</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            
        }

        header {
            background-color: #4a90e2;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        header h1 {
            margin: 0;
            font-size: 32px;
        }

        .profile-icon {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            background-color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .profile-icon img {
            border-radius: 50%;
            width: 100%;
            height: 100%;
        }

        .content {
            text-align: center;
            padding: 20px;
        }

        .content h2 {
            color: #4a90e2;
            margin-bottom: 30px;
            font-size: 28px;
        }

        .turmas-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;
            justify-items: center;
            margin: 20px;
            padding: 20px;
        }

        .turma-card {
            background-color: #4a90e2;
            color: white;
            width: 250px;
            height: 180px;
            border-radius: 25px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            margin: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .turma-card h3 {
            font-size: 18px;
            margin: 0;
        }

        .turma-card p {
            font-size: 14px;
        }

        .turma-card button {
            padding: 10px 20px;
            background-color: white;
            color: #4a90e2;
            border: none;
            border-radius: 20px;
            font-size: 14px;
            cursor: pointer;
        }

        .turma-card button:hover {
            background-color: #357ABD;
            color: white;
        }

        @media (max-width: 768px) {
            .turmas-container {
                grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            }
        }
    </style>
</head>
<body>

    <!-- Cabe�alho -->
    <header>
        <h1>Hire Hub</h1>
        <div class="profile-icon">
            <img src="https://via.placeholder.com/50" alt="Profile">
        </div>
    </header>
    <div class="content">
        <h2>Turmas</h2>
        <div class="turmas-container">
            <c:forEach var="turma" items="${turmas}">
                <div class="turma-card">
                    <h5><c:out value="${turma.codigo}"/></h5>
                    <h3><c:out value="${turma.nome}"/></h3>
                    <button>Ver Detalhes</button>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
