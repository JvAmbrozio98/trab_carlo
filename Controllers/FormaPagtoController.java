package modulovendas.Controllers;

import modulovendas.DAO.FormaPagtoDAO;
import modulovendas.FormPagto;
import modulovendas.Models.CompraModel;
import modulovendas.Models.FormaPagtoModel;

import java.sql.SQLException;

public class FormaPagtoController {
    private FormaPagtoDAO formaPagtoDAO;
    public FormaPagtoController () { this.formaPagtoDAO = new FormaPagtoDAO();}

    public void cadastrarFormaPagto (FormaPagtoModel formaPagtoModel) throws SQLException {
        try {
            this.formaPagtoDAO.adcionar(formaPagtoModel);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public FormaPagtoModel consultarPorId(int id) {
        try {
            return FormaPagtoDAO.consultar(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return null;

    }

    public void excluirFormaPagto (Integer id) {
        try {
            this.formaPagtoDAO.excluir(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void atualizarFormaPagto (Integer id, FormaPagtoModel formPagto) {
        try {
            this.formaPagtoDAO.atualizar(formPagto,id);
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }
}
