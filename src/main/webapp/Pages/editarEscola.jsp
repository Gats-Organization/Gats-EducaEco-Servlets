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
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="<%=escola.getNome()%>"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" value="<%=escola.getEmail()%>"></td>
        </tr>
        <tr>
            <td>Telefone:</td>
            <td><input type="number" name="telefone" value="<%=escola.getTelefone()%>"></td>
        </tr>
        <tr>
            <td>Id_endereco:</td>
            <td><input type="text" name="id_endereco" value="<%=escola.getId_endereco()%>"></td>
        </tr>
        <tr>
            <input type="submit" value="Atualizar">
        </tr>
    </table>
</form>


</body>
</html>
