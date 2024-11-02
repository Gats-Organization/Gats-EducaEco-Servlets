<%@ page import="Model.Escola" %>
<%@ page import="Model.EscolaDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/editarEscola.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="CSS/voltarEditar.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <%-- Após o processamento no servlet "ServletAtuaizarEscola, se tudo correr bem o usário será direcionado para esta página --%>
        <title>Editar Escola</title>

        <%-- Criando um objeto do tipo Escola para receber os valores de cada campo da tabela--%>
        <%
            EscolaDTO escola = (EscolaDTO) request.getAttribute("escola");
        %>
    </head>
    <body>
        <h1>Editar Escola</h1>

        <%-- Interface onde o usuário pode preencher os campos da tabela e editar uma escola --%>
        <form action="atualizarEscola" method="post">

            <%-- O id da escola é passado como parâmetro para o servlet atualizarEscola --%>
            <input type="hidden" name="id" value="<%=escola.getId()%>">

                <%-- A tabela que mostrará os dados, permitindo a edição --%>
                <table>
                    <strong>Edite uma informação da escola <%=escola.getNome()%>:</strong>
                    <tr>
                        <td>Nome:</td>
                        <td><input type="text" name="nome" value="<%=escola.getNome()%>" id="inputNome"></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><input type="email" name="email" value="<%=escola.getEmail()%>" id="inputEmail"></td>
                    </tr>
                    <tr>
                        <td>Telefone:</td>
                        <td><input type="number" name="telefone" value="<%=escola.getTelefone()%>" id="inputTelefone"></td>
                    </tr>
                    <tr>
                        <td>Endereco:</td>
                        <td><input type="text" name="enderecoCompleto" value="<%=escola.getEnderecoCompleto()%>" id="inputEndereco"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Salvar" id="salvar"></td>
                    </tr>
                </table>
            </form>
        <div id="voltar">
            <a href="listarEscola" style="text-decoration: none; color: #000000">Voltar a listagem</a>
        </div>
    </body>
</html>
