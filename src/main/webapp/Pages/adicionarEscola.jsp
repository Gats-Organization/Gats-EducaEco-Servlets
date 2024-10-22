<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 22/10/2024
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Escola</title>
</head>
<body>
<form action="salvarEscola" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Telefone:</td>
            <td><input type="text" name="telefone"></td>
        </tr>
        <tr>
            <td>Id_endereço:</td>
            <td><input type="number" name="id_endereco"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvar"></td>
        </tr>
    </table>
</form>


</body>
</html>
