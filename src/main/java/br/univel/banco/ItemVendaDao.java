package br.univel.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.classes.ItemVenda;

public class ItemVendaDao implements DaoGenerico<ItemVenda> {


	private PreparedStatement ps = null;
	private ItemVenda iv = null;
	private Connection con = Conexao.getInstance().conOpen();


	@Override
	public int inserir(ItemVenda itemVenda) {
		try {
			ps = con.prepareStatement(
					"INSERT INTO itemvenda (id_i, cod_v, descricao, departamento, quantidade, vlrunidade, vlrtotal) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, iv.getId());
			ps.setInt(2, iv.getIdVenda());
			ps.setString(3, iv.getDescricao());
			ps.setString(4, iv.getDepartamento());
			ps.setInt(5, iv.getQtd());
			ps.setBigDecimal(6, iv.getVlrUnidade());
			ps.setBigDecimal(7, iv.getVlrTotal());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Item: " + iv.getDescricao() + "\n Adicionado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int atualizar(ItemVenda tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int excluir(int id) {
		try {
			ps = con.prepareStatement("DELETE FROM itemvenda WHERE id_i =" + id);
			int res = ps.executeUpdate();
			ps.close();
			if (res == 1)
				JOptionPane.showMessageDialog(null, "Item selecionado não foi excluido!");
			else
				JOptionPane.showMessageDialog(null, "Item selecionado foi\nexcluido com sucesso");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ItemVenda buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ItemVenda> listar(String sql) throws SQLException {

		List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();

		ResultSet result;
		ps= con.prepareStatement(sql);
		result = ps.executeQuery();

		while(result.next()){
			ItemVenda novoItem = new ItemVenda();

			novoItem.setId(result.getInt("id"));
			novoItem.setIdVenda(result.getInt("cod_v"));
			novoItem.setIdProduto(result.getInt("IdItemVenda"));
			novoItem.setDescricao(result.getString("descricao"));
			novoItem.setDepartamento(result.getString("departamento"));
			novoItem.setQtd(result.getInt("quantidade"));
			novoItem.setVlrUnidade(result.getBigDecimal("vlrTotal"));
			novoItem.setVlrTotal(result.getBigDecimal("vlrTotal"));
			itensVenda.add(novoItem);
		}
		result.close();
		ps.close();
		return itensVenda;

	}

	public Connection getCon() {
		return con;
	}

	@Override
	public List<ItemVenda> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}