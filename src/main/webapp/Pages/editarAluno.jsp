<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/editarAluno.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="CSS/voltarEditar.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <%-- Após o processamento no servlet "ServletAtuaizarAluno, se tudo correr bem o usário será direcionado para esta página --%>
        <title>Editar Aluno </title>
    </head>
    <body>
        <h1>Editar Aluno</h1>
        <%@page import="Daos.AlunoDAO,Model.Aluno"%>
        <%@ page import="Model.AlunoDTO" %>

        <%-- Criando um objeto do tipo Aluno para receber os valores de cada campo da tabela--%>
        <%
            Aluno aluno = (Aluno) request.getAttribute("aluno");
        %>

        <%-- Interface onde o usuário pode preencher os campos da tabela e editar um aluno --%>
        <form action="atualizarAluno" method="post">

            <%-- O id do aluno é passado como parâmetro para o servlet atualizarAluno --%>
            <input type="hidden" name="id" value="<%=aluno.getId()%>">

                <%-- A tabela que mostrará os dados, permitindo a edição --%>
                <table>
                    <strong>Edite uma informação do(a) aluno(a) <%=aluno.getNome()%>:</strong>
                    <tr>
                        <td>Nome:</td>
                        <td><input type="text" name="nome" value="<%=aluno.getNome()%>" id="inputNome"></td>
                    </tr>
                    <tr>
                        <td>Sobrenome:</td>
                        <td><input type="text" name="sobrenome" value="<%=aluno.getSobrenome()%>" id="inputSobrenome"></td>
                    </tr>
                    <tr>
                        <td>Xp:</td>
                        <td><input type="text" name="xp" value="<%=aluno.getXp()%>" id="inputXp"></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><input type="text" name="email" value="<%=aluno.getEmail()%>" id="inputEmail"></td>
                    </tr>
                    <tr>
                        <td>Senha:</td>
                        <td><input type="password" name="senha" value="<%=aluno.getSenha()%>" id="inputSenha"></td>
                    </tr>
                    <tr>
                        <td>Id Turma:</td>
                        <td><input type="text" name="idturma" value="<%=aluno.getId_turma()%>" id="inputTurma"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Salvar" id="salvar"></td>
                    </tr>
                </table>
            </form>
        <div id="voltar">
            <a href="listarAlunos" style="text-decoration: none; color: #000000">Voltar a listagem</a>
        </div>
    </body>
</html>
