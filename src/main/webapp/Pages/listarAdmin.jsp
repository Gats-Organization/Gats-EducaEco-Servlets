<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="CSS/listarAdmin.css">
        <link rel="stylesheet" href="CSS/modalExcluir.css">
        <link rel="stylesheet" href="CSS/headerEsidebar.css">
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <!-- Após o processamento no servlet "ServletListarAdmin, se tudo correr bem o usário será direcionado para esta página -->
        <title>Listar Administradores</title>
    </head>
    <input type="checkbox" id="check">
    <header>
        <label for="check">
            <img src="Imagens Login/Menu2.png" alt="menu" class="icons" id="sidebar_btn">
        </label>
        <div class="left">
            <h3>Administradores</h3>
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
        <a href="listarAlunos"><img src="Imagens Login/Tabela.png" alt="Aluno" class="icons"><span>  Aluno</span></a>
        <a href="listarEscola"><img src="Imagens Login/Tabela.png" alt="Escola" class="icons"><span>  Escola</span></a>
        <a href="listarResponsavel"><img src="Imagens Login/Tabela.png" alt="Responsável" class="icons"><span>  Responsável</span></a>
        <a href="listarProfessor"><img src="Imagens Login/Tabela.png" alt="Professor" class="icons"><span>  Professor</span></a>
        <a href="listarTurma"><img src="Imagens Login/Tabela.png" alt="Turma" class="icons"><span>  Turma</span></a>
    </div>
    <div class="content"></div>
    <body>
        <%@page import="Model.Admin, Daos.AdminDAO"%>
        <%@ page import="java.util.List" %>

        <!-- Tag do tipo dialog para exibir a mensagem -->
        <dialog id="retornoDialog">
            <p id="retornoMensagem">Atualizações</p>
        </dialog>

        <!-- Tabela listando os dados dos administradores -->
        <table border="1">
            <br><br>
            <tr id="colunas">
                <th>Id</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Senha</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>

            <!-- Criando um objeto do tipo Admin que receberá a listagem da tabela-->
            <%
                AdminDAO adminDAO = new AdminDAO();
                List<Admin> listaAdmin = adminDAO.listarAdmins();
                request.setAttribute("listaAdmin", listaAdmin);

                // Condição que exibe cada dado tabela por vez, caso ela não esteja vazia
                if(listaAdmin != null && !listaAdmin.isEmpty()){
                for(Admin admin : listaAdmin){
            %>
            <tr>

                <!-- Recebendo cada linha da tabela -->
                <td><%=admin.getId()%></td>
                <td><%=admin.getNome()%></td>
                <td><%=admin.getEmail()%></td>
                <td><%=admin.getSenha()%></td>
                <td>

                    <!-- Formulário que dá ao usuário a opção de editar o administrador que desejar -->
                    <form action="editarAdmins" method="get">
                        <input type="hidden" name="id" value="<%= admin.getId() %>">
                        <button id="botao" type="submit">
                            <img src="Imagens Login/Lápis.png" alt="Lápis">
                            Editar
                        </button>
                    </form>
                </td>

                <!-- Botão que exclui o administrador que o usuário desejar, usando uma function -->
                <td id="excluir">
                    <a href="#" onclick="confirmarExclusao(<%= admin.getId() %>)">
                        <img src="Imagens Login/Lixeira.png" alt="Lixeira">
                        Excluir
                    </a>
                </td>
            </tr>
            <%
            }
                // Caso não haja administradores na lista, exibe essa mensagem
                }else{
                    System.out.println("Nenhum administrador encontrado");
                }
        %>
        </table>

        <!-- Modal de confirmação de exclusão-->
        <div id="modalExclusao" class="modal">
            <div class="modal-content">
                <p>Tem certeza que deseja excluir este admin?</p>
                <div class="botoes">
                    <button class="cancelar" onclick="fecharModal()">Cancelar</button>
                    <button class="confirmar" id="confirmado">Confirmar</button>
                </div>
            </div>
        </div>

        <!-- Script que cria uma função, que redireciona para o servlet ExcluirAdmin após receber uma confirmação do usuário -->
        <script type="text/javascript">
            function confirmarExclusao(id) {
                document.getElementById("modalExclusao").style.display = "block";
                document.getElementById("confirmado").onclick = function() {
                    location.href = "excluirAdmin?id=" + id;
                }
            }

            function fecharModal() {
                document.getElementById("modalExclusao").style.display = "none";

            }
        </script>
        <br>

        <!-- Botão que redireciona para a página de adicionar administrador -->
        <div class="botaoAddAdmin">
            <a id="addAdmin" href="adicionarAdmin"><strong>+ Adicionar Admin</strong></a>
        </div>
        <br><br>

        <!-- Dialog para mensagem de erro ou adicionado com sucesso-->
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
