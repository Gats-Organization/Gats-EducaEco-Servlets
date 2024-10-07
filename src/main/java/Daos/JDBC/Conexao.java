package Daos.JDBC;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
public class Conexao {
    // Variáveis de conexão

    public Connection conn;
    public ResultSet rs;
    public PreparedStatement pstmt;

    // Método para conectar ao banco de dados
    public boolean conectar() {
        try {

            // Carregando o driver do banco de dados
            Class.forName("org.postgresql.Driver");
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("DATABASE_URL");
            String user = dotenv.get("USER");
            String password = dotenv.get("PASSWORD");

//            String urlA= "jdbc:postgresql://pg-3f95fc8e-educaeco.k.aivencloud.com:12168/defaultdb";
//            String userA= "avnadimin";
//            String passwordA= "AVNS_r89pqPsfl1M4wvtLp_2";
            // Configurando a conexão com o banco de dados
            conn = DriverManager.getConnection(
                    url,user, password
            );

            //Se a conexão for bem sucedida, retorna true
            return conn != null;
        } catch (ClassNotFoundException cnfe) {
            //Caso o driver não seja encontrado
            return false;
        } catch (SQLException sqle) {
            //Caso ocorra algum erro de conexão
            return false;
        }
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


