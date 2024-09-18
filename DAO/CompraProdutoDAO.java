package modulovendas.DAO;

import modulovendas.Connection.ConnectionModule;
import modulovendas.Models.CompraProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraProdutoDAO {
    private Connection connection;

    public CompraProdutoDAO() {
        this.connection = new ConnectionModule().connect();
    }

    public void inserir(CompraProdutoModel compraProduto) throws SQLException {
        String sql = "INSERT INTO compra_produto (CPR_CODIGO, PRO_CODIGO, CPR_QTDE, CPR_PRECO, CPR_DESCONTO, CPR_TOTAL) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, compraProduto.getCompraCodigo());
            statement.setInt(2, compraProduto.getProdutoCodigo());
            statement.setBigDecimal(3, compraProduto.getQuantidade());
            statement.setBigDecimal(4, compraProduto.getPreco());
            statement.setBigDecimal(5, compraProduto.getDesconto());
            statement.setBigDecimal(6, compraProduto.getTotal());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
