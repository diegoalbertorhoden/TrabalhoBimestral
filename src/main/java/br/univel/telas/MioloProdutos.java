package br.univel.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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

import br.univel.classes.Produtos;
import br.univel.classes.TratamentoException;
import br.univel.tabelas.TabelaProdutos;

@SuppressWarnings("serial")
public class MioloProdutos extends JPanel {
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtDepartamento;
	private JTextField txtCusto;
	private JTextField txtMarkup;
	private JTable table;
	private JComboBox<String> cbUnidade;
	
	private TabelaProdutos tabelaProdutos;
//	private ProdutoDaoImplementacao p = new ProdutoDaoImplementacao();
	private List<Produtos> listaP = new ArrayList<>();
	private int indice = -1;

	public MioloProdutos() {
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

		this.cbUnidade = new JComboBox();
		cbUnidade.setBounds(205, 145, 59, 20);
		add(cbUnidade);
		cbUnidade.setEnabled(false);

		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(226, 219, 89, 23);
		add(btnSalvar);
		btnSalvar.setEnabled(false);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
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
			@Override
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

				// // carrega as unidades no combobox diretamente da Enum
				// Unidade[] unidades = Unidade.values();
				// ComboBoxModel cbmodel = new DefaultComboBoxModel(unidades);
				// cbUnidade.setModel(cbmodel);
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

		table = new JTable();
		scrollPane.setViewportView(table);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				txtId.requestFocus();
			}
		});

	}

	protected void cadastrar() {
		try {
			Produtos produtos = new Produtos(
					Integer.parseInt(txtBarras.getText()),
					txtCategoria.getText(),
					txtUnidade.getText(),
					new TratamentoException().tratamentoBigDecimal(txtCusto.getText()),
					new TratamentoException().tratamentoBigDecimal(txtMargem.getText()));
			p.inserir(produtos);
			listaP = p.listar();
			tableProduto.adicionarLista(listaP);
			limpar();
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Valor digitado incorreto!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Campo somente para n�meros");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void limpar() {
		// TODO Auto-generated method stub
		
	}
}