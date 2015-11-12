package br.univel.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.banco.ProdutoDaoImplementacao;
import br.univel.classes.Produtos;

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

	public String getColumnName(int col){
		switch(col){
		case 0: return "Código";
		case 1: return "Código de Barras";
		case 2: return "Descrição";
		case 3: return "Departamento";
		case 4: return "Unidade";
		case 5: return "Custo";
		case 6: return "Margem de Lucro";
		default: return "";
		}
	}
	
	public List<Produtos> listar() {
		ProdutoDaoImplementacao c  = new ProdutoDaoImplementacao(); 
		this.lista = c.listar();
		this.fireTableStructureChanged();
		return this.lista;
	}

	@Override
	public void excluir(int tipo) {
		// TODO Auto-generated method stub

	}
};
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {

	return null;
}

}
