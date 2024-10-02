package Daos.Turma;
//importando bibliotecas necessárias
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Daos.JDBC.Conexao;

public class TurmaDAO {
    //definindo variáveis para conexão com o banco
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstmt;
    //Instanciando a classe Conexao
    Conexao conexao = new Conexao();

    //Criando método para inserir turma
    public int inserirTurma(int id, int serie, int ano, int id_professor,int id_escola) {
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //Consulta sql para inserir turma
            pstmt = conn.prepareStatement("INSERT INTO TURMA VALUES (?,?,?,?,?)");
           //setando os valores
            pstmt.setInt(1,id);
            pstmt.setInt(2,serie);
            pstmt.setInt(3,ano);
            pstmt.setInt(4,id_professor);
            pstmt.setInt(5,id_escola);
            //Executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e){
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para alterar id_professor
    //Para caso mude o professor da turma
    public int alterarIdProfessor(int id_professor, int id){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //Consulta sql para alterar id_professor
            pstmt = conn.prepareStatement("UPDATE TURMA SET ID_PROFESSOR=? WHERE ID=?");
            //setando os valores
            pstmt.setInt(1,id_professor);
            pstmt.setInt(2,id);
            //Executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e){
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para remover turma
    //arrumar com procudere
    public int removerTurma(int id){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //Consulta sql para remover turma
            String sql = "DELETE FROM TURMA WHERE ID=?";
            pstmt = conn.prepareStatement(sql);
            //setando os valores
            pstmt.setInt(1,id);
            //Executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException e){
            //caso ocorra algum erro, retornar -1

            return -1;
        }finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
    }

    public ResultSet buscarTurma(int id){
        conexao.conectar();
        try{
            pstmt = conn.prepareStatement("SELECT*FROM TURMA WHERE ID=?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexao.desconectar();
        }
        return null;
    }
    //Criando método para buscar turma por serie
    public ResultSet buscarTurmaPorSerie(int serie){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //Consulta sql para buscar turma por serie
            pstmt = conn.prepareStatement("SELECT*FROM TURMA WHERE SERIE=?");
            //setando os valores
            pstmt.setInt(1,serie);
            //Executando a consulta
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null

        }finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
    //Criando método para buscar turma por escola
    public ResultSet buscarTurmaPorEscola(int id_escola){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //Consulta sql para buscar turma por escola
            pstmt = conn.prepareStatement("SELECT*FROM TURMA WHERE ID_TURMA=?");
            //setando os valores
            pstmt.setInt(1,id_escola);
            //Executando a consulta
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null

        }finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
    //Criando método para buscar turma por ano
    public ResultSet buscarTurmaPorAno(int ano){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //Consulta sql para buscar turma por ano
            pstmt = conn.prepareStatement("SELECT*FROM TURMA WHERE AN0=?");
            //setando os valores
            pstmt.setInt(1,ano);
            //Executando a consulta
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null

        }finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }

}

