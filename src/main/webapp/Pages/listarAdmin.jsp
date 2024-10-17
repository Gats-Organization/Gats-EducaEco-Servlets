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
<%
    AdminDAO adminDAO = new AdminDAO();
    List<Admin> listaAdmin = adminDAO.listarAdmins();
    request.setAttribute("listaAdmin", listaAdmin);
    %>
<h1>Listagem de Administradores</h1>


<table border="1">
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Senha</th>
        <th>Editar</th>
        <th>Excluir</th>
    </tr>
    <%
        if(listaAdmin != null && !listaAdmin.isEmpty()){
        for(Admin admin : listaAdmin){
    %>
    <tr>
        <td><%=admin.getId()%></td>
        <td><%=admin.getNome()%></td>
        <td><%=admin.getEmail()%></td>
        <td><%=admin.getSenha()%></td>
        <td>
        <form action="ServletEditarAluno" method="post">
            <input type="hidden" name="id" value="<%= admin.getId() %>">
            <button type="submit">Editar</button>
        </form>

        </td>
        <td><a href="ServletExcluirAluno?id=<%= admin.getId() %>" >Excluir</a></td>
    </tr>
    <%
    }
        }else{
            System.out.println("Nenhum administrador encontrado");
        }
%>
</body>
</html>
