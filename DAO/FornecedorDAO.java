package modulovendas.DAO;

import modulovendas.Connection.ConnectionModule;
import modulovendas.Models.ClienteModel;
import modulovendas.Models.FornecedorModel;

import java.sql.*;

public class FornecedorDAO {
    private Connection connectionModule;
    public FornecedorDAO() {
        this.connectionModule = new ConnectionModule().connect();
    }

    public void adicionar(FornecedorModel fornecedorModel) throws SQLException {
        String sqlPessoa = "INSERT INTO pessoa (PES_NOME, PES_FANTASIA, PES_FISICA, PES_CPFCNPJ, PES_RGIE, PES_CADASTRO, PES_ENDERECO, PES_NUMERO, PES_COMPLEMENTO, PES_BAIRRO, PES_CIDADE, PES_UF, PES_CEP, PES_FONE1, PES_FONE2, PES_CELULAR, PES_SITE, PES_EMAIL, PES_ATIVO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Prepare the statement for the "pessoa" table
        PreparedStatement stmPessoa = this.connectionModule.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);

        // Set values for the "pessoa" table
        stmPessoa.setString(1, fornecedorModel.getPesNome().replace("\u0000", ""));
        stmPessoa.setString(2, fornecedorModel.getPesFantasia().replace("\u0000", ""));
        stmPessoa.setString(3, String.valueOf(fornecedorModel.getPesFisica()).replace("\u0000", ""));
        stmPessoa.setString(4, fornecedorModel.getPesCpfCnpj().replace("\u0000", ""));
        stmPessoa.setString(5, fornecedorModel.getPesRgIe().replace("\u0000", ""));
        stmPessoa.setDate(6, java.sql.Date.valueOf(fornecedorModel.getPesCadastro()));
        stmPessoa.setString(7, fornecedorModel.getPesEndereco().replace("\u0000", ""));
        stmPessoa.setString(8, fornecedorModel.getPesNumero().replace("\u0000", ""));
        stmPessoa.setString(9, fornecedorModel.getPesComplemento().replace("\u0000", ""));
        stmPessoa.setString(10, fornecedorModel.getPesBairro().replace("\u0000", ""));
        stmPessoa.setString(11, fornecedorModel.getPesCidade().replace("\u0000", ""));
        stmPessoa.setString(12, fornecedorModel.getPesUf().replace("\u0000", ""));
        stmPessoa.setString(13, fornecedorModel.getPesCep().replace("\u0000", ""));
        stmPessoa.setString(14, fornecedorModel.getPesFone1().replace("\u0000", ""));
        stmPessoa.setString(15, fornecedorModel.getPesFone2().replace("\u0000", ""));
        stmPessoa.setString(16, fornecedorModel.getPesCelular().replace("\u0000", ""));
        stmPessoa.setString(17, fornecedorModel.getPesSite().replace("\u0000", ""));
        stmPessoa.setString(18, fornecedorModel.getPesEmail().replace("\u0000", ""));
        stmPessoa.setString(19, String.valueOf(fornecedorModel.getPesAtivo()).replace("\u0000", ""));

