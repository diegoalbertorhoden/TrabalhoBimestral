package br.univel.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.banco.UsuarioDaoImplementacao;
import br.univel.classes.Usuarios;

/**
 * @author Diego Alberto Rhoden tabela de usuarios
 */
@SuppressWarnings("serial")
public class TabelaUsuarios extends AbstractTableModel {

	List<Usuarios> lista = new ArrayList<>();

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID do usuário";
		case 1:
			return "ID do cliente";
		case 2:
			return "Usuário";
		case 3:
			return "Senha";
		default:
			return "";
		}
	}

	@Override
	public Object getValueAt(int row, int col) {

		Usuarios temp = lista.get(row);
		switch (col) {
		case 0:
			return temp.getId();
		case 1:
			return temp.getIdCliente();
		case 2:
			return temp.getCliente();
		case 3:
			return temp.getSenha();
		default:
			return "";
		}
	}

	public List<Usuarios> listar() {
		UsuarioDaoImplementacao udi = new UsuarioDaoImplementacao();
		return lista = udi.listar();
	}

	public void adicionarLista(List<Usuarios> u) {
		this.lista = u;
		this.fireTableStructureChanged();
	}

	public void deletar(int indice) {
		lista.remove(indice);
		this.fireTableStructureChanged();
	}

	public void atualizarLista(int indice, Usuarios u) {
		lista.set(indice, u);
		this.fireTableStructureChanged();
	}

}
