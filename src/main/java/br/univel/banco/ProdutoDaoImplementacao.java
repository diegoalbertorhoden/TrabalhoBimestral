package br.univel.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.classes.Produtos;

/**
 * @author Diego Alberto Rhoden
 */
public abstract class ProdutoDaoImplementacao implements DaoGenerico<Produtos> {

			
		private PreparedStatement ps = null;
		private Statement st = null;
		private ResultSet rs = null;
		private Produtos p = null;
		private List<Produtos> lista = null;
		private Connection con =  Conexao.getInstance().conOpen();
		
		@Override
		public void inserir(Produtos pd) {
			try {
				ps = con
						.prepareStatement("INSERT INTO produtos (barras, categoria, descricao, unidade, custo, margem) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setInt(1, pd.getBarras());
				ps.setString(2, pd.getCategoria());
				ps.setString(3, pd.getDescricao());
				ps.setString(4, pd.getUnidade());
				ps.setBigDecimal(5, pd.getCusto());
				ps.setBigDecimal(6, pd.getMargem());
				ps.executeUpdate();
				ps.close();
				JOptionPane.showMessageDialog(null, "Produtos: " + pd.getDescricao()
						+ "\n Cadastrado com sucesso.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	

	@Override
	public void atualizar(Produtos pd) {
		try {
			ps = con
					.prepareStatement("UPDATE produtos SET barras = ?, categoria = ?, descricao = ?,"
							+ " unidade = ?, custo = ?, margem = ? WHERE id = " + pd.getId());
			ps.setInt(1, pd.getBarras());
			ps.setString(2, pd.getCategoria());
			ps.setString(3, pd.getDescricao());
			ps.setString(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargem());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produtos: " + pd.getDescricao()
					+ "\n Atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Produtos pd) {
		try {
			ps =con.prepareStatement("DELETE FROM produtos WHERE id =" + pd.getId());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produtos excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// public Produtos buscar(int id) {
	//
	// return null;
	// }

	public List<Produtos> listarProdutos() {

		return null;
	}

}
