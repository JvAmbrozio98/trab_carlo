package modulovendas;

import modulovendas.Controllers.FormaPagtoController;
import modulovendas.Models.FormaPagtoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FormPagto extends JPanel {

    private JLabel lblId, lblFormaPagto, lblAtivo;

    private JTextField tfId, tfFormaPagto;

    private JComboBox cbAtivo;

    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;

    String[] ativo = {"Ativo", "Não Ativo"};

    public FormPagto() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts

        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
        configurar();
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

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe uma nova janela
                JFrame newFrame = new JFrame("Consultar Forma de Pagamento");
                newFrame.setSize(650, 550);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
                newFrame.setResizable(false); // Permite redimensionar a janela
                newFrame.setLocationRelativeTo(null);

                // Cria um painel com BorderLayout para adicionar componentes
                JPanel newPanel = new JPanel(new BorderLayout()); // Usa BorderLayout para expandir a tabela
                newFrame.add(newPanel);

                // Adiciona os campos de entrada e botões na parte superior (NORTE)
                JPanel topPanel = new JPanel();
                topPanel.add(new JLabel("ID:"));
                JTextField tfId = new JTextField(5);
                topPanel.add(tfId);

                topPanel.add(new JLabel("Forma de Pagamento:"));
                JTextField tfNome = new JTextField(20);
                topPanel.add(tfNome);

                JButton btnConsultar = new JButton("Consultar");
                topPanel.add(btnConsultar);

                JButton btnLimpar = new JButton("Limpar");
                topPanel.add(btnLimpar);

                newPanel.add(topPanel, BorderLayout.NORTH); // Adiciona o painel superior ao NORTE

                // Cria os dados da tabela
                String[][] data = {
                    {"", "", ""}
                };
                String[] columnNames = {"Código", "Forma de Pagamento", "Ativo"};

                // Cria a tabela e adiciona um JScrollPane
                JTable tFormPagto = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(tFormPagto);

                // Adiciona o JScrollPane ao painel principal no CENTRO
                newPanel.add(scrollPane, BorderLayout.CENTER);
            }
        });

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

    public void configurar () {
        btnIncluir.addActionListener(e -> {
            FormaPagtoModel formaPagtoModel = new FormaPagtoModel();
            FormaPagtoController formaPagtoController = new FormaPagtoController();
            formaPagtoModel.setFpgNome(tfFormaPagto.getText());
            formaPagtoModel.setFpgAtivo(cbAtivo.getSelectedItem().toString().equals("Ativo") ? 'y' : 'n');
            try {
                formaPagtoController.cadastrarFormaPagto(formaPagtoModel);
                JOptionPane.showMessageDialog(this.getParent(),"Forma de pagamento cadastrado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this.getParent(),"Erro ao cadastrar");
                throw new RuntimeException(ex);
            }
        });

        btnExcluir.addActionListener(e -> {
            FormaPagtoController formaPagtoController = new FormaPagtoController();
            try {
                formaPagtoController.excluirFormaPagto(Integer.valueOf(tfId.getText()));
                JOptionPane.showMessageDialog(this.getParent(),"Deletado");
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this.getParent(),"Erro ao deletar");
            }
        });

        btnAlterar.addActionListener(e -> {
            FormaPagtoController formaPagtoController = new FormaPagtoController();
            FormaPagtoModel formaPagtoModel = new FormaPagtoModel();
            formaPagtoModel.setFpgNome(tfFormaPagto.getText());
            formaPagtoModel.setFpgAtivo(cbAtivo.getSelectedItem().toString().equals("Ativo") ? 'y' : 'n');
            try {
                formaPagtoController.atualizarFormaPagto(Integer.valueOf(tfId.getText()),formaPagtoModel);
                JOptionPane.showMessageDialog(this.getParent(),"Atualizado");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.getParent(),"Erro ao atualizar");
            }
        });

    }
}
