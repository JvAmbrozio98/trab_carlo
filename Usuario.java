package modulovendas;

import javax.swing.*;

public class Usuario extends JPanel {

    private JLabel lblId, lblNome, lbllogin, lblSenha, lblDataCadastro;
    
    private JTextField tfId, tfNome, tflogin, tfSenha, tfDataCadastro;
    
    private JCheckBox chbAtivo;
    
    private JButton btnIncluir, btnAlterar, btnConsultar, btnExcluir;
    
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
        
        // TextFields
        tfId = new JTextField();
        tfNome = new JTextField();
        tflogin = new JTextField();
        tfSenha = new JTextField();
        tfDataCadastro = new JTextField();
        
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
        add(lblNome);
        add(lbllogin);
        add(lblSenha);
        add(lblDataCadastro);
        
        // Adiciona TextFields
        add(tfId);
        add(tfNome);
        add(tflogin);
        add(tfSenha);
        add(tfDataCadastro);
        
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
        lblId.setBounds(200, 160, 90, 25);
        lblNome.setBounds(200, 200, 150, 25);
        lbllogin.setBounds(200, 240, 150, 25);
        lblSenha.setBounds(200, 280, 150, 25);
        lblDataCadastro.setBounds(200, 320, 150, 25);
     
        // Posiciona TextFields
        tfId.setBounds(400, 160, 300, 25);
        tfNome.setBounds(400, 200, 300, 25);
        tflogin.setBounds(400, 240, 300, 25);
        tfSenha.setBounds(400, 280, 300, 25);
        tfDataCadastro.setBounds(400, 320, 300, 25);
        
        // Posiciona CheckBoxes

        chbAtivo.setBounds(200, 360, 120, 25);
        
        // Posiciona Buttons
        btnIncluir.setBounds(560, 0, 100, 20);
        btnAlterar.setBounds(660, 0, 100, 20);
        btnConsultar.setBounds(760, 0, 100, 20);
        btnExcluir.setBounds(860, 0, 100, 20);
        
    }
}
