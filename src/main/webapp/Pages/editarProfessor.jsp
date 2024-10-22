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
            <tr>
                <td>Nome:</td>
                <td><input type="text" name="nome" value="<%=professor.getNome() %>"></td>
                </tr>
            <tr>
                <td>Sobrenome:</td>
                <td><input type="text" name="sobrenome" value="<%=professor.getSobrenome() %>"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="<%=professor.getEmail() %>"></td>
            </tr>
            <tr>
                <td>Senha:</td>
                <td><input type="password" name="senha" value="<%=professor.getSenha() %>"></td>
                </tr>
                <tr>
                        <td><input type="submit" value="Salvar"></td>
                </tr>
                </table>
        </form>

</body>
</html>
