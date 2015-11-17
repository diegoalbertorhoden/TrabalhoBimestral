package br.univel.banco;


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
			ps = con.prepareStatement("INSERT INTO vendas (id_cliente, cliente, id_produto, produto, subtotal, valor_pago, troco, data, hora) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, vd.getId_c());
			ps.setString(2, vd.getCliente());
			ps.setInt(3, vd.getCod_p());
			ps.setString(4, vd.getProduto());
			ps.setBigDecimal(5, vd.getSubTotal());
			ps.setBigDecimal(6, vd.getValorPago());
			ps.setBigDecimal(7, vd.getTroco());
			ps.setString(8, vd.getData());
			ps.setString(9, vd.getHora());
			int res = ps.executeUpdate();
			ps.close();
			if(res == 1)
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
			rs = st.executeQuery("SELECT * FROM vendas WHERE COD_V ="+ cod_v);
			rs.next();
			if (rs.getString("ID_C") != null) {
				v = new Vendas(rs.getInt("ID_C"),
						rs.getInt("COD_P"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("subtotal"),
						rs.getBigDecimal("valor_pago"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA"));
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
			rs = st.executeQuery("SELECT COD_V, id_cliente, CLIENTE, id_produto,"
					+ "PRODUTO, subtotal, valor_pago, TROCO, DATA, HORA FROM vendas");
			while (rs.next()) {
				lista.add(v = new Vendas(rs.getInt("COD_V"),
						rs.getInt("ID_C"),
						rs.getInt("COD_P"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("subtotal"),
						rs.getBigDecimal("valor_pago"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA")));
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
			ps = con.prepareStatement("DELETE FROM vendas WHERE COD_V =" + cod_v);
			int res = ps.executeUpdate();
			ps.close();
			if(res == 1)
				JOptionPane.showMessageDialog(null, "Historico selecionado foi\nexcluido com sucesso");
			else
				JOptionPane.showMessageDialog(null, "Histórico selecionado não foi excluido!");
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
			rs = st.executeQuery("SELECT * FROM vendas WHERE COD_V ="+ cod_v);
			rs.next();
			if (rs.getString("ID_C") != null) {
				v = new Vendas(rs.getInt("ID_C"),
						rs.getInt("COD_P"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("subtotal"),
						rs.getBigDecimal("valor_pago"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA"));
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
