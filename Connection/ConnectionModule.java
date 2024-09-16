package modulovendas.Connection;

import javax.swing.*;
import java.sql.*;

public class ConnectionModule {
    private final static String DRIVER = "org.postgresql.Driver";
    private final static String BANCO = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USUARIO = "postgres";
    private final static String SENHA = "postgres";
    private  java.sql.Connection conexao;
    private Statement stm;


    public Connection connect() {
        try {
            Class.forName(DRIVER); // Load the PostgreSQL driver
            conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to the database: " + e.getMessage());
        }
        return conexao;
    }


}
