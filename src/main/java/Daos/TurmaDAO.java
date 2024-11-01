package Daos;

// Importando classes necessárias para conexão com o banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Daos.JDBC.Conexao;
import Model.Turma;
import Model.TurmaDTO;

public class TurmaDAO {

    // Definindo as variáveis para conexão com o banco de dados
    Conexao conexao;

    // Método que abrirá a conexão com o banco
    public TurmaDAO() {
        this.conexao = new Conexao();
    }

    // Criando método para inserir dados na tabela turma
    public int inserirTurma( TurmaDTO turmaDTO) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para inserir turma
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL INSERIR_TURMA(?,?,?,?,?)")) {

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1, turmaDTO.getSerie());
            pstmt.setString(2, turmaDTO.getNomenclatura());
            pstmt.setInt(3, turmaDTO.getAno());
            pstmt.setString(4, turmaDTO.getNomeEscola());
            pstmt.setString(5, turmaDTO.getNomeProfessor() );

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para atualizar turma
    // O método recebe todos os parâmetros da tabela, porém não necessariamente todos serão alterados
    public int atualizarTurma(Turma turma) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para atualizar turma
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE TURMA SET SERIE=?, NOMENCLATURA=?, ANO=?, ID_PROFESSOR=?, ID_ESCOLA=? WHERE ID=?")) {

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1, turma.getId());
            pstmt.setInt(2, turma.getSerie());
            pstmt.setString(3, turma.getNomenclatura());
            pstmt.setInt(4, turma.getAno());
            pstmt.setInt(5, turma.getId_professor());
            pstmt.setInt(6, turma.getId_escola());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para remover uma turma, que recebe o id da mesma como parâmetro
    //arrumar com procudere
    public int removerTurma(int id) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para remover uma turma
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL EXCLUIR_TURMA(?)")) {

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1, id);

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException e) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para listar as turmas
    public List<Turma> listarTurmas() {

        // Estabelecendo conexão com o banco e criando uma lista
        List<Turma> turmas = new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todas as turmas
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT*FROM TURMA ORDER BY SERIE ASC")) {

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Turma
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId(rs.getInt("ID"));
                turma.setSerie(rs.getInt("SERIE"));
                turma.setNomenclatura(rs.getString("NOMENCLATURA"));
                turma.setAno(rs.getInt("ANO"));
                turma.setId_professor(rs.getInt("ID_PROFESSOR"));
                turma.setId_escola(rs.getInt("ID_ESCOLA"));

                // Adicionando o objeto Turma à lista de turmas
                turmas.add(turma);
            }
        } catch (SQLException e) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return turmas;
    }

    // Criando método para listar as turmas e suas repectivas escolas
    public List<TurmaDTO> listarTurmasPorEscola() {

        // Estabelecendo conexão com o banco e criando uma lista
        List<TurmaDTO> turmas = new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todas as turmas e suas respectivas escolas
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT TURMA.ID, TURMA.SERIE, TURMA.NOMENCLATURA, TURMA.ANO, TURMA.ID_PROFESSOR, TURMA.ID_ESCOLA, ESCOLA.NOME AS NOME_ESCOLA, PROFESSOR.NOME AS NOME_PROFESSOR FROM TURMA JOIN ESCOLA ON TURMA.ID_ESCOLA= ESCOLA.ID JOIN PROFESSOR ON TURMA.ID_PROFESSOR= PROFESSOR.ID ORDER BY SERIE ASC")) {

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto TurmaDTO
            while (rs.next()) {
                TurmaDTO turma = new TurmaDTO();
                turma.setId(rs.getInt("ID"));
                turma.setSerie(rs.getInt("SERIE"));
                turma.setNomenclatura(rs.getString("NOMENCLATURA"));
                turma.setAno(rs.getInt("ANO"));
                turma.setId_professor(rs.getInt("ID_PROFESSOR"));
                turma.setId_escola(rs.getInt("ID_ESCOLA"));
                turma.setNomeEscola(rs.getString("NOME_ESCOLA"));
                turma.setNomeProfessor(rs.getString("NOME_PROFESSOR"));

                // Adicionando o objeto à lista de turmas
                turmas.add(turma);
            }
        } catch (SQLException e) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return turmas;
    }

    // Criando método para buscar aluno, que recebe o id da turma como parâmetro e retorna seus dados correspondentes
    public TurmaDTO buscarTurmaPorId(int id) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Consulta em SQL para buscar turma
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT*FROM TURMA WHERE ID=?")) {

            // Definindo o valor do id
            pstmt.setInt(1, id);

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto TurmaDTO
            while (rs.next()) {
                TurmaDTO turma = new TurmaDTO();
                turma.setId(rs.getInt("ID"));
                turma.setSerie(rs.getInt("SERIE"));
                turma.setNomenclatura(rs.getString("NOMENCLATURA"));
                turma.setAno(rs.getInt("ANO"));
                turma.setId_professor(rs.getInt("ID_PROFESSOR"));
                turma.setId_escola(rs.getInt("ID_ESCOLA"));

                // Retornando a turma selecionado
                return turma;
            }
        } catch (SQLException e) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
        return null;
    }

}



