<%--
  Created by IntelliJ IDEA.
  User: claramoreira-ieg
  Date: 16/10/2024
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/listarEscola.css">
    <link rel="stylesheet" href="CSS/modalExcluir.css">
    <link rel="stylesheet" href="CSS/headerEsidebar.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
    <title>Listar Escolas</title>
    <%@page import="Daos.EscolaDAO,Model.Escola, java.util.List" %>
    <%@ page import="Model.EscolaDTO" %>
</head>
<input type="checkbox" id="check">
<header>
    <label for="check">
        <img src="Imagens Login/Menu2.png" alt="menu" class="icons" id="sidebar_btn">
    </label>
    <div class="left">
        <h3>Escolas</h3>
    </div>
    <div class="right">
        <a href="index.html" class="sair_btn">Sair</a>
    </div>
</header>
<!--header final-->
<!--sidebar começo-->
<div class="sidebar">
    <img src="Imagens Login/logo app.png" class="image" alt="">
    <hr>
    <a href="painelPrincipal.html"><img src="Imagens Login/Inicio2.png" alt="Início" class="icons"><span>  Início</span></a>
    <a href="listarAluno"><img src="Imagens Login/Tabela.png" alt="Aluno" class="icons"><span>  Aluno</span></a>
    <a href="listarAdmin"><img src="Imagens Login/Tabela.png" alt="Admin" class="icons"><span>  Admin</span></a>
    <a href="listarResponsavel"><img src="Imagens Login/Tabela.png" alt="Responsável" class="icons"><span>  Responsável</span></a>
    <a href="listarProfessor"><img src="Imagens Login/Tabela.png" alt="Professor" class="icons"><span>  Professor</span></a>
    <a href="listarTurma"><img src="Imagens Login/Tabela.png" alt="Turma" class="icons"><span>  Turma</span></a>
</div>
<!--sidebar final-->
<div class="content"></div>
<body>
<table border="1">
    <tr id="colunas">
        <th>Id</th>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Telefone</th>
        <th>Endereço</th>
        <th>Editar</th>
        <th>Excluir</th>
    </tr>
    <%
        EscolaDAO escolaDAO = new EscolaDAO();
        List<EscolaDTO> listarEscolas = escolaDAO.listarEscolasPorEndereco();

        if( listarEscolas!= null && !listarEscolas.isEmpty()){
        for(EscolaDTO escola : listarEscolas){
    %>
    <tr>
        <td><%=escola.getId()%></td>
        <td><%=escola.getNome()%></td>
        <td><%=escola.getEmail()%></td>
        <td><%=escola.getTelefone()%></td>
        <td><%=escola.getNumero()%>, <%=escola.getRua()%>, <%=escola.getBairro()%>, <%=escola.getCidade()%>, <%=escola.getEstado()%>, <%=escola.getCep()%></td>
        <td>
            <form action="editarEscola" method="get">
                <input type="hidden" name="id" value="<%=escola.getId()%>">
                <button id="botao" type="submit">
                    <img src="Imagens Login/Lápis.png" alt="Lápis">
                    Editar
                </button>
            </form>
        </td>
        <td id="excluir">
            <a href="#" onclick="confirmarExclusao(<%= escola.getId() %>)">
                <img src="Imagens Login/Lixeira.png" alt="Lixeira">
                Excluir
            </a>
        </td>
    </tr>
    <%}
}else{
            System.out.println("Não existem escolas registadas");
}

%>
</table>
<%--     Modal de confirmação de exclusão--%>
<%--   --%>
<div id="modalExclusao" class="modal">
    <div class="modal-content">
        <p>Tem certeza que deseja excluir esta escola?</p>
        <div class="botoes">
            <button class="cancelar" onclick="fecharModal()">Cancelar</button>
            <button class="confirmar" id="confirmado">Confirmar</button>
        </div>
    </div>
</div>

<script type="text/javascript">
    function confirmarExclusao(id) {
        document.getElementById("modalExclusao").style.display = "block";
        document.getElementById("confirmado").onclick = function() {
            location.href = "ServletExcluirEscola?id=" + id;
        }
    }

    function fecharModal() {
        document.getElementById("modalExclusao").style.display = "none";

    }

</script>
<br>
<div class="botaoAddEscola">
    <a id="addEscola" href="adicionarEscola"><strong>+ Adicionar Escola</strong></a>
</div>
<br><br>
</body>
</html>
