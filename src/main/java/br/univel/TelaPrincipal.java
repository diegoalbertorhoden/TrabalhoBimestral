package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnCadastro.add(mntmProdutos);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mnCadastro.add(mntmClientes);
		
		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mnCadastro.add(mntmUsurios);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mnVendas.add(mntmNovaVenda);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Produtos");
		mnRelatrios.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mnRelatrios.add(mntmNewMenuItem_1);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnRelatrios.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
