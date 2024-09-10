package modulovendas;

import modulovendas.Controllers.ClienteController;
import modulovendas.Models.ClienteModel;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Cliente extends JPanel {

    private JLabel lblId, lblNome, lblNomeFantasia, lblPessoa, lblRg, lblDatacadastro, lblEndereco, 
            lblNumero, lblComplemento, lblBairro, lblCidade, lblUf, lblCep, lblTel1, lblTel2, lblCelular, lblSite,
            lblEmail, lblAtivo, lblLimiteCredito;
    
    private JTextField tfId, tfNome, tfNomeFantasia, tfCpfCnpj, tfRg, tfEndereco, tfNumero, tfComplemento, tfCep,
            tfTel1, tfTel2, tfCelular, tfSite, tfEmail, tfLimiteCredito, tfBairro, tfCidade, tfUf;
    
    private JComboBox<String> cbPesFiJu, cbAtivo;
    
    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;
    
    private JSpinner spinner;
    
    private SpinnerDateModel model;

<<<<<<< HEAD:View/Cliente.java
    String[] pesFJ = { "Física", "Jurídica" };
    
    String[] ativo = { "Ativo", "Não Ativo" };
    
=======


>>>>>>> 657e4cef651c17f896195638e4bf87548a6271b7:Cliente.java
    public Cliente() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts
        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
        configurar();
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
        lblLimiteCredito = new JLabel("Limite Crédito");
        
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
        tfLimiteCredito = new JTextField();
        tfBairro = new JTextField();
        tfCidade = new JTextField();
        tfUf = new JTextField();
        
        // ComboBoxes
        cbPesFiJu = new JComboBox(pesFJ);
        cbAtivo = new JComboBox(ativo);

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
        add(lblLimiteCredito);
        
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
        add(tfLimiteCredito);
        add(tfBairro);
        add(tfCidade);
        add(tfUf);

        // Adiciona ComboBoxes
        add(cbPesFiJu);
        add(cbAtivo);

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
        lblUf.setBounds(500, 260, 90, 25); // reduzir 40 neste acima
        lblCep.setBounds(500, 300, 90, 25);
        
        lblTel1.setBounds(25, 380, 90, 25);
        lblTel2.setBounds(25, 420, 90, 25);
        lblCelular.setBounds(25, 460, 120, 25);
        lblSite.setBounds(500, 380, 90, 25);
        lblEmail.setBounds(500, 420, 90, 25);
        lblAtivo.setBounds(500, 460, 90, 25);
        
        lblLimiteCredito.setBounds(500, 500, 120, 25);
        
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
        tfLimiteCredito.setBounds(600, 500, 300, 25);
        
        // Posiciona ComboBoxes

        cbPesFiJu.setBounds(25, 180, 100, 25);
        cbAtivo.setBounds(600, 460, 100, 25);
        
        // Posiciona Buttons
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);
        
        // Posiciona Spinner
        spinner.setBounds(150, 300, 300, 25);
    }

    public void configurar () {
        btnIncluir.addActionListener(e -> {
            ClienteController clienteController = new ClienteController();
            ClienteModel clienteModel = new ClienteModel();
            clienteModel.setPesNome(tfNome.getText());
            clienteModel.setPesCpfCnpj(tfCpfCnpj.getText());
            clienteModel.setPesFantasia(tfNomeFantasia.getText());
            clienteModel.setPesRgIe(tfRg.getText());
            clienteModel.setPesFone1(tfCelular.getText());
            clienteModel.setPesFone2(tfTel2.getText());
            clienteModel.setPesEndereco(tfEndereco.getText());
            clienteModel.setPesComplemento(tfComplemento.getText());
            clienteModel.setPesCadastro(LocalDate.now());
            clienteModel.setPesFone1(tfTel1.getText());
            clienteModel.setPesFone2(tfTel2.getText());
            clienteModel.setPesCelular(tfCelular.getText());
            clienteModel.setPesEndereco(tfEndereco.getText());
            clienteModel.setPesNumero(tfNumero.getText());
            clienteModel.setPesComplemento(tfComplemento.getText());
            clienteModel.setPesBairro("Recanto Azul");
            clienteModel.setPesCidade("Bauru");
            clienteModel.setPesUf("SP");
            clienteModel.setPesCep("12345678");
            clienteModel.setPesSite(tfSite.getText());
            clienteModel.setPesEmail(tfEmail.getText());
            clienteModel.setPesAtivo('y');
            clienteModel.setCliLimiteCred(BigDecimal.valueOf(100));

            try {
                clienteController.cadastrarCliente(clienteModel);
                JOptionPane.showMessageDialog(this.getParent(),"Usuario cadastrado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this.getParent(),"Usuario cadastrado");
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        });

        btnExcluir.addActionListener(e -> {
            ClienteController clienteController = new ClienteController();
            try {
                clienteController.excluirCliente(Integer.valueOf(tfId.getText()));
                JOptionPane.showMessageDialog(this.getParent(),"O puto foi excluido");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this.getParent(),"Erron a exclusão");
                throw new RuntimeException(ex);
            }
        });
    }

}
