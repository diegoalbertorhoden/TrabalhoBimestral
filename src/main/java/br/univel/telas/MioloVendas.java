package br.univel.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import javax.swing.SwingConstants;

import br.univel.banco.ClienteDaoImplementacao;
import br.univel.banco.ProdutoDaoImplementacao;
import br.univel.banco.VendaDaoImplementacao;
import br.univel.classes.Clientes;
import br.univel.classes.Produtos;
import br.univel.classes.TratamentoException;
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

	private TabelaVendas tabelaVendas;
	private VendaDaoImplementacao v = new VendaDaoImplementacao();
	private List<Vendas> listarVendas = new ArrayList<>();
	protected int indice = -1;

	private List<Clientes> listaCliente = new ArrayList<Clientes>();
	private List<Produtos> listaProduto = new ArrayList<Produtos>();

	@SuppressWarnings("deprecation")
	public MioloVendas() {
		setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo da Venda:");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(240, 30, 105, 14);
		add(lblCodigo);

		txtCodigoVenda = new JTextField();
		txtCodigoVenda.setBounds(355, 30, 105, 20);
		add(txtCodigoVenda);
		txtCodigoVenda.setColumns(10);
		txtCodigoVenda.enable(false);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setBounds(240, 55, 105, 14);
		add(lblCliente);

		cbClientes = new JComboBox<String>();
		cbClientes.setBounds(356, 52, 328, 20);
		add(cbClientes);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProduto.setBounds(240, 80, 105, 14);
		add(lblProduto);

		cbProdutos = new JComboBox<String>();
		cbProdutos.setBounds(356, 77, 328, 20);

		cbProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					acaoComboBox();
				}
			}
		});
		add(cbProdutos);

		JLabel lblTotal = new JLabel("Valor Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(240, 105, 105, 14);
		add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setBounds(356, 102, 328, 20);
		add(txtTotal);
		txtTotal.setColumns(10);

		JLabel lblPago = new JLabel("Valor Pago:");
		lblPago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPago.setBounds(240, 130, 105, 14);
		add(lblPago);

		txtPago = new JTextField();
		txtPago.setBounds(356, 127, 328, 20);
		add(txtPago);
		txtPago.setColumns(10);

		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTroco.setBounds(240, 155, 105, 14);
		add(lblTroco);

		txtTroco = new JTextField();
		txtTroco.setBounds(356, 152, 328, 20);
		add(txtTroco);
		txtTroco.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setBounds(240, 180, 105, 14);
		add(lblData);

		txtData = new JTextField();
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setBounds(355, 177, 176, 20);
		add(txtData);
		txtData.setColumns(10);

		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoras.setBounds(240, 205, 105, 14);
		add(lblHoras);

		JButton btnFazerVenda = new JButton("Concluir");
		btnFazerVenda.setBounds(541, 183, 143, 64);
		btnFazerVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});

		txtHora = new JTextField();
		txtHora.setHorizontalAlignment(SwingConstants.CENTER);
		txtHora.setBounds(355, 202, 176, 20);
		add(txtHora);
		txtHora.setColumns(10);
		add(btnFazerVenda);

		JButton btnAlterarVenda = new JButton("Edi\u00E7\u00E3o");
		btnAlterarVenda.setBounds(428, 224, 105, 23);
		btnAlterarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		add(btnAlterarVenda);

		JButton btnDeletarVenda = new JButton("Excluir");
		btnDeletarVenda.setBounds(313, 224, 105, 23);
		btnDeletarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		add(btnDeletarVenda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 258, 900, 350);
		add(scrollPane);

		table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Vendas vd = listarVendas.get(table.getSelectedRow());
					returnVenda(vd);
					indice = table.getSelectedRow();
				}
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Vendas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(365, 0, 113, 25);
		add(lblNewLabel);

		listaDeVendas();

		listaClienteProduto();

		rDataTime();

		txtTotal.setEnabled(false);
		txtPago.setEnabled(false);
		txtTroco.setEnabled(false);
	}

	public void listaDeVendas() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tabelaVendas = new TabelaVendas();
				listarVendas = tabelaVendas.listar();
				table.setModel(tabelaVendas);
			}
		}).start();
	}

	protected void cadastrar() {

		try {
			Vendas vendas = new Vendas(
					listaCliente.get(cbClientes.getSelectedIndex() - 1)
					.getId(),
					listaProduto.get(cbProdutos.getSelectedIndex() - 1)
					.getId(),
					String.valueOf(cbClientes.getSelectedItem()),
					String.valueOf(cbProdutos.getSelectedItem()),
					new TratamentoException().tratamentoBigDecimal(txtTotal.getText()),
					new TratamentoException().tratamentoBigDecimal(txtPago.getText()),
					new TratamentoException().tratamentoBigDecimal(txtTroco.getText()),
					txtData.getText(), txtHora.getText());
			v.inserir(vendas);
			listarVendas = v.listar();
			tabelaVendas.adicionarLista(listarVendas);
			limpar();
			JOptionPane.showMessageDialog(null, "Venda Concretizada!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	protected void atualizar() {
		if (indice > -1) {
			try {
				Vendas vendas = new Vendas(
						Integer.parseInt(txtCodigoVenda.getText()),
						listaCliente.get(cbClientes.getSelectedIndex() - 1)
						.getId(),
						listaProduto.get(cbProdutos.getSelectedIndex() - 1)
						.getId(),
						String.valueOf(cbClientes.getSelectedItem()),
						String.valueOf(cbProdutos.getSelectedItem()),
						new TratamentoException().tratamentoBigDecimal(txtTotal.getText()),
						new TratamentoException().tratamentoBigDecimal(txtPago.getText()),
						new TratamentoException().tratamentoBigDecimal(txtTroco.getText()),
						txtData.getText(), txtHora.getText());
				v.inserir(vendas);
				listarVendas = v.listar();
				tabelaVendas.adicionarLista(listarVendas);
				JOptionPane.showMessageDialog(null, "Venda alterada!");
				limpar();				
				indice = -1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Clique duas vezes no item da tabela para atualizar!");
		}
	}

	private void deletar() {
		v.excluir(listarVendas.get(table.getSelectedRow()).getCod_p());
		tabelaVendas.excluir(table.getSelectedRow());
	}

	private void returnVenda(Vendas v) {
		txtCodigoVenda.setText(String.valueOf(v.getCod_v()));
		cbClientes.setSelectedItem(v.getCliente());
		cbProdutos.setSelectedItem(v.getProduto());
		txtTotal.setText(String.valueOf(v.getSubTotal()));
		txtPago.setText(String.valueOf(v.getValorPago()));
		txtTroco.setText(String.valueOf(v.getTroco()));
		txtData.setText(v.getData());
		txtHora.setText(v.getHora());
		txtCodigoVenda.setEnabled(true);
		txtCodigoVenda.setEditable(false);
		txtData.setEnabled(true);
		txtHora.setEnabled(true);
		txtData.setEditable(true);
		txtHora.setEditable(true);
		mostrarbotoes();


	}

	private void mostrarbotoes() {
		txtTotal.setEnabled(true);
		txtPago.setEnabled(true);
		txtTroco.setEnabled(true);
		txtTotal.setEditable(false);
		txtPago.setEditable(false);
		txtTroco.setEditable(false);

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
	protected void acaoComboBox() {
		try {

			double vt = listaProduto.get(cbProdutos.getSelectedIndex() - 1) .CalcularMarLucrP();
			txtTotal.setText(String.valueOf(vt));
			double vp = Double.valueOf(JOptionPane.showInputDialog("Digite o valor do pagamento ?"));
			if (vp >= vt) {
				double troco = vp - vt;
				txtPago.setText(String.valueOf(vp));

				BigDecimal bd = new BigDecimal(troco).setScale(2, RoundingMode.HALF_EVEN);
				txtTroco.setText(bd.toString());
			} else {
				JOptionPane.showMessageDialog(null,
						"Valor recebido é menor que o preço de custo do produto");
			}
			mostrarbotoes();
		} catch (Exception e) {
			JOptionPane
			.showMessageDialog(null,
					"O valor digitado deve ser número ou com ponto\nEX: 50 ou 21.25");
		}
	}

	private void rDataTime() {
		SimpleDateFormat frm = new SimpleDateFormat("dd/MM/yyyy");
		txtData.setText(frm.format(new java.util.Date()));

		Calendar hora = Calendar.getInstance();
		txtHora.setText(String.format("%1$tH:%tM:%1$tS", hora));
	}
}