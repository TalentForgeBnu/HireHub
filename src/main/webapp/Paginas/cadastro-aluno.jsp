<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HireHub - Cadastro</title>
    <link rel="stylesheet" href="Recursos/Css/cadastro.css">
</head>

<body>
    <img src="<%=request.getContextPath()%>/Recursos/Imagens/cadastro-alunos.png" alt="Ilustração de uma pessoa em cadeira de rodas">
    <div class="formulario">
        
        <div class="topo">
            <h1>CADASTRO</h1>
            <p>Olá, aluno! Por favor preencha suas informações.</p>
        </div>
      
        <form id="formulario" action="<%=request.getContextPath()%>/inserir-aluno" method="post">
            
            <div class="tab">
                <input type="text" name="nome" placeholder="Nome" required>
                <input type="text" name="sobrenome" placeholder="Sobrenome" required>
                <input type="text" name="nome-social" placeholder="Nome Social">
                <input type="text" name="cpf" placeholder="CPF" required>
                <input type="date" name="data-nascimento" placeholder="Data de Nascimento" required>
                <select id="Etnia" name="etnia" required>
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
            </div>

            <div class="tab">
                <div class="grupo-input">
                    <select name="estado" required>
                        <option value="" disabled selected>Estado</option>
                        <option value="SC">Santa Catarina</option>
                    </select>
                    <select name="cidade" required>
                        <option value="" disabled selected>Cidade</option>
                        <option value="blumenau">Blumenau</option>
                    </select>
                </div>
                <input type="text" name="cep" placeholder="CEP">
                <div class="grupo-input">
                    <input type="text" name="bairro" placeholder="Bairro" required>
                    <input type="text" name="numero" placeholder="Número" required>
                </div>
                <input type="tel" name="telefone" placeholder="Número de Telefone" required>
                <select id="renda-familiar" name="renda-familiar" required>
                    <option value="" disabled selected>Renda Familiar</option>
                    <option value="ate-1-salario-minimo">Menos de um salário mínimo</option>
                    <option value="entre-1-a-2-salarios-minimos">Entre um a dois salários mínimos</option>
                    <option value="acima-de-6-salarios-minimos">Acima de seis salários mínimos</option>
                </select>
            </div>

            <div class="tab">
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="senha" id="senha" placeholder="Senha" required>
                <input type="password" name="confirmar-senha" id="confirmar-senha" placeholder="Confirme sua Senha" required>
            </div>

            <div class="termos">
                <input type="checkbox" name="termos" required>
                <label>Li e concordo com os <a href="#">termos de uso</a>.</label>
            </div>

            <div class="acoes-form">
                <button type="button" id="voltar">Voltar</button>
                <button type="button" id="proximo">Próximo</button>
            </div>

            <script src="<%=request.getContextPath()%>/Recursos/Scripts/lista.js"></script>

        </form>

        <footer>
            <p>Já possui uma conta? <a href="<%=request.getContextPath()%>/login">Entrar</a></p>
        </footer>
    </div>
</body>
</html>