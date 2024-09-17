package modulovendas.Controllers;

import modulovendas.Models.ClienteModel;
import modulovendas.DAO.ClienteDAO;

import java.sql.SQLException;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrarCliente (ClienteModel clienteModel) throws SQLException {
        try {
            this.clienteDAO.adicionar(clienteModel);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ClienteModel consultarCliente(int id) {
        try {
            return clienteDAO.consultar(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void excluirCliente (Integer id) throws  SQLException {
        try {
            this.clienteDAO.exluir(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    };

    public void atualizarCliente (ClienteModel clienteModel,Integer id) throws SQLException  {
        try {
            this.clienteDAO.atualizar(clienteModel,id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
