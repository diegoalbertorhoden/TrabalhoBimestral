package br.univel.relatorios;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.classes.Clientes;
import br.univel.classes.Estado;
import br.univel.tabelas.TabelaClientes;

public class RelatorioClientes extends JPanel {

	private JComboBox<String> cbEstado;
	private JComboBox<String> cdCidade;
	private JTable table;

	private List<Clientes> listaC;
	private TabelaClientes tbClienteModelo;
	private String sql = "SELECT id_c, nome, telefone, endereco, cidade, estado, email, genero FROM clientes";

	public RelatorioClientes() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 121, 125, 0, 125, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnNewButton = new JButton("EXPORTAR PRA PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportarPdf();
			}
		});

		JLabel lblNewLabel = new JLabel("FILTRO POR ESTADO:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		cbEstado = new JComboBox<>();
		cbEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2)
					filtrarPorEstado();
			}
		});
		GridBagConstraints gbc_cbEstado = new GridBagConstraints();
		gbc_cbEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstado.gridx = 1;
		gbc_cbEstado.gridy = 1;
		add(cbEstado, gbc_cbEstado);

		JLabel lblFiltroPorCidade = new JLabel("   FILTRO POR CIDADE: ");
		GridBagConstraints gbc_lblFiltroPorCidade = new GridBagConstraints();
		gbc_lblFiltroPorCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltroPorCidade.anchor = GridBagConstraints.EAST;
		gbc_lblFiltroPorCidade.gridx = 2;
		gbc_lblFiltroPorCidade.gridy = 1;
		add(lblFiltroPorCidade, gbc_lblFiltroPorCidade);

		cdCidade = new JComboBox<>();
		cdCidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2)
					filtrarPorCidade();
			}
		});
		GridBagConstraints gbc_cdCidade = new GridBagConstraints();
		gbc_cdCidade.insets = new Insets(0, 0, 5, 5);
		gbc_cdCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cdCidade.gridx = 3;
		gbc_cdCidade.gridy = 1;
		add(cdCidade, gbc_cdCidade);

		JButton btnEC = new JButton("FILTRO DE E.C.");
		btnEC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtroEC();
			}
		});
		GridBagConstraints gbc_btnEC = new GridBagConstraints();
		gbc_btnEC.insets = new Insets(0, 0, 5, 5);
		gbc_btnEC.gridx = 4;
		gbc_btnEC.gridy = 1;
		add(btnEC, gbc_btnEC);

		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloTable();
			}
		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 5;
		gbc_btnAtualizar.gridy = 1;
		add(btnAtualizar, gbc_btnAtualizar);
		btnNewButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

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

		listarDDF();
	}


	private void modeloTable() {
		tbClienteModelo = new TabelaClientes();
		listaC = tbClienteModelo.listar();
		new Thread(new Runnable() {
			@Override
			public void run() {
				table.setModel(tbClienteModelo);
			}
		}).start();
	}


	private void listarDDF() {
		int indice = 0;
		for (Estado e : Estado.values()) {
			if (indice == 0) {
				cbEstado.addItem("");
				indice = 1;
			}
			cbEstado.addItem(e.getNome());
		}

		for (int i = 0; i < listaC.size(); i++) {
			indice = 0;
			if (i == 0) {
				cdCidade.addItem("");
			}

			for (int j = 0; j < cdCidade.getItemCount(); j++) {
				if (listaC.get(i).getCidade()
						.equals(cdCidade.getItemAt(j).toString()))
					indice++;
				if (indice > 1)
					break;
			}
			if (indice < 1)
				cdCidade.addItem(listaC.get(i).getCidade());
		}
	}


	protected void filtroEC() {
		if (cdCidade.getSelectedItem() != "" && cbEstado.getSelectedItem() != "") {
			StringBuilder filtrosql = new StringBuilder();
			filtrosql.append(sql+ " WHERE estado = '"
					+ Estado.transformar(cbEstado.getSelectedItem().toString())
					+ "' AND cidade ='"
					+ cdCidade.getSelectedItem().toString() +
					"'");
			listaC = tbClienteModelo.listarRelatorio(filtrosql.toString());
			table.setModel(tbClienteModelo);
		} else {
			JOptionPane.showMessageDialog(null,
					"Selecione cidade e estado para filtrar.");
		}

	}

	protected void filtrarPorCidade() {
		if (cdCidade.getSelectedItem() != "") {
			StringBuilder filtrosql = new StringBuilder();
			filtrosql.append(sql + " WHERE cidade = '"
					+ cdCidade.getSelectedItem() + "'");
			listaC = tbClienteModelo.listarRelatorio(filtrosql.toString());
			table.setModel(tbClienteModelo);
		}
	}

	protected void filtrarPorEstado() {
		if (cbEstado.getSelectedItem() != "") {
			StringBuilder filtrosql = new StringBuilder();
			filtrosql.append(sql+ " WHERE estado = '"
					+ Estado.transformar(cbEstado.getSelectedItem().toString()) + "'");
			listaC = tbClienteModelo.listarRelatorio(filtrosql.toString());
			table.setModel(tbClienteModelo);
		}
	}

	public void exportarPdf() {
		new GerarPDF("Cliente", getTableModelProduto());
	}


	private TableModel getTableModelProduto() {
		String[] columnNames = { "id_c", "nome", "telefone", "endereco",
				"cidade", "estado", "email", "genero" };

		Object[][] data = new Object[listaC.size()][8];
		for (int i = 0; i < listaC.size(); i++) {
			int j = 0;
			data[i][j++] = listaC.get(i).getId();
			data[i][j++] = listaC.get(i).getNome();
			data[i][j++] = listaC.get(i).getTelefone();
			data[i][j++] = listaC.get(i).getEndereco();
			data[i][j++] = listaC.get(i).getCidade();
			data[i][j++] = listaC.get(i).getEstado().toString();
			data[i][j++] = listaC.get(i).getEmail();
			data[i][j++] = listaC.get(i).getGenero().toString();
		}
		return new DefaultTableModel(data, columnNames);
	}

}


