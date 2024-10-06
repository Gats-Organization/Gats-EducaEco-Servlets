package Daos.JDBC;

import java.sql.Connection;
public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        // Testar se a conexão foi bem-sucedida
        boolean sucesso = conexao.conectar();

        if (sucesso) {
            System.out.println("Conexão bem-sucedida!");
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    }
}