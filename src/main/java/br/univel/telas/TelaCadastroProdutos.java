package br.univel.telas;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TelaCadastroProdutos extends JPanel {
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtDepartamento;
	private JTextField txtCusto;
	private JTextField txtMarkup;

	public TelaCadastroProdutos() {
		setLayout(null);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroDeProdutos.setBounds(132, 0, 183, 31);
		add(lblCadastroDeProdutos);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(183, 74, 11, 14);
		add(lblNewLabel);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(148, 105, 46, 14);
		add(lblDescrio);

		txtId = new JTextField();
		txtId.setBounds(204, 71, 46, 20);
		add(txtId);
		txtId.setColumns(10);


		txtDescricao = new JTextField();
		txtDescricao.setBounds(204, 102, 208, 20);
		add(txtDescricao);
		txtDescricao.setColumns(10);
		txtDescricao.setEnabled(false);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(125, 133, 69, 14);
		add(lblDepartamento);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(155, 164, 39, 14);
		add(lblUnidade);

		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setBounds(166, 195, 28, 14);
		add(lblCusto);

		JLabel lblMarkup = new JLabel("Markup");
		lblMarkup.setBounds(159, 229, 35, 14);
		add(lblMarkup);

		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(204, 133, 114, 20);
		add(txtDepartamento);
		txtDepartamento.setColumns(10);
		txtDepartamento.setEnabled(false);

		txtCusto = new JTextField();
		txtCusto.setBounds(204, 195, 86, 20);
		add(txtCusto);
		txtCusto.setColumns(10);
		txtCusto.setEnabled(false);

		txtMarkup = new JTextField();
		txtMarkup.setBounds(204, 226, 86, 20);
		add(txtMarkup);
		txtMarkup.setColumns(10);
		txtMarkup.setEnabled(false);

		JComboBox cbUnidade = new JComboBox();
		cbUnidade.setBounds(205, 164, 39, 20);
		add(cbUnidade);
		cbUnidade.setEnabled(false);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(226, 264, 89, 23);
		add(btnSalvar);
		btnSalvar.setEnabled(false);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(142, 266, 76, 23);
		add(btnLimpar);

		JButton btnNovoCadastro = new JButton("Novo");
		btnNovoCadastro.setBounds(104, 42, 80, 23);
		add(btnNovoCadastro);

		JButton btnExcluirCadastro = new JButton("Excluir");
		btnExcluirCadastro.setBounds(184, 42, 80, 23);
		add(btnExcluirCadastro);
		btnExcluirCadastro.setEnabled(false);

		JButton btnEditarCadastro = new JButton("Editar");
		btnEditarCadastro.setBounds(262, 42, 80, 23);
		add(btnEditarCadastro);
		btnEditarCadastro.setEnabled(false);

		SwingUtilities.invokeLater(new Runnable() {  
			public void run() {  
				txtId.requestFocus();  
			}  
		}); 

	}
}