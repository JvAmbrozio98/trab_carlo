package modulovendas.Controllers;

import modulovendas.DAO.CompraDAO;
import modulovendas.Models.CompraModel;

import java.sql.SQLException;

public class CompraController {
    private CompraDAO compraDAO;

    public CompraController() {
        this.compraDAO = new CompraDAO();
    }

    public int cadastrarCompra(CompraModel compraModel) {
        try {
            // Capture the generated key from addCompra
            int generatedId = this.compraDAO.addCompra(compraModel);

            // Log the generated key
            System.out.println("Compra cadastrada com sucesso. ID gerado: " + generatedId);

            // Return the generated key
            return generatedId;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar compra.");
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
