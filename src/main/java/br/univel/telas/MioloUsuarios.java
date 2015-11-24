package br.univel.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private JButton btnDeletar;
	private JTable table;

	private TabelaUsuarios tabelaUsuarios;
	private UsuarioDaoImplementacao u = new UsuarioDaoImplementacao();
	private List<Usuarios> listaU = new ArrayList<>();
	private int indice = -1;
	private JLabel lblCadastroDeUsurios;

	@SuppressWarnings("deprecation")
	public MioloUsuarios() {
		setLayout(null);
		
		lblCadastroDeUsurios = new JLabel("Cadastro de Usu\u00E1rios");
		lblCadastroDeUsurios.setBounds(313, 0, 211, 23);
		lblCadastroDeUsurios.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblCadastroDeUsurios);

		JLabel lblId = new JLabel("Id do Usu\u00E1rio:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(247, 25, 82, 14);
		add(lblId);

		txtIdUsuario = new JTextField();
		txtIdUsuario.setBounds(334, 22, 190, 20);
		add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		txtIdUsuario.enable(false);

		JLabel lblIdCliente = new JLabel("Id do Cliente:");
		lblIdCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdCliente.setBounds(252, 50, 77, 14);
		add(lblIdCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(334, 47, 190, 20);
		add(txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblEndereco = new JLabel("Cliente:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setBounds(288, 75, 41, 14);
		add(lblEndereco);

		txtCliente = new JTextField();
		txtCliente.setBounds(334, 72, 190, 20);
		add(txtCliente);
		txtCliente.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(289, 100, 40, 14);
		add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(334, 97, 190, 20);
		add(txtSenha);

		btnCadastrar = new JButton("Salvar");
		btnCadastrar.setBounds(414, 119, 110, 32);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		add(btnCadastrar);

		btnDeletar = new JButton("Excluir");
		btnDeletar.setBounds(299, 125, 77, 23);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		add(btnDeletar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 150, 884, 426);
		add(scrollPane);

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
