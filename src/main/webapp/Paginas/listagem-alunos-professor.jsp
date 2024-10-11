<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hire Hub - Lista de Alunos</title>
</head>
<body>
    <div>
        <h1>Hire Hub</h1>
    </div>
    <div>
        <h2>Lista de Alunos</h2>
    
        <table>
            <thead>
                <tr>
                    <th>Matrícula</th>
                    <th>Aluno</th>
                    <th>Data de Nascimento</th>
                    <th>Status</th>
                    <th>Dossiê</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>0001</td>
                    <td>Lara Monteiro</td>
                    <td>12/03/1990</td>
                    <td><span >Formado</span></td>
                    <td><button >Editar Dossiê</button></td>
                </tr>
                <tr>
                    <td>0002</td>
                    <td>João da Silva</td>
                    <td>22/06/2000</td>
                    <td><span>Desistente</span></td>
                    <td><button >Editar Dossiê</button></td>
                </tr>
                <tr>
                    <td>0003</td>
                    <td>Beatriz Souza</td>
                    <td>15/09/1989</td>
                    <td><span >Formado</span></td>
                    <td><button>Editar Dossiê</button></td>
                </tr>
                <tr>
                    <td>0004</td>
                    <td>Rafael Costa</td>
                    <td>09/02/2004</td>
                    <td><span >Cursando</span></td>
                    <td><button>Editar Dossiê</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
