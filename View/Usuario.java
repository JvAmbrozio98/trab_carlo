package modulovendas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Usuario extends JPanel {

    private JLabel lblId, lblNome, lbllogin, lblSenha, lblDataCadastro, lblAtivo;
    
    private JTextField tfId, tfNome, tflogin;
    
    private JPasswordField pfSenha;
    
    private JComboBox cbAtivo;
    
    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;
    
    private JSpinner spinner;
    
    private SpinnerDateModel model;
    
    String[] ativo = {"Ativo", "Não Ativo"};
    
    public Usuario() {
        setLayout(null); // Definindo layout absoluto, embora seja recomendado usar outros layouts

        instanciar(); // Instancia componentes
        adicionar(); // Adiciona componentes
        posicionar(); // Posiciona componentes
    }

    public void instanciar() {

        // Labels
        lblId = new JLabel("ID");
        lblNome = new JLabel("Nome");
        lbllogin = new JLabel("Login");
        lblSenha = new JLabel("Senha");
        lblDataCadastro = new JLabel("Data Cadastro");
        lblAtivo = new JLabel("Ativo");
        
        // TextFields
        tfId = new JTextField();
        tfNome = new JTextField();
        tflogin = new JTextField();
        
        pfSenha = new JPasswordField();
        
        // ComboBoxes
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

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe uma nova janela
                JFrame newFrame = new JFrame("Consultar Usuário");
                newFrame.setSize(600, 500);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
                newFrame.setResizable(false);
                newFrame.setLocationRelativeTo(null);

                // Cria um painel para adicionar componentes à nova janela
                JPanel newPanel = new JPanel(new BorderLayout());
                newFrame.add(newPanel);

                // Adiciona vários componentes ao painel da nova janela
                JPanel topPanel = new JPanel();
                // Adiciona vários componentes ao painel da nova janela
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
                        {"", "", "", ""}};
                
                String[] columnNames = {"Código",
                    "Nome",
                    "Data Cadastro",
                    "Ativo"};
                
                JTable tUsuario = new JTable(data, columnNames);
                
                JScrollPane scrollPane = new JScrollPane(tUsuario);
                newPanel.add(scrollPane, BorderLayout.CENTER);
                
            }
        });
    }

    public void adicionar() {

        // Adiciona Labels
        add(lblId);
        add(lblNome);
        add(lbllogin);
        add(lblSenha);
        add(lblDataCadastro);
        add(lblAtivo);
        
        // Adiciona TextFields
        add(tfId);
        add(tfNome);
        add(tflogin);
        
        add(pfSenha);
        
        // Adiciona ComboBoxes
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
        lblId.setBounds(200, 160, 90, 25);
        lblNome.setBounds(200, 200, 150, 25);
        lbllogin.setBounds(200, 240, 150, 25);
        lblSenha.setBounds(200, 280, 150, 25);
        lblDataCadastro.setBounds(200, 320, 150, 25);
        lblAtivo.setBounds(200, 360, 120, 25);
     
        // Posiciona TextFields
        tfId.setBounds(400, 160, 300, 25);
        tfNome.setBounds(400, 200, 300, 25);
        tflogin.setBounds(400, 240, 300, 25);
        
        pfSenha.setBounds(400, 280, 300, 25);
        
        // Posiciona ComboBoxes
        cbAtivo.setBounds(200, 390, 120, 25);
        
        // Posiciona Buttons
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);
        
        // Posiciona Spinner
        spinner.setBounds(400, 320, 300, 25);
    }
}
