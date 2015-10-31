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
import javax.swing.JComboBox;

public class TelaCadastroProdutos extends JPanel {
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtDepartamento;
	private JTextField txtCusto;
	private JTextField txtMarkup;

	/**
	 * Create the panel.
	 */
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
		
		txtCusto = new JTextField();
		txtCusto.setBounds(204, 195, 86, 20);
		add(txtCusto);
		txtCusto.setColumns(10);
		
		txtMarkup = new JTextField();
		txtMarkup.setBounds(204, 226, 86, 20);
		add(txtMarkup);
		txtMarkup.setColumns(10);
		
		JComboBox cbUnidade = new JComboBox();
		cbUnidade.setBounds(205, 164, 39, 20);
		add(cbUnidade);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(218, 265, 89, 23);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(132, 266, 76, 23);
		add(btnLimpar);
		
		JButton btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.setBounds(52, 42, 110, 23);
		add(btnNovoCadastro);
		
		JButton btnExcluirCadastro = new JButton("Excluir Cadastro");
		btnExcluirCadastro.setBounds(167, 42, 114, 23);
		add(btnExcluirCadastro);
		
		JButton btnEditarCadastro = new JButton("Editar Cadastro");
		btnEditarCadastro.setBounds(286, 42, 110, 23);
		add(btnEditarCadastro);

	}
}
