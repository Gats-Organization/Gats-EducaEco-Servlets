<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/adicionarAdmin.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/voltarAdicionar.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

    <%-- Após o processamento no servlet "ServletAdicionarAdmin, se tudo correr bem o usário será direcionado para esta página --%>
    <title>Adicionar Administrador</title>
</head>
    <body>
        <h1>Adicionar Admin</h1>
        <strong>Para adicionar um novo administrador, preencha os seguintes campos:</strong>
        <br>

        <%-- Interface onde o usuário pode preencher os campos da tabela e inserir um novo administrador --%>
        <form action="salvarAdmin" method="post">

            <%-- A tabela que mostrará os dados, permitindo a inserção de valores--%>
            <table>
                <tr>
                    <td><input type="hidden" name="id" id="inputId"></td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome" id="inputNome"></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="email" name="email" id="inputEmail"></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="password" name="senha" id="inputSenha"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Salvar" id="salvar"></td>
                </tr>
            </table>
        </form>
        <div id="voltar">
            <a href="listarAdmin" style="text-decoration: none; color: #000000">Voltar a listagem</a>
        </div>
    </body>
</html>
