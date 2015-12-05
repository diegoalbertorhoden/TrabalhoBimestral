package br.univel.banco;

/**
 * @author Diego Alberto Rhoden Classe de implementacao de venda
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.classes.Vendas;

public class VendaDaoImplementacao implements DaoGenerico<Vendas> {
	private PreparedStatement ps;
	private Statement st = null;
	private ResultSet rs = null;
	private Vendas v = null;
	private List<Vendas> lista = null;
	private Connection con = Conexao.getInstance().conOpen();

	public int inserir(Vendas vd) {
		try {
			ps = con.prepareStatement(
					"INSERT INTO vendas (id_c, cliente, cod_p, produto, quantidade, subtotal, valorPago, troco, data, hora) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, vd.getId_c());
			ps.setString(2, vd.getCliente());
			ps.setInt(3, vd.getCod_p());
			ps.setString(4, vd.getProduto());
			ps.setString(5, vd.getQuantidade());
			ps.setBigDecimal(5, vd.getSubTotal());
			ps.setBigDecimal(6, vd.getValorPago());
			ps.setBigDecimal(7, vd.getTroco());
			ps.setString(8, vd.getData());
			ps.setString(9, vd.getHora());
			int res = ps.executeUpdate();
			ps.close();
			if (res == 1)
				JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso.");
			else
				JOptionPane.showMessageDialog(null, "Venda não efetuada!");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int atualizar(Vendas vd) {

		return 0;
	}

	public Vendas buscarUm(int cod_v) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM vendas WHERE cod_v =" + cod_v);
			rs.next();
			if (rs.getString("id_c") != null) {
				v = new Vendas(rs.getInt("id_c"), rs.getInt("cod_p"), rs.getString("cliente"), rs.getString("produto"),
						rs.getBigDecimal("subtotal"), rs.getBigDecimal("valoPago"), rs.getBigDecimal("troco"),
						rs.getString("data"), rs.getString("hora"));
			}
			rs.close();
			st.close();
			return v;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Vendas> listar() {
		lista = new ArrayList<Vendas>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT cod_v, id_c, cliente, cod_p,"
					+ "produto, quantidade, subtotal, valorPago, troco, data, hora FROM vendas");
			while (rs.next()) {
				lista.add(v = new Vendas(rs.getInt("cod_v"), rs.getInt("id_c"), rs.getInt("cod_p"),
						rs.getString("cliente"), rs.getString("produto"), rs.getInt("quantidade"),
						rs.getBigDecimal("subtotal"), rs.getBigDecimal("valorPago"), rs.getBigDecimal("troco"),
						rs.getString("data"), rs.getString("hora")));
			}
			rs.close();
			st.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getCon() {
		return con;
	}

	@Override
	public int excluir(int cod_v) {
		try {
			ps = con.prepareStatement("DELETE FROM vendas WHERE cod_v =" + cod_v);
			int res = ps.executeUpdate();
			ps.close();
			if (res == 1)
				JOptionPane.showMessageDialog(null, "Histórico selecionado não foi excluido!");
			else
				JOptionPane.showMessageDialog(null, "Historico selecionado foi\nexcluido com sucesso");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Vendas buscar(int cod_v) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM vendas WHERE cod_v =" + cod_v);
			rs.next();
			if (rs.getString("id_c") != null) {
				v = new Vendas(rs.getInt("id_c"), rs.getInt("cod_p"), rs.getString("cliente"), rs.getString("produto"),
						rs.getBigDecimal("subtotal"), rs.getBigDecimal("valoPago"), rs.getBigDecimal("troco"),
						rs.getString("data"), rs.getString("hora"));
			}
			rs.close();
			st.close();
			return v;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
