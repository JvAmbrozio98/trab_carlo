package modulovendas.Controllers;

import modulovendas.DAO.UsuarioDAO;
import modulovendas.Models.UsuarioModel;

import java.sql.SQLException;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    public UsuarioController () {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario (UsuarioModel usuarioModel) {
        try {
            this.usuarioDAO.adicionar(usuarioModel);
        } catch (SQLException e) {
            System.out.println("Deu merda isso");
            throw new RuntimeException(e);
        }
    }

    public void excluirUsuario (Integer id) {
        try {
            System.out.println("Deu certo a exclusão");
            this.usuarioDAO.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarUsuario (Integer id,UsuarioModel usuarioModel) {
        try {
            System.out.println("Deu certo alteração");
            this.usuarioDAO.atualizar(usuarioModel,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
