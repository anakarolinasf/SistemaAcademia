package dao;
import java.sql.Connection;
import dao.Conexao;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConnection()) {
            System.out.println("✅ Conexão bem-sucedida!");
        } catch (Exception e) {
            System.out.println("❌ Erro na conexão: " + e.getMessage());
        }
    }
}
