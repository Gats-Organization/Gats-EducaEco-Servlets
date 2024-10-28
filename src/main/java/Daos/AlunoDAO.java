package Daos;//importando classes para conexão com o banco de dados
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;
import Daos.JDBC.Conexao;
import Model.Aluno;
import Model.AlunoDTO;
import Model.TurmaDTO;

public class AlunoDAO {
    //definindo variaveis para conexão com o banco de dados
    Conexao conexao;


    public AlunoDAO() {
        this.conexao = new Conexao();
    }
    AlunoDTO alunoDTO = new AlunoDTO();
    String turma = alunoDTO.getSerie() + '-' + alunoDTO.getNomeclantura();
    //criando método inserir aluno
    public int inserirAluno(AlunoDTO alunoDTO) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        //consulta SQL para inserir aluno
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL INSERIR_ALUNO(?,?,?,?,?,?)")) {
            //setando os valores
            pstmt.setString(1, alunoDTO.getNome());
            pstmt.setString(2, alunoDTO.getSobrenome());
            pstmt.setInt(3, alunoDTO.getXp());
            pstmt.setString(4, alunoDTO.getEmail());
            pstmt.setString(5, alunoDTO.getSenha());
            pstmt.setString(6, alunoDTO.getTurma());
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



    //criando método para alterar o id da turma do aluno, recebe o id_turma e o id
    public int atualizarAluno( AlunoDTO aluno) {

        // estabelecendo conexão
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL ATUALIZAR_ALUNO(?,?,?,?,?,?,?)")){
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getSobrenome());
            pstmt.setInt(3, aluno.getXp());
            pstmt.setString(4, aluno.getEmail());
            pstmt.setString(5, aluno.getSenha());
            pstmt.setString(6, aluno.getTurma());
            pstmt.setInt(7, aluno.getId());
            // executando a consulta
             return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            // retornando -1 em caso de erro
            sqle.printStackTrace();
            return -1;

        } finally {
            // fechando conexão com o banco
            conexao.desconectar();
        }
    }

    //criando método para remover aluno, que recebe o id do aluno como parâmetro
    public int removerAluno(int id) {
        //estabelecendo conexão com o banco
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL EXCLUIR_ALUNO(?)")){
            //consulta SQL para remover aluno
            //setando o valor do id
            pstmt.setInt(1, id);
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

    public List<Aluno> listarAlunos() {
        //estabelecendo conexão com o banco
        List<Aluno> alunos = new ArrayList<>();
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ALUNO")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setXp(rs.getInt("xp"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setId_turma(rs.getInt("id_turma"));
                alunos.add(aluno);
            }
        } catch (SQLException sqle) {
            return null;
        } finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
        return alunos;
    }


    public List<AlunoDTO> listarAlunosTurma() {
        //estabelecendo conexão com o banco
        List<AlunoDTO> alunos = new ArrayList<>();
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM aluno JOIN turma ON aluno.id_turma = turma.id")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setXp(rs.getInt("xp"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setIdTurma(rs.getInt("id_turma"));
                aluno.setSerie(rs.getInt("serie"));
                aluno.setNomeclantura(rs.getString("nomenclatura"));
                alunos.add(aluno);
            }
        } catch (SQLException sqle) {
            return null;
        } finally {
            //fechando conexão com o banco
            conexao.desconectar();
        }
        return alunos;
    }

    //criando método para buscar aluno, que recebe o id do aluno como parâmetro e retorna o resultado da consulta
    public AlunoDTO buscarAlunoPorId(int id) {
        //estabelecendo conexão com o banco
         conexao.conectar();
        //consulta SQL para buscar aluno
        try  (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ALUNO WHERE ID= ?")){
            //setando o valor do id
            pstmt.setInt(1, id);
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
             while(rs.next()){
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setXp(rs.getInt("xp"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setTurma(rs.getString("turma"));
                return aluno;
            }
        } catch (SQLException sqle) {
            return null;
            //retornando null em caso de erro
        } finally {
            //fechando conexão com o banco
            conexao.desconectar();

        }

        return null;
    }
}


