package modulovendas.Main;

import modulovendas.Login;

public class Main {
    public static void main(String[] args) {
        // Executa a aplicação na thread de despacho de eventos do Swing
        javax.swing.SwingUtilities.invokeLater(() -> new Login());
    }
}                                       