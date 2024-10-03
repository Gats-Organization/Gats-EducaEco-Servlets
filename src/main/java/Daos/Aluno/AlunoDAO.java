package Daos.Aluno;

//importando classes para conexão com o banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Daos.JDBC.Conexao;

public class AlunoDAO {
    //definindo variaveis para conexão com o banco de dados
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    //criando método inserir aluno
    public int inserirAluno(int id, String nome, String sobrenome, String email, String senha, int xp, int id_turma) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        try {
            //consulta SQL para inserir aluno
            pstmt = conn.prepareStatement("INSERT INTO ALUNO (ID,NOME,SOBRENOME,EMAIL,SENHA,XP,ID_TURMA) VALUES (?,?,?,?,?,?,?)");
            //setando os valores
            pstmt.setInt(1, id);
            pstmt.setString(2, nome);
            pstmt.setString(3, sobrenome);
            pstmt.setString(4, email);
            pstmt.setString(5, senha);
            pstmt.setInt(6, xp);
            pstmt.setInt(7, id_turma);
            //executando a consulta
            return pstmt.executeUpdate() ;
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
        try{
            //consulta SQL para alterar o nome do aluno
            pstmt = conn.prepareStatement("UPDATE ALUNO SET NOME=? WHERE ID=? ");
            //setando os valores
            pstmt.setString(1,nome);
            pstmt.setInt(2,id);
            //executando a consulta
            return pstmt.executeUpdate();
        }catch (SQLException sqle) {
            //retornando -1 em caso de erro
            return -1;
        }
        finally {
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
            pstmt = conn.prepareStatement("CALL TRANSFERIR_ALUNO(?,?)");

            // setanddo os valores
            pstmt.setInt(1,id_turma);
            pstmt.setInt(2,id);
            // executando a consulta
            return pstmt.executeUpdate();
        }catch (SQLException sqle) {
            // retornando -1 em caso de erro
            return -1;
        }finally {
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
            pstmt = conn.prepareStatement(remover);
            //setando o valor do id
            pstmt.setInt(1,id);
            //executando a consulta
            return pstmt.executeUpdate();
        }catch (SQLException sqle) {
            //retornando -1 em caso de erro
            return -1;
        }finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
    }
    public List<Aluno> listarAlunos() {
        //estabelecendo conexão com o banco
        conexao.conectar();
        List<Aluno> alunos = new ArrayList<>();
        try {
             pstmt = conn.prepareStatement("SELECT * FROM ALUNO");
             ResultSet rs = pstmt.executeQuery();
        }catch (SQLException sqle) {
            return null;
        }finally {
            conexao.desconectar();
        }
        return alunos;
    }













    //criando método para buscar aluno, que recebe o id do aluno como parâmetro e retorna o resultado da consulta
    public ResultSet buscarAluno(int id) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        try {
            //consulta SQL para buscar aluno
            pstmt = conn.prepareStatement("SELECT * FROM ALUNO WHERE ID= ?");
            //setando o valor do id
            pstmt.setInt(1,id);
            //executando a consulta
            ResultSet rs =pstmt.executeQuery();
        }catch (SQLException sqle) {
            //retornando null em caso de erro
        }finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
        return null;


    }
    //criando método para buscar aluno por turma, que recebe o id da turma como parâmetro e retorna o resultado da consulta
    public ResultSet buscarAlunoPorTurma(int id_turma) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        try{
            //consulta SQL para buscar aluno por turma
            pstmt = conn.prepareStatement("SELECT * FROM ALUNO WHERE ID_TURMA =? ");
            //setando o valor do id da turma
            pstmt.setInt(1,id_turma);
            //retornando o resultado da consulta
            ResultSet rs = pstmt.executeQuery();
        }catch (SQLException sqle) {
            //retornando null em caso de erro
        }finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
        return null;
    }

}


