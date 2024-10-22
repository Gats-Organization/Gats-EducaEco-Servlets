package Daos;

//importando bibliotecas necessárias
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Daos.JDBC.Conexao;
import Model.Responsavel;

public class ResponsavelDAO {
    //definindo váriaveis para conexão com o banco
    Conexao conexao;
    //Instanciando a classe Conexao
    public ResponsavelDAO() {
        this.conexao = new Conexao();
    }

    //Criando método para inserir um responsável
    public int inserirResponsavel(int id,String nome, String sobrenome,String email, int id_aluno ) {
        //conectando com banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("INSERT INTO RESPONSAVEL VALUES(?,?,?,?,?)")){
            //consulta sql para inserir um responsável
            //setando os valores
            pstmt.setInt(1,id);
            pstmt.setString(2,nome);
            pstmt.setString(3,sobrenome);
            pstmt.setString(4,email);
            pstmt.setInt(5,id_aluno);

            //executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e) {
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para alterar um responsável
    public int atualizarResponsavel(Responsavel responsavel ) {
        //conectando com banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("UPDATE RESPONSAVEL SET NOME =? ,SOBRENOME=? ,EMAIL =? ,ID_ALUNO=? WHERE ID =? " ) ){

            //setando os valores
            pstmt.setString(1,responsavel.getNome());
            pstmt.setString(2,responsavel.getSobrenome());
            pstmt.setString(3,responsavel.getEmail());
            pstmt.setInt(4,responsavel.getId_aluno());
            pstmt.setInt(5,responsavel.getId());
            //executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e) {
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para remover um responsável
    //arrumar com o procedure
    public int removerResponsavel(int id){
        //conectando com banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("DELETE FROM RESPONSAVEL WHERE ID = ? " ) ){
            //setando o valor do id
            pstmt.setInt(1,id);
            //executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e) {
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para consultar responsáveis
    public List<Responsavel> listarResponsavel(){
        List<Responsavel> responsaveis= new ArrayList<>();
        //conectando com banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT*FROM RESPONSAVEL")){
            //consulta sql para consultar responsáveis
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            //enquanto existir registros, adiciona na lista de responsáveis
            while(rs.next()){
                Responsavel responsavel = new Responsavel();
                responsavel.setId(rs.getInt("id"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setSobrenome(rs.getString("sobrenome"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setId_aluno(rs.getInt("id_aluno"));
                responsaveis.add(responsavel);
            }
        }catch(SQLException e) {
            //caso ocorra algum erro, retorna null
            return null;
        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return responsaveis;
    }

    public Responsavel buscarResponsavelPorId(int id) {
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT*FROM RESPONSAVEL WHERE ID = ? ")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Responsavel responsavel = new Responsavel();
                responsavel.setId(rs.getInt("id"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setSobrenome(rs.getString("sobrenome"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setId_aluno(rs.getInt("id_aluno"));
                return responsavel;
            }
        }catch(SQLException e) {
            return null;
        }finally{
            conexao.desconectar();
        }
            return null;
        }

}