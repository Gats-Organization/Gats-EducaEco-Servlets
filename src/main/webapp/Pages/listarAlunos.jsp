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
<h1> Listagem de Alunos </h1>
<%
    AlunoDAO alunoDAO = new AlunoDAO();
    ResultSet rs = alunoDAO.listarAlunos();


%>

 <table><tr><th>Id</th><th> Nome</th><th>Sobrenome</th><th>Xp</th><th>Email</th><th>Senha</th><th>Turma</th></tr>
  <%

   while (rs.next()){

  %>

  <tr>
      <td><%= rs.getInt("id") %></td>
      <td><%= rs.getString("nome") %></td>
      <td><%= rs.getString("sobrenome") %></td>
      <td><%= rs.getInt("xp") %></td>
      <td><%= rs.getString("email") %></td>
      <td><%= rs.getString("senha") %></td>
      <td><%= rs.getInt("id_turma") %></td>
  </tr>
  <%
   }
  %>

</html>
