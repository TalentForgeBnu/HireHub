<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub</title>
</head>
<body>
    <h2>Cadastro</h2>
       <ul>
           <li><a href="Paginas/cadastro-aluno.jsp">Cadastro Aluno</a></li>
           <li><a href="Paginas/cadastro-curriculo.jsp">Cadastro Currículo</a></li>
           <li><a href="Paginas/cadastro-curso.jsp">Cadastro Curso</a></li>
           <li><a href="Paginas/cadastro-dossie.jsp">Cadastro Dossie</a></li>
           <li><a href="Paginas/cadastro-empresa.jsp">Cadastro Empresa</a></li>
           <li><a href="Paginas/cadastro-instituicao.jsp">Cadastro Instituição</a></li>
           <li><a href="Paginas/cadastro-professor.jsp">Cadastro Professor</a></li>
           <li><a href="Paginas/cadastro-turma.jsp">Cadastro Turma</a></li>
           <li><a href="Paginas/cadastro-vaga.jsp">Cadastro Vaga</a></li>
       </ul>
   <h2>Login</h2>
          <ul>
              <li><a href="Paginas/tela-login.jsp">Login</a></li>
              <li><a href="<%=request.getContextPath()%>/usuario-logout">Logout (direto)</a></li>
          </ul>
    <h2>Listagem</h2>
       <ul>
           <li><a href="Paginas/listagem-alunos-professor.jsp">Listagem Alunos</a></li>
           <li><a href="<%=request.getContextPath()%>/recuperar-lista-cursos">Listagem Cursos</a></li>
           <li><a href="<%=request.getContextPath()%>/recuperar-lista-turma">Listagem Turmas</a></li>
           <li><a href="<%=request.getContextPath()%>/recuperar-lista-vagas">Listagem Vagas</a></li>
       </ul>
    <h2>Perfis</h2>
       <ul>
           <li><a href="<%=request.getContextPath()%>/recuperar-perfil-aluno">Perfil Aluno</a></li>
           <li><a href="<%=request.getContextPath()%>/recuperar-perfil-empresa">Perfil Empresa</a></li>
           <li><a href="<%=request.getContextPath()%>/recuperar-perfil-instituicao">Perfil Instituição</a></li>
           <li><a href="<%=request.getContextPath()%>/recuperar-perfil-professor">Perfil Professor</a></li>
       </ul>
</body>
</html>