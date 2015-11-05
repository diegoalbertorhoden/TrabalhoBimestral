package br.univel.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import br.univel.banco.ClienteDaoImplementacao;
import br.univel.classes.Clientes;
import br.univel.classes.Estado;
import br.univel.classes.Genero;
import br.univel.tabelas.TabelaDeClientes;

public class TelaCadastroClientes extends JPanel {

	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JTable table;
	private Clientes cliente = new Clientes();
	private JComboBox<String> cbEstado;
	private JComboBox<String> cbGenero;

	private TabelaDeClientes tabelaclientes;
	private ClienteDaoImplementacao c = new ClienteDaoImplementacao();
	private List<Clientes> listaC = new ArrayList<>();
	private int indice = -1;

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
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setBounds(109, 63, 45, 14);
		add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(109, 88, 45, 14);
		add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(109, 115, 45, 14);
		add(lblTelefone);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setBounds(109, 140, 45, 14);
		add(lblEndereo);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(109, 166, 45, 14);
		add(lblCidade);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstado.setBounds(109, 192, 45, 14);
		add(lblEstado);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(109, 217, 45, 14);
		add(lblEmail);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGnero.setBounds(109, 242, 45, 14);
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

		this.cbEstado = new JComboBox(Estado.values());
		cbEstado.setBounds(164, 188, 86, 20);
		add(cbEstado);
		cbEstado.setEnabled(false);

		this.cbGenero = new JComboBox(Genero.values());
		cbGenero.setBounds(164, 238, 86, 20);
		add(cbGenero);
		cbGenero.setEnabled(false);

		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(219, 260, 89, 23);
		add(btnSalvar);
		btnSalvar.setEnabled(false);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				txtNome.setText("");
				txtNome.requestFocus();
				txtTelefone.setText("");
				txtEndereco.setText("");
				txtCidade.setText("");
				txtEmail.setText("");

			}
		});
		btnLimpar.setBounds(127, 260, 89, 23);
		add(btnLimpar);

		final JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(188, 36, 80, 23);
		add(btnEditar);
		btnEditar.setEnabled(false);

		final JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(267, 36, 80, 23);
		add(btnExcluir);
		btnExcluir.setEnabled(false);

		final JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(110, 36, 80, 23);
		add(btnNovo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 282, 430, 180);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnNovo.addActionListener(new ActionListener() {
			@Override
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
				btnSalvar.setEnabled(true);
				btnNovo.setEnabled(false);
				// carregar combobox estado com os dados da enum
				// Estado[] estados = Estado.values();
				// ComboBoxModel cbmodel = new DefaultComboBoxModel(estados);
				// cbEstado.setModel(cbmodel);
				// // carregar combobox genero com os dados da enum
				// Genero[] generos = Genero.values();
				// ComboBoxModel cbmodel2 = new DefaultComboBoxModel(generos);
				// cbGenero.setModel(cbmodel2);
			}
		});

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				txtId.requestFocus();
			}
		});

	}

	public void listaDeCliente() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tabelaclientes = new TabelaDeClientes();
				listaC = tabelaclientes.listar();
				table.setModel(tabelaclientes);
			}
		}).start();
	}

	protected void cadastrar() {

		Clientes cliente = new Clientes(txtNome.getText(),
				txtTelefone.getText(), txtEndereco.getText(),
				txtCidade.getText(), cbEstado.getSelectedItem().toString(),
				txtEmail.getText(), cbGenero.getSelectedItem().toString());
		c.inserir(cliente);
		listaC = c.listar();
		tabelaclientes.adicionarLista(listaC);
		limparcampos();

	}

	public void returnCliente(Clientes c) {
		txtId.setText(String.valueOf(c.getId()));
		txtNome.setText(c.getNome());
		txtTelefone.setText(c.getTelefone());
		txtEndereco.setText(c.getEndereco());
		txtCidade.setText(c.getCidade());
		cbEstado.setSelectedItem(c.getEstado());
		txtEmail.setText(c.getEmail());
		cbGenero.setSelectedItem(c.getGenero());
	}

	public void limparcampos() {
		txtId.setText("");
		txtNome.setText("");
		txtTelefone.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
		cbEstado.setSelectedIndex(0);
		txtEmail.setText("");
		cbGenero.setSelectedIndex(0);
	}
}
