package Daos;
//importando bibliotecas necessárias
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Daos.JDBC.Conexao;
import Model.Turma;

public class TurmaDAO {
    //definindo variáveis para conexão com o banco
    Conexao conexao;

    //Instanciando a classe Conexao
    public TurmaDAO() {
        this.conexao = new Conexao();
    }

    //Criando método para inserir turma
    public int inserirTurma(int id, int serie, int ano, int id_professor, int id_escola) {
        //Conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("INSERT INTO TURMA VALUES (?,?,?,?,?)")) {
            //Consulta sql para inserir turma
            //setando os valores
            pstmt.setInt(1, id);
            pstmt.setInt(2, serie);
            pstmt.setInt(3, ano);
            pstmt.setInt(4, id_professor);
            pstmt.setInt(5, id_escola);
            //Executando a consulta
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        } finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
    }

    //Criando método para alterar id_professor
    //Para caso mude o professor da turma
    public int atualizarProfessor(int id_professor, int id) {
        //Conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("UPDATE TURMA SET ID_PROFESSOR=? WHERE ID=?")) {
            //Consulta sql para alterar id_professor
            //setando os valores
            pstmt.setInt(1, id_professor);
            pstmt.setInt(2, id);
            //Executando a consulta
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        } finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
    }

    //Criando método para remover turma
    //arrumar com procudere
    public int removerTurma(int id) {
        //Conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("DELETE FROM TURMA WHERE ID=?")) {
            //Consulta sql para remover turma
            //setando os valores
            pstmt.setInt(1, id);
            //Executando a consulta
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            //caso ocorra algum erro, retornar -1

            return -1;
        } finally {
            //Desconectando do banco de dados
            conexao.desconectar();
        }
    }

    public ResultSet buscarTurmaPorId(int id) {
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT*FROM TURMA WHERE ID=?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }
        return null;
    }
    //Criando método para buscar turma por escola

    //Criando método para buscar

    public List<Turma> listarTurmas() {
        List<Turma> turmas = new ArrayList<>();
        //Conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.conn.prepareStatement("SELECT*FROM TURMA ORDER BY SERIE ASC")) {
            //Executando a consulta
            ResultSet rs = pstmt.executeQuery();
            //Enquanto existir registros, adicionar na lista de turmas
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId(rs.getInt("ID"));
                turma.setSerie(rs.getInt("SERIE"));
                turma.setAno(rs.getInt("ANO"));
                turma.setId_professor(rs.getInt("ID_PROFESSOR"));
                turma.setId_escola(rs.getInt("ID_ESCOLA"));
                turmas.add(turma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }
        return turmas;
    }
}

}

