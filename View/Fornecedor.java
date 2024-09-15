package modulovendas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Fornecedor extends JPanel {

    private JLabel lblId, lblNome, lblNomeFantasia, lblPessoa, lblRg, lblDatacadastro, lblEndereco,
            lblNumero, lblComplemento, lblBairro, lblCidade, lblUf, lblCep, lblTel1, lblTel2, lblCelular, lblSite,
            lblEmail, lblAtivo, lblFornecedorCont;

    private JTextField tfId, tfNome, tfNomeFantasia, tfCpfCnpj, tfRg, tfEndereco, tfNumero, tfComplemento, tfCep,
            tfTel1, tfTel2, tfCelular, tfSite, tfEmail, tfFornecedorCont, tfBairro, tfCidade, tfUf;

    private JComboBox<String> cbAtivo, cbPesFJ;

    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;
    
    private JSpinner spinner;
    
    private SpinnerDateModel model;

    String[] pesFJ = { "Física", "Jurídica" };
    
    String[] ativo = { "Ativo", "Não Ativo" };

    public Fornecedor() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts

        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
    }

    public void instanciar() {

        // Labels
        lblId = new JLabel("ID");
        lblNome = new JLabel("Nome");
        lblNomeFantasia = new JLabel("Nome Fantasia");
        lblPessoa = new JLabel("Pessoa");
        lblRg = new JLabel("RG");
        lblDatacadastro = new JLabel("Data Cadastro");
        lblEndereco = new JLabel("Endereço");
        lblNumero = new JLabel("Número");
        lblComplemento = new JLabel("Complemento");
        lblBairro = new JLabel("Bairro");
        lblCidade = new JLabel("Cidade");
        lblUf = new JLabel("UF");
        lblCep = new JLabel("CEP");
        lblTel1 = new JLabel("Telefone 1");
        lblTel2 = new JLabel("Telefone 2");
        lblCelular = new JLabel("Telefone Celular");
        lblSite = new JLabel("Site");
        lblEmail = new JLabel("Email");
        lblAtivo = new JLabel("Ativo");
        lblFornecedorCont = new JLabel("Contato Fornecedor");

        // TextFields
        tfId = new JTextField();
        tfNome = new JTextField();
        tfNomeFantasia = new JTextField();
        tfCpfCnpj = new JTextField();
        tfRg = new JTextField();
        tfEndereco = new JTextField();
        tfNumero = new JTextField();
        tfComplemento = new JTextField();
        tfCep = new JTextField();
        tfTel1 = new JTextField();
        tfTel2 = new JTextField();
        tfCelular = new JTextField();
        tfSite = new JTextField();
        tfEmail = new JTextField();
        tfFornecedorCont = new JTextField();
        tfBairro = new JTextField();
        tfCidade = new JTextField();
        tfUf = new JTextField();

        // ComboBoxes
        cbPesFJ = new JComboBox<>(pesFJ);
        cbAtivo = new JComboBox<>(ativo);

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

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe uma nova janela
                JFrame newFrame = new JFrame("Consultar Fornecedor");
                newFrame.setSize(1200, 550);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
                newFrame.setLocationRelativeTo(null);

                // Cria um painel para adicionar componentes à nova janela
                JPanel newPanel = new JPanel(new BorderLayout());
                newFrame.add(newPanel);

                // Adiciona vários componentes ao painel da nova janela
                JPanel topPanel = new JPanel();
                topPanel.add(new JLabel("ID:"));
                JTextField tfId = new JTextField(5);
                topPanel.add(tfId);

                topPanel.add(new JLabel("Nome:"));
                JTextField tfNome = new JTextField(25);
                topPanel.add(tfNome);

                JButton btnConsultar = new JButton("Consultar");
                topPanel.add(btnConsultar);

                JButton btnLimpar = new JButton("Limpar");
                topPanel.add(btnLimpar);

                newPanel.add(topPanel, BorderLayout.NORTH); 
                
                String[][] data = {
                        {"", "",  "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",}};
                
                String[] columnNames = {"Código", "Nome", "Nome Fantasia", "Pessoa", "CPF/CNPJ", "RG", "Data Cadastro",
                         "Endereço", "Número", "Complemento", "Bairro", "Cidade", "UF", "CEP",
                         "Telefone 1", "Telefone 2", "Telefone Celular", "Site", "Email", "Ativo", "Contato Fornecedor"};
                
                JTable tFornecedor = new JTable(data, columnNames);
                
                JScrollPane scrollPane = new JScrollPane(tFornecedor);
                newPanel.add(scrollPane, BorderLayout.CENTER);
                
            }
        });
        
    }

    public void adicionar() {

        // Adiciona Labels
        add(lblId);
        add(lblNome);
        add(lblNomeFantasia);
        add(lblPessoa);
        add(lblRg);
        add(lblDatacadastro);
        add(lblEndereco);
        add(lblNumero);
        add(lblComplemento);
        add(lblBairro);
        add(lblCidade);
        add(lblUf);
        add(lblCep);
        add(lblTel1);
        add(lblTel2);
        add(lblCelular);
        add(lblSite);
        add(lblEmail);
        add(lblAtivo);
        add(lblFornecedorCont);

        // Adiciona TextFields
        add(tfId);
        add(tfNome);
        add(tfNomeFantasia);
        add(tfCpfCnpj);
        add(tfRg);
        add(tfEndereco);
        add(tfNumero);
        add(tfComplemento);
        add(tfCep);
        add(tfTel1);
        add(tfTel2);
        add(tfCelular);
        add(tfSite);
        add(tfEmail);
        add(tfFornecedorCont);
        add(tfBairro);
        add(tfCidade);
        add(tfUf);

        // Adiciona ComboBoxes
        add(cbPesFJ);
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
        lblId.setBounds(25, 20, 90, 25);
        lblNome.setBounds(25, 60, 90, 25);
        lblNomeFantasia.setBounds(25, 100, 100, 25);
        lblPessoa.setBounds(25, 140, 90, 25);
        lblRg.setBounds(25, 260, 90, 25);
        lblDatacadastro.setBounds(25, 300, 120, 25);

        lblEndereco.setBounds(500, 60, 90, 25);
        lblNumero.setBounds(500, 100, 90, 25);
        lblComplemento.setBounds(500, 140, 100, 25);
        lblBairro.setBounds(500, 180, 90, 25);
        lblCidade.setBounds(500, 220, 90, 25);
        lblUf.setBounds(500, 260, 90, 25);
        lblCep.setBounds(500, 300, 90, 25);

        lblTel1.setBounds(25, 380, 90, 25);
        lblTel2.setBounds(25, 420, 90, 25);
        lblCelular.setBounds(25, 460, 120, 25);
        lblSite.setBounds(500, 380, 90, 25);
        lblEmail.setBounds(500, 420, 90, 25);
        lblAtivo.setBounds(500, 460, 90, 25);

        lblFornecedorCont.setBounds(500, 500, 120, 25);

        // Posiciona TextFields
        tfId.setBounds(150, 20, 300, 25);
        tfNome.setBounds(150, 60, 300, 25);
        tfNomeFantasia.setBounds(150, 100, 300, 25);
        tfCpfCnpj.setBounds(25, 220, 300, 25);
        tfRg.setBounds(150, 260, 300, 25);

        tfEndereco.setBounds(600, 60, 300, 25);
        tfNumero.setBounds(600, 100, 300, 25);
        tfComplemento.setBounds(600, 140, 300, 25);
        tfCep.setBounds(600, 300, 300, 25);
        tfBairro.setBounds(600, 180, 300, 25);
        tfCidade.setBounds(600, 220, 300, 25);
        tfUf.setBounds(600, 260, 100, 25);

        tfTel1.setBounds(150, 380, 300, 25);
        tfTel2.setBounds(150, 420, 300, 25);
        tfCelular.setBounds(150, 460, 300, 25);
        tfSite.setBounds(600, 380, 300, 25);
        tfEmail.setBounds(600, 420, 300, 25);
        tfFornecedorCont.setBounds(630, 500, 270, 25);

        // Posiciona ComboBoxes
        cbPesFJ.setBounds(25, 180, 100, 25);
        cbAtivo.setBounds(600, 460, 100, 25);

        // Posiciona Buttons
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);
        
        // Posiciona Spinner
        spinner.setBounds(150, 300, 300, 25);
    }
}
