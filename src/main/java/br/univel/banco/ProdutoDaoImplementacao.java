package br.univel.banco;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.classes.Produtos;

/**
 * @author Diego Alberto Rhoden implementacao do produto
 */
public class ProdutoDaoImplementacao implements DaoGenerico<Produtos> {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Produtos p = null;
	private List<Produtos> lista = null;
	private Connection con = Conexao.getInstance().conOpen();

	public int inserir(Produtos pd) {
		try {
			ps = con.prepareStatement(
					"INSERT INTO produtos (barras, descricao, departamento, unidade, custo, margem) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, pd.getBarras());
			ps.setString(2, pd.getDescricao());
			ps.setString(3, pd.getDepartamento());
			ps.setString(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargem());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto: " + pd.getDescricao() + "\n Cadastrado com sucesso.");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int atualizar(Produtos pd) {
		try {
			ps = con.prepareStatement("UPDATE produtos SET barras = ?, descricao = ?, departamento = ?,"
					+ " unidade = ?, custo = ?, margem = ? WHERE id = " + pd.getId());
			ps.setInt(1, pd.getBarras());
			ps.setString(2, pd.getDescricao());
			ps.setString(3, pd.getDepartamento());
			ps.setString(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargem());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto: " + pd.getDescricao() + "\n Atualizado com sucesso.");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Produtos buscar(int id) {

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT barras, descricao, departamento, unidade, custo, margem "
					+ "FROM produtos WHERE id = " + id);
			rs.next();
			if (rs.getString("barras") != null) {
				p = new Produtos(id, rs.getInt("barras"), rs.getString("descricao"), rs.getString("departamento"),
						rs.getString("unidade"), rs.getBigDecimal("custo"), rs.getBigDecimal("margem"));
			}
			rs.close();
			st.close();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Produtos> listar() {

		lista = new ArrayList<Produtos>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(
					"SELECT id, barras, descricao, departamento, unidade, custo, margem " + "FROM produtos");
			while (rs.next()) {
				lista.add(p = new Produtos(rs.getInt("id"), rs.getInt("barras"), rs.getString("descricao"),
						rs.getString("departamento"), rs.getString("unidade"), rs.getBigDecimal("custo"),
						rs.getBigDecimal("margem")));
			}
			rs.close();
			st.close();
			if (lista != null)
				return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getCon() {
		return con;
	}

	public int excluir(int id) {
		try {
			ps = con.prepareStatement("DELETE FROM produtos WHERE id =" + id);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produtos excluido com sucesso.");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public BigDecimal buscaMargem(int i) {

		return null;
	}

	public BigDecimal buscarValorProd(int idProd) {
		// TODO Auto-generated method stub
		return null;
	}
}