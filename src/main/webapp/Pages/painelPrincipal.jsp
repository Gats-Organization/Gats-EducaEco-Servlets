<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 05/10/2024
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Painel Principal</title>
    <link rel="stylesheet" href="CSS/painelPrincipal.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
</head>
<body>
<div class="Titulo">
    <h1>Bem-vindo ao Painel de Administração</h1>
    <p>Escolha uma tabela para visualizar:</p>
</div>
<div class="botoes">
    <a href="listarAlunos" id="botaoAluno">Aluno</a>
    <a href="listarAdmin" id="botaoAdmin">Admin</a>
    <a href="listarEscola" id="botaoEscola">Escola</a>
    <a href="listarProfessor" id="botaoProfessor">Professor</a>
    <a href="listarResponsavel" id="botaoResponsavel">Responsável</a>
    <a href="listarTurma" id="botaoTurma">Turma</a>
</div>
<br><br>
</body>
</html>
