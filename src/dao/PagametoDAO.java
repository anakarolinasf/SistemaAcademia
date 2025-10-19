package dao;
import model.Pagamento;
import java.sql.*;
import java.util.*;

public class PagamentoDAO {

    public void inserir(Pagamento p) {
        String sql = "INSERT INTO pagamento (id_aluno, valor, data_pagamento, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getIdAluno());
            stmt.setDouble(2, p.getValor());
            stmt.setDate(3, p.getDataPagamento());
            stmt.setString(4, p.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pagamento> listar() {
        List<Pagamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM pagamento";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pagamento p = new Pagamento();
                p.setId(rs.getInt("id_pagamento"));
                p.setIdAluno(rs.getInt("id_aluno"));
                p.setValor(rs.getDouble("valor"));
                p.setDataPagamento(rs.getDate("data_pagamento"));
                p.setStatus(rs.getString("status"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
