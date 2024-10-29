package Daos;

// Importando classes necessárias para conexão com o banco de dados
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Daos.JDBC.Conexao;
import Model.Aluno;
import Model.AlunoDTO;

public class AlunoDAO {
    // Definindo as variáveis para conexão com o banco de dados
    Conexao conexao;

    // Método que abrirá a conexão com o banco
    public AlunoDAO() {
        this.conexao = new Conexao();
    }

    // Instância de um objeto do tipo Aluno DTO e uma String turma, que receberá o nome da turma formatado
    AlunoDTO alunoDTO = new AlunoDTO();
    String turma = alunoDTO.getSerie() + '-' + alunoDTO.getNomeclantura();

    // Criando método para inserir dados na tabela Aluno
    public int inserirAluno(AlunoDTO alunoDTO) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para inserir aluno
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL INSERIR_ALUNO(?,?,?,?,?,?)")) {

            // Definindo os parâmetros usados no comando
            pstmt.setString(1, alunoDTO.getNome());
            pstmt.setString(2, alunoDTO.getSobrenome());
            pstmt.setInt(3, alunoDTO.getXp());
            pstmt.setString(4, alunoDTO.getEmail());
            pstmt.setString(5, alunoDTO.getSenha());
            pstmt.setString(6, alunoDTO.getTurma());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para atualizar aluno
    // O método recebe todos os parâmetros da tabela, porém não necessariamente todos serão alterados
    public int atualizarAluno( AlunoDTO aluno) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para atualizar aluno
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL ATUALIZAR_ALUNO(?,?,?,?,?,?,?)")){

            // Definindo os parâmetros usados no comando
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getSobrenome());
            pstmt.setInt(3, aluno.getXp());
            pstmt.setString(4, aluno.getEmail());
            pstmt.setString(5, aluno.getSenha());
            pstmt.setString(6, aluno.getTurma());
            pstmt.setInt(7, aluno.getId());

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {

            // Retornando -1 em caso de erro
            sqle.printStackTrace();
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para remover aluno, que recebe o id do mesmo como parâmetro
    public int removerAluno(int id) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para remover um aluno
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL EXCLUIR_ALUNO(?)")){

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1, id);

            // Executando o comando
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {

            // Retornando -1 em caso de erro
            return -1;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
    }

    // Criando método para listar os alunos
    public List<Aluno> listarAlunos() {

        // Estabelecendo conexão com o banco e criando uma lista
        List<Aluno> alunos = new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todos os alunos
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ALUNO")) {

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Aluno
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setXp(rs.getInt("xp"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setId_turma(rs.getInt("id_turma"));

                // Adicionando o objeto Aluno à lista de alunos
                alunos.add(aluno);
            }
        } catch (SQLException sqle) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return alunos;
    }

    // Criando método para listar os alunos e suas repectivas turmas
    public List<AlunoDTO> listarAlunosTurma() {

        // Estabelecendo conexão com o banco e criando uma lista
        List<AlunoDTO> alunos = new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todos os alunos e suas respectivas turmas
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM aluno JOIN turma ON aluno.id_turma = turma.id")) {

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto AlunoDTO
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

                // Adicionando o objeto à lista de alunos
                alunos.add(aluno);
            }
        } catch (SQLException sqle) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return alunos;
    }

    // Criando método para buscar aluno, que recebe o id do aluno como parâmetro e retorna seus dados correspondentes
    public AlunoDTO buscarAlunoPorId(int id) {

        // Estabelecendo conexão com o banco
         conexao.conectar();

        // Consulta em SQL para buscar aluno
        try  (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ALUNO WHERE ID= ?")){

            // Definindo o valor do id
            pstmt.setInt(1, id);

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto AlunoDTO
            while(rs.next()){
                AlunoDTO aluno = new AlunoDTO();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setXp(rs.getInt("xp"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setTurma(rs.getString("turma"));

                // Retornando o aluno selecionado
                return aluno;
            }
        } catch (SQLException sqle) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }
        return null;
    }
}


