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
    <title>Adicionar Responsável</title>
</head>
<body>
<h1>Adicionar Responsável</h1>
<form action="salvarResponsavel" method="post">
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
      <td>Sobrenome:</td>
      <td><input type="text" name="sobrenome"></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><input type="text" name="email"></td>
    </tr>
    <tr>
      <td>Id_aluno:</td>
      <td><input type="number" name="id_aluno"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Salvar"></td>
    </tr>
    </table>
 </form>

</body>
</html>
