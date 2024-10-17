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
    public int inserirAdmin(int id, String nome, String email, String senha){
        //conectando ao banco de dados
        conexao.conectar();
        try{
            //consulta sql para inserir administrador
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO ADMIN VALUES (?,?,?,?)");
            //setando os valores
            conexao.pstmt.setInt(1,id);
            conexao.pstmt.setString(2,nome);
            conexao.pstmt.setString(3,email);
            conexao.pstmt.setString(4,senha);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
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
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ADMIN SET EMAIL =? WHERE ID=? ");
            //setando os valores
            conexao.pstmt.setString(1, email);
            conexao.pstmt.setInt(2, id);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
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
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ADMIN SET NOME =? WHERE ID=? ");
            //setando os valores
            conexao.pstmt.setString(1, nome);
            conexao.pstmt.setInt(2, id);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
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
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ADMIN SET SENHA =? WHERE ID=? ");
            //setando os valores
            conexao.pstmt.setString(1, senha);
            conexao.pstmt.setInt(2, id);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
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
            conexao.pstmt = conexao.conn.prepareStatement(sql);
            //setando os valores
            conexao.pstmt.setInt(1,id);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
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
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT * FROM ADMIN");){
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

}
