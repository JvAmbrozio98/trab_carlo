package modulovendas.DAO;

import modulovendas.Connection.ConnectionModule;
import modulovendas.Models.ProdutoModel;

import java.sql.*;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO() {
        this.connection = new ConnectionModule().connect();
    }

    public void adcionar(ProdutoModel produtoModel) throws SQLException {
        String sql = "INSERT INTO produto (PRO_NOME, PRO_ESTOQUE, PRO_UNIDADE, PRO_PRECO, PRO_CUSTO, PRO_ATACADO, PRO_MIN, PRO_MAX, PRO_EMBALAGEM, PRO_PESO, PRO_CADASTRO, PRO_OBS, PRO_ATIVO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Setando os valores de acordo com os tipos corretos
            stmt.setString(1,produtoModel.getProNome()); // PRO_NOME
            stmt.setBigDecimal(2,produtoModel.getProEstoque()); // PRO_ESTOQUE
            stmt.setString(3,produtoModel.getProUnidade()); // PRO_UNIDADE
            stmt.setBigDecimal(4,produtoModel.getProPreco()); // PRO_PRECO
            stmt.setBigDecimal(5,produtoModel.getProCusto() ); // PRO_CUSTO
            stmt.setBigDecimal(6,produtoModel.getProAtacado()); // PRO_ATACADO
            stmt.setBigDecimal(7,produtoModel.getProMin()); // PRO_MIN
            stmt.setBigDecimal(8,produtoModel.getProMax()); // PRO_MAX
            stmt.setBigDecimal(9,produtoModel.getProEmbalagem()); // PRO_EMBALAGEM
            stmt.setBigDecimal(10,produtoModel.getProPeso()); // PRO_PESO
            stmt.setDate(11,Date.valueOf(produtoModel.getProCadastro())); // PRO_CADASTRO
            stmt.setString(12,produtoModel.getProObs() ); // PRO_OBS (pode ser Clob dependendo do seu banco)
            stmt.setString(13,String.valueOf(produtoModel.getProAtivo())); // PRO_ATIVO

            // Executando a inserção
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                // Recuperando o ID gerado
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1); // O ID gerado está na primeira coluna
                        System.out.println("Produto inserido com sucesso! ID gerado: " + id);
                    } else {
                        System.out.println("Nenhum ID gerado.");
                    }
                }
            } else {
                System.out.println("Nenhum produto foi inserido.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir o produto: " + e.getMessage());
        }
    }

    public void excluirProduto(Integer id) throws SQLException {
        String sql = "DELETE FROM produto\n" + "WHERE PRO_CODIGO = ?;";
        try (PreparedStatement pstmt1 = connection.prepareStatement(sql)) {
            pstmt1.setInt(1, id); // Set the value for the placeholder
            int affectedRows1 = pstmt1.executeUpdate();

            if (affectedRows1 > 0) {
                System.out.println("Delete from produto successful.");
            } else {
                System.out.println("No records deleted from produto.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting from cliente: " + e.getMessage());
        }
    }

    public void atualizar(ProdutoModel produtoModel, Integer id) throws SQLException {
        // Verifica se todos os campos obrigatórios estão preenchidos antes de atualizar
        if (produtoModel.getProNome() == null || produtoModel.getProEstoque() == null ||
                produtoModel.getProUnidade() == null || produtoModel.getProPreco() == null ||
                produtoModel.getProCusto() == null || produtoModel.getProAtacado() == null ||
                produtoModel.getProMin() == null || produtoModel.getProMax() == null ||
                produtoModel.getProEmbalagem() == null || produtoModel.getProPeso() == null ||
                produtoModel.getProCadastro() == null || produtoModel.getProObs() == null ||
                produtoModel.getProAtivo() == '\u0000') {

            // Aborta a atualização se qualquer campo obrigatório estiver ausente
            System.out.println("Atualização abortada: Um ou mais campos obrigatórios estão faltando.");
            return;
        }

        // SQL query para atualizar a tabela produto
        String sqlProduto = "UPDATE produto SET " +
                "PRO_NOME = ?, PRO_ESTOQUE = ?, PRO_UNIDADE = ?, PRO_PRECO = ?, " +
                "PRO_CUSTO = ?, PRO_ATACADO = ?, PRO_MIN = ?, PRO_MAX = ?, " +
                "PRO_EMBALAGEM = ?, PRO_PESO = ?, PRO_CADASTRO = ?, PRO_OBS = ?, PRO_ATIVO = ? " +
                "WHERE PRO_CODIGO = ?";

        try (PreparedStatement stmt = this.connection.prepareStatement(sqlProduto)) {

            // Setando os valores para a tabela produto
            stmt.setString(1, produtoModel.getProNome()); // PRO_NOME
            stmt.setBigDecimal(2, produtoModel.getProEstoque()); // PRO_ESTOQUE
            stmt.setString(3, produtoModel.getProUnidade()); // PRO_UNIDADE
            stmt.setBigDecimal(4, produtoModel.getProPreco()); // PRO_PRECO
            stmt.setBigDecimal(5, produtoModel.getProCusto()); // PRO_CUSTO
            stmt.setBigDecimal(6, produtoModel.getProAtacado()); // PRO_ATACADO
            stmt.setBigDecimal(7, produtoModel.getProMin()); // PRO_MIN
            stmt.setBigDecimal(8, produtoModel.getProMax()); // PRO_MAX
            stmt.setBigDecimal(9, produtoModel.getProEmbalagem()); // PRO_EMBALAGEM
            stmt.setBigDecimal(10, produtoModel.getProPeso()); // PRO_PESO
            stmt.setDate(11, Date.valueOf(produtoModel.getProCadastro())); // PRO_CADASTRO
            stmt.setString(12, produtoModel.getProObs()); // PRO_OBS
            stmt.setString(13, String.valueOf(produtoModel.getProAtivo())); // PRO_ATIVO
            stmt.setInt(14, id); // PRO_CODIGO para a cláusula WHERE

            // Executa a atualização na tabela produto
            int affectedRows = stmt.executeUpdate();

            // Verifica se a atualização foi bem-sucedida
            if (affectedRows > 0) {
                System.out.println("Atualização de produto realizada com sucesso.");
            } else {
                System.out.println("Nenhum registro foi atualizado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
        }
    }


}

