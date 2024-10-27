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
    <link rel="stylesheet" href="CSS/listarAdmin.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
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
    <tr id="colunas">
        <th>Id</th>
        <th>Nome</th>
        <th>E-mail</th>
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
        <form action="editarAdmins" method="get">
            <input type="hidden" name="id" value="<%= admin.getId() %>">
            <button id="botao" type="submit">
                <img src="Imagens Login/Lápis.png" alt="Lápis">
                Editar
            </button>
        </form>
        </td>
        <td id="excluir">
            <a href="ServletExcluirAdmin?id=<%= admin.getId() %>">
                <img src="Imagens Login/Lixeira.png" alt="Lixeira">
                Excluir
            </a>
        </td>
    </tr>
    <%
    }
        }else{
            System.out.println("Nenhum administrador encontrado");
        }
%>
</table>
<br>
<div class="botaoAddAdmin">
    <a id="addAdmin" href="adicionarAdmin"><strong>+ Adicionar Admin</strong></a>
</div>
<br><br>
</body>
</html>
