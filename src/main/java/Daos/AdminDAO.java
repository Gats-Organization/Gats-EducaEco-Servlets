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
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    //instanciando a classe de conexão
    Conexao conexao = new Conexao();


    //criando método para inserir administrador
    public int inserirAdmin(int id, String nome, String email, String senha){
        //conectando ao banco de dados
        conexao.conectar();
        try{
            //consulta sql para inserir administrador
            pstmt = conn.prepareStatement("INSERT INTO ADMIN VALUES (?,?,?,?)");
            //setando os valores
            pstmt.setInt(1,id);
            pstmt.setString(2,nome);
            pstmt.setString(3,email);
            pstmt.setString(4,senha);
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
    //Criando método para alterar email do administrador, por meio do id
    public int alterarEmail( String email, int id) {
        //conectando ao banco de dados
        conexao.conectar();
        try {
            //consulta sql para alterar email do administrador
            pstmt = conn.prepareStatement("UPDATE ADMIN SET EMAIL =? WHERE ID=? ");
            //setando os valores
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
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

    //Criando método para alterar nome do administrador, com base no id
    public int alterarNome(String nome, int id) {
        //conectando ao banco de dados
        conexao.conectar();
        try {
            //consulta sql para alterar nome do administrador
            pstmt = conn.prepareStatement("UPDATE ADMIN SET NOME =? WHERE ID=? ");
            //setando os valores
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);
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
    //Criando método alterarSenhar
    public int alterarSenha(String senha, int id) {
        //conectando ao banco de dados
        conexao.conectar();
        try {
            //consulta sql para alterar senha do administrador
            pstmt = conn.prepareStatement("UPDATE ADMIN SET SENHA =? WHERE ID=? ");
            //setando os valores
            pstmt.setString(1, senha);
            pstmt.setInt(2, id);
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
        try{
            //consulta sql para remover administrador
            String sql = "DELETE FROM ADMIN WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
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
        try {
            //consulta sql para ver todos os administradores
            pstmt = conn.prepareStatement("SELECT*FROM ADMIN");
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

}
