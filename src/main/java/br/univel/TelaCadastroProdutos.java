package br.univel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class TelaCadastroProdutos extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProdutos() {
		setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCadastroDeProdutos.setBounds(136, 11, 147, 14);
		add(lblCadastroDeProdutos);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(76, 53, 46, 14);
		add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(76, 89, 46, 14);
		add(lblDescrio);
		
		textField = new JTextField();
		textField.setBounds(125, 50, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 86, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}
}
