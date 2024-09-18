package modulovendas.DAO;

import modulovendas.Connection.ConnectionModule;
import modulovendas.Models.CompraModel;

import java.sql.*;

public class CompraDAO {
    private Connection connection;
    public  CompraDAO () {
        this.connection = new ConnectionModule().connect();
    }

    public int addCompra(CompraModel compra) throws SQLException {
        // SQL query to insert a new record into the 'compra' table
        String sql = "INSERT INTO compra (USU_CODIGO, FOR_CODIGO, CPR_EMISSAO, CPR_VALOR, CPR_DESCONTO, CPR_TOTAL, CPR_DTENTRADA, CPR_OBS) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Create a PreparedStatement that returns generated keys
        try (PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            // Set the values for the placeholders in the SQL query
            pstmt.setInt(1, compra.getUsuCodigo());
            pstmt.setInt(2, compra.getForCodigo());
            pstmt.setDate(3, Date.valueOf(compra.getCprEmissao()));
            pstmt.setBigDecimal(4, compra.getCprValor());
            pstmt.setBigDecimal(5, compra.getCprDesconto());
            pstmt.setBigDecimal(6, compra.getCprTotal());
            pstmt.setDate(7, Date.valueOf(compra.getCprDtEntrada()));
            pstmt.setString(8, compra.getCprObs());

            // Execute the INSERT statement
            pstmt.executeUpdate();

            // Retrieve the generated keys (e.g., the primary key 'CPR_CODIGO')
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    // Set the generated key (CPR_CODIGO) into the CompraModel object
                    int generatedId = rs.getInt(1);
                    compra.setCprCodigo(generatedId);
                    // Return the generated key
                    return generatedId;
                } else {
                    throw new SQLException("Failed to retrieve generated key.");
                }
            }
        }
    }

    public void updateCompra(CompraModel compra) throws SQLException {
        String sql = "UPDATE compra SET USU_CODIGO = ?, FOR_CODIGO = ?, CPR_EMISSAO = ?, CPR_VALOR = ?, CPR_DESCONTO = ?, " +
                "CPR_TOTAL = ?, CPR_DTENTRADA = ?, CPR_OBS = ? WHERE CPR_CODIGO = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, compra.getUsuCodigo());
            pstmt.setInt(2, compra.getForCodigo());
            pstmt.setDate(3, Date.valueOf(compra.getCprEmissao()));
            pstmt.setBigDecimal(4, compra.getCprValor());
            pstmt.setBigDecimal(5, compra.getCprDesconto());
            pstmt.setBigDecimal(6, compra.getCprTotal());
            pstmt.setDate(7, Date.valueOf(compra.getCprDtEntrada()));
            pstmt.setString(8, compra.getCprObs());
            pstmt.setInt(9, compra.getCprCodigo());
            pstmt.executeUpdate();
        }
    }

    public void deleteCompra(int cprCodigo) throws SQLException {
        String sql = "DELETE FROM compra WHERE CPR_CODIGO = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cprCodigo);
            pstmt.executeUpdate();
        }
    }

    public CompraModel consultarCompra(int cprCodigo) throws SQLException {
        String sql = "SELECT USU_CODIGO, FOR_CODIGO, CPR_EMISSAO, CPR_VALOR, CPR_DESCONTO, CPR_TOTAL, CPR_DTENTRADA, CPR_OBS " +
                     "FROM compra WHERE CPR_CODIGO = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cprCodigo);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    CompraModel compra = new CompraModel();
                    compra.setCprCodigo(cprCodigo);
                    compra.setUsuCodigo(rs.getInt("USU_CODIGO"));
                    compra.setForCodigo(rs.getInt("FOR_CODIGO"));
                    compra.setCprEmissao(rs.getDate("CPR_EMISSAO").toLocalDate());
                    compra.setCprValor(rs.getBigDecimal("CPR_VALOR"));
                    compra.setCprDesconto(rs.getBigDecimal("CPR_DESCONTO"));
                    compra.setCprTotal(rs.getBigDecimal("CPR_TOTAL"));
                    compra.setCprDtEntrada(rs.getDate("CPR_DTENTRADA").toLocalDate());
                    compra.setCprObs(rs.getString("CPR_OBS"));
                    return compra;
                } else {
                    throw new SQLException("Compra com ID " + id + " não encontrada.");
                }
            }
        }
    }
    

}
