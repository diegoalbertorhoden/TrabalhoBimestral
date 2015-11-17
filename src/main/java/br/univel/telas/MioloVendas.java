package br.univel.telas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.univel.banco.ClienteDaoImplementacao;
import br.univel.banco.ProdutoDaoImplementacao;
import br.univel.banco.VendaDaoImplementacao;
import br.univel.classes.Clientes;
import br.univel.classes.Produtos;
import br.univel.classes.Vendas;
import br.univel.tabelas.TabelaVendas;

@SuppressWarnings("serial")
public class MioloVendas extends JPanel {
	private JTextField txtTotal;
	private JTextField txtPago;
	private JTextField txtTroco;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtCodigoVenda;
	private JComboBox<String> cbClientes;
	private JComboBox<String> cbProdutos;
	private JTable table;

	private TabelaVendas tableVenda;
	private VendaDaoImplementacao v = new VendaDaoImplementacao();
	private List<Vendas> listaDeVendas = new ArrayList<>();
	protected int indice = -1;

	private List<Clientes> listaCliente = new ArrayList<Clientes>();
	private List<Produtos> listaProduto = new ArrayList<Produtos>();

	@SuppressWarnings("deprecation")
	public MioloVendas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 77, 0, 96, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCodigo = new JLabel("C\u00D3D da VENDA: ");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 1;
		add(lblCodigo, gbc_lblCodigo);

		txtCodigoVenda = new JTextField();
		GridBagConstraints gbc_txtCodigoVenda = new GridBagConstraints();
		gbc_txtCodigoVenda.ipadx = 99;
		gbc_txtCodigoVenda.anchor = GridBagConstraints.WEST;
		gbc_txtCodigoVenda.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigoVenda.gridx = 1;
		gbc_txtCodigoVenda.gridy = 1;
		add(txtCodigoVenda, gbc_txtCodigoVenda);
		txtCodigoVenda.setColumns(10);
		txtCodigoVenda.enable(false);

		JLabel lblCliente = new JLabel("CLIENTE: ");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 2;
		add(lblCliente, gbc_lblCliente);

		cbClientes = new JComboBox<String>();
		GridBagConstraints gbc_cbClientes = new GridBagConstraints();
		gbc_cbClientes.gridwidth = 3;
		gbc_cbClientes.insets = new Insets(0, 0, 5, 0);
		gbc_cbClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbClientes.gridx = 1;
		gbc_cbClientes.gridy = 2;
		add(cbClientes, gbc_cbClientes);

		JLabel lblProduto = new JLabel("PRODUTO: ");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.EAST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 3;
		add(lblProduto, gbc_lblProduto);

		cbProdutos = new JComboBox<String>();
		
		cbProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
//					acaoComboBox();
				}
			}
		});
		GridBagConstraints gbc_cbProdutos = new GridBagConstraints();
		gbc_cbProdutos.gridwidth = 3;
		gbc_cbProdutos.insets = new Insets(0, 0, 5, 0);
		gbc_cbProdutos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbProdutos.gridx = 1;
		gbc_cbProdutos.gridy = 3;
		add(cbProdutos, gbc_cbProdutos);

		JLabel lblTotal = new JLabel("VALOR TOTAL: ");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 4;
		add(lblTotal, gbc_lblTotal);

		txtTotal = new JTextField();
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.gridwidth = 3;
		gbc_txtTotal.insets = new Insets(0, 0, 5, 0);
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.gridx = 1;
		gbc_txtTotal.gridy = 4;
		add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);

		JLabel lblPago = new JLabel("VALOR PAGO: ");
		GridBagConstraints gbc_lblPago = new GridBagConstraints();
		gbc_lblPago.anchor = GridBagConstraints.EAST;
		gbc_lblPago.insets = new Insets(0, 0, 5, 5);
		gbc_lblPago.gridx = 0;
		gbc_lblPago.gridy = 5;
		add(lblPago, gbc_lblPago);

		txtPago = new JTextField();
		GridBagConstraints gbc_txtPago = new GridBagConstraints();
		gbc_txtPago.gridwidth = 3;
		gbc_txtPago.insets = new Insets(0, 0, 5, 0);
		gbc_txtPago.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPago.gridx = 1;
		gbc_txtPago.gridy = 5;
		add(txtPago, gbc_txtPago);
		txtPago.setColumns(10);

		JLabel lblTroco = new JLabel("TROCO: ");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.EAST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 0;
		gbc_lblTroco.gridy = 6;
		add(lblTroco, gbc_lblTroco);

		txtTroco = new JTextField();
		GridBagConstraints gbc_txtTroco = new GridBagConstraints();
		gbc_txtTroco.gridwidth = 3;
		gbc_txtTroco.insets = new Insets(0, 0, 5, 0);
		gbc_txtTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTroco.gridx = 1;
		gbc_txtTroco.gridy = 6;
		add(txtTroco, gbc_txtTroco);
		txtTroco.setColumns(10);

		JLabel lblData = new JLabel("DATA: ");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 7;
		add(lblData, gbc_lblData);

		txtData = new JTextField();
		GridBagConstraints gbc_txtData = new GridBagConstraints();
		gbc_txtData.anchor = GridBagConstraints.WEST;
		gbc_txtData.ipadx = 99;
		gbc_txtData.insets = new Insets(0, 0, 5, 5);
		gbc_txtData.gridx = 1;
		gbc_txtData.gridy = 7;
		add(txtData, gbc_txtData);
		txtData.setColumns(10);

		JLabel lblHoras = new JLabel("HORAS:");
		GridBagConstraints gbc_lblHoras = new GridBagConstraints();
		gbc_lblHoras.anchor = GridBagConstraints.EAST;
		gbc_lblHoras.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoras.gridx = 0;
		gbc_lblHoras.gridy = 8;
		add(lblHoras, gbc_lblHoras);

		JButton btnFazerVenda = new JButton("EFETUAR VENDA");
		btnFazerVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});

		txtHora = new JTextField();
		GridBagConstraints gbc_txtHora = new GridBagConstraints();
		gbc_txtHora.anchor = GridBagConstraints.WEST;
		gbc_txtHora.ipadx = 99;
		gbc_txtHora.insets = new Insets(0, 0, 5, 5);
		gbc_txtHora.gridx = 1;
		gbc_txtHora.gridy = 8;
		add(txtHora, gbc_txtHora);
		txtHora.setColumns(10);
		GridBagConstraints gbc_btnFazerVenda = new GridBagConstraints();
		gbc_btnFazerVenda.anchor = GridBagConstraints.EAST;
		gbc_btnFazerVenda.insets = new Insets(0, 0, 5, 5);
		gbc_btnFazerVenda.gridx = 1;
		gbc_btnFazerVenda.gridy = 9;
		add(btnFazerVenda, gbc_btnFazerVenda);

		JButton btnAlterarVenda = new JButton("ALTERAR");
		btnAlterarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		GridBagConstraints gbc_btnAlterarVenda = new GridBagConstraints();
		gbc_btnAlterarVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAlterarVenda.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlterarVenda.gridx = 2;
		gbc_btnAlterarVenda.gridy = 9;
		add(btnAlterarVenda, gbc_btnAlterarVenda);

		JButton btnDeletarVenda = new JButton("DELETAR");
		btnDeletarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		GridBagConstraints gbc_btnDeletarVenda = new GridBagConstraints();
		gbc_btnDeletarVenda.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeletarVenda.gridx = 3;
		gbc_btnDeletarVenda.gridy = 9;
		add(btnDeletarVenda, gbc_btnDeletarVenda);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Vendas vd = listaDeVendas.get(table.getSelectedRow());
					returnVenda(vd);
					indice = table.getSelectedRow();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		listaDeVenda();
		
		listaClienteProduto();
		
		rDataTime();
	}

	public void listaDeVenda() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tableVenda = new TabelaVendas();
				listaDeVendas = tableVenda.listar();
				table.setModel(tableVenda);
			}
		}).start();
	}

	protected void cadastrar() {
		Vendas vendas;
//		try {
//			vendas = new Vendas(
//					listaCliente.get(cbClientes.getSelectedIndex() - 1)
//							.getId(),
//					listaProduto.get(cbProdutos.getSelectedIndex() - 1)
//							.getCod(),
//					String.valueOf(cbClientes.getSelectedItem()),
//					String.valueOf(cbProdutos.getSelectedItem()),
//					new TratarException().tratarBigDecimal(txtTotal.getText()),
//					new TratarException().tratarBigDecimal(txtPago.getText()),
//					new TratarException().tratarBigDecimal(txtTroco.getText()),
//					txtData.getText(), txtHora.getText());
//			v.inserir(vendas);
//			listaDeVendas = v.listar();
//			tableVenda.adicionarLista(listaDeVendas);
//			limpar();
//		} catch (ParseException e) {
//			JOptionPane.showMessageDialog(null, "Erro com valor digitado!");
//		} catch (NumberFormatException e) {
//			JOptionPane.showMessageDialog(null,
//					"Digite somete números e não letras");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	protected void atualizar() {
//		if (indice > -1) {
//			try {
//				Vendas vendas = new Vendas(
//						Integer.parseInt(txtCodigoVenda.getText()),
//						listaCliente.get(cbClientes.getSelectedIndex() - 1)
//								.getId(),
//						listaProduto.get(cbProdutos.getSelectedIndex() - 1)
//								.getCod(),
//						String.valueOf(cbClientes.getSelectedItem()),
//						String.valueOf(cbProdutos.getSelectedItem()),
//						new TratarException().tratarBigDecimal(txtTotal.getText()),
//						new TratarException().tratarBigDecimal(txtPago.getText()),
//						new TratarException().tratarBigDecimal(txtTroco.getText()),
//						txtData.getText(), txtHora.getText());
//				v.inserir(vendas);
//				listaDeVendas = v.listar();
//				tableVenda.adicionarLista(listaDeVendas);
//				limpar();
//				indice = -1;
//			} catch (ParseException e) {
//				JOptionPane.showMessageDialog(null, "Erro com valor digitado!");
//			} catch (NumberFormatException e) {
//				JOptionPane.showMessageDialog(null,
//						"Digite somete números e não letras");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			JOptionPane.showMessageDialog(null,
//					"De um duplo click na tabela venda para poder atualizar!");
//		}
	}

	private void deletar() {
//		v.deletar(listaDeVendas.get(table.getSelectedRow()).getCod_p());
//		tableVenda.deletar(table.getSelectedRow());
	}

	private void returnVenda(Vendas v) {
//		txtCodigoVenda.setText(String.valueOf(v.getCod_v()));
		cbClientes.setSelectedItem(v.getCliente());
		cbProdutos.setSelectedItem(v.getProduto());
		txtTotal.setText(String.valueOf(v.getSubTotal()));
		txtPago.setText(String.valueOf(v.getValorPago()));
		txtTroco.setText(String.valueOf(v.getTroco()));
		txtData.setText(v.getData());
		txtHora.setText(v.getHora());
	}

	private void limpar() {
		txtCodigoVenda.setText("");
		cbClientes.setSelectedIndex(0);
		cbProdutos.setSelectedIndex(0);
		txtTotal.setText("");
		txtPago.setText("");
		txtTroco.setText("");
		rDataTime();
	}

	private void listaClienteProduto() {
		ClienteDaoImplementacao dc = new ClienteDaoImplementacao();
		listaCliente = dc.listar();
		ProdutoDaoImplementacao dp = new ProdutoDaoImplementacao();
		listaProduto = dp.listar();
		int contador = 0;
		for (Clientes c : listaCliente) {
			if (contador == 0) {
				contador = 1;
				cbClientes.addItem("");
			}
			cbClientes.addItem(c.getNome());
		}
		contador = 0;
		for (Produtos p : listaProduto) {
			if (contador == 0) {
				contador = 1;
				cbProdutos.addItem("");
			}
			cbProdutos.addItem(p.getDescricao());
		}
	}
