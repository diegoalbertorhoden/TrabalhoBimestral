package br.univel.telas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.univel.banco.UsuarioDaoImplementacao;
import br.univel.classes.Usuarios;
import br.univel.tabelas.TabelaUsuarios;

@SuppressWarnings("serial")
public class MioloUsuarios extends JPanel {
	
	protected JTextField txtIdUsuario;
	protected JTextField txtIdCliente;
	private JTextField txtCliente;
	private JPasswordField txtSenha;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JTable table;

	private TabelaUsuarios tabelaUsuarios;
	private UsuarioDaoImplementacao u = new UsuarioDaoImplementacao();
	private List<Usuarios> listaU = new ArrayList<>();
	private int indice = -1;

	@SuppressWarnings("deprecation")
	public MioloUsuarios() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 96, 0, 0, 95, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("ID do USU\u00C1RIO: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		txtIdUsuario = new JTextField();
		GridBagConstraints gbc_txtIdUsuario = new GridBagConstraints();
		gbc_txtIdUsuario.gridwidth = 4;
		gbc_txtIdUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtIdUsuario.gridx = 1;
		gbc_txtIdUsuario.gridy = 1;
		add(txtIdUsuario, gbc_txtIdUsuario);
		txtIdUsuario.setColumns(10);
		txtIdUsuario.enable(false);

		JLabel lblIdCliente = new JLabel("ID do CLIENTE: ");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 2;
		add(lblIdCliente, gbc_lblIdCliente);

		txtIdCliente = new JTextField();
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.gridwidth = 4;
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtIdCliente.gridx = 1;
		gbc_txtIdCliente.gridy = 2;
		add(txtIdCliente, gbc_txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblEndereco = new JLabel("CLIENTE");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 3;
		add(lblEndereco, gbc_lblEndereco);

		txtCliente = new JTextField();
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.gridwidth = 4;
		gbc_txtCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCliente.gridx = 1;
		gbc_txtCliente.gridy = 3;
		add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);

		JLabel lblSenha = new JLabel("SENHA: ");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 4;
		add(lblSenha, gbc_lblSenha);

		txtSenha = new JPasswordField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.gridwidth = 4;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 1;
		gbc_txtSenha.gridy = 4;
		add(txtSenha, gbc_txtSenha);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCadastrar.gridx = 2;
		gbc_btnCadastrar.gridy = 5;
		add(btnCadastrar, gbc_btnCadastrar);

		btnAtualizar = new JButton("ALTERAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 3;
		gbc_btnAtualizar.gridy = 5;
		add(btnAtualizar, gbc_btnAtualizar);

		btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		GridBagConstraints gbc_btnDeletar = new GridBagConstraints();
		gbc_btnDeletar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeletar.gridx = 4;
		gbc_btnDeletar.gridy = 5;
		add(btnDeletar, gbc_btnDeletar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Usuarios u = (Usuarios) listaU.get(table.getSelectedRow());
					returnUsuarios(u);
					indice = table.getSelectedRow();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		listaDeUsuarios();
	}
	public void listaDeUsuarios() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tabelaUsuarios = new TabelaUsuarios();
				listaU = tabelaUsuarios.listar();
				table.setModel(tabelaUsuarios);
			}
		}).start();
	}

	@SuppressWarnings("deprecation")
	protected void cadastrar() {
		Usuarios usuario = new Usuarios();
		usuario.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
		usuario.setCliente(txtCliente.getText());
		usuario.setSenha(txtSenha.getText());
		u.inserir(usuario);
		listaU = u.listar();
		tabelaUsuarios.adicionarLista(listaU);
		limpar();
	}

	protected void atualizar() {
		if (indice > -1) {
			Usuarios usuario = new Usuarios();
			usuario.setId(Integer.parseInt(txtIdUsuario.getText()));
			usuario.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
			usuario.setCliente(txtCliente.getText());
			usuario.setSenha(txtSenha.getSelectedText());
			u.atualizar(usuario);
			tabelaUsuarios.atualizarLista(indice, usuario);
			limpar();
			indice = -1;
		} else {
			JOptionPane.showMessageDialog(null,
					"Você deve selecionar um Usuário para editar!");
		}
	}

	protected void deletar() {
		u.excluir(listaU.get(table.getSelectedRow()).getId());
		tabelaUsuarios.deletar(table.getSelectedRow());
	}

	public void returnUsuarios(Usuarios u) {
		txtIdUsuario.setText(String.valueOf(u.getId()));
		txtIdCliente.setText(String.valueOf(u.getIdCliente()));
		txtCliente.setText(u.getCliente());
		txtSenha.setText(u.getSenha());
	}

	public void limpar() {
		txtIdUsuario.setText("");
		txtIdCliente.setText("");
		txtCliente.setText("");
		txtSenha.setText("");;
	}


}
