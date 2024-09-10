package modulovendas;

import javax.swing.*;

public class Produto extends JPanel {

    private JLabel lblId, lblNome, lblEstoque, lblUnidade, lblPreco, lblCusto, lblAtacado, lblMin, lblMax, lblEmbalagem,
            lblPeso, lblDataCadastro, lblObs, lblAtivo;

    private JTextField tfId, tfNome, tfEstoque, tfUnidade, tfPreco, tfCusto, tfAtacado, tfMin, tfMax, tfEmbalagem, tfPeso,
            tfObs;

    private JComboBox cbAtivo;

    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;

    private JSpinner spinner;

    private SpinnerDateModel model;
    
    String[] ativo = { "Ativo", "Não Ativo" };

    public Produto() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts

        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
    }

    public void instanciar() {

        // Labels
        lblId = new JLabel("ID");
        lblNome = new JLabel("Nome");
        lblEstoque = new JLabel("Estoque");
        lblUnidade = new JLabel("Unidade");
        lblPreco = new JLabel("Preço");
        lblDataCadastro = new JLabel("Data Cadastro");
        lblCusto = new JLabel("Custo");
        lblAtacado = new JLabel("Atacado");
        lblMin = new JLabel("Mínimo");
        lblMax = new JLabel("Máximo");
        lblEmbalagem = new JLabel("Embalagem");
        lblPeso = new JLabel("Peso");
        lblObs = new JLabel("Observações");
        lblAtivo = new JLabel("Ativo");

        // TextFields
        tfId = new JTextField();
        tfNome = new JTextField();
        tfEstoque = new JTextField();
        tfUnidade = new JTextField();
        tfPreco = new JTextField();
        tfCusto = new JTextField();
        tfAtacado = new JTextField();
        tfMin = new JTextField();
        tfMax = new JTextField();
        tfEmbalagem = new JTextField();
        tfPeso = new JTextField();
        tfObs = new JTextField();

        // CheckBoxes
        cbAtivo = new JComboBox(ativo);

        // Buttons
        btnIncluir = new JButton("Incluir");
        btnAlterar = new JButton("Alterar");
        btnConsultar = new JButton("Consultar");
        btnExcluir = new JButton("Excluir");

        // Create a SpinnerDateModel with the current date
        model = new SpinnerDateModel();
        // Create a JSpinner with the date model
        spinner = new JSpinner(model);
        // Create a DateEditor for the spinner to format the date display
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd");
        spinner.setEditor(editor);

    }

    public void adicionar() {

        // Adiciona Labels
        add(lblId);
        add(lblNome);
        add(lblEstoque);
        add(lblUnidade);
        add(lblPreco);
        add(lblCusto);
        add(lblAtacado);
        add(lblMin);
        add(lblMax);
        add(lblEmbalagem);
        add(lblPeso);
        add(lblDataCadastro);
        add(lblObs);
        add(lblAtivo);

        // Adiciona TextFields
        add(tfId);
        add(tfNome);
        add(tfEstoque);
        add(tfUnidade);
        add(tfPreco);
        add(tfCusto);
        add(tfAtacado);
        add(tfMin);
        add(tfMax);
        add(tfEmbalagem);
        add(tfPeso);
        add(tfObs);

        // Adiciona ComboBox
        add(cbAtivo);

        // Add Buttons
        add(btnIncluir);
        add(btnAlterar);
        add(btnConsultar);
        add(btnExcluir);

        // Add Spinneer
        add(spinner);
    }

    public void posicionar() {

        // Posiciona Labels
        lblId.setBounds(25, 120, 90, 25);
        lblNome.setBounds(25, 160, 90, 25);
        lblEstoque.setBounds(25, 200, 100, 25);
        lblUnidade.setBounds(25, 240, 90, 25);
        lblPreco.setBounds(25, 280, 90, 25);
        lblCusto.setBounds(25, 320, 120, 25);
        lblAtivo.setBounds(25, 360, 90, 25);

        lblAtacado.setBounds(500, 120, 90, 25);
        lblMin.setBounds(500, 160, 90, 25);
        lblMax.setBounds(500, 200, 100, 25);
        lblEmbalagem.setBounds(500, 240, 90, 25);
        lblPeso.setBounds(500, 280, 90, 25);
        lblDataCadastro.setBounds(500, 320, 90, 25);
        lblObs.setBounds(500, 360, 150, 25);

        // Posiciona TextFields
        tfId.setBounds(150, 120, 300, 25);
        tfNome.setBounds(150, 160, 300, 25);
        tfEstoque.setBounds(150, 200, 300, 25);
        tfUnidade.setBounds(150, 240, 300, 25);
        tfPreco.setBounds(150, 280, 300, 25);
        tfCusto.setBounds(150, 320, 300, 25);

        tfAtacado.setBounds(600, 120, 300, 25);
        tfMin.setBounds(600, 160, 300, 25);
        tfMax.setBounds(600, 200, 300, 25);
        tfEmbalagem.setBounds(600, 240, 300, 25);
        tfPeso.setBounds(600, 280, 300, 25);
        tfObs.setBounds(600, 360, 300, 25);

        // Posiciona ComboBox
        cbAtivo.setBounds(25, 390, 120, 25);

        // Posiciona Buttons
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);

        // Posiciona Spinner
        spinner.setBounds(600, 320, 300, 25);
    }
}
