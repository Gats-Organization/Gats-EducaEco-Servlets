package Daos;

//importando as bibliotecas necessárias
import Daos.JDBC.Conexao;
import Model.Escola;
import Model.EscolaDTO;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscolaDAO {
    //definindo variaveis para conexão com o banco de dados
    Conexao conexao;
    //instanciando a classe de conexão

    public EscolaDAO() {
        this.conexao = new Conexao();
    }
    //Criando método para inserir dados na tabela escola
    public int inserirEscola(EscolaDTO escolaDTO) {
        //conectando ao banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL INSERIR_ESCOLA(?,?,?,?)")){
            //consulta SQL para inserir dados na tabela escola
            //setando os valores dos parâmetros
            pstmt.setString(1,escolaDTO.getNome());
            pstmt.setString(2, escolaDTO.getEmail());
            pstmt.setInt(3,escolaDTO.getTelefone());
            pstmt.setString(4,escolaDTO.getEnderecoCompleto());
            //executando a consulta
            return pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //Criando método para alterar o nome da escola
    public int atualizarEscola(Escola escola){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE ESCOLA SET NOME=? , EMAIL=?, TELEFONE=?, ID_ENDERECO=? WHERE ID=?  ")){
            //Consulta SQL para alterar o nome da escola
            pstmt.setString(1,escola.getNome());
            pstmt.setString(2,escola.getEmail());
            pstmt.setInt(3,escola.getTelefone());
            pstmt.setInt(4,escola.getId_endereco());
            pstmt.setInt(5,escola.getId());

            return pstmt.executeUpdate();

            //executando a consulta
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }

    //criando método para remover uma escola
    public int removerEscola(int id){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("CALL EXCLUIR_ESCOLA(?)")){
            //Consulta SQL para remover uma escola
//            //setando o valor do parâmetro
            pstmt.setInt(1,id); //arrumar
            //executando a consulta
            return pstmt.executeUpdate();
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar -1
            return -1;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
    }
    //criando método para listar todas as escolas
    public List<Escola> listarEscolas(){
        //Estabelecendo conexão com o banco de dados
        List<Escola> escolas = new ArrayList<>();
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT*FROM ESCOLA")){
            //Consulta SQL para listar todas as escolas
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Escola escola = new Escola();
                escola.setId(rs.getInt("ID"));
                escola.setNome(rs.getString("NOME"));
                escola.setEmail(rs.getString("EMAIL"));
                escola.setTelefone(rs.getInt("TELEFONE"));
                escola.setId_endereco(rs.getInt("ID_ENDERECO"));
                escolas.add(escola);
            }
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null
            return null;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return escolas;
    }
    public List<EscolaDTO> listarEscolasPorEndereco(){
        //Estabelecendo conexão com o banco de dados
        List<EscolaDTO> escolas = new ArrayList<>();
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT*FROM ESCOLA JOIN ENDERECO ON ESCOLA.ID_ENDERECO = ENDERECO.ID")){
            //Consulta SQL para listar todas as escolas
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                EscolaDTO escola = new EscolaDTO();
                escola.setId(rs.getInt("ID"));
                escola.setNome(rs.getString("NOME"));
                escola.setEmail(rs.getString("EMAIL"));
                escola.setTelefone(rs.getInt("TELEFONE"));
                escola.setId_endereco(rs.getInt("ID_ENDERECO"));
                escola.setNumero(rs.getInt("NUMERO"));
                escola.setRua(rs.getString("RUA"));
                escola.setBairro(rs.getString("BAIRRO"));
                escola.setCidade(rs.getString("CIDADE"));
                escola.setEstado(rs.getString("ESTADO"));
                escola.setCep(rs.getString("CEP"));
                escolas.add(escola);
            }
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null
            return null;
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return escolas;
    }
    //criando método para buscar uma escola pelo id
    public Escola buscarEscolaPorId(int id){
        //Estabelecendo conexão com o banco de dados
        conexao.conectar();
        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT*FROM ESCOLA WHERE ID=?")){
            //Consulta SQL para buscar uma escola pelo id
            //setando o valor do parâmetro
            pstmt.setInt(1,id);
            //executando a consulta
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Escola escola = new Escola();
                escola.setId(rs.getInt("ID"));
                escola.setNome(rs.getString("NOME"));
                escola.setEmail(rs.getString("EMAIL"));
                escola.setTelefone(rs.getInt("TELEFONE"));
                escola.setId_endereco(rs.getInt("ID_ENDERECO"));
                return escola;

            }
        }catch (SQLException e) {
            //caso ocorra algum erro, retornar null
        }finally {
            //desconectando do banco de dados
            conexao.desconectar();
        }
        return null;
    }
}

