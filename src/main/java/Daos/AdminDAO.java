package Daos;

//importando as classes para conexão com o banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Daos.JDBC.Conexao;
import Model.Admin;

public class AdminDAO {
    //definindo variáveis para conexão com o banco de dados
    Conexao conexao;

    //instanciando a classe de conexão
    public AdminDAO() {
        this.conexao = new Conexao();
    }

    //criando método para inserir administrador
    public int inserirAdmin(Admin admin) {
        //conectando ao banco de dados
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO ADMIN (NOME, EMAIL, SENHA) VALUES (?,?,?)");)                {
            //consulta sql para inserir administrador
            //setando os valores
            pstmt.setString(1,admin.getNome());
            pstmt.setString(2,admin.getEmail());
            pstmt.setString(3,admin.getSenha());
            //executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e){
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }

    //Criando método alterar Admin com base no id
    public int atualizarAdmin(Admin admin) {
        //conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE ADMIN SET NOME = ?, EMAIL = ?, SENHA = ? WHERE ID=? ");){
            //consulta sql para alterar senha do administrador
            //setando os valores
            pstmt.setString(1, admin.getNome());
            pstmt.setString(2, admin.getEmail());
            pstmt.setString(3, admin.getSenha());
            pstmt.setInt(4, admin.getId());
            //executando a consulta
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        } finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }

    //Criando método para remover administrador, com base no id
    public int removerAdmin(int id){
        //conectando ao banco de dados
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("DELETE FROM ADMIN WHERE ID = ?")){
            //consulta sql para remover administrador
            //setando os valores
            pstmt.setInt(1,id);
            //executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e){
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para consultar todos os administradores
    public List<Admin> listarAdmins(){
        //conectando ao banco de dados
        List<Admin> admins = new ArrayList<>();
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMIN");){
            //consulta sql para ver todos os administradores
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setNome(rs.getString("nome"));
                admin.setEmail(rs.getString("email"));
                admin.setSenha(rs.getString("senha"));
                admins.add(admin);
            }
        }catch(SQLException e){
            //caso ocorra algum erro, retornar null
            return null;

        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return admins;
    }

    public Admin buscarAdminPorId(int id) {
        //conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMIN WHERE ID = ?");) {
            //consulta sql para buscar administrador por id
            //setando os valores
            pstmt.setInt(1, id);
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
