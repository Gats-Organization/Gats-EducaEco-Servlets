<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 20/10/2024
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/adicionarProfessor.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Adicionar Professor</title>
</head>
<body>
<h1>Adicionar Professor</h1>
<strong>Para adicionar um novo professor, preencha os seguintes campos:</strong>
<br>
<form action="salvarProfessor" method="post">
    <table>
        <tr>
            <td>Id</td>
             <td><input type="number" name="id" id="inputId"></td>
        </tr>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" id="inputNome"></td>
        </tr>
        <tr>
            <td>Sobrenome:</td>
            <td><input type="text" name="sobrenome" id="inputSobrenome"></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><input type="email" name="email" id="inputEmail"></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha" id="inputSenha"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvar" id="salvar"></td>
        </tr>
        </table>
</form>

</body>
</html>
