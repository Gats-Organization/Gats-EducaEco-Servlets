<%@ page import="Model.Professor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/editarProfessor.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="CSS/voltarEditar.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <%-- Após o processamento no servlet "ServletAtuaizarProfessor, se tudo correr bem o usário será direcionado para esta página --%>
        <title>Editar Professor</title>
    </head>
    <body>

        <%-- Criando um objeto do tipo Professor para receber os valores de cada campo da tabela--%>
        <%
                Professor professor = (Professor) request.getAttribute("professor");
        %>
        <h1>Editar Professor</h1>

        <%-- Interface onde o usuário pode preencher os campos da tabela e editar um professor --%>
        <form action="atualizarProfessor" method="post">

            <%-- O id do proessor é passado como parâmetro para o servlet atualizarProfessor --%>
            <input type="hidden" name="id" value="<%=professor.getId() %>">

                <%-- A tabela que mostrará os dados, permitindo a edição --%>
                <table>
                    <strong>Edite uma informação do(a) professor(a) <%=professor.getNome() %>:</strong>
                    <tr>
                        <td>Nome:</td>
                        <td><input type="text" name="nome" value="<%=professor.getNome() %>" id="inputNome"></td>
                    </tr>
                    <tr>
                        <td>Sobrenome:</td>
                        <td><input type="text" name="sobrenome" value="<%=professor.getSobrenome() %>" id="inputSobrenome"></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><input type="email" name="email" value="<%=professor.getEmail() %>" id="inputEmail"></td>
                    </tr>
                    <tr>
                        <td>Senha:</td>
                        <td><input type="password" name="senha" value="<%=professor.getSenha() %>" id="inputSenha"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Salvar" id="salvar"></td>
                    </tr>
                </table>
            </form>
        <%--kwhdkqw--%>
        <div id="voltar">
            <a href="listarProfessor" style="text-decoration: none; color: #000000">Voltar a listagem</a>
        </div>
    </body>
</html>
