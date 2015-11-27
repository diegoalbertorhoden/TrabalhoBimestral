package br.univel.relatorios;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.tabelas.TabelaProdutos;
import br.univel.classes.Produtos;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class RelatorioProdutos extends JPanel {

	private JTextField txtMarkup;
	private JComboBox<String> cbDepartamento;
	private JTable table;
	
	private List<Produtos> listaP;
	private TabelaProdutos tableModelProduto;
	
	public RelatorioProdutos() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 113, 99, 46, 106, 47, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnExportar = new JButton("F6 - Exportar em PDF");
		btnExportar.setMnemonic(KeyEvent.VK_F6);
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportarParaPdf();
			}
		});

		JLabel lblMargem = new JLabel("Margem:");
		GridBagConstraints gbc_lblMargem = new GridBagConstraints();
		gbc_lblMargem.anchor = GridBagConstraints.EAST;
		gbc_lblMargem.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargem.gridx = 0;
		gbc_lblMargem.gridy = 1;
		add(lblMargem, gbc_lblMargem);

		txtMarkup = new JTextField();
		GridBagConstraints gbc_txtMarkup = new GridBagConstraints();
		gbc_txtMarkup.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMarkup.insets = new Insets(0, 0, 5, 5);
		gbc_txtMarkup.gridx = 1;
		gbc_txtMarkup.gridy = 1;
		add(txtMarkup, gbc_txtMarkup);
		txtMarkup.setColumns(10);

		JLabel lblDepartamento = new JLabel("Departamento:");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.anchor = GridBagConstraints.EAST;
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 2;
		gbc_lblDepartamento.gridy = 1;
		add(lblDepartamento, gbc_lblDepartamento);

		cbDepartamento = new JComboBox<String>();
		GridBagConstraints gbc_cbDepartamento = new GridBagConstraints();
		gbc_cbDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_cbDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDepartamento.gridx = 3;
		gbc_cbDepartamento.gridy = 1;
		add(cbDepartamento, gbc_cbDepartamento);

		JButton btnFiltrar = new JButton("F2 - Filtrar");
		btnFiltrar.setMnemonic(KeyEvent.VK_F2);
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 4;
		gbc_btnFiltrar.gridy = 1;
		add(btnFiltrar, gbc_btnFiltrar);

		JButton btnAtualizar = new JButton("F5 - Atualizar");
		btnAtualizar.setMnemonic(KeyEvent.VK_F5);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloTable();
			}
		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 5;
		gbc_btnAtualizar.gridy = 1;
		add(btnAtualizar, gbc_btnAtualizar);
		btnExportar.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnExportar = new GridBagConstraints();
		gbc_btnExportar.anchor = GridBagConstraints.EAST;
		gbc_btnExportar.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportar.gridx = 6;
		gbc_btnExportar.gridy = 1;
		add(btnExportar, gbc_btnExportar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTable();

		popularCombobox();
	}

	private void modeloTable() {
		tableModelProduto = new TabelaProdutos();
		listaP = tableModelProduto.listar();
		new Thread(new Runnable() {
			@Override
			public void run() {
				table.setModel(tableModelProduto);
			}
		}).start();
	}

	private void popularCombobox() {
		for (int i = 0; i < listaP.size(); i++) {
			int indice = 0;
			if (i == 0){
				cbDepartamento.addItem("");
			}			
			for (int j = 0; j < cbDepartamento.getItemCount(); j++) {
				if (listaP.get(i).getDepartamento().equals(cbDepartamento.getItemAt(j).toString())) 
					indice++;
				if (indice > 1) break; 
			}			
			if (indice < 1) cbDepartamento.addItem(listaP.get(i).getDepartamento());			
		}
	}

	protected void consultar() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, barras, departamento, descricao, unidade, custo, margem FROM produtos ");
		try {
			if (Double.valueOf(txtMarkup.getText()) > 0) {
				txtMarkup.setBackground(Color.WHITE);
				sql.append("WHERE margem >= '" + txtMarkup.getText()+"' ");
				if (cbDepartamento.getSelectedItem() != null)
					sql.append("AND departamento = '"+ cbDepartamento.getSelectedItem()+"'");
			}else if (cbDepartamento.getSelectedItem() != null) {
				sql.append("WHERE departamento = '" + cbDepartamento.getSelectedItem()+"'");
			}
			listaP = tableModelProduto.listarRelatorio(sql.toString());
			table.setModel(tableModelProduto);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite somente números");
			txtMarkup.setBackground(Color.yellow);
			txtMarkup.setFocusable(true);
		}
	}

	public void exportarParaPdf() {
		new GerarPDF("Produtos", getTableModelProduto());
	}

	private TableModel getTableModelProduto() {
		String[] columnNames = { "id", "barras", "departamento", "descricao", "unidade", "custo", "margem" };

		Object[][] data = new Object[listaP.size()][7];
		for (int i = 0; i < listaP.size(); i++) {
			int j = 0;
			data[i][j++] = Long.valueOf(listaP.get(i).getId());
			data[i][j++] = listaP.get(i).getBarras();
			data[i][j++] = listaP.get(i).getDepartamento();
			data[i][j++] = listaP.get(i).getDescricao();
			data[i][j++] = listaP.get(i).getUnidade();
			data[i][j++] = listaP.get(i).getCusto();
			data[i][j++] = listaP.get(i).getMargem();
		}
		return new DefaultTableModel(data, columnNames);
	}


}


