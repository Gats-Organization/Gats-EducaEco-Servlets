<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/listarAluno.css">
        <link rel="stylesheet" href="CSS/headerEsidebar.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="CSS/modalExcluir.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">
        <link rel="stylesheet" href="CSS/modalExcluir.css">

        <!-- Após o processamento no servlet "ServletListarAluno, se tudo correr bem o usário será direcionado para esta página -->
        <title> Listagem dos Alunos </title>
    </head>
    <body>
        <%@page import ="Model.Aluno, Daos.AlunoDAO, java.util.*,java.sql.ResultSet" %>
        <%@ page import="java.sql.SQLException" %>
        <%@ page import="java.sql.Connection" %>
        <%@ page import="java.sql.Statement" %>
        <%@ page import="Model.AlunoDTO" %>
        <%@ page import="Controller.Admin.ServletSalvarAdmin" %>

        <input type="checkbox" id="check">
        <header>
            <label for="check">
                <img src="Imagens Login/Menu2.png" alt="menu" class="icons" id="sidebar_btn">
            </label>
            <div class="left">
                <h3>Alunos</h3>
            </div>
            <div class="right">
                <a href="index.html" class="sair_btn">Sair</a>
            </div>
        </header>

        <!--Elementos visuais e estilização da página-->
        <!--Sidebar-->
        <div class="sidebar">
            <img src="Imagens Login/logo app.png" class="image" alt="">
            <hr>
            <a href="painelPrincipal.html"><img src="Imagens Login/Inicio2.png" alt="Início" class="icons"><span>  Início</span></a>
            <a href="listarAdmin"><img src="Imagens Login/Tabela.png" alt="Admin" class="icons"><span>  Admin</span></a>
            <a href="listarEscola"><img src="Imagens Login/Tabela.png" alt="Escola" class="icons"><span>  Escola</span></a>
            <a href="listarResponsavel"><img src="Imagens Login/Tabela.png" alt="Responsável" class="icons"><span>  Responsável</span></a>
            <a href="listarProfessor"><img src="Imagens Login/Tabela.png" alt="Professor" class="icons"><span>  Professor</span></a>
            <a href="listarTurma"><img src="Imagens Login/Tabela.png" alt="Turma" class="icons"><span>  Turma</span></a>
        </div>
        <div class="content"></div>

        <!-- Tag do tipo dialog para exibir a mensagem -->
        <dialog id="retornoDialog">
            <p id="retornoMensagem">Atualizações</p>
        </dialog>

        <!-- Tabela listando os dados dos alunos -->
        <table border="1">
             <tr id="colunas">
                 <th>Id</th>
                 <th>Nome</th>
                 <th>Sobrenome</th>
                 <th>Xp</th>
                 <th>E-mail</th>
                 <th>Senha</th>
                 <th>Turma</th>
                 <th>Editar</th>
                 <th>Excluir</th>
             </tr>

            <!-- Criando uma lista do tipo AlunoDTO que receberá a listagem da tabela -->
             <%
                 List<AlunoDTO> listaAlunos = (List<AlunoDTO>)request.getAttribute("listaAlunos");

                 // Condição que exibe cada dado tabela por vez, caso ela não esteja vazia
                 if (listaAlunos != null && !listaAlunos.isEmpty()) {
                     for (AlunoDTO aluno : listaAlunos) {
             %>
             <tr>

                 <!-- Recebendo cada linha da tabela -->
                 <td><%= aluno.getId() %></td>
                 <td><%= aluno.getNome() %></td>
                 <td><%= aluno.getSobrenome() %></td>
                 <td><%= aluno.getXp() %></td>
                 <td><%= aluno.getEmail() %></td>
                 <td><%= aluno.getSenha() %></td>
                 <td><%= aluno.getSerie() %> - <%= aluno.getNomeclantura() %></td>
                 <td id="editar">

                     <!-- Formulário que dá ao usuário a opção de editar o aluno que desejar -->
                     <form action="buscarAluno" method="get">
                         <input type="hidden" name="id" value="<%= aluno.getId() %>">
                         <button id="botao" type="submit">
                             <img src="Imagens Login/Lápis.png" alt="Lápis">
                             Editar
                         </button>
                     </form>
                 </td>

                 <!-- Botão que exclui o aluno que o usuário desejar, usando uma function -->
                 <td id="excluir">
                 <a href="#" onclick="confirmarExclusao(<%= aluno.getId() %>)">
                     <img src="Imagens Login/Lixeira.png" alt="Lixeira">
                     Excluir
                 </a>
                 </td>
             </tr>
             <%
                     }

                     // Caso não haja alunos na lista, exibe essa mensagem
                     } else {
                             System.out.println("Nenhum aluno encontrado");
                     }
             %>
         </table>

        <!-- Modal de confirmação de exclusão -->
        <div id="modalExclusao" class="modal">
            <div class="modal-content">
                <p>Tem certeza que deseja excluir este aluno?</p>
                <div class="botoes">
                    <button class="cancelar" onclick="fecharModal()">Cancelar</button>
                    <button class="confirmar" id="confirmado">Confirmar</button>
                </div>
            </div>
        </div>

        <!-- Script que cria uma função, que redireciona para o servlet ExcluirAluno após receber uma confirmação do usuário -->
        <script type="text/javascript">
            function confirmarExclusao(id) {
                document.getElementById("modalExclusao").style.display = "block";
                document.getElementById("confirmado").onclick = function() {
                    location.href = "excluirAluno?id=" + id;
                }
            }

            function fecharModal() {
                document.getElementById("modalExclusao").style.display = "none";

            }
        </script>
        <br>

        <!-- Botão que redireciona para a página de adicionar aluno -->
        <div class="botaoAddAluno">
            <a id="addAluno" href="adicionarAluno"><strong>+ Adicionar Aluno</strong></a>
        </div>
        <br><br>

        <!-- Dialog para mensagem de erro ou adicionado com sucesso -->
        <script>
            const dialog = document.getElementById('retornoDialog');
            const initialMessage = "Atualizações";
            const mensagem = "<%= request.getParameter("txt") != null ? request.getParameter("txt") : "" %>";

            // Define a mensagem e abre o diálogo
            if (mensagem.trim() !== "") {
                document.getElementById('retornoMensagem').innerText = mensagem;
            } else {
                document.getElementById('retornoMensagem').innerText = initialMessage;
            }
            dialog.showModal();

            // Fechar o diálogo automaticamente após 3 segundos
            setTimeout(() => {
                dialog.close();

                // Tempo em milissegundos
            }, 2000);
        </script>
    </body>
</html>
