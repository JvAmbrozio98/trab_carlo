package modulovendas.DAO;

import modulovendas.Connection.ConnectionModule;
import modulovendas.Models.UsuarioModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connectionModule;
    public UsuarioDAO() {
        this.connectionModule = new ConnectionModule().connect();
    }

    public void adicionar(UsuarioModel usuarioModel) throws SQLException {
        String sql = "INSERT INTO usuario (USU_NOME, USU_LOGIN, USU_SENHA, USU_CADASTRO, USU_ATIVO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connectionModule.prepareStatement(sql)) {
            pstmt.setString(1, usuarioModel.getUsuNome()); // Set USU_NOME
            pstmt.setString(2, usuarioModel.getUsuLogin()); // Set USU_LOGIN
            pstmt.setString(3, usuarioModel.getUsuSenha()); // Set USU_SENHA
            pstmt.setDate(4, java.sql.Date.valueOf(usuarioModel.getUsuCadastro())); // Set USU_CADASTRO (assuming it's a Timestamp)
            pstmt.setString(5, String.valueOf(usuarioModel.getUsuAtivo())); // Set USU_ATIVO (assuming it's a boolean)

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("User added successfully.");
            } else {
                System.out.println("No rows affected. User might not be added.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
            throw e; // Rethrow exception after logging
        }
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE USU_CODIGO = ?";

        try (PreparedStatement pstmt = connectionModule.prepareStatement(sql)) {
            pstmt.setInt(1, id); // Set USU_CODIGO

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No user found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
            throw e; // Rethrow the exception to propagate it up the stack
        }
    }
    public void atualizar(UsuarioModel usuarioModel, int id) throws SQLException {
        String sql = "UPDATE usuario SET USU_NOME = ?, USU_LOGIN = ?, USU_SENHA = ?, USU_CADASTRO = ?, USU_ATIVO = ? WHERE USU_CODIGO = ?";

        try (PreparedStatement pstmt = connectionModule.prepareStatement(sql)) {
            pstmt.setString(1, usuarioModel.getUsuNome());     // Atualiza USU_NOME
            pstmt.setString(2, usuarioModel.getUsuLogin());    // Atualiza USU_LOGIN
            pstmt.setString(3, usuarioModel.getUsuSenha());    // Atualiza USU_SENHA
            pstmt.setDate(4, java.sql.Date.valueOf(usuarioModel.getUsuCadastro())); // Atualiza USU_CADASTRO (assumindo que seja um Timestamp)
            pstmt.setString(5, String.valueOf(usuarioModel.getUsuAtivo()));    // Atualiza USU_ATIVO (assumindo que seja um boolean)
            pstmt.setInt(6, id);                              // Condição WHERE para o USU_CODIGO, com base no id passado

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
            throw e; // Rethrow the exception to handle it higher up the call stack
        }
    }




}
