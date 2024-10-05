package Daos;

//importando classes para conexão com o banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Daos.JDBC.Conexao;
public class ProfessorDAO {
    //definindo variaveis para conexão com o banco de dados
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    //Instanciando a classe de conexão
    Conexao conexao = new Conexao();

    //Criando método para inserir um professor
    public int inserirProfessor(int id, String nome, String sobrenome,String email,String senha ){
        //Conectando ao banco de dados
        conexao.conectar();
        try {
            //consulta SQL para inserir aluno
            pstmt = conn.prepareStatement("INSERT INTO PROFESSOR(ID,NOME,SOBRENOME,EMAIL,SENHA) VALUES (?,?,?,?,?)");
            //setando os valores
            pstmt.setInt(1, id);
            pstmt.setString(2, nome);
            pstmt.setString(3, sobrenome);
            pstmt.setString(4, email);
            pstmt.setString(5, senha);
            //executando a consulta
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para alterar o nome de um professor
    public int alterarNome( String nome, int id ){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //consulta SQL para alterar o nome do professor
            pstmt = conn.prepareStatement("UPDATE PROFESSOR SET NOME=? WHERE ID=?");
            //setando os valores
            pstmt.setString(1,nome);
            pstmt.setInt(2,id);
            //executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException sqle){
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para alterar o sobrenome de um professor
    public int alterarSobrenome( String sobrenome, int id ) {
        //Conectando ao banco de dados
        conexao.conectar();
        try {
            //consulta SQL para alterar o sobrenome do professor
            pstmt = conn.prepareStatement("UPDATE PROFESSOR SET SOBRENOME=? WHERE ID=?");
            //setando os valores
            pstmt.setString(1, sobrenome);
            pstmt.setInt(2, id);
            //executando a consulta
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para remover um professor
    public int removerProfessor(int id){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //consulta SQL para remover o professor
            String sql = "DELETE FROM PROFESSOR WHERE ID=?";
            pstmt = conn.prepareStatement(sql);
            //setando os valores
            pstmt.setInt(1,id);
            //executando a consulta
            return pstmt.executeUpdate();
        }catch(SQLException sqle){
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para consultar um professor com base no id
    public ResultSet consultarProfessor(int id){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //consulta SQL para consultar um professor
            pstmt = conn.prepareStatement("SELECT FROM PROFESSOR WHERE ID=?");
            //setando os valores
            pstmt.setInt(1,id);
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
        }catch (SQLException sqle){
            //caso ocorra algum erro, retorna null
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
    //Criando método para consultar todos os professores
    public ResultSet consultarTodosProfessores(){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //consulta SQL para consultar todos os professores
            pstmt = conn.prepareStatement("SELECT * FROM PROFESSOR");
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
        }catch (SQLException sqle){
            //caso ocorra algum erro, retorna null
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
}

