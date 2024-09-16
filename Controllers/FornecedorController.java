package modulovendas.Controllers;

import modulovendas.DAO.FornecedorDAO;
import modulovendas.Models.ClienteModel;
import modulovendas.Models.FornecedorModel;

import java.sql.SQLException;

public class FornecedorController {
    private FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    public void cadastrarFornecedor (FornecedorModel fornecedorModel) throws SQLException {
        try {
            this.fornecedorDAO.adicionar(fornecedorModel);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
