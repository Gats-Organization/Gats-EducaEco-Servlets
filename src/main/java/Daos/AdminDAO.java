package Daos;

// Importando as classes para conexão com o banco de dados
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Daos.JDBC.Conexao;
import Model.Admin;

public class AdminDAO {

    // Definindo as variáveis para conexão com o banco de dados
    Conexao conexao;

    // Método que abrirá a conexão com o banco
    public AdminDAO() {
        this.conexao = new Conexao();
    }

    // Criando método para inserir dados na tabela Escola
    public int inserirAdmin(Admin admin) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para inserir administrador
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO ADMIN (NOME, EMAIL, SENHA) VALUES (?,?,?)");)                {

            // Definindo os parâmetros usados no comando
            pstmt.setString(1,admin.getNome());
            pstmt.setString(2,admin.getEmail());
            pstmt.setString(3,admin.getSenha());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e){

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para atualizar admin
    // O método recebe todos os parâmetros da tabela, porém não necessariamente todos serão alterados
    public int atualizarAdmin(Admin admin) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para atualizar administrador
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE ADMIN SET NOME = ?, EMAIL = ?, SENHA = ? WHERE ID=? ");){

            // Definindo os parâmetros usados no comando
            pstmt.setString(1, admin.getNome());
            pstmt.setString(2, admin.getEmail());
            pstmt.setString(3, admin.getSenha());
            pstmt.setInt(4, admin.getId());

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

    // Criando método para remover um administrador, que recebe o id do mesmo como parâmetro
    public int removerAdmin(int id){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para remover um administrador
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("DELETE FROM ADMIN WHERE ID = ?")){

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1,id);

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e){

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para listar todos os administradores
    public List<Admin> listarAdmins(){

        // Estabelecendo conexão com o banco e criando uma lista
        List<Admin> admins = new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todos os administradores
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMIN");){

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Admin
            while(rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setNome(rs.getString("nome"));
                admin.setEmail(rs.getString("email"));
                admin.setSenha(rs.getString("senha"));

                // Adicionando o objeto Admin à lista de admins
                admins.add(admin);
            }
        }catch(SQLException e){

            // Em caso de erro, a consulta retorna null
            return null;

        }finally{

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return admins;
    }

    // Criando método para buscar administrador, que recebe o id do admin como parâmetro e retorna seus dados correspondentes
    public Admin buscarAdminPorId(int id) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Consulta em SQL para buscar admin
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMIN WHERE ID = ?");) {

            // Definindo o valor do id
            pstmt.setInt(1, id);

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Admin
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setNome(rs.getString("nome"));
                admin.setEmail(rs.getString("email"));
                admin.setSenha(rs.getString("senha"));

                // Retornando o admin selecionado
                return admin;
            }
        } catch (SQLException e) {

            // Em caso de erro, a consulta retorna null
            return null;
        }finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
        return null;
    }

    public Admin buscarAdminPorEmail(String email) {
        //conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMIN WHERE EMAIL = ?");) {
            //consulta sql para buscar administrador por id
            //setando os valores
            pstmt.setString(1, email);
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setNome(rs.getString("nome"));
                admin.setEmail(rs.getString("email"));
                admin.setSenha(rs.getString("senha"));
                return admin;
            }
        } catch (SQLException e) {
            return null;
        }finally {
            conexao.desconectar();
        }
        return null;
    }
}
