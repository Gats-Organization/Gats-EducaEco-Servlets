<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
      <link rel="stylesheet" href="CSS/listarResponsavel.css">
      <link rel="stylesheet" href="CSS/modalExcluir.css">
      <link rel="stylesheet" href="CSS/headerEsidebar.css">
      <link rel="stylesheet" href="CSS/style.css">
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
      <link rel="shortcut icon" href="Imagens Login/logo app.png" type="image/x-icon">

        <!-- Após o processamento no servlet "ServletListarResponsavel, se tudo correr bem o usário será direcionado para esta página -->
      <title>Listar Responsável</title>
      <%@ page import="Model.Responsavel" %>
      <%@ page import="java.util.List" %>
      <%@ page import="Daos.ResponsavelDAO" %>
      <%@ page import="Model.ResponsavelDTO" %>


    </head>
    <input type="checkbox" id="check">
    <header>
        <label for="check">
            <img src="Imagens Login/Menu2.png" alt="menu" class="icons" id="sidebar_btn">
        </label>
        <div class="left">
            <h3>Responsáveis</h3>
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
        <a href="listarAdmin"><img src="Imagens Login/Tabela.png" alt="Admin" class="icons"><span>  Admin</span></a>
        <a href="listarEscola"><img src="Imagens Login/Tabela.png" alt="Escola" class="icons"><span>  Escola</span></a>
        <a href="listarProfessor"><img src="Imagens Login/Tabela.png" alt="Professor" class="icons"><span>  Professor</span></a>
        <a href="listarTurma"><img src="Imagens Login/Tabela.png" alt="Turma" class="icons"><span>  Turma</span></a>
    </div>
    <div class="content"></div>
    <body>

        <!-- Tabela listando os dados dos responsaveis -->
        <table border="1">
            <tr id="colunas">
                <th>Id</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>E-mail</th>
                <th>Aluno</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>

                <!-- Criando uma lista do tipo ResponsavelDTO que receberá a listagem da tabela -->
                <%
                    ResponsavelDAO responsavelDao = new ResponsavelDAO();
                    List<ResponsavelDTO> listaResponsavel = responsavelDao.listarResponsavelPorAluno();
                    request.setAttribute("listaResponsavel", listaResponsavel);

                    // Condição que exibe cada dado tabela por vez, caso ela não esteja vazia
                    if(listaResponsavel != null && !listaResponsavel.isEmpty()){
                      for(ResponsavelDTO responsavel : listaResponsavel){
                %>
                      <tr>

                          <!-- Recebendo cada linha da tabela -->
                          <td><%= responsavel.getId()%></td>
                          <td><%= responsavel.getNome()%></td>
                          <td><%= responsavel.getSobrenome()%></td>
                          <td><%= responsavel.getEmail()%></td>
                          <td><%= responsavel.getNomeAluno()%> <%= responsavel.getSobrenomeAluno()%></td>

                          <!-- Formulário que dá ao usuário a opção de editar o responsável que desejar -->
                          <td>
                              <form action="editarResponsavel" method="get">
                                  <input type="hidden" name="id" value="<%= responsavel.getId()%>">
                                  <button id="botao" type="submit">
                                      <img src="Imagens Login/Lápis.png" alt="Lápis">
                                      Editar
                                  </button>
                              </form>
                          </td>

                          <!-- Botão que exclui o responsável que o usuário desejar, usando uma function -->
                          <td id="excluir">
                              <a href="#" onclick="confirmarExclusao(<%= responsavel.getId() %>)">
                                  <img src="Imagens Login/Lixeira.png" alt="Lixeira">
                                  Excluir
                              </a>
                          </td>
                       </tr>

                        <%
                         }
                    } else{

                        // Caso não haja professores na lista, exibe essa mensagem
                        System.out.println("Nenhum responsável foi encontrado");
                    }
                    %>
        </table>

        <!-- Modal de confirmação de exclusão -->
        <div id="modalExclusao" class="modal">
            <div class="modal-content">
                <p>Tem certeza que deseja excluir este(a) responsável?</p>
                <div class="botoes">
                    <button class="cancelar" onclick="fecharModal()">Cancelar</button>
                    <button class="confirmar" id="confirmado">Confirmar</button>
                </div>
            </div>
        </div>

        <!-- Script que cria uma função, que redireciona para o servlet ExcluirResponsavel após receber uma confirmação do usuário -->
        <script type="text/javascript">
            function confirmarExclusao(id) {
                document.getElementById("modalExclusao").style.display = "block";
                document.getElementById("confirmado").onclick = function() {
                    location.href = "excluirResponsavel?id=" + id;
                }
            }

            function fecharModal() {
                document.getElementById("modalExclusao").style.display = "none";

            }
        </script>
        <br>

        <!-- Botão que redireciona para a página de adicionar responsavel -->
        <div class="botaoAddResponsavel">
            <a id="addResponsavel" href="adicionarResponsavel"><strong>+ Adicionar Responsável</strong></a>
        </div>
        <br><br>
    </body>
</html>
