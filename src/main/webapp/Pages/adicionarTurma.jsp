<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/adicionarTurma.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/voltarAdicionar.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

    <%-- Após o processamento no servlet "ServletAdicionarTurma, se tudo correr bem o usário será direcionado para esta página --%>
    <title>Adicionar Turma</title>
</head>
    <body>
        <h1>Adicionar Turma</h1>
        <strong>Para adicionar uma nova turma, preencha os seguintes campos:</strong>
        <br>

        <%-- Interface onde o usuário pode preencher os campos da tabela e inserir uma nova turma --%>
        <form action="salvarTurma" method="post">
            <table>
                <tr>
                    <td><input type="hidden" name="id" id="inputId"></td>
                </tr>
                <tr>
                    <td>Serie:</td>
                    <td><input type="number" name="serie" id="inputSerie"></td>
                </tr>
                <tr>
                    <td>Nomenclatura:</td>
                    <td><input type="text" name="nomenclatura" id="inputNomeclarura"></td>
                </tr>
                <tr>
                    <td>Ano:</td>
                    <td><input type="number" name="ano" id="inputAno"></td>
                </tr>
                <tr>
                    <td>Escola:</td>
                    <td><input type="text" name="escola" id="inputEscola"></td>
                </tr>
                <tr>
                    <td>Professor:</td>
                    <td><input type="text" name="professor" id="inputProfessor"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Salvar" id="salvar"></td>
                </tr>
            </table>
        </form>
        <div id="voltar">
            <a href="listarTurma" style="text-decoration: none; color: #000000">Voltar a listagem</a>
        </div>
    </body>
</html>
