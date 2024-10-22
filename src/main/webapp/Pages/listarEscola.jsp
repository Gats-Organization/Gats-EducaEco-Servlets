<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 16/10/2024
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Escolas</title>
    <%@page import="Daos.EscolaDAO,Model.Escola, java.util.List" %>
</head>
<body>
<h1>Listar Escolas</h1>
<table border="1">
    <%
      EscolaDAO escolaDAO = new EscolaDAO();
      List<Escola> listarEscolas = escolaDAO.listarEscolas();



    %>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>Id_endereco</th>
        <th>Editar</th>
        <th>Excluir</th>
    </tr>
    <%
        if( listarEscolas!= null && !listarEscolas.isEmpty()){
        for(Escola escola : listarEscolas){
    %>
    <tr>
        <td><%=escola.getId()%></td>
        <td><%=escola.getNome()%></td>
        <td><%=escola.getEmail()%></td>
        <td><%=escola.getTelefone()%></td>
        <td><%=escola.getId_endereco()%></td>
        <td>
            <form action="editarEscola" method="get">
                <input type="hidden" name="id" value="<%=escola.getId()%>">
                <input type="submit" value="Editar">
            </form>
        </td>

        <td> <a href="excluirEscola?id=<%=escola.getId()%>">Excluir</a></td>
    </tr>
    <%}
}else{
            System.out.println("Não existem escolas registadas");
}

%>

</table>
<a href="adicionarEscola">Adicionar Escola</a>

</body>
</html>
