<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 20/10/2024
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/listarProfessor.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Listar Professores</title>
    <%@page import="java.util.List, Daos.ProfessorDAO, Model.Professor" %>
</head>
<body>
  <h1> Listagem dos Professores </h1>
    <table border="1">
        <tr id="colunas">
            <th>Id</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Editar</th>
            <th>Excluir</th>
        </tr>
        <%
            ProfessorDAO professorDAO = new ProfessorDAO();
            List<Professor> listaProfessores = professorDAO.listarProfessores();
            request.setAttribute("listaProfessores", listaProfessores);
            if ( listaProfessores!= null && !listaProfessores.isEmpty()) {
                for (Professor professor : listaProfessores) {
        %>
        <tr>
            <td><%=professor.getId()%></td>
            <td><%=professor.getNome()%></td>
            <td><%=professor.getSobrenome()%></td>
            <td><%=professor.getEmail()%></td>
            <td><%=professor.getSenha()%></td>
            <td>
                <form action="ServletEditarProfessor" method="get">
                <input type="hidden" name="id" value="<%=professor.getId()%>">
                    <button id="botao" type="submit">
                        <img src="Imagens Login/Lápis.png" alt="Lápis">
                        Editar
                    </button>
                </form>
            </td>
            <td id="excluir">
                <a href="ServletExcluirProfessor?id=<%= professor.getId() %>">
                    <img src="Imagens Login/Lixeira.png" alt="Lixeira">
                    Excluir
                </a>
            </td>
        </tr>
        <%}
        } else {
            System.out.println("Nenhum professor encontrado");
        }%>
    </table>
  <br>
  <div class="botaoAddProfessor">
      <a id="addProfessor" href="adicionarProfessor"><strong>+ Adicionar Professor</strong></a>
  </div>
  <br><br>
</body>
</html>
