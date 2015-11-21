package br.univel.relatorios;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.banco.RelatoriosDao;
import br.univel.classes.Vendas;
import br.univel.tabelas.TabelaVendas;

public class RelatorioVendas extends JPanel {

	private JTextField txtCliente;
	private JTable table;
	private JComboBox<Object> cb_dia;
	private JComboBox<Object> cb_mes;
	private JComboBox<Object> cbDepto;
	
	private List<Vendas> listaV;
	private TabelaVendas tabelaModelo;

	public RelatorioVendas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{224, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 50, 0, 50, 0, 100, 0, 150, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel(" DIA: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		cb_dia = new JComboBox<>();
		GridBagConstraints gbc_cb_dia = new GridBagConstraints();
		gbc_cb_dia.insets = new Insets(0, 0, 5, 5);
		gbc_cb_dia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_dia.gridx = 1;
		gbc_cb_dia.gridy = 0;
		panel.add(cb_dia, gbc_cb_dia);
		
		JLabel lblNewLabel_1 = new JLabel("  M\u00CAS: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cb_mes = new JComboBox<>();
		GridBagConstraints gbc_cb_mes = new GridBagConstraints();
		gbc_cb_mes.insets = new Insets(0, 0, 5, 5);
		gbc_cb_mes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_mes.gridx = 3;
		gbc_cb_mes.gridy = 0;
		panel.add(cb_mes, gbc_cb_mes);
		
		JLabel lblDepartamentoDoProduto = new JLabel("  DEPARTAMENTO DO PRODUTO: ");
		GridBagConstraints gbc_lblDepartamentoDoProduto = new GridBagConstraints();
		gbc_lblDepartamentoDoProduto.anchor = GridBagConstraints.EAST;
		gbc_lblDepartamentoDoProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamentoDoProduto.gridx = 4;
		gbc_lblDepartamentoDoProduto.gridy = 0;
		panel.add(lblDepartamentoDoProduto, gbc_lblDepartamentoDoProduto);
		
		cbDepto = new JComboBox<>();
		GridBagConstraints gbc_cbDepto = new GridBagConstraints();
		gbc_cbDepto.insets = new Insets(0, 0, 5, 5);
		gbc_cbDepto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDepto.gridx = 5;
		gbc_cbDepto.gridy = 0;
		panel.add(cbDepto, gbc_cbDepto);
		
		JLabel lblCliente = new JLabel("  CLIENTE: ");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 6;
		gbc_lblCliente.gridy = 0;
		panel.add(lblCliente, gbc_lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setToolTipText("DIGITE O PRIMEIRO NOME DO CLIENTE");
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCliente.gridx = 7;
		gbc_txtCliente.gridy = 0;
		panel.add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);
		
		JButton btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.anchor = GridBagConstraints.WEST;
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 8;
		gbc_btnFiltrar.gridy = 0;
		panel.add(btnFiltrar, gbc_btnFiltrar);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloTable();
			}
		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.anchor = GridBagConstraints.WEST;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 9;
		gbc_btnAtualizar.gridy = 0;
		panel.add(btnAtualizar, gbc_btnAtualizar);
		
		JButton btnGerarRelatorio = new JButton("GERAR RELAT\u00D3RIO");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportarPdf();
			}
		});
		GridBagConstraints gbc_btnGerarRelatorio = new GridBagConstraints();
		gbc_btnGerarRelatorio.anchor = GridBagConstraints.EAST;
		gbc_btnGerarRelatorio.insets = new Insets(0, 0, 5, 0);
		gbc_btnGerarRelatorio.gridx = 10;
		gbc_btnGerarRelatorio.gridy = 0;
		panel.add(btnGerarRelatorio, gbc_btnGerarRelatorio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 11;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		modeloTable();
		
		preencherCbx();
		
		preencherCbxCateg();
	}
	
	private void modeloTable() {
		tabelaModelo = new TabelaVendas();
		listaV = tabelaModelo.listar();
		new Thread(new Runnable() {
			@Override
			public void run() {
				table.setModel(tabelaModelo);
			}
		}).start();
	}

	
	private void preencherCbx() {
		for (int i = 1; i < 32; i++) {
			if(i <= 12){
				if(i <= 9){
					cb_mes.addItem("0"+i);
					cb_dia.addItem("0"+i);
				}else{
					cb_mes.addItem(i);
					cb_dia.addItem(i);
				}
			}else{	
				cb_dia.addItem(i);
			}
		}
	 }
	
	private void preencherCbxCateg() {
			RelatoriosDao d = new RelatoriosDao();
			List<String> lct = d.listarDepProd();
			for (int i = 0; i < lct.size(); i++) {
				int indice = 0;			
				for (int j = 0; j < cbDepto.getItemCount(); j++) {
					if (lct.get(i).toString().equals(cbDepto.getItemAt(j).toString())) 
						indice++;
					if (indice > 1) break; 
				}			
				if (indice < 1) cbDepto.addItem(lct.get(i).toString());			
			}
	}
	
	protected void consultar() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cod_v,cliente,produto,subtotal,valorPago,troco,data,hora FROM VENDA, PRODUTO WHERE ");
		sql.append("vendas.data LIKE '"+cb_dia.getSelectedItem()+"/"+cb_mes.getSelectedItem().toString()+ "%' AND departamento = '"+cbDepto.getSelectedItem()
					+"' AND venda.cliente LIKE '"+txtCliente.getText().trim()+"%'"); 
		listaV = tabelaModelo.listarRelatorio(sql);
		table.setModel(tabelaModelo);		
	}

	
	public void exportarPdf() {
		new GerarPDF("Vendas", getTableModelProduto());
	}

	
	private TableModel getTableModelProduto() {
		String[] columnNames = {"cod_v","cliente","produto","subtotal","valorPago","troco","data","hora"};

		Object[][] data = new Object[listaV.size()][8];
		for (int i = 0; i < listaV.size(); i++) {
			int j = 0;
			data[i][j++] = listaV.get(i).getCod_v();
			data[i][j++] = listaV.get(i).getCliente();
			data[i][j++] = listaV.get(i).getProduto();
			data[i][j++] = listaV.get(i).getSubTotal();
			data[i][j++] = listaV.get(i).getValorPago();
			data[i][j++] = listaV.get(i).getTroco();
			data[i][j++] = listaV.get(i).getData();
			data[i][j++] = listaV.get(i).getHora();
		}
		return new DefaultTableModel(data, columnNames);
	}

}
