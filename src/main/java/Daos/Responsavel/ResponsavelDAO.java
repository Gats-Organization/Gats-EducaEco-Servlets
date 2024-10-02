package Daos.Responsavel;

//importando bibliotecas necessárias
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Daos.JDBC.Conexao;

public class ResponsavelDAO {
    //definindo váriaveis para conexão com o banco
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    //Instanciando a classe Conexao
    Conexao conexao = new Conexao();

    //Criando método para inserir um responsável
    public int inserirResponsavel(int id,String nome, String sobrenome,String email, String senha, int id_aluno ) {
        //conectando com banco de dados
        conexao.conectar();
        try {
            //consulta sql para inserir um responsável
            pstmt = conn.prepareStatement("INSERT INTO RESPONSAVEL VALUES(?,?,?,?,?,?,?)");
            //setando os valores
            pstmt.setInt(1,id);
            pstmt.setString(2,nome);
            pstmt.setString(3,sobrenome);
            pstmt.setString(4,email);
            pstmt.setString(5,senha);
            pstmt.setInt(6,id_aluno);
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
    public int alterarResponsavel(int id, String nome,String sobrenome, String email, String senha, int id_aluno ) {
        //conectando com banco de dados
        conexao.conectar();
        try{
            //consulta sql para alterar um responsável
            pstmt = conn.prepareStatement("UPDATE RESPONSAVEL SET ID =? , SET NOME =? , " +
                    "SET SOBRENOME=? , SET EMAIL=?,SET SENHA=? SET ID_ALUNO=? WHERE ID=?");
            //setando os valores
            pstmt.setInt(1,id);
            pstmt.setString(2,nome);
            pstmt.setString(3,sobrenome);
            pstmt.setString(4,email);
            pstmt.setString(5,senha);
            pstmt.setInt(6,id_aluno);
            pstmt.setInt(7,id);
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
        try{
            //consulta sql para remover um responsável
            String sql = "DELETE FROM RESPONSAVEL WHERE ID=?";
            pstmt = conn.prepareStatement(sql);
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
    public ResultSet consultarResponsavel(){
        //conectando com banco de dados
        conexao.conectar();
        try{
            //consulta sql para consultar responsáveis
            pstmt = conn.prepareStatement("SELECT*FROM RESPONSAVEL");
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch(SQLException e) {
            //caso ocorra algum erro, retorna null
        }finally{
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }

}