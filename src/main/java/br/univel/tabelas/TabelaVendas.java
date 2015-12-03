package br.univel.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.banco.RelatoriosDao;
import br.univel.banco.VendaDaoImplementacao;
import br.univel.classes.Vendas;

@SuppressWarnings("serial")
public class TabelaVendas extends AbstractTableModel {

	List<Vendas> lista = new ArrayList<>();

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public int getColumnCount() {

		return 8;
	}

	@Override
	public Object getValueAt(int row, int col) {

		Vendas x = lista.get(row);
		switch (col) {
		case 0:
			return x.getCod_v();
		case 1:
			return x.getCliente();
		case 2:
			return x.getProduto();
		case 3:
			return x.getSubTotal();
		case 4:
			return x.getValorPago();
		case 5:
			return x.getTroco();
		case 6:
			return x.getData();
		case 7:
			return x.getHora();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Código Venda";
		case 1:
			return "Cliente";
		case 2:
			return "Produto";
		case 3:
			return "SubTotal";
		case 4:
			return "Valor Pago";
		case 5:
			return "Troco";
		case 6:
			return "Data";
		case 7:
			return "Hora";
		default:
			return "";
		}
	}

	public List<Vendas> listar() {

		VendaDaoImplementacao vdi = new VendaDaoImplementacao();
		return lista = vdi.listar();
	}

	public void adicionarLista(List<Vendas> listaDeVendas) {

		this.lista = listaDeVendas;
		this.fireTableStructureChanged();

	}

	public void atualizarLista(int indice, Vendas vd) {

		this.lista.set(indice, vd);
		this.fireTableStructureChanged();
	}

	public void excluir(int indice) {

		this.lista.remove(indice);
		this.fireTableStructureChanged();
	}

	public List<Vendas> listarRelatorio(StringBuilder sql) {
		RelatoriosDao d = new RelatoriosDao();
		this.lista = d.relacionarVendas(sql);
		this.fireTableDataChanged();
		return lista;
	}

}
