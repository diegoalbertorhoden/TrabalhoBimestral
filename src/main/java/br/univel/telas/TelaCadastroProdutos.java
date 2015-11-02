package br.univel.telas;

import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import br.univel.Genero;
import br.univel.Unidade;

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
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(104, 74, 90, 14);
		add(lblNewLabel);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(104, 97, 90, 14);
		add(lblDescrio);

		txtId = new JTextField();
		txtId.setBounds(204, 71, 46, 20);
		add(txtId);
		txtId.setColumns(10);


		txtDescricao = new JTextField();
		txtDescricao.setBounds(204, 95, 208, 20);
		add(txtDescricao);
		txtDescricao.setColumns(10);
		txtDescricao.setEnabled(false);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartamento.setBounds(104, 123, 90, 14);
		add(lblDepartamento);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnidade.setBounds(104, 148, 90, 14);
		add(lblUnidade);

		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCusto.setBounds(104, 174, 90, 14);
		add(lblCusto);

		JLabel lblMarkup = new JLabel("Markup");
		lblMarkup.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarkup.setBounds(104, 198, 90, 14);
		add(lblMarkup);

		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(204, 120, 114, 20);
		add(txtDepartamento);
		txtDepartamento.setColumns(10);
		txtDepartamento.setEnabled(false);

		txtCusto = new JTextField();
		txtCusto.setBounds(204, 170, 86, 20);
		add(txtCusto);
		txtCusto.setColumns(10);
		txtCusto.setEnabled(false);

		txtMarkup = new JTextField();
		txtMarkup.setBounds(204, 195, 86, 20);
		add(txtMarkup);
		txtMarkup.setColumns(10);
		txtMarkup.setEnabled(false);

		final JComboBox cbUnidade = new JComboBox();
		cbUnidade.setBounds(205, 145, 59, 20);
		add(cbUnidade);
		cbUnidade.setEnabled(false);

		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(226, 219, 89, 23);
		add(btnSalvar);
		btnSalvar.setEnabled(false);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtDescricao.setText("");
				txtDescricao.requestFocus();
				txtDepartamento.setText("");
				txtCusto.setText("");
				txtMarkup.setText("");
	
			}
		});
		btnLimpar.setBounds(142, 218, 76, 23);
		add(btnLimpar);

		final JButton btnNovoCadastro = new JButton("Novo");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cbUnidade.setEnabled(true);
				txtDepartamento.setEnabled(true);
				txtDescricao.setEnabled(true);
				txtCusto.setEnabled(true);
				txtMarkup.setEnabled(true);
				txtId.setEnabled(false);
				txtDescricao.requestFocus();
				btnSalvar.setEnabled(true);
				btnNovoCadastro.setEnabled(false);
//				carrega as unidades no combobox diretamente da Enum
				Unidade[] unidades = Unidade.values();  
			      ComboBoxModel cbmodel = new DefaultComboBoxModel(unidades);  
			      cbUnidade.setModel(cbmodel);
				
				
			}
		});
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 253, 415, 207);
		add(scrollPane);

		SwingUtilities.invokeLater(new Runnable() {  
			public void run() {  
				txtId.requestFocus();  
			}  
		}); 

	}
}