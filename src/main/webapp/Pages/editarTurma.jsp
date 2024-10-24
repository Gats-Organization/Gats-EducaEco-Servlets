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
    <link rel="stylesheet" href="CSS/editarTurma.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Editar Turma</title>
</head>
<body>
<h1>Editar Turma</h1>
<%
    Turma turma = (Turma) request.getAttribute("turma");
%>
<form action="atualizarTurma" method="post">
    <input type="hidden" name="id" value="<%=turma.getId()%>">
    <table>
        <strong>Edite uma informação da turma <%=turma.getSerie()%>º <%= turma.getNomenclatura() %>:</strong>
        <tr>
            <td>Serie:</td>
            <td><input type="number" name="serie" value="<%=turma.getSerie()%>" id="inputSerie"></td>
        </tr>
        <tr>
            <td>Nomenclatura:</td>
            <td><input type="text" name="nomenclatura" value="<%=turma.getNomenclatura()%>" id="inputNomeclarura"></td>
        </tr>
        <tr>
            <td>Ano:</td>
            <td><input type="number" name="ano" value="<%=turma.getAno()%>" id="inputAno"></td>
        </tr>
        <tr>
            <td>Id_professor:</td>
            <td><input type="number" name="id_professor" value="<%=turma.getId_professor()%>" id="inputIdProfessor"></td>
        </tr>
        <tr>
            <td>Id_escola:</td>
            <td><input type="number" name="id_escola" value="<%=turma.getId_escola()%>" id="inputIdEscola"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Salvar" id="salvar"></td>
        </tr>
        </table>
</form>
</body>
</html>
