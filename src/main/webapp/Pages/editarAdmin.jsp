<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 20/10/2024
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Administrador</title>
</head>
<body>
<%@page import="Daos.AdminDAO,Model.Admin" %>
<%
    Admin admin = (Admin) request.getAttribute("admin");

%>
<form action="atualizarAdmin" method="post">
    <input type="hidden" name="id" value="<%=admin.getId()%>">
    <table>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="<%=admin.getNome()%>"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="<%=admin.getEmail()%>"></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha" value="<%=admin.getSenha()%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Atualizar"></td>
        </tr>
    </table>
</form>
</body>
</html>
