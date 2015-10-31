package br.univel.telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaCadastroClientes extends JPanel {
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public TelaCadastroClientes() {
		setLayout(null);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroDeClientes.setBounds(139, 11, 169, 20);
		add(lblCadastroDeClientes);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setBounds(127, 69, 10, 14);
		add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(110, 94, 27, 14);
		add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(95, 119, 42, 14);
		add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setBounds(92, 144, 45, 14);
		add(lblEndereo);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(104, 169, 33, 14);
		add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstado.setBounds(104, 194, 33, 14);
		add(lblEstado);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(109, 219, 28, 14);
		add(lblEmail);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGnero.setBounds(102, 244, 35, 14);
		add(lblGnero);
		
		txtId = new JTextField();
		txtId.setBounds(164, 60, 42, 20);
		add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(164, 85, 224, 20);
		add(txtNome);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(164, 113, 86, 20);
		add(txtTelefone);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(164, 138, 224, 20);
		add(txtEndereco);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(164, 163, 224, 20);
		add(txtCidade);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(164, 213, 86, 20);
		add(txtEmail);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 188, 86, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(164, 238, 86, 20);
		add(comboBox_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(219, 269, 89, 23);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(127, 269, 89, 23);
		add(btnLimpar);
		
		JButton btnNewButton = new JButton("Novo");
		btnNewButton.setBounds(110, 36, 80, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setBounds(188, 36, 80, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setBounds(267, 36, 80, 23);
		add(btnNewButton_2);

	}
}
