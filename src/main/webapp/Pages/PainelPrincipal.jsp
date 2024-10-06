<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 05/10/2024
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Painel Principal</title>
</head>
<body>
<h1>Bem-vindo ao Painel de Administração</h1>
<p>Escolha uma tabela para visualizar:</p>

<!-- Botão que redireciona para o Servlet de listagem de alunos -->
<%--<form action="listarAlunos" method="get">--%>
<%--    <button type="submit">Listar Alunos</button>--%>
<%--</form>--%>

<a href="listarAlunos">Alunos</a>

<!-- Exemplo de outro botão para listar outra tabela -->
<%--<form action="listarAlunos" method="get">--%>
<%--    <button type="submit">Alunos</button>--%>
<%--</form>--%>
</head>
</body>
</html>
