package br.com.fiapStore.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private Connection connection;
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private final String USER = "RM99748";
    private final String PASSWORD = "130303";

    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar-se ao banco de dados", e);
        }
        return connection;
    }
}
