<%@ page import="Model.Turma" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.TurmaDTO" %><%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 22/10/2024
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/listarTurma.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Listar Turmas</title>
</head>
<body>
<h1>Listar Turmas</h1>
<table border="1"  >
    <tr id="colunas">
        <th>Id</th>
        <th>Serie</th>
        <th>Nomenclatura</th>
        <th>Ano</th>
        <th>Escola</th>
        <th>Professor</th>
        <th>Editar</th>
        <th>Excluir</th>
    </tr>
    <%
        List<TurmaDTO> listaTurma = (List<TurmaDTO>) request.getAttribute("listaTurma");
                 if (listaTurma != null && !listaTurma.isEmpty()) {
             for (TurmaDTO turma : listaTurma) {
    %>
    <tr>
        <td><%=turma.getId()%></td>
        <td><%=turma.getSerie()%></td>
        <td><%=turma.getNomenclatura()%></td>
        <td><%=turma.getAno()%></td>
        <td><%=turma.getNomeEscola()%></td>
        <td><%=turma.getNomeProfessor()%></td>
        <td>
            <form action="editarTurma" method="get">
                <input type="hidden" name="id" value="<%=turma.getId()%>">
                <button id="botao" type="submit">
                    <img src="Imagens Login/Lápis.png" alt="Lápis">
                    Editar
                </button>
            </form>
        </td>
        <td id="excluir">
            <a href="excluirTurma?id=<%=turma.getId()%>">
                <img src="Imagens Login/Lixeira.png" alt="Lixeira">
                Excluir
            </a>
        </td>
    </tr>
    <%
             }
         }else {
                 System.out.println("Não há turmas para listar");
             }
    %>
</table>
<br>
<div class="botaoAddTurma">
    <a id="addTurma" href="adicionarTurma"><strong>+ Adicionar Turma</strong></a>
</div>
<br><br>
</body>
</html>
