package modulovendas;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Dashboard extends JFrame {

    private JMenuBar barraMenu;
    private JMenu menuCadastro, menuMovimento, menuSair;
    private JMenuItem menuCliente, menuFornecedor, menuProduto, menuFormPagto, menuUsuario, menuVenda, menuCompra;
    
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Dashboard() {
        setTitle("ACV - Gerenciamento de Compra e Vendas"); // título do frame
        setPreferredSize(new Dimension(980, 630)); // ajuste do tamanho e layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        instanciar(); // instancia componentes (objetos Swing);
        adicionar(); // adiciona componentes no frame
        posicionar(); // configura as posições dos componentes;
        
        setVisible(true); // deixa o frame visível
        pack(); // reorganiza os componentes (objetos) no frame
        setLocationRelativeTo(null); // Centraliza a janela
    }
    
    public void instanciar() {

        barraMenu = new JMenuBar();
        
        menuCadastro = new JMenu("Cadastros");
        menuCliente = new JMenuItem("Cliente");
        menuFornecedor = new JMenuItem("Fornecedor");
        menuProduto = new JMenuItem("Produto");
        menuFormPagto = new JMenuItem("Forma de Pagamento");
        menuUsuario = new JMenuItem("Usuário");
        
        menuMovimento = new JMenu("Movimentos");
        menuVenda = new JMenuItem("Venda");
        menuCompra = new JMenuItem("Compra");
        
        menuSair = new JMenu("Sair");
        
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        
        // Adiciona os painéis aos cartões de menuCadastros
        
        cardLayout.show(mainPanel, "Vazio");
        
        mainPanel.add(new JPanel(), "Inicial"); // Painel inicial, apenas um exemplo
        
        mainPanel.add(new Cliente(), "Cliente");
        mainPanel.add(new Fornecedor(), "Fornecedor");
        mainPanel.add(new Produto(), "Produto");
        mainPanel.add(new FormPagto(), "Forma de Pagamento");
        mainPanel.add(new Usuario(), "Usuário");
        
        mainPanel.add(new Venda(), "Venda");
        mainPanel.add(new Compra(), "Compra");
        
        
        // Configura o ActionListener para o item do menu "Cliente"
        menuCliente.addActionListener(new MenuActionListener("Cliente"));
        menuFornecedor.addActionListener(new MenuActionListener("Fornecedor"));
        menuProduto.addActionListener(new MenuActionListener("Produto"));
        menuFormPagto.addActionListener(new MenuActionListener("Forma de Pagamento"));
        menuUsuario.addActionListener(new MenuActionListener("Usuário"));
        
        menuVenda.addActionListener(new MenuActionListener("Venda"));
        menuCompra.addActionListener(new MenuActionListener("Compra"));
    }
    
    public void adicionar() {
        
        barraMenu.add(menuCadastro);
        menuCadastro.add(menuCliente);
        menuCadastro.add(menuFornecedor);
        menuCadastro.add(menuProduto);
        menuCadastro.add(menuFormPagto);
        menuCadastro.add(menuUsuario);
        
        barraMenu.add(menuMovimento);
        menuMovimento.add(menuVenda);
        menuMovimento.add(menuCompra);
        
        barraMenu.add(menuSair);
        
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(Box.createHorizontalGlue());
                 
        setJMenuBar(barraMenu);
        add(mainPanel);

    }
        
    public void posicionar() {
        barraMenu.setBounds(0, 0, 1000, 30); // Ajuste para corresponder ao tamanho da janela
                
    }
    
    private class MenuActionListener implements ActionListener {
        private String cardName;

        public MenuActionListener(String cardName) {
            this.cardName = cardName;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(mainPanel, cardName);
        }
    }
}
