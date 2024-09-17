package modulovendas.DAO;

import modulovendas.Models.ClienteModel;
import modulovendas.Connection.ConnectionModule;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connectionModule;

    public ClienteDAO() {
        this.connectionModule = new ConnectionModule().connect();
    }

    public void adicionar(ClienteModel clienteModel) throws SQLException {
        String sqlPessoa = "INSERT INTO pessoa (PES_NOME, PES_FANTASIA, PES_FISICA, PES_CPFCNPJ, PES_RGIE, PES_CADASTRO, PES_ENDERECO, PES_NUMERO, PES_COMPLEMENTO, PES_BAIRRO, PES_CIDADE, PES_UF, PES_CEP, PES_FONE1, PES_FONE2, PES_CELULAR, PES_SITE, PES_EMAIL, PES_ATIVO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Prepare the statement for the "pessoa" table
        PreparedStatement stmPessoa = this.connectionModule.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);

        // Set values for the "pessoa" table
        stmPessoa.setString(1, clienteModel.getPesNome().replace("\u0000", ""));
        stmPessoa.setString(2, clienteModel.getPesFantasia().replace("\u0000", ""));
        stmPessoa.setString(3, String.valueOf(clienteModel.getPesFisica()).replace("\u0000", ""));
        stmPessoa.setString(4, clienteModel.getPesCpfCnpj().replace("\u0000", ""));
        stmPessoa.setString(5, clienteModel.getPesRgIe().replace("\u0000", ""));
        stmPessoa.setDate(6, java.sql.Date.valueOf(clienteModel.getPesCadastro()));
        stmPessoa.setString(7, clienteModel.getPesEndereco().replace("\u0000", ""));
        stmPessoa.setString(8, clienteModel.getPesNumero().replace("\u0000", ""));
        stmPessoa.setString(9, clienteModel.getPesComplemento().replace("\u0000", ""));
        stmPessoa.setString(10, clienteModel.getPesBairro().replace("\u0000", ""));
        stmPessoa.setString(11, clienteModel.getPesCidade().replace("\u0000", ""));
        stmPessoa.setString(12, clienteModel.getPesUf().replace("\u0000", ""));
        stmPessoa.setString(13, clienteModel.getPesCep().replace("\u0000", ""));
        stmPessoa.setString(14, clienteModel.getPesFone1().replace("\u0000", ""));
        stmPessoa.setString(15, clienteModel.getPesFone2().replace("\u0000", ""));
        stmPessoa.setString(16, clienteModel.getPesCelular().replace("\u0000", ""));
        stmPessoa.setString(17, clienteModel.getPesSite().replace("\u0000", ""));
        stmPessoa.setString(18, clienteModel.getPesEmail().replace("\u0000", ""));
        stmPessoa.setString(19, String.valueOf(clienteModel.getPesAtivo()).replace("\u0000", ""));

        // Nunca escrevi codigo tão feio em minha vida,mas a beleza é subjetiva no fim do dia
        int affectedRows = stmPessoa.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Inserting into pessoa failed, no rows affected.");
        }

        try (ResultSet generatedKeys = stmPessoa.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int pesCodigo = generatedKeys.getInt(1); // Retrieve the generated key

                // Now insert into the "cliente" table using the retrieved pesCodigo
                String sqlCliente = "INSERT INTO cliente (PES_CODIGO, CLI_LIMITECRED) VALUES (?, ?)";
                PreparedStatement stmCliente = this.connectionModule.prepareStatement(sqlCliente);
                stmCliente.setInt(1, pesCodigo); // Set the generated pesCodigo
                stmCliente.setBigDecimal(2, clienteModel.getCliLimiteCred());
                stmCliente.execute();
                stmCliente.close();
            } else {
                throw new SQLException("Creating cliente failed, no ID obtained.");
            }
        }

        stmPessoa.close();
    }

    public void exluir(Integer id) throws SQLException {

        String sql1 = "DELETE FROM cliente WHERE PES_CODIGO = ?";
        String sql2 = "DELETE FROM pessoa WHERE PES_CODIGO = ?";

        // Delete from cliente
        try (PreparedStatement pstmt1 = connectionModule.prepareStatement(sql1)) {
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

        // Delete from pessoa
        try (PreparedStatement pstmt2 = connectionModule.prepareStatement(sql2)) {
            pstmt2.setInt(1, id); // Set the value for the placeholder
            int affectedRows2 = pstmt2.executeUpdate();

            if (affectedRows2 > 0) {
                System.out.println("Delete from pessoa successful.");
            } else {
                System.out.println("No records deleted from pessoa.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting from pessoa: " + e.getMessage());
        }
    }

    public ClienteModel consultar(int id) throws SQLException {
        // Consulta SQL para buscar os dados do cliente com base no ID
        String sql = "SELECT p.*, c.CLI_LIMITECRED " +
                     "FROM pessoa p " +
                     "JOIN cliente c ON p.PES_CODIGO = c.PES_CODIGO " +
                     "WHERE p.PES_CODIGO = ?";
    
        // Cria um PreparedStatement para a consulta
        try (PreparedStatement pstmt = connectionModule.prepareStatement(sql)) {
            pstmt.setInt(1, id); // Define o valor do ID na consulta
            
            // Executa a consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Cria um objeto ClienteModel e define seus atributos com os valores obtidos
                    ClienteModel cliente = new ClienteModel();
                    cliente.setPesCodigo(rs.getInt("PES_CODIGO"));
                    cliente.setPesNome(rs.getString("PES_NOME"));
                    cliente.setPesFantasia(rs.getString("PES_FANTASIA"));
                    cliente.setPesFisica(rs.getChar("PES_FISICA"));
                    cliente.setPesCpfCnpj(rs.getString("PES_CPFCNPJ"));
                    cliente.setPesRgIe(rs.getString("PES_RGIE"));
                    cliente.setPesCadastro(rs.getDate("PES_CADASTRO").toLocalDate());
                    cliente.setPesEndereco(rs.getString("PES_ENDERECO"));
                    cliente.setPesNumero(rs.getString("PES_NUMERO"));
                    cliente.setPesComplemento(rs.getString("PES_COMPLEMENTO"));
                    cliente.setPesBairro(rs.getString("PES_BAIRRO"));
                    cliente.setPesCidade(rs.getString("PES_CIDADE"));
                    cliente.setPesUf(rs.getString("PES_UF"));
                    cliente.setPesCep(rs.getString("PES_CEP"));
                    cliente.setPesFone1(rs.getString("PES_FONE1"));
                    cliente.setPesFone2(rs.getString("PES_FONE2"));
                    cliente.setPesCelular(rs.getString("PES_CELULAR"));
                    cliente.setPesSite(rs.getString("PES_SITE"));
                    cliente.setPesEmail(rs.getString("PES_EMAIL"));
                    cliente.setPesAtivo(rs.getChar("PES_ATIVO"));
                    cliente.setCliLimiteCred(rs.getInt("CLI_LIMITECRED"));
                    
                    return cliente;
                } else {
                    throw new SQLException("Cliente com ID " + id + " não encontrado.");
                }
            }
        }
    }
    

    public void atualizar(ClienteModel clienteModel, Integer id) throws SQLException {
        // Ensure all fields (except PES_CODIGO) have valid values before updating
        if (clienteModel.getPesNome() == null || clienteModel.getPesFantasia() == null ||
                clienteModel.getPesCpfCnpj() == null || clienteModel.getPesEndereco() == null ||
                clienteModel.getPesNumero() == null || clienteModel.getPesBairro() == null ||
                clienteModel.getPesCidade() == null || clienteModel.getPesUf() == null ||
                clienteModel.getPesCep() == null || clienteModel.getPesFone1() == null ||
                clienteModel.getPesEmail() == null || clienteModel.getCliLimiteCred() == null) {

            // Abort update if any required field is null
            System.out.println("Update aborted: One or more required fields are missing.");
            return;
        }

        // SQL query to update pessoa table
        String sqlPessoa = "UPDATE pessoa SET " +
                "PES_NOME = ?, PES_FANTASIA = ?, PES_CPFCNPJ = ?, PES_ENDERECO = ?, " +
                "PES_NUMERO = ?, PES_BAIRRO = ?, PES_CIDADE = ?, PES_UF = ?, PES_CEP = ?, " +
                "PES_FONE1 = ?, PES_EMAIL = ? WHERE PES_CODIGO = ?";

        // SQL query to update cliente table
        String sqlCliente = "UPDATE cliente SET " +
                "CLI_LIMITECRED = ? WHERE PES_CODIGO = ?";

        try (PreparedStatement stmPessoa = this.connectionModule.prepareStatement(sqlPessoa);
             PreparedStatement stmCliente = this.connectionModule.prepareStatement(sqlCliente)) {

            // Set values for the pessoa table
            stmPessoa.setString(1, clienteModel.getPesNome().replace("\u0000", ""));
            stmPessoa.setString(2, clienteModel.getPesFantasia().replace("\u0000", ""));
            stmPessoa.setString(3, clienteModel.getPesCpfCnpj().replace("\u0000", ""));
            stmPessoa.setString(4, clienteModel.getPesEndereco().replace("\u0000", ""));
            stmPessoa.setString(5, clienteModel.getPesNumero().replace("\u0000", ""));
            stmPessoa.setString(6, clienteModel.getPesBairro().replace("\u0000", ""));
            stmPessoa.setString(7, clienteModel.getPesCidade().replace("\u0000", ""));
            stmPessoa.setString(8, clienteModel.getPesUf().replace("\u0000", ""));
            stmPessoa.setString(9, clienteModel.getPesCep().replace("\u0000", ""));
            stmPessoa.setString(10, clienteModel.getPesFone1().replace("\u0000", ""));
            stmPessoa.setString(11, clienteModel.getPesEmail().replace("\u0000", ""));
            stmPessoa.setInt(12, id); // PES_CODIGO for WHERE clause

            // Execute update for pessoa
            int affectedRowsPessoa = stmPessoa.executeUpdate();

            // Set values for the cliente table
            stmCliente.setBigDecimal(1, clienteModel.getCliLimiteCred());
            stmCliente.setInt(2, id); // PES_CODIGO for WHERE clause

            // Execute update for cliente
            int affectedRowsCliente = stmCliente.executeUpdate();

            // Check if both updates were successful
            if (affectedRowsPessoa > 0 && affectedRowsCliente > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("No records updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }
    }




}



