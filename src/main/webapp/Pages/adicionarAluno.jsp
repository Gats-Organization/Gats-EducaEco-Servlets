<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 11/10/2024
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/adicionarAluno.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Adicionar Aluno</title>
</head>
<body>
<h1>Adicionar Aluno</h1>
<strong>Para adicionar um novo aluno, preencha os seguintes campos:</strong>
<br>
<form action="salvarAluno" method="post">
    <table>
        <tr>
            <td><input type="hidden" name="id" required id="inputId"></td>
        </tr>
        </tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" required id="inputNome"></td>
        </tr>
        <tr>
            <td>Sobrenome:</td>
            <td><input type="text" name="sobrenome" required id="inputSobrenome"></td>
        </tr>
        <tr>
            <td>Xp:</td>
            <td><input type="number" name="xp" required id="inputXp"></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><input type="email" name="email" required id="inputEmail"></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha" required id="inputSenha"></td>
        </tr>
        <tr>
            <td>Turma:</td>
            <td><input type="text" name="turma" required id="inputTurma"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvar" id="salvar"></td>
        </tr>
    </table>
</form>

<!-- Aqui você poderia incluir lógica JSP para exibir mensagens de erro ou sucesso -->
<%--<%--%>
<%--    if (request.getAttribute("erro") != null) {--%>
<%--%>--%>
<%--<p style="color:red;"><%= request.getAttribute("erro") %></p>--%>
<%--<%--%>
<%--} else if (request.getAttribute("sucesso") != null) {--%>
<%--%>--%>
<%--<p style="color:green;"><%= request.getAttribute("sucesso") %></p>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
</body>
</html>

