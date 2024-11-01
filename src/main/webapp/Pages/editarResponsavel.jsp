<%@ page import="Model.Responsavel" %>
<%@ page import="Model.ResponsavelDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/editarResponsavel.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="CSS/voltarEditar.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <%-- Após o processamento no servlet "ServletAtuaizarResponsavel", se tudo correr bem o usário será direcionado para esta página --%>
        <title>Editar Responsável</title>

        <%-- Criando um objeto do tipo Responsavel para receber os valores de cada campo da tabela--%>
        <%
            ResponsavelDTO responsavel = (ResponsavelDTO) request.getAttribute("responsavel");
        %>
    </head>
    <body>
        <h1>Editar Responsável</h1>

        <%-- Interface onde o usuário pode preencher os campos da tabela e editar um responsavel --%>
        <form action="atualizarResponsavel" method="post">

            <%-- O id do responsável é passado como parâmetro para o servlet atualizarResponsavel --%>
            <input type="hidden" name="id" value="<%= responsavel.getId() %>">

                <%-- A tabela que mostrará os dados, permitindo a edição --%>
                <table>
                    <strong>Edite uma informação do(a) responsável <%= responsavel.getNome() %>:</strong>
                    <tr>
                        <td>Nome:</td>
                        <td><input type="text" name="nome" value="<%= responsavel.getNome() %>" id="inputNome"></td>
                    </tr>
                    <tr>
                        <td>Sobrenome:</td>
                        <td><input type="text" name="sobrenome" value="<%= responsavel.getSobrenome() %>" id="inputSobrenome"></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><input type="text" name="email" value="<%= responsavel.getEmail() %>" id="inputEmail"></td>
                    </tr>
                    <tr>
                        <td>Aluno:</td>
                        <td><input type="text" name="id_aluno" value="<%= responsavel.getId_aluno() %>" id="inputIdAluno"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Salvar" id="salvar"></td>
                    </tr>
                </table>
            </form>
        <%--kwhdkqw--%>
        <div id="voltar">
            <a href="listarResponsavel" style="text-decoration: none; color: #000000">Voltar a listagem</a>
        </div>
    </body>
</html>
