package modulovendas.Controllers;

import modulovendas.DAO.VendaDAO;
import modulovendas.Models.VendaModels;

import java.sql.SQLException;

public class VendaController {
    private VendaDAO vendaDAO;

    public VendaController() {
        this.vendaDAO = new VendaDAO();
    }

    public void cadastrarVenda (VendaModels venda) {
        try {
            this.vendaDAO.adicionarVenda(venda);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deletarVenda (Long id) {
        try {
            this.vendaDAO.deletarVenda(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void atualizarVenda (Integer id,VendaModels vendaModels) {
        try {
            this.vendaDAO.atualizarVenda(id,vendaModels);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
