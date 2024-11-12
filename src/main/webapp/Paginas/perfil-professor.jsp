<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-16"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>HireHub - Perfil</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/Recursos/Css/perfil-aluno.css"
    />
  </head>
  <body>
    <header>
      <div class="voltar">←</div>
      <div class="nome">Hirehub</div>
      <div class="excluir">Excluir conta <img src="#" alt="Excluir conta"/>
      </div>
    </header>

    <div class="pfp">
      <div class="foto">
        <img src="${pageContext.request.contextPath}/Recursos/Paginas/avatar-padrao.png" alt="Foto de Perfil" />
        <div class="editarbotao">Editar</div>
      </div>
    </div>
    <div class="container">
      <form action="<%=request.getContextPath()%>/atualizar-perfil-professor" method="post" >
        <input type="hidden" value="${professor.id}" id="id" name="id" />
        <input type="text" value="${professor.cpf}" disabled/>
        <input type="text" value="${professor.nome}" placeholder="Nome" id="nome" name="nome"/>
        <input type="text" value="${professor.sobrenome}" placeholder="Sobrenome" id="sobrenome" name="sobrenome"/>
        <input type="text" value="${professor.nomeSocial}" placeholder="Nome Social" id="nome-social" name="nome-social"/>
        <input type="date" value="${professor.dataNascimento}" placeholder="Data de Nascimento" id="data-nascimento" name="data-nascimento"/>
        <input type="text" value="${professor.senha}" placeholder="Senha" id="senha" name="senha"/>

        <select id="etnia" name="etnia">
          <option value="${aluno.etnia}" disabled selected>${professor.etnia}</option>
          <option value="branco">Branco</option>
          <option value="preto">Preto</option>
          <option value="pardo">Pardo</option>
          <option value="indigena">Indígena</option>
          <option value="asiatico">Asiático</option>
        </select>

        <select id="sexo" name="sexo">
          <option value="${aluno.sexo}" disabled selected>${professor.sexo}</option>
          <option value="masculino">Masculino</option>
          <option value="feminino">Feminino</option>
          <option value="outros">Outros</option>
        </select>

        <div class="input-group">
          <select id="estado" name="estado">
            <option value="${endereco.estado}" disabled selected>${endereco.estado}</option>
            <option value="SC">Santa Catarina</option>
            <!-- Coloque aqui as opções de estado -->
          </select>
          <select id="cidade" name="cidade">
            <option value="${endereco.cidade}" disabled selected>${endereco.cidade}s</option>
            <option value="blumenau">Blumenau</option>
            <!-- Coloque aqui as opções de cidade -->
          </select>
        </div>

        <div class="input-group">
            <input type="text" value="${endereco.bairro}" name="bairro" placeholder="Bairro">
            <input type="text" value="${endereco.numero}" name="numero" placeholder="Número">
        </div>

        <div class="input-group">
            <input type="text" value="${endereco.cep}" name="cep" placeholder="CEP">
            <input type="text" value="${endereco.logradouro}" name="logradouro" placeholder="Logradouro">
            <input type="text" value="${endereco.tipoVia}" name="via" placeholder="Via">
            <input type="text" value="${endereco.complemento}" name="complemento" placeholder="Complemento">
        </div>

        <button type="submit">Atualizar</button>
      </form>
    </div>
  </body>
</html>
