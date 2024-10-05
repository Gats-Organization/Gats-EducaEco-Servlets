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

   while(rs.next()){
    Aluno aluno = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("sobrenome"), rs.getInt("xp"), rs.getString("email"), rs.getString("senha"), rs.getInt("id_turma"));
  %>
  <tr><td><%=aluno.getId()%></td>
      <td><%=aluno.getNome()%></td>
      <td><%=aluno.getSobrenome()%></td>
      <td><%=aluno.getXp()%></td>
      <td><%=aluno.getEmail()%></td>
      <td><%=aluno.getSenha()%></td>
      <td><%=aluno.getId_turma()%></td>
  </tr>
  <%
   }
  %>

</html>
