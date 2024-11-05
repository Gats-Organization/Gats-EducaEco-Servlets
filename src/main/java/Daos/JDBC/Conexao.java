package Daos.JDBC;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
public class Conexao {
    Dotenv dotenv;
    // Variáveis de conexão
    //tirar o público 

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public Conexao() {
        //dotenv = Dotenv.configure().directory("C:\\Users\\raissacasale-ieg\\OneDrive - Instituto Germinare\\Área de Trabalho\\Trabalho Interdisciplinar\\Servlets\\.env").load();
    }
    // Método para conectar ao banco de dados
    public boolean conectar() {
        try {

            // Carregando o driver do banco de dados
            Class.forName("org.postgresql.Driver");
            String url = System.getenv("DATABASEURL");
            String user = System.getenv("USER");
            String password = System.getenv("PASSWORD");

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


