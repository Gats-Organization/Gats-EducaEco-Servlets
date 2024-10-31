<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/editarAdmin.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <%-- Após o processamento no servlet "ServletAtuaizarAdmin, se tudo correr bem o usário será direcionado para esta página --%>
        <title>Editar Administrador</title>
    </head>
    <body>
        <h1>Editar Admin</h1>
        <%@page import="Daos.AdminDAO,Model.Admin" %>

        <%-- Criando um objeto do tipo Admin para receber os valores de cada campo da tabela--%>
        <%
            Admin admin = (Admin) request.getAttribute("admin");
        %>

        <%-- Interface onde o usuário pode preencher os campos da tabela e editar um administrador --%>
        <form action="atualizarAdmin" method="post">

            <%-- O id do administrador é passado como parâmetro para o servlet atualizarAdmin --%>
            <input type="hidden" name="id" value="<%=admin.getId()%>">

                <%-- A tabela que mostrará os dados, permitindo a edição --%>
                <table>
                    <strong>Edite uma informação do(a) admin <%=admin.getNome()%>:</strong>
                    <tr>
                        <td>Nome:</td>
                        <td><input type="text" name="nome" value="<%=admin.getNome()%>" id="inputNome"></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><input type="text" name="email" value="<%=admin.getEmail()%>" id="inputEmail"></td>
                    </tr>
                    <tr>
                        <td>Senha:</td>
                        <td><input type="password" name="senha" value="<%=admin.getSenha()%>" id="inputSenha"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Salvar" id="salvar"></td>
                    </tr>
                </table>
        </form>
    </body>
</html>
