<!DOCTYPE html>
<html>
<head>
    <title>Perfil</title>
</head>
<body>
    <div>
    <p>Excluir Perfil</p>
    </div>
    <div>
        <form>
        <label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Nome">

        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Sobrenome">
        
        <label for="nomesocial">Nome Social</label>
        <input type="text" name="nomesocial" placeholder="Nome Social">
        
        <label for="datanascimento">Data de Nascimento</label>
        <input type="date" name="datanascimento" placeholder="Data de Nascimento">

        <label for="etnia">Etnia</label>
        <select name="etnia">
            <option value="branca">Branco</option>
            <option value="preta">Pardo</option>
            <option value="parda">Preto</option>
            <option value="asiatico">Asiatico</option>
            <option value="indigena">Indígena</option>
        </select>

        <label for="sexo">Sexo</label>
        <select name="sexo">
            <option value="" disabled selected>Selecione seu sexo</option>
            <option value="masculino">Masculino</option>
            <option value="feminino">Feminino</option>
            <option value="prefironaoinformar">Prefiro Não informar</option>
            <option value="outro">Outro</option>
        </select>


        <label for="endereco">Endereço</label>
        <input type="text" name="endereco" placeholder="Endereço">
    </form>
    </div>
</body>
</html>
