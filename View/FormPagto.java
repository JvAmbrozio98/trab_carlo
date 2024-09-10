package modulovendas;

import javax.swing.*;

public class FormPagto extends JPanel {

    private JLabel lblId, lblFormaPagto, lblAtivo;

    private JTextField tfId, tfFormaPagto;

    private JComboBox cbAtivo;

    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;
    
    String[] ativo = { "Ativo", "Não Ativo" };

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
        lblAtivo = new JLabel("Ativo");

        // TextFields
        tfId = new JTextField();
        tfFormaPagto = new JTextField();

        // ComboBoxes
        cbAtivo = new JComboBox(ativo);

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
        add(lblAtivo);

        // Adiciona TextFields
        add(tfId);
        add(tfFormaPagto);

        // Adiciona ComboBoxes
        add(cbAtivo);

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
        lblAtivo.setBounds(200, 300, 150, 25);

        // Posiciona TextFields
        tfId.setBounds(400, 220, 300, 25);
        tfFormaPagto.setBounds(400, 260, 300, 25);

        // Posiciona ComboBoxes
        cbAtivo.setBounds(200, 330, 120, 25);

        // Posiciona Buttons
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);
    }
}
