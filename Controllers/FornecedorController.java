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

    public void excluirFornecedor (Integer id) {
        try {
            fornecedorDAO.exluir(id);
            System.out.println("Deu certo");
        } catch (SQLException e) {
            System.out.println("Excluiu isso");
            throw new RuntimeException(e);
        }
    }

    public void alterarFornecedor (FornecedorModel fornecedorModel,Integer id) {
        try {
            fornecedorDAO.atualizar(fornecedorModel,id);
        } catch (SQLException e) {
            System.out.println("Deu merda aqui");
            throw new RuntimeException(e);
        }
    }
}
