<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 06/10/2024
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Aluno </title>
</head>
<body>
<%@page import="Daos.AlunoDAO,Model.Aluno"%>

<%
    Aluno aluno = (Aluno) request.getAttribute("aluno");

    try {

    } catch (Exception e) {
        e.printStackTrace();
    }

    if (aluno != null) {
    } else {

    }
%>

<form action="ServletEditarAluno" method="post">
    <input type="hidden" name="id" value="<%=aluno.getId()%>">
    <table>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="<%=aluno.getNome()%>"></td>
        </tr>
        <tr>
            <td>Sobrenome:</td>
            <td><input type="text" name="sobrenome" value="<%=aluno.getSobrenome()%>"></td>
        </tr>
        <tr>
            <td>xp:</td>
            <td><input type="text" name="xp" value="<%=aluno.getXp()%>"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="<%=aluno.getEmail()%>"></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha" value="<%=aluno.getSenha()%>"></td>
        </tr>
        <tr>
            <td>Id-Turma:</td>
            <td><input type="text" name="id_turma" value="<%=aluno.getId_turma()%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvar"></td>
        </tr>
    </table>
</form>



</body>
</html>
