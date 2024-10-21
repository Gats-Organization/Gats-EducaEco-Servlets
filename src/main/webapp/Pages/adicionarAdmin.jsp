<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 20/10/2024
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="salvarAdmin" method="post">
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
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvar"></td>
        </tr>

        </table>
   </form>
</body>
</html>
