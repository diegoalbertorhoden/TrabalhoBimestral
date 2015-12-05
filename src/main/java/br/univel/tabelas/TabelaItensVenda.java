package br.univel.tabelas;

/**
 * @author Diego Alberto Rhoden tabela de itens da venda que nao deu muito certo infelizmente...
 */
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.classes.ItemVenda;
import br.univel.classes.Produtos;

@SuppressWarnings("serial")
public class TabelaItensVenda extends AbstractTableModel {

	private List<Produtos> lista = new ArrayList<Produtos>();

	public TabelaItensVenda(List<ItemVenda> itensVenda) {

	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return lista.size();
	}

	public Object getValueAt(int row, int col) {

		Produtos p = lista.get(row);

		switch (col) {
		case 0:
			return p.getDescricao();
		case 1:
			return p.getQuantidade();
		case 2:
			return p.getCusto();

		default:
			return "Erro!";
		}

	}

	public void incluir(Produtos p) {
		lista.add(p);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Produtos";
		case 1:
			return "Quantidade";
		case 2:
			return "Valor Unitário";
		default:
			return "Erro";

		}
	}

	public void limparlista() {
		lista.clear();
	}

	public Produtos getClienteNaLinha(int index) {

		return lista.get(index);
	}

	// public List<Produtos> listar() {
	//
	//// ItemVendaDao ivd = new ItemVendaDao();
	//// return lista = ivd.listar();
	// }

	public void removeProdutos(Produtos p) {
		int idx = this.lista.indexOf(p);
		this.lista.remove(p);
		super.fireTableRowsDeleted(idx, idx);

	}

}
