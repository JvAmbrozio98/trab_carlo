package modulovendas;

import javax.swing.*;

public class FormPagto extends JPanel {

    private JLabel lblId, lblFormaPagto;
    
    private JTextField tfId, tfFormaPagto;
    
    private JCheckBox chbAtivo;
    
    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;
    
    public FormPagto() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts

        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
    }

    public void instanciar() {

        // Labels
        lblId = new JLabel("ID");
        lblFormaPagto = new JLabel("Forma de Pagamento");
        
        // TextFields
        tfId = new JTextField();
        tfFormaPagto = new JTextField();
        
        // CheckBoxes

        chbAtivo = new JCheckBox("Ativo");
        
        // Buttons
        btnIncluir = new JButton("Incluir");
        btnAlterar = new JButton("Alterar");
        btnConsultar = new JButton("Consultar");
        btnExcluir = new JButton("Excluir");

    }

    public void adicionar() {

        // Adiciona Labels
        add(lblId);
        add(lblFormaPagto);
        
        // Adiciona TextFields
        add(tfId);
        add(tfFormaPagto);
        
        // Adiciona CheckBoxes
        add(chbAtivo);

        // Add Buttons
        add(btnIncluir);
        add(btnAlterar);
        add(btnConsultar);
        add(btnExcluir);

    }

    public void posicionar() {

        // Posiciona Labels
        lblId.setBounds(200, 220, 90, 25);
        lblFormaPagto.setBounds(200, 260, 150, 25);

        // Posiciona TextFields
        tfId.setBounds(400, 220, 300, 25);
        tfFormaPagto.setBounds(400, 260, 300, 25);

        // Posiciona CheckBoxes
        chbAtivo.setBounds(200, 320, 120, 25);

        // Posiciona Buttons
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);
    }
}
