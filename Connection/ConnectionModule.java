package modulovendas.Connection;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionModule {
    private final static String DRIVER = "org.postgresql.Driver";
    private final static String BANCO = "jdbc:postgresql://localhost:5432/Compra";
    private final static String USUARIO = "postgres";
    private final static String SENHA = "unip";
    private static java.sql.Connection conexao;
    private Statement stm;

    public ConnectionModule() {
        try {
            conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA); //cria conexão
            stm = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); // configura o Statement
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco. \n" + ex.getMessage());
        }
    }

    public static java.sql.Connection getConexao() {
        return conexao;
    }

    public static void setConexao(java.sql.Connection conexao) {
        ConnectionModule.conexao = conexao;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao fechar conexao.\n" + ex.getMessage());
        }
    }

}
