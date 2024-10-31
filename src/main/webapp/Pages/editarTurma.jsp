<%@ page import="Model.Turma" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/editarTurma.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <%-- Após o processamento no servlet "ServletAtuaizarTurma", se tudo correr bem o usário será direcionado para esta página --%>
        <title>Editar Turma</title>
    </head>
    <body>
        <h1>Editar Turma</h1>

        <%-- Criando um objeto do tipo Turma para receber os valores de cada campo da tabela--%>
        <%
            Turma turma = (Turma) request.getAttribute("turma");
        %>

        <%-- Interface onde o usuário pode preencher os campos da tabela e editar uma turma --%>
        <form action="atualizarTurma" method="post">

            <%-- O id do responsável é passado como parâmetro para o servlet atualizarTurma --%>
            <input type="hidden" name="id" value="<%=turma.getId()%>">

            <%-- A tabela que mostrará os dados, permitindo a edição --%>
            <table>
                <strong>Edite uma informação da turma <%=turma.getSerie()%>º <%= turma.getNomenclatura() %>:</strong>
                <tr>
                    <td>Serie:</td>
                    <td><input type="number" name="serie" value="<%=turma.getSerie()%>" id="inputSerie"></td>
                </tr>
                <tr>
                    <td>Nomenclatura:</td>
                    <td><input type="text" name="nomenclatura" value="<%=turma.getNomenclatura()%>" id="inputNomeclarura"></td>
                </tr>
                <tr>
                    <td>Ano:</td>
                    <td><input type="number" name="ano" value="<%=turma.getAno()%>" id="inputAno"></td>
                </tr>
                <tr>
                    <td>Id_professor:</td>
                    <td><input type="number" name="id_professor" value="<%=turma.getId_professor()%>" id="inputIdProfessor"></td>
                </tr>
                <tr>
                    <td>Id_escola:</td>
                    <td><input type="number" name="id_escola" value="<%=turma.getId_escola()%>" id="inputIdEscola"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Salvar" id="salvar"></td>
                </tr>
                </table>
        </form>
    </body>
</html>
