package modulovendas.Controllers;

import modulovendas.DAO.CompraDAO;
import modulovendas.Models.CompraModel;

import java.sql.SQLException;

public class CompraController {
    private CompraDAO compraDAO;

    public CompraController() {
        this.compraDAO = new CompraDAO();
    }

    public void cadastrarCompra (CompraModel compraModel) {
        try {
            this.compraDAO.addCompra(compraModel);
            System.out.println("Fooooii");
        } catch (SQLException e) {
            System.out.println("Erro para cadastrar compra");
            throw new RuntimeException(e);
        }

    }

    public void atualizarCompra (CompraModel compraModel) {
        try {
            this.compraDAO.updateCompra(compraModel);
            System.out.println("Compra cadastrada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deletarCompra (Integer id) {
        try {
            this.compraDAO.deleteCompra(id);
            System.out.println("Compra deletada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
