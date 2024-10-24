<%@ page import="Model.Escola" %><%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 21/10/2024
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/editarEscola.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Editar Escola</title>
    <%
        Escola escola = (Escola) request.getAttribute("escola");
    %>
</head>
<body>
<h1>Editar Escola</h1>
<form action="atualizarEscola" method="post">
    <input type="hidden" name="id" value="<%=escola.getId()%>">
    <table>
        <strong>Edite uma informação da escola <%=escola.getNome()%>:</strong>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="<%=escola.getNome()%>" id="inputNome"></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><input type="email" name="email" value="<%=escola.getEmail()%>" id="inputEmail"></td>
        </tr>
        <tr>
            <td>Telefone:</td>
            <td><input type="number" name="telefone" value="<%=escola.getTelefone()%>" id="inputTelefone"></td>
        </tr>
        <tr>
            <td>Id_endereco:</td>
            <td><input type="text" name="id_endereco" value="<%=escola.getId_endereco()%>" id="inputEndereco"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvar" id="salvar"></td>
        </tr>
    </table>
</form>
</body>
</html>