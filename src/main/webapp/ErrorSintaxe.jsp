<%--
  Created by IntelliJ IDEA.
  User: mariacacciatore-ieg
  Date: 01/10/2024
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Erro</title>
</head>
<body>
    <jsp:include page="index.html" flush="true"/>
    <p style="color: rgb(205, 11, 11); text-align: center">
        <strong>Login e/ou senha inválido(s). Tente novamente.</strong>
    </p>
</body>
</html>
