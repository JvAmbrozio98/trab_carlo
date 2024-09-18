package modulovendas.Controllers;

import modulovendas.DAO.CompraProdutoDAO;
import modulovendas.Models.CompraProdutoModel;

import java.sql.SQLException;

public class CompraProdutoController {
    private CompraProdutoDAO compraProdutoDAO;

    public CompraProdutoController() {
        this.compraProdutoDAO = new CompraProdutoDAO();
    }

    public void cadastraProdutoEmCompra(CompraProdutoModel produto) throws SQLException {
        compraProdutoDAO.inserir(produto);
    };
}
