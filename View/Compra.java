package modulovendas;

import modulovendas.Controllers.CompraController;
import modulovendas.Models.CompraModel;

import javax.swing.*;
import java.math.BigDecimal;

public class Compra extends JPanel {

    private JLabel lblId, lblUsu, lblCli, lblDataEm, lblValor, lblDesconto, lblTotal, lblDataEnt, lblObs, lblProdutos;

    private JTextField tfId, tfValor, tfDesconto, tfTotal;

    private JTextField cbIdUsu, cbIdCli;

    private JTextArea taObs;

    private JScrollPane spObs, scrollPane;

    private JTable tProdutos;

    private JButton btnIncluirP, btnAlterarP, btnExcluirP,
            btnIncluir, btnAlterar, btnConsultar, btnExcluir;

    private JSpinner spinnerEm, spinnerEnt;

    private SpinnerDateModel modelEm, modelEnt;
    
    String[] columnNames = {"Código",
        "Quantidade",
        "Preço",
        "Desconto",
        "Total",
        "Produto"};

    Object[][] data = {
        {"", "", "", "", "", ""},
    };

    public Compra() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts

        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
        configurar();
    }

    public void instanciar() {

        // Labels
        lblId = new JLabel("ID Venda");
        lblUsu = new JLabel("Usuário");
        lblCli = new JLabel("Fornecedor");
        lblDataEm = new JLabel("Data Emissão");
        lblValor = new JLabel("Valor");
        lblDesconto = new JLabel("Desconto");
        lblTotal = new JLabel("Total");
        lblDataEnt = new JLabel("Data Entrada");
        lblObs = new JLabel("Observações"); //Tipo Text no Banco
        lblProdutos = new JLabel("Produtos");

        // TextFields
        tfId = new JTextField();
        tfValor = new JTextField();
        tfDesconto = new JTextField();
        tfTotal = new JTextField();

        // ComboBox
        cbIdUsu = new JTextField();
        cbIdCli = new JTextField();

        // TextArea, ScrollPane e Table
        taObs = new JTextArea();
        spObs = new JScrollPane(taObs);
        tProdutos = new JTable(data, columnNames);
        scrollPane = new JScrollPane(tProdutos);

        // Buttons
        btnIncluirP = new JButton("Incluir");
        btnAlterarP = new JButton("Alterar");
        btnExcluirP = new JButton("Excluir");

        btnIncluir = new JButton("Incluir");
        btnAlterar = new JButton("Alterar");
        btnConsultar = new JButton("Consultar");
        btnExcluir = new JButton("Excluir");

        // Create a SpinnerDateModel with the current date
        modelEm = new SpinnerDateModel();
        // Create a JSpinner with the date model
        spinnerEm = new JSpinner(modelEm);
        // Create a DateEditor for the spinner to format the date display
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerEm, "yyyy-MM-dd");
        spinnerEm.setEditor(editor);

        // Create a SpinnerDateModel with the current date
        modelEnt = new SpinnerDateModel();
        // Create a JSpinner with the date model
        spinnerEnt = new JSpinner(modelEnt);
        // Create a DateEditor for the spinner to format the date display
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spinnerEnt, "yyyy-MM-dd");
        spinnerEnt.setEditor(editor2);

    }

    public void adicionar() {

        // Adiciona Labels
        add(lblId);
        add(lblUsu);
        add(lblCli);
        add(lblDataEm);
        add(lblValor);
        add(lblDesconto);
        add(lblTotal);
        add(lblDataEnt);
        add(lblObs);
        add(lblProdutos);

        // Adiciona TextFields
        add(tfId);
        add(cbIdUsu);
        add(cbIdCli);
        add(tfValor);
        add(tfDesconto);
        add(tfTotal);

        // Adiciona ScrollPane e Table
        add(spObs);
        //add(tProdutos);
        add(scrollPane);

        // Buttons
        add(btnIncluirP);
        add(btnAlterarP);
        add(btnExcluirP);

        add(btnIncluir);
        add(btnAlterar);
        add(btnConsultar);
        add(btnExcluir);

        // Add Spinneer
        add(spinnerEm);
        add(spinnerEnt);
    }

    public void posicionar() {

        // Posiciona Labels
        lblId.setBounds(25, 20, 90, 25);
        lblUsu.setBounds(25, 60, 90, 25);
        lblCli.setBounds(25, 100, 100, 25);
        lblDataEm.setBounds(25, 140, 90, 25);
        lblValor.setBounds(25, 500, 90, 25);
        lblDesconto.setBounds(320, 500, 120, 25);
        lblTotal.setBounds(670, 500, 120, 25);
        lblDataEnt.setBounds(25, 180, 120, 25);
        lblObs.setBounds(540, 30, 90, 25);
        lblProdutos.setBounds(180, 220, 120, 25);

        // Posiciona TextFields
        tfId.setBounds(150, 20, 300, 25);
        tfValor.setBounds(70, 500, 200, 25);
        tfDesconto.setBounds(400, 500, 200, 25);
        tfTotal.setBounds(720, 500, 200, 25);

        // Posiciona ComboBox
        cbIdUsu.setBounds(150, 60, 300, 25);
        cbIdCli.setBounds(150, 100, 300, 25);

        // Posiciona ScrollPane e Table
        spObs.setBounds(540, 60, 400, 150);
        scrollPane.setBounds(25, 280, 910, 200);

        // Posiciona Buttons
        btnIncluirP.setBounds(40, 250, 100, 20);
        btnAlterarP.setBounds(160, 250, 100, 20);
        btnExcluirP.setBounds(280, 250, 100, 20);

        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);

        // Posiciona Spinners
        spinnerEm.setBounds(150, 140, 300, 25);
        spinnerEnt.setBounds(150, 180, 300, 25);

    }

    public void configurar () {
        btnIncluir.addActionListener(e -> {
            CompraController compraController = new CompraController();
            CompraModel compra = new CompraModel();
            compra.setUsuCodigo(Integer.valueOf(cbIdUsu.getText()));
            compra.setForCodigo(Integer.valueOf(cbIdCli.getText()));
            compra.setCprEmissao(new java.sql.Date(((java.util.Date) spinnerEm.getValue()).getTime()).toLocalDate());
            compra.setCprDtEntrada(new java.sql.Date(((java.util.Date) spinnerEnt.getValue()).getTime()).toLocalDate());
            compra.setCprValor(BigDecimal.valueOf(Long.parseLong(tfValor.getText())));
            compra.setCprDesconto(BigDecimal.valueOf(Long.parseLong(tfValor.getText())));
            compra.setCprTotal(BigDecimal.valueOf(Long.parseLong(tfTotal.getText())));
            compra.setCprObs(taObs.getText());
            try {
                compraController.cadastrarCompra(compra);
                JOptionPane.showMessageDialog(this.getParent(), "Compra cadastrada");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this.getParent(), "Erro ao cadastrar compra");
            }

        });

        btnAlterar.addActionListener(e -> {
            CompraController compraController = new CompraController();
            CompraModel compra = new CompraModel();
            compra.setUsuCodigo(Integer.valueOf(cbIdUsu.getText()));
            compra.setForCodigo(Integer.valueOf(cbIdCli.getText()));
            compra.setCprEmissao(new java.sql.Date(((java.util.Date) spinnerEm.getValue()).getTime()).toLocalDate());
            compra.setCprDtEntrada(new java.sql.Date(((java.util.Date) spinnerEnt.getValue()).getTime()).toLocalDate());
            compra.setCprValor(BigDecimal.valueOf(Long.parseLong(tfValor.getText())));
            compra.setCprDesconto(BigDecimal.valueOf(Long.parseLong(tfValor.getText())));
            compra.setCprTotal(BigDecimal.valueOf(Long.parseLong(tfTotal.getText())));
            compra.setCprObs(taObs.getText());
            compra.setCprCodigo(Integer.valueOf(tfId.getText()));
            try {
                compraController.atualizarCompra(compra);
                JOptionPane.showMessageDialog(this.getParent(), "Compra atualizada");
            } catch (Exception err) {
                System.out.println(err.getMessage());
                JOptionPane.showMessageDialog(this.getParent(), "Erro ao cadastrar compra");}
        });

        btnExcluir.addActionListener(e -> {
            CompraController compraController = new CompraController();
            try {
                compraController.deletarCompra(Integer.valueOf(tfId.getText()));
                JOptionPane.showMessageDialog(this.getParent(), "Compra deletada");
            } catch (Exception err) {
                System.out.println(err.getMessage());
                JOptionPane.showMessageDialog(this.getParent(), "Erro ao deletar conta");
            }

        });
    }
}