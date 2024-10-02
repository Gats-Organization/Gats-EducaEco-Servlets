package Daos.Escola;

//importando as bibliotecas necessárias
import Daos.JDBC.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EscolaDAO {
    //definindo variaveis para conexão com o banco de dados
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    //instanciando a classe de conexão
    Conexao conexao = new Conexao();

    //Criando método para inserir dados na tabela escola
    public int inserirEscola(int id,String nome, String email,int telefone,int id_endereco) {
        //conectando ao banco de dados
        conexao.conectar();
        try {
            //consulta SQL para inserir dados na tabela escola
            pstmt = conn.prepareStatement("INSERT INTO ESCOLA (ID,NOME,EMAIL,TELEFONE,ID_ENDERECO) VALUES (?,?,?,?,?)");
            //setando os valores dos parâmetros
            pstmt.setInt(1,id);
            pstmt.setString(2,nome);
            pstmt.setString(3,email);
            pstmt.setInt(4,telefone);
            pstmt.setInt(5,id_endereco);
            //executando a consulta
            return pstmt.executeUpdate();
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
            pstmt = conn.prepareStatement("UPDATE ESCOLA SET NOME=?");
            //setando o valor do parâmetro
            pstmt.setString(1,nome);
            //executando a consulta
            return pstmt.executeUpdate();
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
            pstmt = conn.prepareStatement("UPDATE ESCOLA SET EMAIL=?");
            //setando o valor do parâmetro
            pstmt.setString(1,email);
            //executando a consulta
            return pstmt.executeUpdate();
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
            pstmt = conn.prepareStatement("UPDATE ESCOLA SET TELEFONE=?");
            //setando o valor do parâmetro
            pstmt.setInt(1,telefone);
            //executando a consulta
            return pstmt.executeUpdate();
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
            pstmt = conn.prepareStatement("CALL EXCLUIR_ESCOLA(?)");
//            //setando o valor do parâmetro
            pstmt.setInt(1,id); //arrumar
            //executando a consulta
            return pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //criando método para listar todas as escolas
    public ResultSet listarEscolas(int id){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try{
            //Consulta SQL para listar todas as escolas
            pstmt = conn.prepareStatement("SELECT*FROM ESCOLA");
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
    //criando método para buscar uma escola pelo id
    public ResultSet buscarEscola(int id){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try{
            //Consulta SQL para buscar uma escola pelo id
            pstmt = conn.prepareStatement("SELECT*FROM ESCOLA WHERE ID=?");
            //setando o valor do parâmetro
            pstmt.setInt(1,id);
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
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

