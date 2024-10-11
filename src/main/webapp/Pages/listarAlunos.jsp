<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 02/10/2024
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title> Listagem de Alunos </title>
<head>
<body>
<%@page import ="Model.Aluno, Daos.AlunoDAO, java.util.*,java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<h1> Listagem de Alunos </h1>

 <table border="1">

     <tr><th>Id</th><th> Nome</th><th>Sobrenome</th><th>Xp</th><th>Email</th><th>Senha</th><th>Turma</th><th>Editar</th><th>Excluir</th></tr>
     <%
         List<Aluno> listaAlunos = (List<Aluno>)request.getAttribute("listaAlunos");

         if (listaAlunos != null && !listaAlunos.isEmpty()) {
             for (Aluno aluno : listaAlunos) {
     %>
     <tr>
         <td><%= aluno.getId() %></td>
         <td><%= aluno.getNome() %></td>
         <td><%= aluno.getSobrenome() %></td>
         <td><%= aluno.getXp() %></td>
         <td><%= aluno.getEmail() %></td>
         <td><%= aluno.getSenha() %></td>
         <td><%= aluno.getId_turma() %></td>
         <td><a href="editarAluno.jsp?id=<%= aluno.getId() %>">Editar</a></td>
         <td><a href="ServletExcluirAluno?id=<%= aluno.getId() %>">Excluir</a></td>
<%--         <td><a href="excluirAluno.jsp?id=<%= aluno.getId() %>">Excluir</a></td>--%>
     </tr>
     <%
             }
         } else {
                 System.out.println("Nenhum aluno encontrado");
         }
     %>

</table>
</body>
</html>
