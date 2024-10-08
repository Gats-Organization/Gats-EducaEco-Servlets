package Daos;//importando classes para conexão com o banco de dados
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import Daos.JDBC.Conexao;
import Model.Aluno;

public class AlunoDAO {
    //definindo variaveis para conexão com o banco de dados
    Conexao conexao;

    public AlunoDAO() {
       this.conexao = new Conexao();
    }


    //criando método inserir aluno
    public int inserirAluno(int id, String nome, String sobrenome, int xp, String email, String senha, int id_turma) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        //consulta SQL para inserir aluno
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("INSERT INTO ALUNO (ID,NOME,SOBRENOME,XP,EMAIL,SENHA,ID_TURMA) VALUES (?,?,?,?,?,?,?)")){
            //setando os valores
            pstmt.setInt(1, id);
            pstmt.setString(2, nome);
            pstmt.setString(3, sobrenome);
            pstmt.setInt(4, xp);
            pstmt.setString(5, email);
            pstmt.setString(6, senha);
            pstmt.setInt(7, id_turma);
            //executando a consulta
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            //retornando -1 em caso de erro
            return -1;
        } finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
    }

    //criando método para alterar o nome do aluno
    public int alterarNome(String nome, int id) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        try {
            //consulta SQL para alterar o nome do aluno
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ALUNO SET NOME=? WHERE ID=? ");
            //setando os valores
            conexao.pstmt.setString(1, nome);
            conexao.pstmt.setInt(2, id);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        } catch (SQLException sqle) {
            //retornando -1 em caso de erro
            return -1;
        } finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
    }

    //criando método para alterar o id da turma do aluno, recebe o id_turma e o id
    public int alterarId_turma(int id_turma, int id) {

        // estabelecendo conexão
        conexao.conectar();
        try {
            // preparando a consulta para ser executada
            conexao.pstmt = conexao.conn.prepareStatement("CALL TRANSFERIR_ALUNO(?,?)");

            // setanddo os valores
            conexao.pstmt.setInt(1, id_turma);
            conexao.pstmt.setInt(2, id);
            // executando a consulta
            return conexao.pstmt.executeUpdate();
        } catch (SQLException sqle) {
            // retornando -1 em caso de erro
            return -1;
        } finally {
            // fechando conexão com o banco
            conexao.desconectar();
        }
    }

    //criando método para remover aluno, que recebe o id do aluno como parâmetro
    public int remover(int id) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        try {
            //consulta SQL para remover aluno
            String remover = "DELETE FROM ALUNO WHERE ID=?";
            conexao.pstmt = conexao.conn.prepareStatement(remover);
            //setando o valor do id
            conexao.pstmt.setInt(1, id);
            //executando a consulta
            return conexao.pstmt.executeUpdate();
        } catch (SQLException sqle) {
            //retornando -1 em caso de erro
            return -1;
        } finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
    }

    public ResultSet listarAlunos() {
        //estabelecendo conexão com o banco
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT * FROM ALUNO")) {
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException sqle) {
            return null;
        } finally {
            conexao.desconectar();
        }

    }


    //criando método para buscar aluno, que recebe o id do aluno como parâmetro e retorna o resultado da consulta
    public ResultSet buscarAluno(int id) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        //consulta SQL para buscar aluno
        try  (PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT * FROM ALUNO WHERE ID= ?")){
            //setando o valor do id
            conexao.pstmt.setInt(1, id);
            //executando a consulta
            ResultSet rs = conexao.pstmt.executeQuery();
        } catch (SQLException sqle) {
            //retornando null em caso de erro
        } finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
        return null;


    }



}


