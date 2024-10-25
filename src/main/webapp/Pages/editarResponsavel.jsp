<%@ page import="Model.Responsavel" %><%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 21/10/2024
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/editarResponsavel.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Editar Responsável</title>
    <%
        Responsavel responsavel = (Responsavel) request.getAttribute("responsavel");
    %>
</head>
<body>
<h1>Editar Responsável</h1>
<form action="atualizarResponsavel" method="post">
    <input type="hidden" name="id" value="<%= responsavel.getId() %>">
    <table>
        <strong>Edite uma informação do(a) responsável <%= responsavel.getNome() %>:</strong>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="<%= responsavel.getNome() %>" id="inputNome"></td>
        </tr>
        <tr>
            <td>Sobrenome:</td>
            <td><input type="text" name="sobrenome" value="<%= responsavel.getSobrenome() %>" id="inputSobrenome"></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><input type="text" name="email" value="<%= responsavel.getEmail() %>" id="inputEmail"></td>
        </tr>
        <tr>
            <td>Id_Aluno:</td>
            <td><input type="text" name="id_aluno" value="<%= responsavel.getId_aluno() %>" id="inputIdAluno"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Salvar" id="salvar"></td>
        </tr>
    </table>
    </form>
</body>
</html>
