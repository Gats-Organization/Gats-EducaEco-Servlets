<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 11/10/2024
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Aluno</title>
</head>
<body>
<h2>Adicionar Novo Controller.Aluno</h2>

<form action="salvarAluno" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="number" name="id" required></td>
        </tr>
        </tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" required></td>
        </tr>
        <tr>
            <td>Sobrenome:</td>
            <td><input type="text" name="sobrenome" required></td>
        </tr>
        <tr>
            <td>Xp:</td>
            <td><input type="number" name="xp" required></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" required></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha" required></td>
        </tr>
        <tr>
            <td>Id-Turma:</td>
            <td><input type="number" name="id_turma" required></td>
        </tr>
        <tr>
            <td><input type="submit" value="Adicionar Controller.Aluno"></td>
        </tr>
    </table>
</form>

<!-- Aqui você poderia incluir lógica JSP para exibir mensagens de erro ou sucesso -->
<%--<%--%>
<%--    if (request.getAttribute("erro") != null) {--%>
<%--%>--%>
<%--<p style="color:red;"><%= request.getAttribute("erro") %></p>--%>
<%--<%--%>
<%--} else if (request.getAttribute("sucesso") != null) {--%>
<%--%>--%>
<%--<p style="color:green;"><%= request.getAttribute("sucesso") %></p>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
</body>
</html>

