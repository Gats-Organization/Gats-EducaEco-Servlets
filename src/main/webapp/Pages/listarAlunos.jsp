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
<h1> Listagem de Alunos </h1>
<%
//    AlunoDAO alunoDAO = new AlunoDAO();
//    ResultSet rs = alunoDAO.listarAlunos();
    ResultSet rs = (ResultSet)request.getAttribute("resultSetAlunos");


%>

 <table><tr><th>Id</th><th> Nome</th><th>Sobrenome</th><th>Xp</th><th>Email</th><th>Senha</th><th>Turma</th></tr>
  <%
   try{
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
      <td><a href="editarAluno.jsp?id=${Aluno.id}<%= rs.getInt("id") %>">Editar</a></td>
      <td><a href="excluirAluno.jsp?id=<%= rs.getInt("id") %>">Excluir</a></td>

  </tr>
  <%

   }
   }catch(SQLException e){
       e.printStackTrace();
   }
  %>

</html>
