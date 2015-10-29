package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
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
	public TelaProdutos() {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		menuBar.add(mntmNovo);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		menuBar.add(mntmExcluir);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		menuBar.add(mntmEditar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(155, 30, 10, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(170, 27, 63, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1.setBounds(119, 55, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 52, 166, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBarras = new JLabel("Barras");
		lblBarras.setBounds(134, 80, 31, 14);
		contentPane.add(lblBarras);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 77, 123, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(118, 105, 47, 14);
		contentPane.add(lblCategoria);
		
		textField_3 = new JTextField();
		textField_3.setBounds(170, 102, 123, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(126, 130, 39, 14);
		contentPane.add(lblUnidade);
		
		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setBounds(137, 155, 28, 14);
		contentPane.add(lblCusto);
		
		textField_5 = new JTextField();
		textField_5.setBounds(170, 152, 123, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMarkup = new JLabel("Markup");
		lblMarkup.setBounds(130, 180, 35, 14);
		contentPane.add(lblMarkup);
		
		textField_6 = new JTextField();
		textField_6.setBounds(170, 177, 123, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(140, 212, 63, 20);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(218, 208, 75, 25);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnSalvar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 127, 123, 20);
		contentPane.add(comboBox);
	}
}