//	protected void acaoComboBox() {
//		try {
//			
////////			double vt = listaProduto.get(cbProdutos.getSelectedIndex() - 1) .CalcularMarLucrP();
//////			txtTotal.setText(String.valueOf(vt));
//////			double vp = Double.valueOf(JOptionPane.showInputDialog("Digite o valor do pagamento ?"));
//////			if (vp >= vt) {
//////				double troco = vp - vt;
////				txtPago.setText(String.valueOf(vp));
////				
////				BigDecimal bd = new BigDecimal(troco).setScale(2, RoundingMode.HALF_EVEN);
////				txtTroco.setText(bd.toString());
////			} else {
////				JOptionPane.showMessageDialog(null,
////						"Valor recebido é menor que o preço de custo do produto");
////			}
////
////		} catch (Exception e) {
////			JOptionPane
////					.showMessageDialog(null,
////							"O valor digitado deve ser número ou com ponto\nEX: 50 ou 21.25");
////		}
////
//	}

	private void rDataTime() {
		SimpleDateFormat frm = new SimpleDateFormat("dd/MM/yyyy");
		txtData.setText(frm.format(new java.util.Date()));

		Calendar hora = Calendar.getInstance();
		txtHora.setText(String.format("%1$tH:%tM:%1$tS", hora));
	}

}
