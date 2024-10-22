<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 20/10/2024
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Responsável</title>
  <%@ page import="Model.Responsavel" %>
  <%@ page import="java.util.List" %>
  <%@ page import="Daos.ResponsavelDAO" %>

  <%
    ResponsavelDAO responsavelDao = new ResponsavelDAO();
    List<Responsavel> listaResponsavel = responsavelDao.listarResponsavel();
  request.setAttribute("listaResponsavel", listaResponsavel);
  %>
</head>
<body>
<h1>Listar Responsável</h1>
<table border="1">

  <tr>
    <th>Id</th>
    <th>Nome</th>
    <th>Sobrenome</th>
    <th>Email</th>
    <th>Id_Aluno</th>
    <th>Editar</th>
    <th>Excluir</th>
  </tr>
    <%
        if(listaResponsavel != null && !listaResponsavel.isEmpty()){
          for(Responsavel responsavel : listaResponsavel){
  %>
      <tr>
        <td><%= responsavel.getId()%></td>
        <td><%= responsavel.getNome()%></td>
        <td><%= responsavel.getSobrenome()%></td>
        <td><%= responsavel.getEmail()%></td>
        <td><%= responsavel.getId_aluno()%></td>
        <td>

          <form action="editarResponsavel" method="get">
            <input type="hidden" name="id" value="<%= responsavel.getId()%>">
            <input type="submit" value="Editar">
          </form>
        </td>
        <td>
        <a href="excluirResponsavel?id=<%= responsavel.getId()%>">Excluir</a>
        </td>
       </tr>

          <%
             }
        }else{
          System.out.println("Nenhum responsável foi encontrado");
        }
%>
  </table>
<br><
<a href="adicionarResponsavel">Adicionar Responsável</a>
</body>
</html>
