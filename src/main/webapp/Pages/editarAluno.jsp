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
    <link rel="stylesheet" href="CSS/editarAluno.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Editar Aluno </title>
</head>
<body>
<h1>Editar Aluno</h1>
<%@page import="Daos.AlunoDAO,Model.Aluno"%>

<%
    Aluno aluno = (Aluno) request.getAttribute("aluno");

%>

<form action="atualizarAluno" method="post">
    <input type="hidden" name="id" value="<%=aluno.getId()%>">
    <table>
        <strong>Edite uma informação do aluno <%=aluno.getNome()%>:</strong>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="<%=aluno.getNome()%>" id="inputNome"></td>
        </tr>
        <tr>
            <td>Sobrenome:</td>
            <td><input type="text" name="sobrenome" value="<%=aluno.getSobrenome()%>" id="inputSobrenome"></td>
        </tr>
        <tr>
            <td>Xp:</td>
            <td><input type="text" name="xp" value="<%=aluno.getXp()%>" id="inputXp"></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><input type="text" name="email" value="<%=aluno.getEmail()%>" id="inputEmail"></td>
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha" value="<%=aluno.getSenha()%>" id="inputSenha"></td>
        </tr>
        <tr>
            <td>Id-Turma:</td>
            <td><input type="text" name="id_turma" value="<%=aluno.getId_turma()%>" id="inputTurma"></td>

        </tr>
        <tr id="botaoSalvar">
<%--     <button><a href="/Pages/listarAluno.jsp"><input type="submit" value="Salvar"></a></button>       <a href="/Pages/listarAluno.jsp">Voltar</a>--%>
            <td><input type="submit" value="Salvar" id="salvar"></td>
        </tr>
    </table>
</form>



</body>
</html>
