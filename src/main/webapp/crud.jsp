<%--
  Created by IntelliJ IDEA.
  User: mariacacciatore-ieg
  Date: 01/10/2024
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teste tela do Crud</title>
</head>
<body>
    <h1>Olá CRUD</h1>
    <p>O e-mail é: <%=request.getParameter("email")%></p>
    <p>A senha é: <%=request.getParameter("senha")%></p>
</body>
</html>
