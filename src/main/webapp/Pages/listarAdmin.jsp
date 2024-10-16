<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 16/10/2024
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Administradores</title>
</head>
<body>
<%@page import="Model.Admin, Daos.AdminDAO"%>
<%@ page import="java.util.List" %>
<h1>Listagem de Administradores</h1>


<table border="1">
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Senha</th>
    </tr>
    <%
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> listaAdmin = adminDAO.listarAdmins();
        for(Admin admin : listaAdmin){
    %>
    <tr>
        <td><%=admin.getId()%></td>
        <td><%=admin.getNome()%></td>
        <td><%=admin.getEmail()%></td>
        <td><%=admin.getSenha()%></td>
    </tr>
    <%
        }%>
</body>
</html>
