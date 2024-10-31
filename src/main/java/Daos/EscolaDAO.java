package Daos;

// Importando classes necessárias para conexão com o banco de dados
import Daos.JDBC.Conexao;
import Model.Escola;
import Model.EscolaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscolaDAO {

    // Definindo as variáveis para conexão com o banco de dados
    Conexao conexao;

    // Método que abrirá a conexão com o banco
    public EscolaDAO() {
        this.conexao = new Conexao();
    }

    // Criando método para inserir dados na tabela Escola
    public int inserirEscola(EscolaDTO escolaDTO) {

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para inserir escola
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL INSERIR_ESCOLA(?,?,?,?)")){

            // Definindo os parâmetros usados no comando
            pstmt.setString(1,escolaDTO.getNome());
            pstmt.setString(2, escolaDTO.getEmail());
            pstmt.setString(3,escolaDTO.getTelefone());
            pstmt.setString(4,escolaDTO.getEnderecoCompleto());

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

    // Criando método para atualizar escola
    // O método recebe todos os parâmetros da tabela, porém não necessariamente todos serão alterados
    public int atualizarEscola(EscolaDTO  escola){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para atualizar escola
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL ATUALIZAR_ESCOLA (?,?,?,?,?) ")){

                // Definindo os parâmetros usados no comando
                pstmt.setInt(1,escola.getId());
                pstmt.setString(2,escola.getNome());
                pstmt.setString(3,escola.getEmail());
                pstmt.setString(4,escola.getTelefone());
                pstmt.setString(5,escola.getEnderecoCompleto());

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

    // Criando método para remover uma escola, que recebe o id da mesma como parâmetro
    public int removerEscola(int id){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Comando em SQL para remover uma escola
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL EXCLUIR_ESCOLA(?)")){

            // Definindo os parâmetros usados no comando
            pstmt.setInt(1,id); //arrumar

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

    // Criando método para listar as escolas e seus repectivos endereços
    public List<EscolaDTO> listarEscolasPorEndereco(){

        // Estabelecendo conexão com o banco e criando uma lista
        List<EscolaDTO> escolas = new ArrayList<>();
        conexao.conectar();

        // Comando em SQL para listar todas as escolas e seus respectivos endereços
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ESCOLA JOIN ENDERECO ON ESCOLA.ID_ENDERECO = ENDERECO.ID")){

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto EscolaDTO
            while (rs.next()) {
                EscolaDTO escola = new EscolaDTO();
                escola.setId(rs.getInt("ID"));
                escola.setNome(rs.getString("NOME"));
                escola.setEmail(rs.getString("EMAIL"));
                escola.setTelefone(rs.getString("TELEFONE"));
                escola.setId_endereco(rs.getInt("ID_ENDERECO"));
                escola.setNumero(rs.getInt("NUMERO"));
                escola.setRua(rs.getString("RUA"));
                escola.setBairro(rs.getString("BAIRRO"));
                escola.setCidade(rs.getString("CIDADE"));
                escola.setEstado(rs.getString("ESTADO"));
                escola.setCep(rs.getString("CEP"));

                // Adicionando o objeto à lista de alunos
                escolas.add(escola);
            }
        } catch (SQLException e) {

            // Em caso de erro, a consulta retorna null
            return null;
        } finally {

            // Por fim, fechando a conexão com o banco
            conexao.desconectar();
        }

        // Retornando a lista
        return escolas;
    }

    // Criando método para buscar escola, que recebe o id da escola como parâmetro e retorna seus dados correspondentes
    public EscolaDTO buscarEscolaPorId(int id){

        // Estabelecendo conexão com o banco
        conexao.conectar();

        // Consulta em SQL para buscar escola
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ESCOLA WHERE ID=?")){

            // Definindo o valor do id
            pstmt.setInt(1,id);

            // Definindo o ResultSet para receber os resultados da consulta
            ResultSet rs = pstmt.executeQuery();

            // Percorrendo o ResultSet e atribuindo os valores a um objeto Escola
            while (rs.next()) {
                EscolaDTO escola = new EscolaDTO();
                escola.setId(rs.getInt("ID"));
                escola.setNome(rs.getString("NOME"));
                escola.setEmail(rs.getString("EMAIL"));
                escola.setTelefone(rs.getString("TELEFONE"));
                escola.setId_endereco(rs.getInt("ID_ENDERECO"));

                // Retornando a escola selecionada
                return escola;
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

