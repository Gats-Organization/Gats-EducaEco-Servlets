<%@ page import="Model.Professor" %><%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 20/10/2024
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/editarProfessor.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/voltarEditar.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Editar Professor</title>
</head>
<body>
<%
        Professor professor = (Professor) request.getAttribute("professor");
%>
<h1>Editar Professor</h1>
<form action="atualizarProfessor" method="post">
<input type="hidden" name="id" value="<%=professor.getId() %>">
        <table>
            <strong>Edite uma informação do(a) professor(a) <%=professor.getNome() %>:</strong>
            <tr>
                <td>Nome:</td>
                <td><input type="text" name="nome" value="<%=professor.getNome() %>" id="inputNome"></td>
                </tr>
            <tr>
                <td>Sobrenome:</td>
                <td><input type="text" name="sobrenome" value="<%=professor.getSobrenome() %>" id="inputSobrenome"></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="email" name="email" value="<%=professor.getEmail() %>" id="inputEmail"></td>
            </tr>
            <tr>
                <td>Senha:</td>
                <td><input type="password" name="senha" value="<%=professor.getSenha() %>" id="inputSenha"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Salvar" id="salvar"></td>
            </tr>
        </table>
</form>
<div id="voltar">
    <a href="listarProfessor" style="text-decoration: none; color: #000000">Voltar a listagem</a>
</div>
</body>
</html>
