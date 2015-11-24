package br.univel.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

import br.univel.banco.ProdutoDaoImplementacao;
import br.univel.classes.Produtos;
import br.univel.classes.TratamentoException;
import br.univel.classes.Unidade;
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
	private ProdutoDaoImplementacao p = new ProdutoDaoImplementacao();
	private List<Produtos> listaP = new ArrayList<>();
	private int indice = -1;
	private JTextField txtBarras;

	public MioloProdutos() {
		setLayout(null);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroDeProdutos.setBounds(322, 0, 183, 31);
		add(lblCadastroDeProdutos);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(246, 73, 90, 14);
		add(lblNewLabel);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(246, 120, 90, 14);
		add(lblDescrio);

		txtId = new JTextField();
		txtId.setBounds(346, 70, 208, 20);
		add(txtId);
		txtId.setColumns(10);
		txtId.setEnabled(false);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(346, 118, 208, 20);
		add(txtDescricao);
		txtDescricao.setColumns(10);
		txtDescricao.setEnabled(false);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartamento.setBounds(246, 146, 90, 14);
		add(lblDepartamento);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnidade.setBounds(246, 171, 90, 14);
		add(lblUnidade);

		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCusto.setBounds(246, 197, 90, 14);
		add(lblCusto);

		JLabel lblMarkup = new JLabel("Markup");
		lblMarkup.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarkup.setBounds(246, 221, 90, 14);
		add(lblMarkup);

		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(346, 143, 208, 20);
		add(txtDepartamento);
		txtDepartamento.setColumns(10);
		txtDepartamento.setEnabled(false);

		txtCusto = new JTextField();
		txtCusto.setBounds(346, 193, 208, 20);
		add(txtCusto);
		txtCusto.setColumns(10);
		txtCusto.setEnabled(false);

		txtMarkup = new JTextField();
		txtMarkup.setBounds(346, 218, 208, 20);
		add(txtMarkup);
		txtMarkup.setColumns(10);
		txtMarkup.setEnabled(false);
		
		txtBarras = new JTextField();
		txtBarras.setBounds(346, 94, 208, 20);
		add(txtBarras);
		txtBarras.setColumns(10);
		txtBarras.setEnabled(false);

		this.cbUnidade = new JComboBox(Unidade.values());
		cbUnidade.setBounds(347, 168, 208, 20);
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
		btnSalvar.setBounds(398, 249, 125, 35);
		add(btnSalvar);
		btnSalvar.setEnabled(false);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setBounds(286, 246, 76, 23);
		add(btnLimpar);

		final JButton btnExcluirCadastro = new JButton("Excluir");
		btnExcluirCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar();
			}
		});
		btnExcluirCadastro.setBounds(416, 29, 118, 30);
		add(btnExcluirCadastro);
		btnExcluirCadastro.setEnabled(true);

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
				txtBarras.setEnabled(true);
				txtBarras.requestFocus();
				btnSalvar.setEnabled(true);
				btnNovoCadastro.setEnabled(false);
				btnExcluirCadastro.setEnabled(false);
			}
		});
		btnNovoCadastro.setBounds(286, 29, 118, 31);
		add(btnNovoCadastro);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 295, 816, 308);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		listaDeProdutos();

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		lblCdigoDeBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoDeBarras.setBounds(233, 96, 103, 14);
		add(lblCdigoDeBarras);

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
					txtDescricao.getText(),
					txtDepartamento.getText(),
					cbUnidade.getSelectedItem().toString(), 
					new TratamentoException().tratamentoBigDecimal(txtCusto.getText()),
					new TratamentoException().tratamentoBigDecimal(txtMarkup.getText()));
			p.inserir(produtos);
			listaP = p.listar();
			tabelaProdutos.adicionarLista(listaP);
			limpar();
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Valor digitado incorreto!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Campo somente para números");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deletar() {
		p.excluir(listaP.get(table.getSelectedRow()).getId());
		tabelaProdutos.excluir(table.getSelectedRow());		
	}
	
		
	public void listaDeProdutos() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tabelaProdutos = new TabelaProdutos();
				listaP = tabelaProdutos.listar();
				table.setModel(tabelaProdutos);
			}
		}).start();
	}
	
	protected void atualizar() {
		if (indice > -1) {
			try {
				Produtos produtos = new Produtos(Integer.parseInt(txtId.getText()),
											  Integer.parseInt(txtBarras.getText()),
											  txtDescricao.getText(),
											  txtDepartamento.getText(),
											  cbUnidade.getSelectedItem().toString(),
											  new TratamentoException().tratamentoBigDecimal(txtCusto.getText()),
											  new TratamentoException().tratamentoBigDecimal(txtMarkup.getText()));
				p.atualizar(produtos);
				tabelaProdutos.atualizarLista(indice, produtos);
				limpar();
				indice = -1;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,"Erro com valor digitado!");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Digite somente números e não letras");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null,"De um duplo click no produtos que deseja alterar!");
		}
	}
	
	public void returnProduto(Produtos p) {
		txtId.setText(String.valueOf(p.getId()));
		txtBarras.setText(String.valueOf(p.getBarras()));
		txtDescricao.setText(p.getDescricao());
		txtDepartamento.setText(p.getDepartamento());
		cbUnidade.getSelectedItem().toString();
		txtCusto.setText(new BigDecimal(p.getCusto().toString()).setScale(2, RoundingMode.HALF_EVEN).toString());
		txtMarkup.setText(String.valueOf(p.getMargem()));
	}

	private void limpar() {
		txtDescricao.setText("");
		txtBarras.requestFocus();
		txtDepartamento.setText("");
		txtCusto.setText("");
		txtMarkup.setText("");
		txtBarras.setText("");
	}
}