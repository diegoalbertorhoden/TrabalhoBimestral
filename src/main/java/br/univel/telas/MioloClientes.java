package br.univel.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import br.univel.tabelas.TabelaClientes;

@SuppressWarnings("serial")
public class MioloClientes extends JPanel {

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
	private TabelaClientes tabelaclientes;
	private ClienteDaoImplementacao c = new ClienteDaoImplementacao();
	private List<Clientes> listaC = new ArrayList<>();
	private int indice = -1;

	public MioloClientes() {
		setLayout(null);

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroDeClientes.setBounds(333, 11, 169, 20);
		add(lblCadastroDeClientes);

		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setBounds(278, 76, 45, 14);
		add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(278, 101, 45, 14);
		add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(278, 128, 45, 14);
		add(lblTelefone);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setBounds(278, 153, 45, 14);
		add(lblEndereo);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(278, 179, 45, 14);
		add(lblCidade);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstado.setBounds(278, 205, 45, 14);
		add(lblEstado);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(278, 230, 45, 14);
		add(lblEmail);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGnero.setBounds(278, 255, 45, 14);
		add(lblGnero);

		txtId = new JTextField();
		txtId.setBounds(333, 73, 224, 20);
		add(txtId);
		txtId.setColumns(10);
		txtId.setEnabled(false);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(333, 98, 224, 20);
		add(txtNome);
		txtNome.setEnabled(false);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(333, 126, 224, 20);
		add(txtTelefone);
		txtTelefone.setEnabled(false);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(333, 151, 224, 20);
		add(txtEndereco);
		txtEndereco.setEnabled(false);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(333, 176, 224, 20);
		add(txtCidade);
		txtCidade.setEnabled(false);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(333, 226, 224, 20);
		add(txtEmail);
		txtEmail.setEnabled(false);

		this.cbEstado = new JComboBox(Estado.values());
		cbEstado.setBounds(333, 201, 224, 20);
		add(cbEstado);
		cbEstado.setEnabled(false);

		this.cbGenero = new JComboBox(Genero.values());
		cbGenero.setBounds(333, 251, 224, 20);
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
		btnSalvar.setBounds(414, 275, 145, 40);
		add(btnSalvar);
		btnSalvar.setEnabled(false);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparcampos();
			}
		});
		btnLimpar.setBounds(315, 280, 89, 23);
		add(btnLimpar);

		final JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int pergunta = JOptionPane.showConfirmDialog(null, "Quer excluir mesmo?");
				if (pergunta == 0) {
				deletar();
				}else if(pergunta ==1){
					JOptionPane.showMessageDialog(null, "Cliente não excluído");
				}			
			}
		});
		btnExcluir.setBounds(422, 32, 107, 30);
		add(btnExcluir);
		btnExcluir.setEnabled(true);

		final JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(315, 32, 107, 30);
		add(btnNovo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 316, 826, 275);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		listaDeCliente();

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
				btnExcluir.setEnabled(false);
				btnSalvar.setEnabled(true);

			}
		});

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				txtId.requestFocus();
			}
		});

	}
	
	private void deletar() {
		c.excluir(listaC.get(table.getSelectedRow()).getId());
		tabelaclientes.deletar(table.getSelectedRow());		
	}

	public void listaDeCliente() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tabelaclientes = new TabelaClientes();
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
