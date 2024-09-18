package modulovendas;

import modulovendas.Controllers.VendaController;
import modulovendas.Models.VendaModels;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Venda extends JPanel {

    private JLabel lblId, lblUsu, lblCli, lblData, lblValor, lblDesconto, lblTotal, lblObs,
            lblProdutos, lblFormPagto;

    private JTextField tfId, tfValor, tfDesconto, tfTotal;

    private JTextField cbIdUsu, cbIdCli;

    private JTextArea taObs;

    private JScrollPane spObs, spVenda, spPagto;

    private JTable tProdutos, tFormpagto;
    
    private JButton btnIncluirP, btnAlterarP, btnExcluirP, btnIncluirF, btnAlterarF, btnExcluirF,
            btnIncluir, btnAlterar, btnConsultar, btnExcluir;
    
    private JSpinner spinner;
    
    private SpinnerDateModel model;
    
    String[] columnNames = {"Código",
        "Quantidade",
        "Preço",
        "Desconto",
        "Total",
        "Produto"};

    Object[][] data = {
        {"", "", "", "", "", ""},
    };
    
    String[] columnNames2 = {"Código",
        "Valor",
        "Forma Pagamento"};

    Object[][] data2 = {
        {"", "", ""},
    };

    public Venda() {
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
        spVenda = new JScrollPane(tProdutos);
        tFormpagto = new JTable(data2, columnNames2);
        spPagto = new JScrollPane(tFormpagto);
        
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
        add(tfValor);
        add(tfDesconto);
        add(tfTotal);

        // Adiciona ScrollPane e Table
        add(spObs);
        add(spVenda);
        add(spPagto);

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

        // Add Spinneer
        add(spinner);
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
        tfValor.setBounds(70, 500, 200, 25);
        tfDesconto.setBounds(400, 500, 200, 25);
        tfTotal.setBounds(720, 500, 200, 25);

        // Posiciona ComboBox
        cbIdUsu.setBounds(150, 60, 300, 25);
        cbIdCli.setBounds(150, 100, 300, 25);

        // Posiciona ScrollPane e Table
        spObs.setBounds(540, 60, 400, 110);
        spVenda.setBounds(25, 250, 440, 200);
        spPagto.setBounds(500, 250, 440, 200);

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

        // Posiciona Spinner
        spinner.setBounds(150, 140, 300, 25);
    }

    public void configurar () {
        AtomicReference<Integer> valorGaurdado = new AtomicReference<>(0);
        btnIncluir.addActionListener(e -> {
            VendaController vendaController = new VendaController();
            VendaModels vendaModels = new VendaModels();
            vendaModels.setUsuCodigo(Integer.valueOf(cbIdUsu.getText()));
            vendaModels.setCliCodigo(Integer.valueOf(cbIdCli.getText()));
            vendaModels.setVdaData(new java.sql.Date(((java.util.Date) spinner.getValue()).getTime()).toLocalDate());
            vendaModels.setVdaValor(BigDecimal.valueOf(Long.parseLong(tfValor.getText())));
            vendaModels.setVdaTotal(BigDecimal.valueOf(Long.parseLong(tfTotal.getText())));
            vendaModels.setVdaDesconto(BigDecimal.valueOf(Long.parseLong(tfTotal.getText())));
            vendaModels.setVdaObs(taObs.getText());
            try {
                vendaController.cadastrarVenda(vendaModels);
                JOptionPane.showMessageDialog(this.getParent(),"A venda foi cadastrada");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.getParent(),"Erro ao cadastrar");
                throw new RuntimeException(ex);
            }

        });

        btnExcluir.addActionListener(e -> {
            VendaController vendaController = new VendaController();
            try {
                vendaController.deletarVenda(Long.valueOf(tfId.getText()));
                JOptionPane.showMessageDialog(this.getParent(),"A venda foi cadastrada");
            } catch (Exception expt) {
                JOptionPane.showMessageDialog(this.getParent(),"Erro ao excluir");
                throw new RuntimeException(expt);
            }
        });

        btnAlterar.addActionListener(e -> {
            VendaController vendaController = new VendaController();
            VendaModels vendaModels = new VendaModels();
            vendaModels.setUsuCodigo(Integer.valueOf(cbIdUsu.getText()));
            vendaModels.setCliCodigo(Integer.valueOf(cbIdCli.getText()));
            vendaModels.setVdaData(new java.sql.Date(((java.util.Date) spinner.getValue()).getTime()).toLocalDate());
            vendaModels.setVdaValor(BigDecimal.valueOf(Long.parseLong(tfValor.getText())));
            vendaModels.setVdaTotal(BigDecimal.valueOf(Long.parseLong(tfTotal.getText())));
            vendaModels.setVdaDesconto(BigDecimal.valueOf(Long.parseLong(tfTotal.getText())));
            vendaModels.setVdaObs(taObs.getText());

            try {
                vendaController.atualizarVenda(Integer.valueOf(tfId.getText()),vendaModels);
                JOptionPane.showMessageDialog(this.getParent(),"A venda foi alterada");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this.getParent(),"Erro ao alterar");
                throw new RuntimeException(err);
            };
        });

        btnIncluirP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe uma nova janela
                JFrame newFrame = new JFrame("Cadastro de Produto");
                newFrame.setSize(400, 300); // Ajuste o tamanho conforme necessário
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
                newFrame.setResizable(false);
                newFrame.setLocationRelativeTo(null);

                // Cria um painel para adicionar componentes à nova janela
                JPanel newPanel = new JPanel(new GridLayout(6, 2, 10, 10));
                newFrame.add(newPanel);

                // Adiciona os componentes ao painel
                newPanel.add(new JLabel("Produto:"));
                JTextField tfProduto = new JTextField();
                newPanel.add(tfProduto);

                newPanel.add(new JLabel("Quantidade:"));
                JTextField tfQuantidade = new JTextField();
                newPanel.add(tfQuantidade);

                newPanel.add(new JLabel("Preço:"));
                JTextField tfPreco = new JTextField();
                newPanel.add(tfPreco);

                newPanel.add(new JLabel("Desconto (%):"));
                JTextField tfDesconto = new JTextField();
                newPanel.add(tfDesconto);

                newPanel.add(new JLabel("Total:"));
                JTextField tfTotal = new JTextField();
                tfTotal.setEditable(false); // Total não deve ser editável
                newPanel.add(tfTotal);

                // Adiciona botões para cadastrar e limpar
                JButton btnCadastrar = new JButton("Cadastrar");
                newPanel.add(btnCadastrar);

                JButton btnLimpar = new JButton("Limpar");
                newPanel.add(btnLimpar);

                // Adiciona ação ao botão Cadastrar
                btnCadastrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String produto = tfProduto.getText();
                            int quantidade = Integer.parseInt(tfQuantidade.getText());
                            double preco = Double.parseDouble(tfPreco.getText());
                            double desconto = Double.parseDouble(tfDesconto.getText());

                            // Calcula o total com desconto
                            double total = quantidade * preco * (1 - desconto / 100);
                            tfTotal.setText(String.format("%.2f", total));

                            // Simula o cadastro do produto (pode ser substituído por código real de cadastro)
                            // Exemplo de exibição de mensagem de sucesso
                            JOptionPane.showMessageDialog(newFrame,
                                    String.format("Produto cadastrado com sucesso!\nProduto: %s\nQuantidade: %d\nPreço: %.2f\nDesconto: %.2f%%\nTotal: %.2f",
                                            produto, quantidade, preco, desconto, total),
                                    "Cadastro Concluído",
                                    JOptionPane.INFORMATION_MESSAGE);

                            // Limpa os campos após o cadastro
                            tfProduto.setText("");
                            tfQuantidade.setText("");
                            tfPreco.setText("");
                            tfDesconto.setText("");
                            tfTotal.setText("");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(newFrame, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Adiciona ação ao botão Limpar
                btnLimpar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tfProduto.setText("");
                        tfQuantidade.setText("");
                        tfPreco.setText("");
                        tfDesconto.setText("");
                        tfTotal.setText("");
                    }
                });
            }
        });

        btnIncluirF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe uma nova janela
                JFrame newFrame = new JFrame("Cadastro de Forma de Pagamento");
                newFrame.setSize(400, 300); // Ajuste o tamanho conforme necessário
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
                newFrame.setResizable(false);
                newFrame.setLocationRelativeTo(null);

                // Cria um painel para adicionar componentes à nova janela
                JPanel newPanel = new JPanel(new GridLayout(4, 2, 10, 10));
                newFrame.add(newPanel);

                // Adiciona os componentes ao painel
                newPanel.add(new JLabel("Código:"));
                JTextField tfCodigo = new JTextField();
                newPanel.add(tfCodigo);

                newPanel.add(new JLabel("Valor:"));
                JTextField tfValor = new JTextField();
                newPanel.add(tfValor);

                newPanel.add(new JLabel("Forma de Pagamento:"));
                JTextField tfFormaPagto = new JTextField();
                newPanel.add(tfFormaPagto);

                // Adiciona botões para cadastrar e limpar
                JButton btnCadastrar = new JButton("Cadastrar");
                newPanel.add(btnCadastrar);

                JButton btnLimpar = new JButton("Limpar");
                newPanel.add(btnLimpar);

                // Adiciona ação ao botão Cadastrar
                btnCadastrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            // Obtém os valores dos campos
                            String codigo = tfCodigo.getText();
                            double valor = Double.parseDouble(tfValor.getText());
                            String formaPagto = tfFormaPagto.getText();

                            // Valida os campos
                            if (codigo.isEmpty()) {
                                throw new IllegalArgumentException("O campo 'Código' não pode estar vazio.");
                            }
                            if (valor <= 0) {
                                throw new IllegalArgumentException("O campo 'Valor' deve ser maior que zero.");
                            }
                            if (formaPagto.isEmpty()) {
                                throw new IllegalArgumentException("O campo 'Forma de Pagamento' não pode estar vazio.");
                            }

                            // Simula o cadastro do pagamento (pode ser substituído por código real de cadastro)
                            // Exemplo de exibição de mensagem de sucesso
                            JOptionPane.showMessageDialog(newFrame,
                                    String.format("Forma de pagamento cadastrada com sucesso!\nCódigo: %s\nValor: %.2f\nForma de Pagamento: %s",
                                            codigo, valor, formaPagto),
                                    "Cadastro Concluído",
                                    JOptionPane.INFORMATION_MESSAGE);

                            // Limpa os campos após o cadastro
                            tfCodigo.setText("");
                            tfValor.setText("");
                            tfFormaPagto.setText("");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(newFrame, "Por favor, insira valores válidos para o campo 'Valor'.", "Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(newFrame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Adiciona ação ao botão Limpar
                btnLimpar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tfCodigo.setText("");
                        tfValor.setText("");
                        tfFormaPagto.setText("");
                    }
                });
            }
        });

    };
}
