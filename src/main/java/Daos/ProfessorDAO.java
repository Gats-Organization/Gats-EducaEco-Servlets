package Daos;

//importando classes para conexão com o banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Daos.JDBC.Conexao;
import Model.Professor;

public class ProfessorDAO {
    //definindo variaveis para conexão com o banco de dados
    Conexao conexao;
    //Instanciando a classe de conexão
    public ProfessorDAO() {
        this.conexao = new Conexao();
    }

    //Criando método para inserir um professor
    public int inserirProfessor(int id, String nome, String sobrenome,String email,String senha ){
        //Conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("INSERT INTO PROFESSOR(ID,NOME,SOBRENOME,EMAIL,SENHA) VALUES (?,?,?,?,?)")){
            //consulta SQL para inserir aluno
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
    public int atualizarProfessor( Professor professor ){
        //Conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("UPDATE PROFESSOR SET NOME = ?, SET SOBRENOME = ?, SET EMAIL = ?, SET SENHA = ? WHERE ID = ?")){
            //consulta SQL para alterar o nome do professor
            //setando os valores
            pstmt.setString(1,professor.getNome());
            pstmt.setString(2,professor.getSobrenome());
            pstmt.setString(3,professor.getEmail());
            pstmt.setString(4,professor.getSenha());
            pstmt.setInt(5,professor.getId());
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

    //Criando método para remover um professor
    public int removerProfessor(int id){
        //Conectando ao banco de dados
        conexao.conectar();
        try{
            //consulta SQL para remover o professor
            String sql = "DELETE FROM PROFESSOR WHERE ID=?";
            conexao.pstmt = conexao.conn.prepareStatement(sql);
            //setando os valores
            conexao.pstmt.setInt(1,id);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        }catch(SQLException sqle){
            //caso ocorra algum erro, retorna -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para consultar um professor com base no id
    public Professor buscarProfessorPorId(int id){
        //Conectando ao banco de dados
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT * FROM PROFESSOR WHERE ID=?")){
            //consulta SQL para consultar um professor
            // setando os valores
            pstmt.setInt(1,id);
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("ID"));
                professor.setNome(rs.getString("NOME"));
                professor.setEmail(rs.getString("EMAIL"));
                professor.setSenha(rs.getString("SENHA"));
                return professor;

            }
        }catch (SQLException sqle){
            //caso ocorra algum erro, retorna null
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
    //Criando método para consultar todos os professores
    public List<Professor> listarProfessores(){
        List<Professor> professores = new ArrayList<>();
        //Conectando ao banco de dados
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT * FROM PROFESSOR")){
            //consulta SQL para consultar todos os professores
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setSobrenome(rs.getString("sobrenome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
                professores.add(professor);
            }
        }catch (SQLException sqle){
            return null;
            //caso ocorra algum erro, retorna null
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return professores;
    }
}
