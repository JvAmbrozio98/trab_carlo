package modulovendas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    private JLabel lblLogin, lblEmail, lblSenha, lblMudarSenha, lblCriarConta;
    private JTextField tfEmail;
    private JPasswordField pfSenha;
    private JButton btEntrar;

    public Login() {
        setTitle("ACV - Gerenciamento de Compra e Vendas"); // título do frame
        setPreferredSize(new Dimension(700, 400)); // ajuste do tamanho e layout
        setLayout(null); // aqui a definição para utilização de layout absoluto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        instanciar(); // instancia componentes (objetos Swing);
        adicionar(); // adiciona componentes no frame
        posicionar(); // configura as posições dos componentes;
        
        setVisible(true); // deixa o frame visível
        pack(); // reorganiza os componentes (objetos) no frame
        setLocationRelativeTo(null);
        setResizable(false);

        // Adiciona o ActionListener ao botão
        btEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a tela Dashboard
                new Dashboard();
                // Fecha a tela de login
                dispose();
            }
        });
    }
    
    public void instanciar() {

        lblLogin = new JLabel("Faça o seu login");
        lblEmail = new JLabel("email");
        lblSenha = new JLabel("senha");
        lblMudarSenha = new JLabel("esqueci minha senha");
        lblCriarConta = new JLabel("ainda não tenho uma conta");
        
        tfEmail = new JTextField();
        
        pfSenha = new JPasswordField();
        
        btEntrar = new JButton("Entrar");
        
    }
    
    public void adicionar() {
        
        add(lblLogin);
        add(lblEmail);
        add(lblSenha);
        add(lblMudarSenha);
        add(lblCriarConta);
        add(tfEmail);
        add(pfSenha);
        add(btEntrar);

    }
        
    public void posicionar() {

        lblLogin.setBounds(200, 20, 300, 80);
        lblLogin.setFont(new Font("Arial", Font.PLAIN, 40));
        lblEmail.setBounds(150, 100, 150, 30);
        lblSenha.setBounds(150, 180, 150, 30);
        lblMudarSenha.setBounds(430, 240, 150, 30);
        lblCriarConta.setBounds(280, 310, 200, 30);
        tfEmail.setBounds(150, 130, 400, 30);
        pfSenha.setBounds(150, 210, 400, 30);
        btEntrar.setBounds(150, 280, 400, 30);
        btEntrar.setFont(new Font("Arial", Font.PLAIN, 20));
        
    }
    
}
