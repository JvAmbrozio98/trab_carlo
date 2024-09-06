package modulovendas;

import javax.swing.*;

public class Venda extends JPanel {

    private JLabel lblId, lblUsu, lblCli, lblData, lblValor, lblDesconto, lblTotal, lblObs,
            lblProdutos, lblFormPagto;

    private JTextField tfId, tfData, tfValor, tfDesconto, tfTotal;

    private JComboBox cbIdUsu, cbIdCli;

    private JTextArea taObs;

    private JScrollPane spObs;

    private JTable tProdutos, tFormpagto;
    
    private JButton btnIncluirP, btnAlterarP, btnExcluirP, btnIncluirF, btnAlterarF, btnExcluirF,
            btnIncluir, btnAlterar, btnConsultar, btnExcluir;

    public Venda() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts

        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
    }

    public void instanciar() {

        // Labels
        lblId = new JLabel("ID Venda");
        lblUsu = new JLabel("Usuário");
        lblCli = new JLabel("Cliente");
        lblData = new JLabel("Data");
        lblValor = new JLabel("Valor");
        lblDesconto = new JLabel("Desconto");
        lblTotal = new JLabel("Total");
        lblObs = new JLabel("Observações"); //Tipo Text no Banco
        lblProdutos = new JLabel("Produtos");
        lblFormPagto = new JLabel("Formas de Pagamento");

        // TextFields
        tfId = new JTextField();
        tfData = new JTextField();
        tfValor = new JTextField();
        tfDesconto = new JTextField();
        tfTotal = new JTextField();

        // ComboBox
        cbIdUsu = new JComboBox();
        cbIdCli = new JComboBox();

        // TextArea, ScrollPane e Table
        taObs = new JTextArea();
        spObs = new JScrollPane(taObs);
        tProdutos = new JTable();
        tFormpagto = new JTable();
        
        // Buttons
        btnIncluirP = new JButton("Incluir");
        btnAlterarP = new JButton("Alterar");
        btnExcluirP = new JButton("Excluir");
        btnIncluirF = new JButton("Incluir");
        btnAlterarF = new JButton("Alterar");
        btnExcluirF = new JButton("Excluir");
        
        btnIncluir = new JButton("Incluir");
        btnAlterar = new JButton("Alterar");
        btnConsultar = new JButton("Consultar");
        btnExcluir = new JButton("Excluir");



    }

    public void adicionar() {

        // Adiciona Labels
        add(lblId);
        add(lblUsu);
        add(lblCli);
        add(lblData);
        add(lblValor);
        add(lblDesconto);
        add(lblTotal);
        add(lblObs);
        add(lblProdutos);
        add(lblFormPagto);

        // Adiciona TextFields
        add(tfId);
        add(cbIdUsu);
        add(cbIdCli);
        add(tfData);
        add(tfValor);
        add(tfDesconto);
        add(tfTotal);

        // Adiciona ScrollPane e Table
        add(spObs);
        add(tProdutos);
        add(tFormpagto);

        // Buttons
        add(btnIncluirP);
        add(btnAlterarP);
        add(btnExcluirP);
        add(btnIncluirF);
        add(btnAlterarF);
        add(btnExcluirF);
        
        add(btnIncluir);
        add(btnAlterar);
        add(btnConsultar);
        add(btnExcluir);

    }

    public void posicionar() {

        // Posiciona Labels
        lblId.setBounds(25, 20, 90, 25);
        lblUsu.setBounds(25, 60, 90, 25);
        lblCli.setBounds(25, 100, 100, 25);
        lblData.setBounds(25, 140, 90, 25);
        lblValor.setBounds(25, 500, 90, 25);
        lblDesconto.setBounds(320, 500, 120, 25);
        lblTotal.setBounds(670, 500, 120, 25);
        lblObs.setBounds(540, 30, 100, 25);
        lblProdutos.setBounds(180, 190, 120, 25);
        lblFormPagto.setBounds(660, 190, 150, 25);

        // Posiciona TextFields
        tfId.setBounds(150, 20, 300, 25);
        tfData.setBounds(150, 140, 300, 25);
        tfValor.setBounds(70, 500, 200, 25);
        tfDesconto.setBounds(400, 500, 200, 25);
        tfTotal.setBounds(720, 500, 200, 25);

        // Posiciona ComboBox
        cbIdUsu.setBounds(150, 60, 300, 25);
        cbIdCli.setBounds(150, 100, 300, 25);

        // Posiciona ScrollPane e Table
        spObs.setBounds(540, 60, 400, 110);
        tProdutos.setBounds(25, 250, 440, 200);
        tFormpagto.setBounds(500, 250, 440, 200);

        // Posiciona Buttons
        btnIncluirP.setBounds(40, 220, 100, 20);
        btnAlterarP.setBounds(160, 220, 100, 20);
        btnExcluirP.setBounds(280, 220, 100, 20);
        btnIncluirF.setBounds(540, 220, 100, 20);
        btnAlterarF.setBounds(680, 220, 100, 20);
        btnExcluirF.setBounds(820, 220, 100, 20);
        
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);

    }
}
