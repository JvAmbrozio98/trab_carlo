package modulovendas.Controllers;

import modulovendas.DAO.ProdutoDAO;
import modulovendas.Models.ProdutoModel;
import modulovendas.Produto;

import java.sql.SQLException;

public class ProdutoControllers {
    private ProdutoDAO produtoDAO;
    public ProdutoControllers() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void cadastrarProduto (ProdutoModel produtoModel) throws SQLException {
        try {
            this.produtoDAO.adcionar(produtoModel);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void  excluirProduto (Integer id) throws SQLException {
        try {
            this.produtoDAO.excluirProduto(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizarProduto (ProdutoModel produtoModel,Integer id) throws SQLException {
        try {
            this.produtoDAO.atualizar(produtoModel,id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    };


}