        // Nunca escrevi codigo tão feio em minha vida,mas a beleza é subjetiva no fim do dia
        int affectedRows = stmPessoa.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Inserting into pessoa failed, no rows affected.");
        }

        try (ResultSet generatedKeys = stmPessoa.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int pesCodigo = generatedKeys.getInt(1); // Retrieve the generated key

                String sqlCliente = "INSERT INTO fornecedor (PES_CODIGO, FOR_CONTATO)\n" +
                        "VALUES\n" +
                        "(?,?)";
                PreparedStatement stmFornecedor = this.connectionModule.prepareStatement(sqlCliente);
                stmFornecedor.setInt(1, pesCodigo); // Set the generated pesCodigo
                stmFornecedor.setString(2, fornecedorModel.getFor_contato());
                stmFornecedor.execute();
                stmFornecedor.close();
            } else {
                throw new SQLException("Creating cliente failed, no ID obtained.");
            }
        }

        stmPessoa.close();
    }

    public void atualizar(FornecedorModel fornecedorModel, Integer id) throws SQLException {
        // Verificar se os campos obrigatórios possuem valores válidos antes de atualizar
        if (fornecedorModel.getPesNome() == null || fornecedorModel.getPesFantasia() == null ||
                fornecedorModel.getPesCpfCnpj() == null || fornecedorModel.getPesEndereco() == null ||
                fornecedorModel.getPesNumero() == null || fornecedorModel.getPesBairro() == null ||
                fornecedorModel.getPesCidade() == null || fornecedorModel.getPesUf() == null ||
                fornecedorModel.getPesCep() == null || fornecedorModel.getPesFone1() == null ||
                fornecedorModel.getPesEmail() == null || fornecedorModel.getFor_contato() == null) {

            // Abortar a atualização se algum campo obrigatório estiver ausente
            System.out.println("Atualização abortada: Um ou mais campos obrigatórios estão ausentes.");
            return;
        }

        // SQL para atualizar a tabela pessoa
        String sqlPessoa = "UPDATE pessoa SET " +
                "PES_NOME = ?, PES_FANTASIA = ?, PES_CPFCNPJ = ?, PES_ENDERECO = ?, " +
                "PES_NUMERO = ?, PES_BAIRRO = ?, PES_CIDADE = ?, PES_UF = ?, PES_CEP = ?, " +
                "PES_FONE1 = ?, PES_EMAIL = ? WHERE PES_CODIGO = ?";

        // SQL para atualizar a tabela fornecedor
        String sqlFornecedor = "UPDATE fornecedor SET FOR_CONTATO = ? WHERE PES_CODIGO = ?;";

        try (PreparedStatement stmPessoa = this.connectionModule.prepareStatement(sqlPessoa);
             PreparedStatement stmFornecedor = this.connectionModule.prepareStatement(sqlFornecedor)) {

            // Setar os valores para a tabela pessoa
            stmPessoa.setString(1, fornecedorModel.getPesNome().replace("\u0000", ""));
            stmPessoa.setString(2, fornecedorModel.getPesFantasia().replace("\u0000", ""));
            stmPessoa.setString(3, fornecedorModel.getPesCpfCnpj().replace("\u0000", ""));
            stmPessoa.setString(4, fornecedorModel.getPesEndereco().replace("\u0000", ""));
            stmPessoa.setString(5, fornecedorModel.getPesNumero().replace("\u0000", ""));
            stmPessoa.setString(6, fornecedorModel.getPesBairro().replace("\u0000", ""));
            stmPessoa.setString(7, fornecedorModel.getPesCidade().replace("\u0000", ""));
            stmPessoa.setString(8, fornecedorModel.getPesUf().replace("\u0000", ""));
            stmPessoa.setString(9, fornecedorModel.getPesCep().replace("\u0000", ""));
            stmPessoa.setString(10, fornecedorModel.getPesFone1().replace("\u0000", ""));
            stmPessoa.setString(11, fornecedorModel.getPesEmail().replace("\u0000", ""));
            stmPessoa.setInt(12, id); // PES_CODIGO para o WHERE

            // Executar a atualização da tabela pessoa
            int affectedRowsPessoa = stmPessoa.executeUpdate();

            // Setar os valores para a tabela fornecedor
            stmFornecedor.setString(1, fornecedorModel.getFor_contato());
            stmFornecedor.setInt(2, id); // PES_CODIGO para o WHERE

            // Executar a atualização da tabela fornecedor
            int affectedRowsFornecedor = stmFornecedor.executeUpdate();

            // Verificar se as atualizações foram bem-sucedidas
            if (affectedRowsPessoa > 0 && affectedRowsFornecedor > 0) {
                System.out.println("Atualização bem-sucedida.");
            } else {
                System.out.println("Nenhum registro foi atualizado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar registro: " + e.getMessage());

        }
    }

    public void exluir(Integer id) throws SQLException {

        String sql1 = "DELETE FROM fornecedor WHERE PES_CODIGO = ?";
        String sql2 = "DELETE FROM pessoa WHERE PES_CODIGO = ?";
        try (PreparedStatement pstmt1 = connectionModule.prepareStatement(sql1)) {
            pstmt1.setInt(1, id);
            int affectedRows1 = pstmt1.executeUpdate();

            if (affectedRows1 > 0) {
                System.out.println("Delete from fornecedor successful.");
            } else {
                System.out.println("No records deleted from fornecedor.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting from cliente: " + e.getMessage());
        }
        try (PreparedStatement pstmt2 = connectionModule.prepareStatement(sql2)) {
            pstmt2.setInt(1, id);
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


}
