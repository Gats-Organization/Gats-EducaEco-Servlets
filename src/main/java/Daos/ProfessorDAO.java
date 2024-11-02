package Daos;

// Importando as classes necessárias para conexão com o banco de dados
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Daos.JDBC.Conexao;
import Model.Professor;

public class ProfessorDAO {

    // Definindo as variáveis para conexão com o banco de dados
    Conexao conexao;

    // Método que abrirá a conexão com o banco
    public ProfessorDAO() {
        this.conexao = new Conexao();
    }

    // Criando método para inserir dados na tabela professor
    public int inserirProfessor( Professor professor ) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para inserir professor
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO PROFESSOR(NOME,SOBRENOME,EMAIL,SENHA) VALUES (?,?,?,?)")){

            // Definindo os parâmetros usados no comando
            pstmt.setString(1, professor.getNome());
            pstmt.setString(2, professor.getSobrenome());
            pstmt.setString(3, professor.getEmail());
            pstmt.setString(4, professor.getSenha());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {

            // Retornando -1 em caso de erro
            return -1;
        }finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para atualizar professor
    // O método recebe todos os parâmetros da tabela, porém não necessariamente todos serão alterados
    public int atualizarProfessor( Professor professor ){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para atualizar professor
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE PROFESSOR SET NOME = ?,SOBRENOME = ?, EMAIL = ?, SENHA = ? WHERE ID = ?")){

            // Definindo os parâmetros usados no comando
            pstmt.setString(1,professor.getNome());
            pstmt.setString(2,professor.getSobrenome());
            pstmt.setString(3,professor.getEmail());
            pstmt.setString(4,professor.getSenha());
            pstmt.setInt(5,professor.getId());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException sqle){

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para remover um professor, que recebe o id do mesmo como parâmetro
    public int removerProfessor(int id){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para remover um professor
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("DELETE FROM PROFESSOR WHERE ID = ?")){

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1,id);

            // Executando o comando
            return pstmt.executeUpdate();
        }catch(SQLException sqle){

            // Retornando -1 em caso de erro
            return -1;
        }finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para listar todos os professores
    public List<Professor> listarProfessores(){

        // Estabelecendo conexão com o banco
        List<Professor> professores = new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todos os professores
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM PROFESSOR")) {

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Professor
            while(rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setSobrenome(rs.getString("sobrenome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));

                // Adicionando o objeto Professor à lista de professores
                professores.add(professor);
            }
        } catch (SQLException sqle) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return professores;
    }

    // Criando método para buscar professor, que recebe o id do mesmo como parâmetro e retorna seus dados correspondentes
    public Professor buscarProfessorPorId(int id){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Consulta em SQL para buscar professores
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM PROFESSOR WHERE ID=?")){

            // Definindo o valor do id
            pstmt.setInt(1,id);

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Professor
            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setSobrenome(rs.getString("sobrenome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));

                System.err.println("Professor: " + professor.toString());

                // Retornando o professor selecionado
                return professor;
            }
        } catch (SQLException sqle){

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
        return null;
    }
}

