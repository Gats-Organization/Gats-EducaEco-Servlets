package Daos;

// Importando as classes para conexão com o banco de dados
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Daos.JDBC.Conexao;
import Model.Responsavel;
import Model.ResponsavelDTO;

public class ResponsavelDAO {

    // Definindo as variáveis para conexão com o banco de dados
    Conexao conexao;

    // Método que abrirá a conexão com o banco
    public ResponsavelDAO() {
        this.conexao = new Conexao();
    }

    // Criando método para inserir dados na tabela responsável
    public int inserirResponsavel(ResponsavelDTO responsavelDTO) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para inserir responsável
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL INSERIR_RESPONSAVEL (?,?,?,?)")){

            // Definindo os parâmetros usados no comando
            pstmt.setString(1,responsavelDTO.getNome());
            pstmt.setString(2, responsavelDTO.getSobrenome());
            pstmt.setString(3,responsavelDTO.getEmail());
            pstmt.setString(4, responsavelDTO.getNomeCompleto());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para atualizar responsável
    // O método recebe todos os parâmetros da tabela, porém não necessariamente todos serão alterados
    public int atualizarResponsavel(ResponsavelDTO responsavel ) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para atualizar responsável
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE RESPONSAVEL SET NOME =? ,SOBRENOME=? ,EMAIL =? ,ID_ALUNO=? WHERE ID =? " ) ){

            // Definindo os parâmetros usados no comando
            pstmt.setString(1,responsavel.getNome());
            pstmt.setString(2,responsavel.getSobrenome());
            pstmt.setString(3,responsavel.getEmail());
            pstmt.setInt(4,responsavel.getId_aluno());
            pstmt.setInt(5,responsavel.getId());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para remover um responsável, que recebe o id do mesmo como parâmetro
    public int removerResponsavel(int id){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para remover um responsável
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("DELETE FROM RESPONSAVEL WHERE ID = ? " ) ){

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1,id);

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para listar os responsaveis e seus repectivos alunos
    public List<ResponsavelDTO> listarResponsavelPorAluno(){

        // Estabelecendo conexão com o banco e criando uma lista
        List<ResponsavelDTO> responsaveis= new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todos os responsaveis e seus respectivos endereços
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT r.id, r.nome, r.sobrenome, r.email, r.id_aluno, a.nome as nomeAluno, a.sobrenome as sobrenomeAluno FROM responsavel r JOIN aluno a ON r.id_aluno = a.id")){

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto ResponsavelDTO
            while(rs.next()){
                ResponsavelDTO responsavel = new ResponsavelDTO();
                responsavel.setId(rs.getInt("id"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setSobrenome(rs.getString("sobrenome"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setId_aluno(rs.getInt("id_aluno"));
                responsavel.setNomeAluno(rs.getString("nomeAluno"));
                responsavel.setSobrenomeAluno(rs.getString("sobrenomeAluno"));

                // Adicionando o objeto à lista de responsaveis
                responsaveis.add(responsavel);
            }
        } catch (SQLException e) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return responsaveis;
    }

    // Criando método para buscar responsavel, que recebe o id do mesmo como parâmetro e retorna seus dados correspondentes
    public ResponsavelDTO buscarResponsavelPorId(int id) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Consulta em SQL para buscar responsaveis
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT*FROM RESPONSAVEL WHERE ID = ? ")) {

            // Definindo o valor do id
            pstmt.setInt(1, id);

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Responsavel
            while (rs.next()) {
                ResponsavelDTO responsavel = new ResponsavelDTO();
                responsavel.setId(rs.getInt("id"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setSobrenome(rs.getString("sobrenome"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setId_aluno(rs.getInt("id_aluno"));

                // Retornando o responsável selecionado
                return responsavel;
            }
        } catch (SQLException e) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
        return null;
    }

}