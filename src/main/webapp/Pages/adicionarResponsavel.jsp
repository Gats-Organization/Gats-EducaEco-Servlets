<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 21/10/2024
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="CSS/adicionarResponsavel.css">
  <link rel="stylesheet" href="CSS/style.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
  <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Adicionar Responsável</title>
</head>
<body>
<h1>Adicionar Responsável</h1>
<form action="salvarResponsavel" method="post">
  <table>
    <strong>Para adicionar um novo responsável, preencha os seguintes campos:</strong>
    <tr>
      <td>Id:</td>
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
      <td><input type="text" name="email" id="inputEmail"></td>
    </tr>
    <tr>
      <td>Aluno:</td>
      <td><input type="text" name="aluno" id="inputIdAluno"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Salvar" id="salvar"></td>
    </tr>
    </table>
 </form>

</body>
</html>
