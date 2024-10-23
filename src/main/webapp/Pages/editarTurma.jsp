<%@ page import="Model.Turma" %><%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 22/10/2024
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Turma</title>
</head>
<body>
<%
    Turma turma = (Turma) request.getAttribute("turma");
%>
<form action="atualizarTurma" method="post">
    <input type="hidden" name="id" value="<%=turma.getId()%>">
    <table>
        <tr>
            <td>Serie:</td>
            <td><input type="number" name="serie" value="<%=turma.getSerie()%>"></td>
        </tr>
        <tr>
            <td>Nomenclatura:</td>
            <td><input type="text" name="nomenclatura" value="<%=turma.getNomenclatura()%>"></td>
        </tr>
        <tr>
            <td>Ano:</td>
            <td><input type="number" name="ano" value="<%=turma.getAno()%>"></td>
        </tr>
        <tr>
            <td>Id_professor:</td>
            <td><input type="number" name="id_professor" value="<%=turma.getId_professor()%>"></td>
        </tr>
        <tr>
            <td>Id_escola:</td>
            <td><input type="number" name="id_escola" value="<%=turma.getId_escola()%>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Salvar"></td>
        </tr>
        </table>
</form>
</body>
</html>
