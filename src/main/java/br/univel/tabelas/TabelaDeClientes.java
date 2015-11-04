package br.univel.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Clientes;

/**
 * @author Diego Alberto Rhoden
 *4 de nov de 2015 às 02:40:01
 */
public class TabelaDeClientes extends AbstractTableModel {

	List<Clientes> lista = new ArrayList<>();

	public int getRowCount() {
		
		return lista.size();
	}

	public int getColumnCount() {

		return 8;
	}
	
	@Override
	public String getColumnName(int column) {
		switch (col) {
		case 0: return "ID";
		case 1: return "NOME";
		case 2: return "TELEFONE";
		case 3: return "ENDEREÇO";
		case 4: return "CIDADE";
		case 5: return i.getEstado().getNome();
		case 6: return i.getEmail();
		case 7: return i.getGenero();
		default: return "";
		}
		return super.getColumnName(column);
	}

	public Object getValueAt(int row, int col) {
		
		Cliente i = lista.get(row);
		switch (col) {
		case 0: return i.getId();
		case 1: return i.getNome();
		case 2: return i.getTelefone();
		case 3: return i.getEndereco();
		case 4: return i.getCidade();
		case 5: return i.getEstado().getNome();
		case 6: return i.getEmail();
		case 7: return i.getGenero();
		default: return "";
		}
	}

}
