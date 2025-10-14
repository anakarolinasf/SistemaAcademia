package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/academia";
    private static final String USER = "root";       // seu usuário MySQL
    private static final String PASSWORD = "suaSenhaAqui"; // sua senha

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
