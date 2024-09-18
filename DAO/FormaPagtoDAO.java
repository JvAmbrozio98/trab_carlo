package modulovendas.DAO;

import modulovendas.Connection.ConnectionModule;
import modulovendas.Models.FormaPagtoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormaPagtoDAO {
    private Connection connectionModule;
    public FormaPagtoDAO () {this.connectionModule = new ConnectionModule().connect();
    }
    public void adcionar(FormaPagtoModel formaPagtoModel) throws SQLException {
        String sql = "INSERT INTO formapagto (FPG_NOME, FPG_ATIVO)\n" + "VALUES\n" + "(?,?);";
        PreparedStatement stmFormPagto = this.connectionModule.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmFormPagto.setString(1,formaPagtoModel.getFpgNome());
        stmFormPagto.setString(2,String.valueOf(formaPagtoModel.getFpgAtivo()));
        int affectedRows = stmFormPagto.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Inserting into FormaPagto failed, no rows affected.");
        }
    }

    public void excluir(Integer id) {
        String sql = "DELETE FROM formapagto\n" + "WHERE FPG_CODIGO = ?;";
        try (PreparedStatement pstmt1 = connectionModule.prepareStatement(sql)) {
            pstmt1.setInt(1, id); // Set the value for the placeholder
            int affectedRows1 = pstmt1.executeUpdate();

            if (affectedRows1 > 0) {
                System.out.println("Delete from cliente successful.");
            } else {
                System.out.println("No records deleted from cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting from cliente: " + e.getMessage());
        }
    }
    public void atualizar(FormaPagtoModel formaPagtoModel, Integer id) {
        String sql = "UPDATE formapagto SET FPG_NOME = ?, FPG_ATIVO = ? WHERE FPG_CODIGO = ?";
        try (PreparedStatement pstmt1 = connectionModule.prepareStatement(sql)) {
            pstmt1.setString(1, formaPagtoModel.getFpgNome()); // Set FPG_NOME
            pstmt1.setString(2, String.valueOf(formaPagtoModel.getFpgAtivo())); // Set FPG_ATIVO (assuming it's a boolean)
            pstmt1.setInt(3, id); // Set the value for FPG_CODIGO

            int affectedRows1 = pstmt1.executeUpdate();

            if (affectedRows1 > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("No records updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }
    }

    public FormaPagtoModel consultarPorId(Integer id) throws SQLException {
    String sql = "SELECT * FROM formapagto WHERE FPG_CODIGO = ?";
    
    try (PreparedStatement pstmt = connectionModule.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                formaPagto = new FormaPagtoModel();
                formaPagto.setFpgCodigo(rs.getInt("FPG_CODIGO")); // Assumindo que há um campo FPG_CODIGO
                formaPagto.setFpgNome(rs.getString("FPG_NOME"));
                formaPagto.setFpgAtivo(rs.getChar("FPG_ATIVO"));
            }
        }
    }
    
    return formaPagto; // Retorna null se não encontrar a forma de pagamento
}


}
