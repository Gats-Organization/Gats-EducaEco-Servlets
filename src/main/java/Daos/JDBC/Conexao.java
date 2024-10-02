package Daos.JDBC;

import java.sql.*;
public class Conexao {
    // Variáveis de conexão
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstmt;

    // Método para conectar ao banco de dados
    public boolean conectar() {
        try {
            // Carregando o driver do banco de dados
            Class.forName("org.postgresql.Driver");
            // Configurando a conexão com o banco de dados
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://pg-3f95fc8e-educaeco.k.aivencloud.com:12168/dbGats", "postgres", "AVNS_r89pqPsfl1M4wvtLp_2"
            );
        } catch (ClassNotFoundException cnfe) {
            //Caso o driver não seja encontrado
            return false;
        } catch (SQLException sqle) {
            //Caso ocorra algum erro de conexão
            return false;
        }
        //Se a conexão for bem sucedida, retorna true
        return true;
    }
    //Método para desconectar do banco de dados
    public boolean desconectar() {
        try {
            // Fechando o ResultSet, PreparedStatement e Conexão
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException sqle) {
            //caso ocorra algum erro de desconexão
            return false;
        }
        //Se a desconexão for bem sucedida, retorna true
        return true;
    }
}


