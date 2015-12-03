package br.univel.tabelas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.banco.ProdutoDaoImplementacao;
import br.univel.banco.RelatoriosDao;
import br.univel.classes.Produtos;

@SuppressWarnings("serial")
public class TabelaProdutos extends AbstractTableModel {

	List<Produtos> lista = new ArrayList<>();

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public int getColumnCount() {

		return 7;
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Código";
		case 1:
			return "Código de Barras";
		case 2:
			return "Descrição";
		case 3:
			return "Departamento";
		case 4:
			return "Unidade";
		case 5:
			return "Custo";
		case 6:
			return "Margem de Lucro";
		default:
			return "";
		}
	}

	public List<Produtos> listar() {
		ProdutoDaoImplementacao c = new ProdutoDaoImplementacao();
		this.lista = c.listar();
		this.fireTableStructureChanged();
		return this.lista;
	}

	public void excluir(int indice) {
		this.lista.remove(indice);
		this.fireTableStructureChanged();

	}

	public void atualizarLista(int indice, Produtos c) {
		this.lista.set(indice, c);
		this.fireTableStructureChanged();
	}

	public void adicionarLista(List<Produtos> c) {
		this.lista = c;
		this.fireTableStructureChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Produtos p = lista.get(row);
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getBarras();
		case 2:
			return p.getDescricao();
		case 3:
			return p.getDepartamento();
		case 4:
			return p.getUnidade();
		case 5:
			return new BigDecimal(p.getCusto().toString()).setScale(2, RoundingMode.HALF_EVEN);
		case 6:
			return p.getMargem();
		default:
			return "";
		}

	}

	public List<Produtos> listarRelatorio(String sql) {

		RelatoriosDao d = new RelatoriosDao();
		this.lista = d.relacionarProdutos(sql);
		this.fireTableDataChanged();
		return lista;
	}
}
