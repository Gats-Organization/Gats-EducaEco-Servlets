<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 22/10/2024
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Turma</title>
</head>
<body>
<form action="salvarTurma" method="post">
<table>
    <tr>
        <td>Id:</td>
        <td><input type="number" name="id"></td>
    </tr>
    <tr>
        <td>Serie:</td>
        <td><input type="number" name="serie"></td>
    </tr>
    <tr>
        <td>Nomenclatura:</td>
        <td><input type="text" name="nomenclatura"></td>
    </tr>
    <tr>
        <td>Ano:</td>
        <td><input type="number" name="ano"></td>
    </tr>
    <tr>
        <td>Id_professor:</td>
        <td><input type="text" name="id_professor"></td>
    </tr>
    <tr>
        <td>Id_escola:</td>
        <td><input type="text" name="id_escola"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Salvar"></td>
    </tr>

</table>
</form>
</body>
</html>
