package Daos;

//importando as bibliotecas necessárias
import Daos.JDBC.Conexao;
import Model.Escola;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscolaDAO {
    //definindo variaveis para conexão com o banco de dados
    Conexao conexao;
    //instanciando a classe de conexão

    public EscolaDAO() {
        this.conexao = new Conexao();
    }
    //Criando método para inserir dados na tabela escola
    public int inserirEscola(int id,String nome, String email,int telefone,int id_endereco) {
        //conectando ao banco de dados
        conexao.conectar();
        try {
            //consulta SQL para inserir dados na tabela escola
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO ESCOLA (ID,NOME,EMAIL,TELEFONE,ID_ENDERECO) VALUES (?,?,?,?,?)");
            //setando os valores dos parâmetros
            conexao.pstmt.setInt(1,id);
            conexao.pstmt.setString(2,nome);
            conexao.pstmt.setString(3,email);
            conexao.pstmt.setInt(4,telefone);
            conexao.pstmt.setInt(5,id_endereco);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para alterar o nome da escola
    public int alterarNome(String nome){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try{
            //Consulta SQL para alterar o nome da escola
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ESCOLA SET NOME=?");
            //setando o valor do parâmetro
            conexao.pstmt.setString(1,nome);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //criando método para alterar o email da escola
    public int alterarEmail(String email){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try{
            //Consulta SQL para alterar o email da escola
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ESCOLA SET EMAIL=?");
            //setando o valor do parâmetro
            conexao.pstmt.setString(1,email);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }

    //criando método para alterar o telefone da escola
    public int alterarTelefone(int telefone){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try{
            //Consulta SQL para alterar o telefone da escola
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ESCOLA SET TELEFONE=?");
            //setando o valor do parâmetro
            conexao.pstmt.setInt(1,telefone);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //criando método para remover uma escola
    public int removerEscola(int id){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try{
            //Consulta SQL para remover uma escola
            conexao.pstmt = conexao.conn.prepareStatement("CALL EXCLUIR_ESCOLA(?)");
//            //setando o valor do parâmetro
            conexao.pstmt.setInt(1,id); //arrumar
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //criando método para listar todas as escolas
    public List<Escola> listarEscolas(){
        //Estabelecendo conexão com o banco de dados
        List<Escola> escolas = new ArrayList<>();
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT*FROM ESCOLA")){
            //Consulta SQL para listar todas as escolas
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Escola escola = new Escola();
                escola.setId(rs.getInt("ID"));
                escola.setNome(rs.getString("NOME"));
                escola.setEmail(rs.getString("EMAIL"));
                escola.setTelefone(rs.getInt("TELEFONE"));
                escola.setId_endereco(rs.getInt("ID_ENDERECO"));
                escolas.add(escola);
            }
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null
            return null;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return escolas;
    }
    //criando método para buscar uma escola pelo id
    public ResultSet buscarEscola(int id){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try{
            //Consulta SQL para buscar uma escola pelo id
            conexao.pstmt = conexao.conn.prepareStatement("SELECT*FROM ESCOLA WHERE ID=?");
            //setando o valor do parâmetro
            conexao.pstmt.setInt(1,id);
            //executando a consulta
            ResultSet rs = conexao.pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
}

