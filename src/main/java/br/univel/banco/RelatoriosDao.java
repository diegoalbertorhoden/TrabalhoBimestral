package br.univel.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univel.classes.Clientes;
import br.univel.classes.Estado;
import br.univel.classes.Genero;
import br.univel.classes.Produtos;
import br.univel.classes.Vendas;

public class RelatoriosDao {

	private Connection con = Conexao.getInstance().conOpen();
	private Statement st = null;
	private ResultSet rs = null;

	public List<Clientes> relacionarClientes(String sql) {
		List<Clientes> lista = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Clientes(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("endereco"), rs.getString("cidade"),
						Estado.valueOf(Estado.class, rs.getString("estado")), rs.getString("email"),
						Genero.valueOf(Genero.class, rs.getString("genero"))));
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

	public List<Produtos> relacionarProdutos(String sql) {
		List<Produtos> lista = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Produtos(rs.getInt("id"), rs.getInt("barras"), rs.getString("departamento"),
						rs.getString("descricao"), rs.getString("unidade"), rs.getBigDecimal("custo"),
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

	public List<Vendas> relacionarVendas(StringBuilder sql) {
		List<Vendas> lista = new ArrayList<Vendas>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql.toString() + " union " + sql.toString());
			while (rs.next()) {
				lista.add(new Vendas(rs.getInt("cod_v"), rs.getString("cliente"), rs.getString("produto"),
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

	public List<String> listarDepProd() {
		List<String> lista = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT departamento FROM produtos");
			while (rs.next()) {
				lista.add(rs.getString("departamento"));
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
}
