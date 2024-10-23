<%@ page import="Model.Turma" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 22/10/2024
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Turmas</title>
</head>
<body>
<h1>Listar Turmas</h1>
<table border="1"  >
    <tr>
        <th>Id</th>
        <th>Serie</th>
        <th>Nomenclatura</th>
        <th>Ano</th>
        <th>Id_professor</th>
        <th>Id_escola</th>
        <th>Editar</th>
        <th>Excluir</th>
    </tr>
    <%
        List<Turma> listaTurma = (List<Turma>) request.getAttribute("listaTurma");
                 if (listaTurma != null && !listaTurma.isEmpty()) {
             for (Turma turma : listaTurma) {
    %>
    <tr>
        <td><%=turma.getId()%></td>
        <td><%=turma.getSerie()%></td>
        <td><%=turma.getNomenclatura()%></td>
        <td><%=turma.getAno()%></td>
        <td><%=turma.getId_professor()%></td>
        <td><%=turma.getId_escola()%></td>
        <td>
            <form action="editarTurma" method="get">
                <input type="hidden" name="id" value="<%=turma.getId()%>">
                <input type="submit" value="Editar">
            </form>
        </td>
        <td>
        <a href="excluirTurma?id=<%=turma.getId()%>">Excluir</a>
        </td>
    </tr>
    <%
             }
         }else {
                 System.out.println("Não há turmas para listar");
             }
    %>
</table>
<a href="adicionarTurma">Adicionar Turma</a>
</body>
</html>
