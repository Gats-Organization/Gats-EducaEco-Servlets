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
    <link rel="stylesheet" href="CSS/listarAluno.css">
    <link rel="stylesheet" href="CSS/headerEsidebar.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/modalExcluir.css">
    <title> Listagem dos Alunos </title>
</head>
<body>
<%@page import ="Model.Aluno, Daos.AlunoDAO, java.util.*,java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="Model.AlunoDTO" %>

<input type="checkbox" id="check">
<header>
    <label for="check">
        <img src="Imagens Login/Menu2.png" alt="menu" class="icons" id="sidebar_btn">
    </label>
    <div class="left">
        <h3>Lista de Alunos</h3>
    </div>
    <div class="right">
        <a href="index.html" class="sair_btn">Sair</a>
    </div>
</header>
<!--header final-->
<!--sidebar começo-->
<div class="sidebar">
    <img src="Imagens Login/logo app.png" class="image" alt="">
    <hr>
    <a href="painelPrincipal.html"><img src="Imagens Login/Inicio2.png" alt="Início" class="icons"><span>  Início</span></a>
</div>
<!--sidebar final-->
<div class="content"></div>

 <table border="1">
     <tr id="colunas">
         <th>Id</th>
         <th>Nome</th>
         <th>Sobrenome</th>
         <th>Xp</th>
         <th>E-mail</th>
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
         <a href="#" onclick="confirmarExclusao(<%= aluno.getId() %>)">
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
 </table>
<%--     ServletExcluirAluno?id=<%= aluno.getId() %>--%>

<%--     Modal de confirmação de exclusão--%>
     <div id="modalExclusao" class="modal">
         <div class="modal-content">
             <p>Tem certeza que deseja excluir este aluno?</p>
             <button class="cancelar" onclick="fecharModal()"><strong>Cancelar</strong></button>
             <button class="confirmar" id="confirmado"><strong>Confirmar</strong></button>
         </div>
     </div>

     <script type="text/javascript">
         function confirmarExclusao(id) {
             document.getElementById("modalExclusao").style.display = "block";
             document.getElementById("confirmado").onclick = function() {
                 location.href = "ServletExcluirAluno?id=" + id;
             }
         }

         function fecharModal() {
             document.getElementById("modalExclusao").style.display = "none";

         }

     </script>


<br>
<div class="botaoAddAluno">
    <a id="addAluno" href="adicionarAluno"><strong>+ Adicionar Aluno</strong></a>
</div>
<br><br>
</body>
</html>
