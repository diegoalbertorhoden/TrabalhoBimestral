package br.univel.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
		txtNome.setEnabled(false);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(164, 113, 86, 20);
		add(txtTelefone);
		txtTelefone.setEnabled(false);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(164, 138, 224, 20);
		add(txtEndereco);
		txtEndereco.setEnabled(false);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(164, 163, 224, 20);
		add(txtCidade);
		txtCidade.setEnabled(false);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(164, 213, 86, 20);
		add(txtEmail);
		txtEmail.setEnabled(false);
		
		final JComboBox cbEstado = new JComboBox();
		cbEstado.setBounds(164, 188, 86, 20);
		add(cbEstado);
		cbEstado.setEnabled(false);
		
		final JComboBox cbGenero = new JComboBox();
		cbGenero.setBounds(164, 238, 86, 20);
		add(cbGenero);
		cbGenero.setEnabled(false);		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(219, 269, 89, 23);
		add(btnSalvar);
		btnSalvar.setEnabled(false);
				
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNome.setText("");
				txtNome.requestFocus();
				txtTelefone.setText("");
				txtEndereco.setText("");
				txtCidade.setText("");
				txtEmail.setText("");
				
				
			}
		});
		btnLimpar.setBounds(127, 269, 89, 23);
		add(btnLimpar);		
		
		
		final JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(188, 36, 80, 23);
		add(btnEditar);
		btnEditar.setEnabled(false);
		
		final JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(267, 36, 80, 23);
		add(btnExcluir);
		btnExcluir.setEnabled(false);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(110, 36, 80, 23);
		add(btnNovo);
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setEnabled(false);
				txtNome.setEnabled(true);
				txtNome.requestFocus();
				txtCidade.setEnabled(true);
				txtEmail.setEnabled(true);
				txtEndereco.setEnabled(true);
				txtTelefone.setEnabled(true);
				cbEstado.setEnabled(true);
				cbGenero.setEnabled(true);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				
			}
		});
				
		SwingUtilities.invokeLater(new Runnable() {  
			public void run() {  
				txtId.requestFocus();  
			}  
		});

	}
}
