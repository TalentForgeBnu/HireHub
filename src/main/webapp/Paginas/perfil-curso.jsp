<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil Curso</title>
</head>
<body>
        <div>     
            <label>Nome: ${curso.nome}</label>
            <label>Área de Atuação: ${curso.areaAtuacao}"</label>
            <label>Disponibilidade: ${curso.disponibilidade}"</label>
            <label>Data de Início: ${curso.dataInicio}"</label>
            <label>Data de Término: ${curso.dataFim}"</label>
            <label>Descrição: ${curso.descricao}</label>
        </div>
        <form action="<%=request.getContextPath()%>/inscricao-turma" method="post">        
           <input type="hidden" id="id-curso" name="id-curso" value="${curso.id}">
           <div class="form-group">
                    <select id="turno" name="turno" required>
                        <option value="" disabled selected>Turno</option>
                        <option value="matutino">Matutino</option>
                        <option value="vespertino">Vespertino</option>
                        <option value="noturno">Noturno</option>
                        <option value="integral">Integral</option>
                    </select>                  
                </div>       
           <button type="submit">Inscrever-se</button>
        </form>
</body>
</html>