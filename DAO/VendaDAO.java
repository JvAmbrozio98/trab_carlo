package modulovendas.DAO;

import modulovendas.Connection.ConnectionModule;
import modulovendas.Models.VendaModels;

import java.sql.*;

public class VendaDAO {
    private Connection connectionModule;

    // Construtor que recebe a conexão com o banco de dados
    public VendaDAO() {
        this.connectionModule = this.connectionModule = new ConnectionModule().connect();
    }

    // Método para inserir uma nova venda no banco de dados
    public void adicionarVenda(VendaModels venda) throws SQLException {
        String sql = "INSERT INTO VENDA (USU_CODIGO, CLI_CODIGO, VDA_DATA, VDA_VALOR, VDA_DESCONTO, VDA_TOTAL, VDA_OBS) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Prepare the statement to return generated keys
        try (PreparedStatement pstmt = connectionModule.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, venda.getUsuCodigo());
            pstmt.setInt(2, venda.getCliCodigo());
            pstmt.setDate(3, Date.valueOf(venda.getVdaData())); // Ensure venda.vdaData is LocalDate
            pstmt.setBigDecimal(4, venda.getVdaValor());
            pstmt.setBigDecimal(5, venda.getVdaDesconto());
            pstmt.setBigDecimal(6, venda.getVdaTotal());
            pstmt.setString(7, venda.getVdaObs());

            pstmt.executeUpdate();

            // Retrieve the generated key
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    Long generatedKey = rs.getLong(1);
                    System.out.println("Venda adicionada com sucesso. ID gerado: " + generatedKey);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar venda: " + e.getMessage());
            throw e;
        }
    }


    // Método para atualizar uma venda existente no banco de dados
    public void atualizarVenda(Integer id,VendaModels venda) throws SQLException {
        String sql = "UPDATE VENDA SET USU_CODIGO = ?, CLI_CODIGO = ?, VDA_DATA = ?, VDA_VALOR = ?, VDA_DESCONTO = ?, VDA_TOTAL = ?, VDA_OBS = ? " +
                "WHERE VDA_CODIGO = ?";

        try (PreparedStatement pstmt = connectionModule.prepareStatement(sql)) {
            pstmt.setInt(1, venda.usuCodigo);
            pstmt.setInt(2, venda.cliCodigo);
            pstmt.setDate(3, Date.valueOf(venda.vdaData));
            pstmt.setBigDecimal(4, venda.vdaValor);
            pstmt.setBigDecimal(5, venda.vdaDesconto);
            pstmt.setBigDecimal(6, venda.vdaTotal);
            pstmt.setString(7, venda.vdaObs);
            pstmt.setLong(8, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Venda atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma venda encontrada com o código informado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar venda: " + e.getMessage());
            throw e;
        }
    }


    // Método para deletar uma venda no banco de dados
    public void deletarVenda(long vdaCodigo) throws SQLException {
        String sql = "DELETE FROM VENDA WHERE VDA_CODIGO = ?";

        try (PreparedStatement pstmt = connectionModule.prepareStatement(sql)) {
            pstmt.setLong(1, vdaCodigo);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Venda deletada com sucesso.");
            } else {
                System.out.println("Nenhuma venda encontrada com o código informado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar venda: " + e.getMessage());
            throw e;
        }
    }


    // Método para buscar uma venda pelo código


    // Método para listar todas as vendas

}
