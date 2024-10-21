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
    <title>Listar Professores</title>

    <%@page import="java.util.List, Daos.ProfessorDAO, Model.Professor" %>
</head>
<body>
  <h1> Listar Professores </h1>
    <table border="1">
        <tr>
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
                <form action="buscarProfessor" method="get">
                <input type="hidden" name="id" value="<%=professor.getId()%>">
                <input type="submit" value="Editar">
                </form>
            </td>
            <td>
                <a href="ServletExcluirProfessor?id=<%=professor.getId()%>">Excluir</a>
            </td>
        </tr>
        <%}
        } else {
            System.out.println("Nenhum professor encontrado");
        }%>
    </table>
<a href="adicionarProfessor">Adicionar Professor</a>



</body>
</html>
