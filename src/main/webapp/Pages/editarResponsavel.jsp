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
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="<%= responsavel.getNome() %>"></td>
        </tr>
        <tr>
            <td>Sobrenome:</td>
            <td><input type="text" name="sobrenome" value="<%= responsavel.getSobrenome() %>"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="<%= responsavel.getEmail() %>"></td>
        </tr>
        <tr>
            <td>Id_Aluno:</td>
            <td><input type="text" name="id_aluno" value="<%= responsavel.getId_aluno() %>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Atualizar"></td>
        </tr>
    </table>
    </form>
</body>
</html>
