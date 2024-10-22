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
    <link rel="stylesheet" href="CSS/listarAlunos.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
</head>
<body>
<%@page import ="Model.Aluno, Daos.AlunoDAO, java.util.*,java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="Model.AlunoDTO" %>
<h1> Listagem de Alunos </h1>

 <table border="1">

     <tr id="colunas">
         <th>Id</th>
         <th> Nome</th>
         <th>Sobrenome</th>
         <th>Xp</th>
         <th>Email</th>
         <th>Senha</th>
         <th>Turma</th>
         <th>Editar</th>
         <th>Excluir</th>
     </tr>
     <%
         List<AlunoDTO> listaAlunos = (List<AlunoDTO>)request.getAttribute("listaAlunos");

         if (listaAlunos != null && !listaAlunos.isEmpty()) {
             for (AlunoDTO aluno : listaAlunos) {
     %>
     <tr>
         <td><%= aluno.getId() %></td>
         <td><%= aluno.getNome() %></td>
         <td><%= aluno.getSobrenome() %></td>
         <td><%= aluno.getXp() %></td>
         <td><%= aluno.getEmail() %></td>
         <td><%= aluno.getSenha() %></td>
         <td><%= aluno.getSerie() %> - <%= aluno.getNomeclantura() %></td>
         <td id="editar">
            <form action="buscarAluno" method="get">
                <input type="hidden" name="id" value="<%= aluno.getId() %>">
                <button id="botao" type="submit">
                    <img src="Imagens Login/Lápis.png" alt="Lápis">
                    Editar
                </button>
            </form>
         </td>
         <td id="excluir">
         <a href="ServletExcluirAluno?id=<%= aluno.getId() %>">
             <img src="Imagens Login/Lixeira.png" alt="Lixeira">
             Excluir
         </a>
         </td>
     </tr>
     <%
             }
         } else {
                 System.out.println("Nenhum aluno encontrado");
         }
     %>


<%--     <script type="text/javascript">--%>
<%--         function confirmarExclusao() {--%>
<%--             return confirm("Tem certeza que deseja excluir este aluno?");--%>
<%--         }--%>
<%--     </script>--%>

</table>
<br>
<div class="botaoAddAluno">
    <a id="addAluno" href="adicionarAlunos"><strong>+ Adicionar Aluno</strong></a>
</div>
</body>
</html>
